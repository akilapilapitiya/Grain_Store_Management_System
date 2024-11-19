/* Use the Created Database */
USE Grain_Management_System;

/* Insert Data into Warehouse */
INSERT INTO warehouse (Warehouse_ID, Warehouse_name, Max_Capacity, Location)
VALUES 
/*Warehouse_ID,  Warehouse_name    , Max_Capacity,  Location*/
('W001'       , 'Kandy_Warehouse'  , 1000        , 'City Center'),
('W002'       , 'Colombo_Warehouse', 800         , 'Eastside'),
('W003'       , 'Jaffna_Warehouse' , 600         , 'Westside');

/* Insert Data into Employee */
INSERT INTO employee (Employee_ID, First_name, Second_name, User_Password, Warehouse_ID)
VALUES 
/*Employee_ID, First_name, Second_name  , User_Password, Warehouse_ID*/
('E001'      , 'Nimal  ' , 'Perera'     , 'pass123'    , 'W001'),
('E002'      , 'Kamal'   , 'Amarasinghe', 'pass456'    , 'W002'),
('E003'      , 'Sumal'   , 'Rathnayaka' , 'pass789'    , 'W003');

/* Insert Data into Employee Telephone */
INSERT INTO employee_telephone (Employee_ID, Telephone_no)
VALUES 
/*Employee_ID, Telephone_no*/
('E001'      , '0776541289'),
('E002'      , '0765329842'),
('E003'      , '0758329468');

/* Insert Data into Stock */
INSERT INTO stock (Stock_ID, Stock_name, Stock_type, Quantity, Total_Availability)
VALUES 
/*Stock_ID, Stock_name   , Stock_type, Quantity, Total_Availability*/
('R001'   , 'Suwadel'    , 'Rice'    , 500     , 1000),
('R002'   , 'Kuruluthuda', 'Rice'    , 300     , 800),
('R003'   , 'Samba'      , 'Rice'    , 200     , 600);

/* Insert Data into Buyer */
INSERT INTO buyer (Buyer_ID, Buyer_name)
VALUES 
/*Buyer_ID, Buyer_name*/
('B001'   , 'ABC Traders'),
('B002'   , 'XYZ Wholesalers'),
('B003'   , 'PQR Retailers');

/* Insert Data into Buyer Telephone */
INSERT INTO buyer_telephone (Buyer_ID, Telephone_no)
VALUES 
/*Buyer_ID, Telephone_no*/
('B001'   , '0712548652'),
('B002'   , '0776583295'),
('B003'   , '0758965315');

/* Insert Data into Warehouse Telephone */
INSERT INTO warehouse_telephone (Warehouse_ID, Telephone_no)
VALUES 
/*Warehouse_ID, Telephone_no*/
('W001'       , '0769823541'),
('W002'       , '0774953684'),
('W003'       , '0768324951');

/* Insert Data into Stock Store (Stock and Warehouse Relationship) */
INSERT INTO stock_store (Stock_ID, Warehouse_ID)
VALUES 
/*Stock_ID, Warehouse_ID*/
('R001'   , 'W001'),
('R002'   , 'W002'),
('R003'   , 'W003');

/* Insert Data into Stock Obtain (Stock and Buyer Relationship) */
INSERT INTO stock_obtain (Stock_ID, Buyer_ID, Quantity_obtained, Obtain_Date)
VALUES 
/*Stock_ID, Buyer_ID, Quantity_obtained, Obtain_Date*/
('S001'   , 'B001'  , 100              , '2024-11-01'),
('S002'   , 'B002'  , 150              , '2024-11-05'),
('S003'   , 'B003'  , 50               , '2024-11-10');
