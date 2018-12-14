package com.github.cloudyrock.mongock.springboot207sample.changesets;

import java.time.LocalDateTime;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.springboot207sample.ClientDomain;
import com.mongodb.client.MongoDatabase;

@ChangeLog
public class ClientChangeLog {

    private static final String COLLECTION_NAME = "clients";

    @ChangeSet(order = "001", id = "cs-1", author = "mongock")
    public void changeSet1(final MongoDatabase db) {
        db.getCollection(COLLECTION_NAME).insertOne(createMongoDocument(new ClientDomain("Gerorge1 " + LocalDateTime.now().toString(), "Orwell")));
    }
    
    private Document createMongoDocument(ClientDomain clientDomain) {
        return new Document()
                .append("name", clientDomain.getName())
                .append("surname", clientDomain.getSurname());
    }

    @ChangeSet(order = "002", id = "cs-2", author = "mongock")
    public void changeSet2(MongoTemplate template) {
        template.insert(getClient(), COLLECTION_NAME);
    }


    private ClientDomain getClient() {
        return new ClientDomain("Gerorge-" + LocalDateTime.now().toString(), "Orwell");
    }

}
