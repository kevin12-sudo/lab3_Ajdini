package com.retailstore;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class MongoCustomer {

    private static final String URI        = "mongodb://localhost:27017";
    private static final String DB_NAME    = "retail_store";
    private static final String COLLECTION = "customers";

    public void createCustomer(int id, String firstName, String lastName,
                               String instagram, String address, String shirtType) {
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase(DB_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION);
            Document newCustomer = new Document("id", id)
                    .append("firstName", firstName)
                    .append("lastName", lastName)
                    .append("instagram", instagram)
                    .append("address", address)
                    .append("shirtType", shirtType);
            collection.insertOne(newCustomer);
            System.out.println("[MongoDB] Created: " + firstName + " " + lastName);
        }
    }

    public void readCustomers() {
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase(DB_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION);
            System.out.println("[MongoDB] All customers:");
            FindIterable<Document> customers = collection.find();
            for (Document customer : customers) {
                System.out.println(customer.toJson());
            }
        }
    }

    public void updateCustomer(int id, String instagram, String shirtType) {
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase(DB_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION);
            Document updated = new Document("$set",
                    new Document("instagram", instagram)
                            .append("shirtType", shirtType));
            collection.updateOne(new Document("id", id), updated);
            System.out.println("[MongoDB] Updated customer ID: " + id);
        }
    }

    public void deleteCustomer(int id) {
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase(DB_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION);
            collection.deleteOne(new Document("id", id));
            System.out.println("[MongoDB] Deleted customer ID: " + id);
        }
    }
}