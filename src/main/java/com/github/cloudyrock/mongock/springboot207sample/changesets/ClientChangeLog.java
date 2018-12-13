package com.github.cloudyrock.mongock.springboot207sample.changesets;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.springboot207sample.ClientDomain;

import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDateTime;

@ChangeLog
public class ClientChangeLog {

    private static final String COLLECTION_NAME = "clients";



    @ChangeSet(id = "cs-2", order = "002", author = "mongock")
    public void changeSet2(MongoTemplate template) {
        template.insert(getClient(), COLLECTION_NAME);
    }


    private ClientDomain getClient() {
        return new ClientDomain("Gerorge-" + LocalDateTime.now().toString(), "Orwell");
    }

}
