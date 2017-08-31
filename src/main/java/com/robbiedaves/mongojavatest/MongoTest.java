package com.robbiedaves.mongojavatest;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class MongoTest {

    public static void main (String[] args) {

        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB database = mongoClient.getDB("RobMongoTest");
            DBCollection collection = database.getCollection("RobMongoCollection");

            collection.insert(getNewUser());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    public static DBObject getNewUser() {
        List<Integer> books = Arrays.asList(28338, 20099);
        DBObject person = new BasicDBObject("_id", "jo")
                .append("name", "Jo Bloggs")
                .append("address", new BasicDBObject("street", "123 Fake Street")
                                            .append("city", "faketon")
                                            .append("state", "MA")
                                            .append("zip", 12345))
                .append("books", books);
        return person;
    }

}
