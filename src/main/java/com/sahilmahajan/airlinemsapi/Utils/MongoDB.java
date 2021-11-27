package com.sahilmahajan.airlinemsapi.Utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDB {

    private static MongoClient mongoClient;
    private static MongoCollection<Document> collection;

    public MongoCollection<Document> getcollection() {
        return collection;
    }

    public static void Connect(String Collection) {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://127.0.0.1:27017/?&gssapiServiceName=mongodb&maxIdleTimeMS=120000"));
        MongoDatabase database = mongoClient.getDatabase("Airline-Management-System");

        collection = database.getCollection(Collection);
    }

    public void CloseConnect() {
        mongoClient.close();
    }
}
