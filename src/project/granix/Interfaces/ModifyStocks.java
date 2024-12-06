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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


//Java Class Imports

import Interfaces.ModifyStocks;
import controller.stockController;
import db.DBConnection;
import dto.stockDto;


public class ModifyStocks extends JFrame{

    private JTextField StockIDTextBox;
    private JTextField StockNameTextBox;
    private JTextField StockQuantityTextBox;
    private JTextField ppuTextField;

    //public static List<String> sectors = Arrays.asList("Government", "Private");
    private JComboBox<String> dropdownType;
    private stockController stockController;

    private JTable viewTable;
    private DefaultTableModel dtm;

    public ModifyStocks(){

        stockController = new stockController();
      
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
                JLabel titleLabel = new JLabel("Add New Stocks");
                titleLabel.setBounds(310, 15, 600, 50);
                titleLabel.setBackground(new Color(237, 235, 235));
                titleLabel.setForeground(Color.WHITE);
                titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        
                //Buttons defined for DashBoard
                JButton dashBoardButton = new JButton("Dashboard");
                dashBoardButton.setBounds(10, 140, 200, 50);
                dashBoardButton.setBackground(new Color(237, 235, 235));
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
                manageStocksButton.setBounds(10, 380, 250, 50);
                manageStocksButton.setBackground(Color.WHITE);
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
        
                //TextBox defined for StockId
                StockIDTextBox = new JTextField("Enter Stock ID");
                StockIDTextBox.setBounds(360, 140, 240, 40);
                StockIDTextBox.setFont(new Font("Arial", Font.ITALIC, 20));
        
                //TextBox defined for StockName
                StockNameTextBox = new JTextField("Enter Stock Name");
                StockNameTextBox.setBounds(620, 140, 240, 40);
                StockNameTextBox.setFont(new Font("Arial", Font.ITALIC, 20));
        
                //TextBox defined for StockQuantity
                StockQuantityTextBox = new JTextField("Enter Stock Quantity");
                StockQuantityTextBox.setBounds(360, 200, 240, 40);
                StockQuantityTextBox.setFont(new Font("Arial", Font.ITALIC, 20));
                
                //Select Crop store Sector
                dropdownType = new JComboBox<>();
                dropdownType.setBounds(620, 200, 240, 40);
                dropdownType.setFont(new Font("Arial", Font.ITALIC, 20));
                dropdownType.setBackground(Color.WHITE);
        
                //TextBox defined for StockQuantity
                ppuTextField = new JTextField("Price Per Unit");
                ppuTextField.setBounds(360, 260, 240, 40);
                ppuTextField.setFont(new Font("Arial", Font.ITALIC, 20));
        
        
                //Save item button
                JButton saveItemButton = new JButton("Modify Item");
                saveItemButton.setBounds(620, 320, 200, 50);
                saveItemButton.setBackground(new Color(237, 235, 235));
                saveItemButton.setForeground(Color.BLACK);
                saveItemButton.setFont(new Font("Arial", Font.BOLD, 20));
                saveItemButton.setBorder(border);
        
                // Create a table model
                dtm = new DefaultTableModel();
        
                // Create a JTable using the model
                viewTable = new JTable(dtm);
                
        
                //Table Appearance Customizations
                viewTable.setFont(new Font("Arial",Font.PLAIN, 14));
                viewTable.setRowHeight(30);
                viewTable.setBackground(new Color(237, 235, 235));
                viewTable.setForeground(Color.BLACK);
                viewTable.setGridColor(Color.DARK_GRAY);
                viewTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
                viewTable.getTableHeader().setBackground(new Color(172, 145, 127));
                viewTable.getTableHeader().setForeground(Color.WHITE);
        
                
                // Add the table to a JScrollPane for scroll functionality
                JScrollPane scrollPane = new JScrollPane(viewTable);
                scrollPane.setBounds(300, 390, 600, 150);
                scrollPane.setBackground(new Color(237, 235, 235));
                scrollPane.getViewport().setBackground(new Color(237, 235, 235));
                scrollPane.setBorder(new EmptyBorder(0,0,0,0));
        
                // Add a FocusListener for StockIDTextBox
                StockIDTextBox.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        // Add Focus
                        StockIDTextBox.setText("");
                    }
        
                    @Override
                    public void focusLost(FocusEvent e) {
                        // Lose Focus
                        if (StockIDTextBox.getText().isEmpty()) {
                            StockIDTextBox.setText("Enter Stock ID");
                        }
                    }
                });
        
                
                // Add a FocusListener for StockNameTextBox
                StockNameTextBox.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        // Add Focus
                        StockNameTextBox.setText("");
                    }
        
                    @Override
                    public void focusLost(FocusEvent e) {
                        // Lose Focus
                        if (StockNameTextBox.getText().isEmpty()) {
                            StockNameTextBox.setText("Enter Stock Name");
                        }
                    }
                });
        

                
                // Add a FocusListener for StockQuantityTextBox
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
        
                ppuTextField.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        // Add Focus
                        ppuTextField.setText("");
                    }
        
                    @Override
                    public void focusLost(FocusEvent e) {
                        // Lose Focus
                        if (ppuTextField.getText().isEmpty()) {
                            ppuTextField.setText("Price Per Unit");
                        }
                    }
                });
        
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

                saveItemButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        
                        try {
                            updateStock();
                        } catch (Exception e1) {
                            
                            e1.printStackTrace();
                        }
                        
                    }
                });
                
                viewTable.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        tableMouseCliked(evt);
                    }

                    private void tableMouseCliked(java.awt.event.MouseEvent evt) {
                        searchStock();
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
                add(StockIDTextBox);
                add(StockNameTextBox);
                add(StockQuantityTextBox);
                add(saveItemButton);
                add(dropdownType);
                add(scrollPane);
                add(titleBox);
                add(menuBox);
                add(ppuTextField);
                //add(bodyBox);
                add(backgroundImageSetter);

                loadallStock();
                loadWarehouse();

    } 

            private void loadWarehouse() {
                dropdownType.removeAllItems();
                try {
                    String query = "SELECT Warehouse_name FROM warehouse";
                    Connection connection = DBConnection.getInstance().getConnection();
                    PreparedStatement pst = connection.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        dropdownType.addItem(rs.getString("Warehouse_name")); // Add each type
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        

            private void updateStock() {
                try {
                    stockDto stockDto = new stockDto(StockIDTextBox.getText(), StockNameTextBox.getText(),Double.parseDouble(StockQuantityTextBox.getText()),Double.parseDouble(ppuTextField.getText()), getWarehouseIdByName(dropdownType.getSelectedItem().toString()));
                    //String result = stockController.updateStock(stockDto);
                    //JOptionPane.showMessageDialog(this, result);

                    if (canAddToWarehouse(stockDto.getWarehouse(), stockDto.getQuantity())) {
                        // Add the stock to the database
                        String result = stockController.updateStock(stockDto);
                        JOptionPane.showMessageDialog(this, result);
    
                        // Update the warehouse after adding the stock
                        updateWarehouse(stockDto.getWarehouse(), stockDto.getQuantity());
                    }
                        Clear();
                        loadallStock();
                        } catch (Exception ex) {
                            Logger.getLogger(ModifyStocks.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, ex.getMessage());
                        }
                    
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
                StockIDTextBox.setText("");
                StockNameTextBox.setText("");
                StockQuantityTextBox.setText("");
                ppuTextField.setText("");
                dropdownType.setSelectedItem("Please Select");;

            }
            private void loadallStock() {
                try {
                    String[] columns = {"Stock_ID", "Stock_name", "Quantity", "PPU","Warehouse"};
                    DefaultTableModel dtm = new DefaultTableModel(columns, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    viewTable.setModel(dtm);
            
                    ArrayList<stockDto> stocks = stockController.getAllStock();
                    for (stockDto stock : stocks) {
                        Object[] rowData = {
                            stock.getStock_ID(),
                            stock.getStock_name(),
                            stock.getQuantity(),
                            stock.getPPU(),
                            stock.getWarehouse()
                        };
                        dtm.addRow(rowData);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ModifyStocks.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }

            

            private void searchStock() {
                try {
                    String stockId = viewTable.getValueAt(viewTable.getSelectedRow(), 0).toString();
                    stockDto stockDto = stockController.getStock(stockId);

                    if (stockDto != null) {
                        StockIDTextBox.setText(stockDto.getStock_ID());
                        StockNameTextBox.setText(stockDto.getStock_name());
                        StockQuantityTextBox.setText(String.valueOf(stockDto.getQuantity()));
                        ppuTextField.setText(String.valueOf(stockDto.getPPU()));
                        dropdownType.setSelectedItem(stockDto.getWarehouse());;
                    } else {
                        JOptionPane.showMessageDialog(this, "Stock Not Found");
                    }

                } catch (Exception ex) {
                    Logger.getLogger(ModifyStocks.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
            private void updateWarehouse(String warehouseName, double addedQuantity) {
                try {
                    // SQL query to update the warehouse stock count or any other details
                    String query = "UPDATE warehouse SET Qty = ? WHERE Warehouse_ID = ?";
                    Connection connection = DBConnection.getInstance().getConnection();
                    PreparedStatement pst = connection.prepareStatement(query);
            
                    // Set the parameters
                    pst.setDouble(1, addedQuantity);
                    pst.setString(2, warehouseName);
            
                    // Execute the update
                    int updatedRows = pst.executeUpdate();
                    if (updatedRows > 0) {
                        System.out.println("Warehouse updated successfully.");
                    } else {
                        System.out.println("Warehouse update failed.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error updating warehouse: " + e.getMessage());
                }
            }
            
            private boolean canAddToWarehouse(String warehouseName, double addedQuantity) {
                try {
                    // SQL query to get current stock and max capacity of the warehouse
                    String query = "SELECT Qty, Max_Capacity FROM warehouse WHERE Warehouse_ID = ?";
                    Connection connection = DBConnection.getInstance().getConnection();
                    PreparedStatement pst = connection.prepareStatement(query);
            
                    // Set the parameter
                    pst.setString(1, warehouseName);
            
                    // Execute the query
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        double maxCapacity = rs.getDouble("Max_Capacity");
            
                        // Check if the new stock fits within the capacity
                        return (addedQuantity) <= maxCapacity;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error checking warehouse capacity: " + e.getMessage());
                }
                return false; // Default to false in case of an error
            }
}
