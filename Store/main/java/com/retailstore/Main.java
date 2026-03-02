/** Project: LAB 3
 * Purpose Details: Class
 * Course: IST 242
 * Author: KEVIN AJDINI
 * Date Developed: 3/1/2026
 * Last Date Changed: 3/1/2026
 * Rev: 3/1/2026

 */

package com.retailstore;
/** class being made */
public class Main {

    public static void main(String[] args) throws Exception {

        MySQLCustomer mysql = new MySQLCustomer();
        MongoCustomer mongo = new MongoCustomer();

/** creates set of costumers for MySQL database */
        System.out.println(" MySQL CREATE ");
        mysql.createCustomer(1, "John", "Yakuza", "JYK_77", "88 Kamurocho", "Large");
        mysql.createCustomer(2, "Snow", "Man", "SNWM_99", "111 Kozak ST", "Medium");
        mysql.createCustomer(3, "Yui", "Tori", "YUTI09", "9812 Clover DR", "Small");
/** gets and prints all costumers in database*/
        System.out.println(" MySQL READ ");
        mysql.readCustomers();
/** updates the second costumers information*/
        System.out.println(" MySQL UPDATE ");
        mysql.updateCustomer(2, "Snowtuffy", "XLarge");
        mysql.readCustomers();
/** deletes the third costumer*/
        System.out.println(" MySQL DELETE");
        mysql.deleteCustomer(3);
        mysql.readCustomers();

/** creates for mongoDB */
        System.out.println("MongoDB CREATE ");
        mongo.createCustomer(1, "John", "Yakuza", "JYK_77", "88 Kamurocho", "Large");
        mongo.createCustomer(2, "Snow", "Man", "SNWM_99", "111 Kozak ST", "Medium");
        mongo.createCustomer(3, "Yui", "Tori", "YUTI09", "9812 Clover DR", "Small");
/** prints out the information in mongo*/
        System.out.println("MongoDB READ ");
        mongo.readCustomers();
/** Updates the infromation for costumer with ID of 2 */
        System.out.println("MongoDB UPDATE");
        mongo.updateCustomer(2, "Snowtuffy", "XLarge");
        mongo.readCustomers();
/** deletes the third costumer*/
        System.out.println(" MongoDB DELETE");
        mongo.deleteCustomer(3);
        mongo.readCustomers();
    }
}