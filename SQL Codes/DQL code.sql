/* Use the Created Database */
USE Grain_Management_System;

/*Select Queries*/
SELECT * FROM employee;
SELECT * FROM warehouse;
SELECT * FROM stock;
SELECT * FROM buyer;
SELECT * FROM employee_telephone;
SELECT * FROM buyer_telephone;
SELECT * FROM warehouse_telephone;
SELECT * FROM stock_store;
SELECT * FROM stock_obtain;

/*InnerJoin Queries*/
SELECT employee.First_name, warehouse.warehouse_name, employee_telephone.Telephone_no FROM employee
	JOIN warehouse ON (employee.Warehouse_ID = warehouse.Warehouse_ID)
    JOIN employee_telephone ON (employee.Employee_ID = employee_telephone.Employee_ID)
    WHERE(employee.Employee_ID = 'E002');
    
