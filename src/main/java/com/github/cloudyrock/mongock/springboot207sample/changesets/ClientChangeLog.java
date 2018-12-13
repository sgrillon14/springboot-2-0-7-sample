package com.github.cloudyrock.mongock.springboot207sample.changesets;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.springboot207sample.ClientDomain;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.time.LocalDateTime;

@ChangeLog
public class ClientChangeLog {

    private static final String COLLECTION_NAME = "clients";


    @ChangeSet(id= "cs-1", order = "001", author = "mongock")
    public void changeSet1(MongoDatabase mongoDatabase) {
        mongoDatabase.getCollection(COLLECTION_NAME).insertOne(createMongoDocument(new ClientDomain("Gerorge " + LocalDateTime.now().toString(), "Orwell")));
    }

    private Document createMongoDocument(ClientDomain clientDomain) {
        return new Document()
                .append("name", clientDomain.getName())
                .append("surname", clientDomain.getSurname());
    }
}
