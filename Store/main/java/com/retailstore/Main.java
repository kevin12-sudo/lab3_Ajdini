package com.retailstore;

public class Main {

    public static void main(String[] args) throws Exception {

        MySQLCustomer mysql = new MySQLCustomer();
        MongoCustomer mongo = new MongoCustomer();

        // ---- MySQL CRUD ----
        System.out.println(" MySQL CREATE ");
        mysql.createCustomer(1, "John", "Yakuza", "JYK_77", "88 Kamurocho", "Large");
        mysql.createCustomer(2, "Snow", "Man", "SNWM_99", "111 Kozak ST", "Medium");
        mysql.createCustomer(3, "Yi", "Tori", "YUTI09", "9812 Clover DR", "Small");

        System.out.println(" MySQL READ ");
        mysql.readCustomers();

        System.out.println(" MySQL UPDATE ");
        mysql.updateCustomer(2, "@brian_updated", "XLarge");
        mysql.readCustomers();

        System.out.println(" MySQL DELETE");
        mysql.deleteCustomer(3);
        mysql.readCustomers();

        // ---- MongoDB CRUD ----
        System.out.println("MongoDB CREATE ");
        mongo.createCustomer(1, "John", "Yakuza", "JYK_77", "88 Kamurocho", "Large");
        mongo.createCustomer(2, "Snow", "Man", "SNWM_99", "111 Kozak ST", "Medium");
        mongo.createCustomer(3, "Yui", "Tori", "YUTI09", "9812 Clover DR", "Small");

        System.out.println("MongoDB READ ");
        mongo.readCustomers();

        System.out.println("MongoDB UPDATE");
        mongo.updateCustomer(2, "@brian_updated", "XLarge");
        mongo.readCustomers();

        System.out.println(" MongoDB DELETE");
        mongo.deleteCustomer(3);
        mongo.readCustomers();
    }
}