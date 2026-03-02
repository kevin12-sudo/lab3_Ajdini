/** Project: LAB 3
 * Purpose Details: Class
 * Course: IST 242
 * Author: KEVIN AJDINI
 * Date Developed: 3/1/2026
 * Last Date Changed: 3/1/2026
 * Rev: 3/1/2026

 */

package com.retailstore;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class MongoCustomer {
    /** defines where in MongoDB this is running and what to use*/
    private static final String URI        = "mongodb://localhost:27017";
    private static final String DB_NAME    = "retail_store";
    private static final String COLLECTION = "customers";
    /** creates costumer for mongo*/
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
    /** same as create but this time it gets the costumer and reads it onto mongo*/
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
    /** updates the document in mongo*/
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
    /** deletes the costumer off mongo works the same for sql*/
    public void deleteCustomer(int id) {
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase(DB_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION);
            collection.deleteOne(new Document("id", id));
            System.out.println("[MongoDB] Deleted customer ID: " + id);
        }
    }
}