/* Create Database */
CREATE DATABASE Grain_Management_System;

/* Use the Created Database */
USE Grain_Management_System;

/* Create Warehouse Table */
CREATE TABLE warehouse (
    Warehouse_ID CHAR(5) NOT NULL PRIMARY KEY,
    Warehouse_name VARCHAR(45) NOT NULL,
    Max_Capacity INT NOT NULL,
    Location VARCHAR(45) NOT NULL
);

/* Create Employee Table */
CREATE TABLE employee (
    Employee_ID CHAR(5) NOT NULL PRIMARY KEY,
    First_name VARCHAR(30) NOT NULL,
    Second_name VARCHAR(30) NOT NULL,
    User_Password VARCHAR(10) NOT NULL,
    Warehouse_ID CHAR(5) NOT NULL,
    FOREIGN KEY (Warehouse_ID) REFERENCES warehouse(Warehouse_ID)
);

/* Telephone Numbers for Employee */
CREATE TABLE employee_telephone (
    Telephone_no_ID INT AUTO_INCREMENT PRIMARY KEY,
    Employee_ID CHAR(5) NOT NULL,
    Telephone_no CHAR(10) NOT NULL,
    FOREIGN KEY (Employee_ID) REFERENCES employee(Employee_ID)
);

/* Create Stock Table */
CREATE TABLE stock (
    Stock_ID CHAR(5) NOT NULL PRIMARY KEY,
    Stock_name VARCHAR(45) NOT NULL,
    Stock_type VARCHAR(45) NOT NULL,
    Quantity INT DEFAULT 0,
    Total_Availability INT DEFAULT 0
);

/* Create Buyer Table */
CREATE TABLE buyer (
    Buyer_ID CHAR(5) NOT NULL PRIMARY KEY,
    Buyer_name VARCHAR(45) NOT NULL
);

/* Telephone Numbers for Buyer */
CREATE TABLE buyer_telephone (
    Telephone_no_ID INT AUTO_INCREMENT PRIMARY KEY,
    Buyer_ID CHAR(5) NOT NULL,
    Telephone_no CHAR(10) NOT NULL,
    FOREIGN KEY (Buyer_ID) REFERENCES buyer(Buyer_ID)
);



/* Telephone Numbers for Warehouse */
CREATE TABLE warehouse_telephone (
    Telephone_no_ID INT AUTO_INCREMENT PRIMARY KEY,
    Warehouse_ID CHAR(5) NOT NULL,
    Telephone_no VARCHAR(15) NOT NULL,
    FOREIGN KEY (Warehouse_ID) REFERENCES warehouse(Warehouse_ID)
);

/* Table for Relationship Between Stock and Warehouse (Many-to-Many) */
CREATE TABLE stock_store (
    Stock_ID CHAR(5) NOT NULL,
    Warehouse_ID CHAR(5) NOT NULL,
    PRIMARY KEY (Stock_ID, Warehouse_ID),
    FOREIGN KEY (Stock_ID) REFERENCES stock(Stock_ID),
    FOREIGN KEY (Warehouse_ID) REFERENCES warehouse(Warehouse_ID)
);

/* Table for Relationship Between Stock and Buyer (Many-to-Many) */
CREATE TABLE stock_obtain (
    Stock_ID CHAR(5) NOT NULL,
    Buyer_ID CHAR(5) NOT NULL,
    Quantity_obtained INT NOT NULL,
    Obtain_Date DATE NOT NULL,
    PRIMARY KEY (Stock_ID, Buyer_ID),
    FOREIGN KEY (Stock_ID) REFERENCES stock(Stock_ID),
    FOREIGN KEY (Buyer_ID) REFERENCES buyer(Buyer_ID)
);
