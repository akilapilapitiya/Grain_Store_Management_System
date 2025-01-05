package Interfaces;

//Imports
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

//Java Class Imports
import Interfaces.StockSales;
import controller.salesController;
import db.DBConnection;
import dto.salesdto;


public class StockSales extends JFrame{

    private JComboBox<String> dropdown;
    private JComboBox<String> dropdown2;
    private JTextField BuyerIDTextBox;
    private JTextField StockQuantityTextBox;

    private salesController salesController;

    public StockSales(){

        salesController = new salesController();

        //JFrame Definitions
        setTitle("Grain Store Managment System"); //Title Changed
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        //JFrame Logo
        ImageIcon iconImage = new ImageIcon(getClass().getResource("assets/icon.png"));
        Image image = iconImage.getImage();
        setIconImage(image);

        //JFrame Background Image
        ImageIcon backgroundImageSet = new ImageIcon(getClass().getResource("Assets/sideView.png"));
        Image imageSet = backgroundImageSet.getImage();
        Image resizedImage = imageSet.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(resizedImage);
        JLabel backgroundImageSetter = new JLabel(backgroundImage);
        backgroundImageSetter.setBounds(100, 0, 1000, 700);

        //JFrame Logo Image
        ImageIcon logoImageSet = new ImageIcon(getClass().getResource("Assets/Logo.png"));
        Image logoSet = logoImageSet.getImage();
        Image resizedLogoImage = logoSet.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        ImageIcon logoImage = new ImageIcon(resizedLogoImage);
        JLabel logoImageSetter = new JLabel(logoImage);
        logoImageSetter.setBounds(40, 0, 200, 100);

        //JPanel for menu Box
        JPanel menuBox = new JPanel();
        menuBox.setBounds(10, 10, 250, 640);
        menuBox.setBackground(Color.WHITE);

        //JPanel for Body Box
        JPanel bodyBox = new JPanel();
        bodyBox.setBounds(260, 10, 710, 640);
        //bodyBox.setBackground(new Color(237, 235, 235));
        bodyBox.setBackground(Color.WHITE);

        //JPanel for Title Box
        JPanel titleBox = new JPanel();
        titleBox.setBounds(260, 0, 740, 75);
        titleBox.setBackground(new Color(172, 145, 127));

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        //JLabel For Interface Title
        JLabel titleLabel = new JLabel("Stock Sales");
        titleLabel.setBounds(310, 15, 400, 50);
        titleLabel.setBackground(new Color(237, 235, 235));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));

        //Buttons defined for DashBoard
        JButton dashBoardButton = new JButton("Dashboard");
        dashBoardButton.setBounds(10, 140, 250, 50);
        dashBoardButton.setBackground(Color.WHITE);
        dashBoardButton.setForeground(new Color(27, 17, 14));
        dashBoardButton.setFont(new Font("Arial", Font.BOLD, 20));
        dashBoardButton.setBorder(border);

        //Buttons defined for Stock Availability
        JButton availabilityButton = new JButton("Stock Availability");
        availabilityButton.setBounds(10, 220, 200, 50);
        availabilityButton.setBackground(new Color(237, 235, 235));
        availabilityButton.setForeground(Color.BLACK);
        availabilityButton.setFont(new Font("Arial", Font.BOLD, 20));
        availabilityButton.setBorder(border);

        //Buttons defined for Report Generation
        JButton reportButton = new JButton("Report");
        reportButton.setBounds(10, 300, 200, 50);
        reportButton.setBackground(new Color(237, 235, 235));
        reportButton.setForeground(Color.BLACK);
        reportButton.setFont(new Font("Arial", Font.BOLD, 20));
        reportButton.setBorder(border);

        //Buttons defined for manage Stocks
        JButton manageStocksButton = new JButton("Manage Stocks");
        manageStocksButton.setBounds(10, 380, 200, 50);
        manageStocksButton.setBackground(new Color(237, 235, 235));
        manageStocksButton.setForeground(Color.BLACK);
        manageStocksButton.setFont(new Font("Arial", Font.BOLD, 20));
        manageStocksButton.setBorder(border);

        //Buttons defined for manage Warehouses
        JButton manageWarehouseButton = new JButton("Manage Warehouses");
        manageWarehouseButton.setBounds(10, 460, 200, 50);
        manageWarehouseButton.setBackground(new Color(237, 235, 235));
        manageWarehouseButton.setForeground(Color.BLACK);
        manageWarehouseButton.setFont(new Font("Arial", Font.BOLD, 20));
        manageWarehouseButton.setBorder(border);

         //Buttons defined for Logout
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(10, 570, 200, 50);
        logoutButton.setBackground(new Color(237, 235, 235));
        logoutButton.setForeground(Color.BLACK);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 20));
        logoutButton.setBorder(border);

        //Select Crop Name
        dropdown = new JComboBox<>();
        dropdown.setBounds(360, 160, 240, 40);
        dropdown.setFont(new Font("Arial", Font.ITALIC, 20));
        dropdown.setBackground(Color.WHITE);

        //Select Warehouse Name
        dropdown2 = new JComboBox<>();
        dropdown2.setBounds(620, 220, 240, 40);
        dropdown2.setFont(new Font("Arial", Font.ITALIC, 20));
        dropdown2.setBackground(Color.WHITE);

        //TextBox defined for StockId
        BuyerIDTextBox = new JTextField("Enter Buyer ID");
        BuyerIDTextBox.setBounds(620, 160, 240, 40);
        BuyerIDTextBox.setFont(new Font("Arial", Font.ITALIC, 20));

        //Add Item Button
        JButton addStockButton = new JButton("Complete Order");
        addStockButton.setBounds(360, 300, 240, 50);
        addStockButton.setBackground(new Color(237, 235, 235));
        addStockButton.setForeground(Color.BLACK);
        addStockButton.setFont(new Font("Arial", Font.BOLD, 20));
        addStockButton.setBorder(border);

        
        //TextBox defined for StockQuantity
        StockQuantityTextBox = new JTextField("Enter Stock Quantity");
        StockQuantityTextBox.setBounds(360, 220, 240, 40);
        StockQuantityTextBox.setFont(new Font("Arial", Font.ITALIC, 20));
        

        //Event actions defined for Dashboard Button
        dashBoardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new DashboardView().setVisible(true);
            }
        });

        //Event actions defined for StockAvailabitity Button
        availabilityButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new StockAvailability().setVisible(true);
            }
        });

        //Event actions defined for Reports Button
        reportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new ReportGenerate().setVisible(true);
            }
        });

        //Event actions defined for manage Stocks Button
        manageStocksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new ManageStocks().setVisible(true);
            }
        });

        //Event actions defined for manage Warehouse Button
        manageWarehouseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new ManageWarehouse().setVisible(true);
            }
        });

        //Event actions defined for Logout Button
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new HomeScreen().setVisible(true);
            }
        });
        StockQuantityTextBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Add Focus
                StockQuantityTextBox.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Lose Focus
                if (StockQuantityTextBox.getText().isEmpty()) {
                    StockQuantityTextBox.setText("Enter Stock Quantity");
                }
            }
        });
        BuyerIDTextBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Add Focus
                BuyerIDTextBox.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Lose Focus
                if (BuyerIDTextBox.getText().isEmpty()) {
                    BuyerIDTextBox.setText("Enter Buyer ID");
                }
            }
        });

        addStockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    addToOrder();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        
        
        //Add Elements to the Frame
        add(logoImageSetter);
        add(titleLabel);
        add(dashBoardButton);
        add(availabilityButton);
        add(reportButton);
        add(manageStocksButton);
        add(manageWarehouseButton);
        add(logoutButton);
        add(dropdown);
        add(dropdown2);
        add(addStockButton);

        add(StockQuantityTextBox);
        add(BuyerIDTextBox);
        add(titleBox);
        add(menuBox);
        //add(bodyBox);
        add(backgroundImageSetter);

        loadStocks();
        loadWarehouse();
        
    } 

            private void loadStocks() {
                dropdown.removeAllItems();
                try {
                    String query = "SELECT Stock_name FROM stock";
                    Connection connection = DBConnection.getInstance().getConnection();
                    PreparedStatement pst = connection.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        dropdown.addItem(rs.getString("Stock_name")); // Add each type
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            private void loadWarehouse() {
                dropdown2.removeAllItems();
                try {
                    String query = "SELECT Warehouse_name FROM warehouse";
                    Connection connection = DBConnection.getInstance().getConnection();
                    PreparedStatement pst = connection.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        dropdown2.addItem(rs.getString("Warehouse_name")); // Add each type
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
            private void addToOrder() throws Exception {
                try {
                    

                    String stockName = dropdown.getSelectedItem().toString();
                   
                    double quantity = Double.parseDouble(StockQuantityTextBox.getText());
                    String warehouseName = dropdown2.getSelectedItem().toString();

                    String stockId = getIdByNameAndWarehouse(stockName, getWarehouseIdByName(warehouseName));

                    salesdto salesdto = new salesdto(stockId,BuyerIDTextBox.getText(),Double.parseDouble(StockQuantityTextBox.getText()),getWarehouseIdByName(dropdown2.getSelectedItem().toString()));
                    
                    updateStockAndWarehouse(stockId, getWarehouseIdByName(warehouseName), quantity);

                    String result = salesController.addsales(salesdto);
                    JOptionPane.showMessageDialog(this, result, "Order Completed Successfully", JOptionPane.INFORMATION_MESSAGE);

                    Clear();
                    
                    } catch (Exception ex) {
                        Logger.getLogger(StockSales.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
            }
            public String getIdByNameAndWarehouse(String name, String Warehouse) {
                String id = null;
                try {
                    // Establish database connection
                    Connection connection = DBConnection.getInstance().getConnection();
            
                    // SQL query to get the ID based on the name
                    String query = "SELECT Stock_ID FROM stock WHERE Stock_name = ? AND Warehouse = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
            
                    // Set the name parameter
                    preparedStatement.setString(1, name.trim());
                    preparedStatement.setString(2, Warehouse.trim());
            
                    // Execute the query
                    ResultSet resultSet = preparedStatement.executeQuery();
            
                    // Retrieve the ID if a record is found
                    if (resultSet.next()) {
                        id = resultSet.getString("Stock_ID");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error retrieving ID by name: " + e.getMessage());
                }
                return id; // Returns null if no record is found
            }
            public String getWarehouseIdByName(String name) {
                String id = null;
                try {
                    // Establish database connection
                    Connection connection = DBConnection.getInstance().getConnection();
            
                    // SQL query to get the ID based on the name
                    String query = "SELECT Warehouse_ID FROM warehouse WHERE Warehouse_name = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
            
                    // Set the name parameter
                    preparedStatement.setString(1, name);
            
                    // Execute the query
                    ResultSet resultSet = preparedStatement.executeQuery();
            
                    // Retrieve the ID if a record is found
                    if (resultSet.next()) {
                        id = resultSet.getString("Warehouse_ID");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error retrieving ID by name: " + e.getMessage());
                }
                return id; // Returns null if no record is found
            }
            private void Clear() {
                BuyerIDTextBox.setText("");
                StockQuantityTextBox.setText("");
                dropdown.setSelectedItem("Please Select");
                dropdown2.setSelectedItem("Please Select");;

            }

            private void updateStockAndWarehouse(String stockId, String warehouseID, double quantity) {
                try {
                    // Establish database connection
                    Connection connection = DBConnection.getInstance().getConnection();
                    Statement statement = connection.createStatement();
            
                    // Update stock quantity
                    String updateStockQuery = "UPDATE stock SET Quantity = Quantity - " + quantity + 
                                              " WHERE Stock_ID = '" + stockId + "'";
                    statement.executeUpdate(updateStockQuery);
            
                    // Update warehouse quantity
                    String updateWarehouseQuery = "UPDATE warehouse SET Qty = Qty - " + quantity + 
                                                  " WHERE Warehouse_ID = '" + warehouseID + "'";
                    statement.executeUpdate(updateWarehouseQuery);
            
                    JOptionPane.showMessageDialog(this, "Stock and warehouse quantities updated successfully.");
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error updating quantities: " + e.getMessage());
                }
            }
            
}


