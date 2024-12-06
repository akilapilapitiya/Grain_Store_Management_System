package Interfaces;

//Imports
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.userController;
import db.DBConnection;
import dto.userDto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;

//Java Class Imports
import Interfaces.SignupScreen;


public class SignupScreen extends JFrame{
    public SignupScreen(){
        userController userController = new userController();


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
        Image resizedImage = imageSet.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(resizedImage);
        JLabel backgroundImageSetter = new JLabel(backgroundImage);
        backgroundImageSetter.setBounds(0, 0, 1000, 700);


        //JFrame Logo Image
        ImageIcon logoImageSet = new ImageIcon(getClass().getResource("Assets/Logo.png"));
        Image logoSet = logoImageSet.getImage();
        Image resizedLogoImage = logoSet.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        ImageIcon logoImage = new ImageIcon(resizedLogoImage);
        JLabel logoImageSetter = new JLabel(logoImage);
        logoImageSetter.setBounds(60, 20, 400, 200);

        //JPanel for Context Box
        JPanel contentBox = new JPanel();
        contentBox.setBounds(30, 30, 400, 600);
        contentBox.setBackground(new Color(237, 235, 235));

        //JLabel For Login Text
        JLabel SignUpText = new JLabel("Sign-up for Employee");
        SignUpText.setBounds(170, 140, 300, 100);
        SignUpText.setForeground(Color.black);
        SignUpText.setFont(new Font("Arial", Font.BOLD, 30));

        //Text Fields Defined for UserName
        JTextField userNameTextBox = new JTextField("Enter your User Name");
        userNameTextBox.setBounds(140, 300, 180, 40);
        userNameTextBox.setFont(new Font("Arial", Font.ITALIC, 13));

        //Text Fields Defined for Password
        JTextField userMobileTextBox = new JTextField("Enter your Mobile Number");
        userMobileTextBox.setBounds(140, 360, 180, 40);
        userMobileTextBox.setFont(new Font("Arial", Font.ITALIC, 13));

        //Text Fields Defined for Password
        JTextField userPasswordTextBox = new JTextField("Enter a Password");
        userPasswordTextBox.setBounds(140, 420, 180, 40);
        userPasswordTextBox.setFont(new Font("Arial", Font.ITALIC, 13));

        //Text Fields Defined for Confirm Password
        JTextField userConfirmPasswordTextBox = new JTextField("Confirm Password");
        userConfirmPasswordTextBox.setBounds(140, 480, 180, 40);
        userConfirmPasswordTextBox.setFont(new Font("Arial", Font.ITALIC, 13));
        
         //Buttons defined for Submit
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(245, 590, 100, 40);
        submitButton.setBackground(new Color(166, 164, 164));
        submitButton.setForeground(Color.white);
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));

        //Buttons defined for Back
        JButton backButton = new JButton("Back");
        backButton.setBounds(120, 590, 100, 40);
        backButton.setBackground(new Color(166, 164, 164));
        backButton.setForeground(Color.white);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));

        //Text Fields Defined for UserID
        JTextField userIDTextBox = new JTextField("Enter your User ID");
        userIDTextBox.setBounds(140, 240, 180, 40);
        userIDTextBox.setFont(new Font("Arial", Font.ITALIC, 13));

        // Create a dropdown list for Warehouse Type
        
        JComboBox<String> dropdown = new JComboBox<>();
        dropdown.setBounds(140, 540, 180, 40);
        dropdown.setBackground(Color.WHITE);
        fetchWarehouseIDs(dropdown);
        
        
    
                // Add a FocusListener for userNameTextBox
                userNameTextBox.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        // Add Focus
                        if (userNameTextBox.getText().equals("Enter your User Name")) {
                            userNameTextBox.setText("");
                            userNameTextBox.setFont(new Font("Arial", Font.PLAIN, 13));
                            userNameTextBox.setForeground(Color.BLACK);
                        }
                    }
        
                    @Override
                    public void focusLost(FocusEvent e) {
                        // Lose Focus
                        if (userNameTextBox.getText().isEmpty()) {
                            userNameTextBox.setText("Enter your User Name");
                            userNameTextBox.setFont(new Font("Arial", Font.ITALIC, 13));
                            userNameTextBox.setForeground(Color.GRAY);
                        }
                    }
                });
                userIDTextBox.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        // Add Focus
                        if (userIDTextBox.getText().equals("Enter your User ID")) {
                            userIDTextBox.setText("");
                            userIDTextBox.setFont(new Font("Arial", Font.PLAIN, 13));
                            userIDTextBox.setForeground(Color.BLACK);
                        }
                    }
        
                    @Override
                    public void focusLost(FocusEvent e) {
                        // Lose Focus
                        if (userIDTextBox.getText().isEmpty()) {
                            userIDTextBox.setText("Enter your User ID");
                            userIDTextBox.setFont(new Font("Arial", Font.ITALIC, 13));
                            userIDTextBox.setForeground(Color.GRAY);
                        }
                    }
                });
        
                // Add a FocusListener for userMobileTextBox
                userMobileTextBox.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        // Add Focus
                        if (userMobileTextBox.getText().equals("Enter your Mobile Number")) {
                            userMobileTextBox.setText("");
                            userMobileTextBox.setFont(new Font("Arial", Font.PLAIN, 13));
                            userMobileTextBox.setForeground(Color.BLACK);
                        }
                        
                    }
        
                    @Override
                    public void focusLost(FocusEvent e) {
                        // Lose Focus
                        if (userMobileTextBox.getText().isEmpty()) {
                            userMobileTextBox.setText("Enter your Mobile Number");
                            userMobileTextBox.setFont(new Font("Arial", Font.ITALIC, 13));
                            userMobileTextBox.setForeground(Color.GRAY);
                        }
                    }
                });
        
                // Add a FocusListener for userPasswordTextBox 
                userPasswordTextBox .addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        // Add Focus
                        if (userPasswordTextBox.getText().equals("Enter a Password")) {
                            userPasswordTextBox.setText("");
                            userPasswordTextBox.setFont(new Font("Arial", Font.PLAIN, 13));
                            userPasswordTextBox.setForeground(Color.BLACK);
                        }
                    }
        
                    @Override
                    public void focusLost(FocusEvent e) {
                        // Lose Focus
                        if (userPasswordTextBox.getText().isEmpty()) {
                            userPasswordTextBox.setText("Enter a Password");
                            userPasswordTextBox.setFont(new Font("Arial", Font.ITALIC, 13));
                            userPasswordTextBox.setForeground(Color.GRAY);
                        }
                    }
                });
        
                // Add a FocusListener for userConfirmPasswordTextBox
                userConfirmPasswordTextBox .addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        // Add Focus
                        if (userConfirmPasswordTextBox.getText().equals("Confirm Password")) {
                            userConfirmPasswordTextBox.setText("");
                            userConfirmPasswordTextBox.setFont(new Font("Arial", Font.PLAIN, 13));
                            userConfirmPasswordTextBox.setForeground(Color.BLACK);
                        }
                    }
        
                    @Override
                    public void focusLost(FocusEvent e) {
                        // Lose Focus
                        if (userConfirmPasswordTextBox.getText().isEmpty()) {
                            userConfirmPasswordTextBox.setText("Confirm Password");
                            userConfirmPasswordTextBox.setFont(new Font("Arial", Font.ITALIC, 13));
                            userConfirmPasswordTextBox.setForeground(Color.GRAY);
                        }
                    }
                });
        
                //Event actions defined for backButton
                backButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        dispose();
                        new HomeScreen().setVisible(true);
                    }
                });
                
        
                dropdown.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedWarehouse = (String) dropdown.getSelectedItem();
                        String warehouseId = getWarehouseIdByName(selectedWarehouse);
                        // Use the warehouseId to insert into Employee table
                    }
                });
                
                
                //Event actions defined for Submit Button
                submitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        
                    createAccount();
                }
                
                            
                private void createAccount() {
                    // TODO Auto-generated method stub
                    try {
                        // Get user input
                        String fullName = userNameTextBox.getText().trim();
                        String[] nameParts = fullName.split(" ");
                        if (nameParts.length >= 2) {
                            String firstName = nameParts[0];
                            String lastName = nameParts[1];
                            String password = userPasswordTextBox.getText().trim();
                            String confirmPassword = userConfirmPasswordTextBox.getText().trim();
                
                            // Check if passwords match
                            if (!password.equals(confirmPassword)) {
                                JOptionPane.showMessageDialog(null, "Passwords do not match.");
                                return;
                            }
                
                            // Retrieve warehouse ID from selected warehouse name
                            String selectedWarehouseName = (String) dropdown.getSelectedItem();
                            String warehouseId = getWarehouseIdByName(selectedWarehouseName);
                
                            if (warehouseId == null || warehouseId.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Invalid Warehouse selected.");
                                return;
                            }
                            try{
                            userDto userDto = new userDto(userIDTextBox.getText(),firstName,lastName,password, warehouseId,userMobileTextBox.getText());
        
                            String result = userController.createAccount(userDto);
                            JOptionPane.showMessageDialog(null, result);
                            clearFields();
                            dispose(); // Close the current Signup screen
                            new DashboardView().setVisible(true); // Open the new Dashboard screen
                            
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Failed to create Employee account.");
                            }
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter both first name and last name.");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    }
                }
                    
            private void clearFields() {
                userIDTextBox.setText("");
                userNameTextBox.setText("");
                userMobileTextBox.setText("");
                userPasswordTextBox.setText("");
                userConfirmPasswordTextBox.setText("");
                dropdown.setSelectedItem("please select");
            }
                    
                });
        
                
        
                //Add Elements to the Frame
                add(logoImageSetter);
                add(SignUpText);
                add(userIDTextBox);
                add(userNameTextBox);
                add(userMobileTextBox);
                add(userPasswordTextBox);
                add(userConfirmPasswordTextBox);
                add(dropdown);
                add(submitButton);
                add(backButton);
                add(contentBox);
                add(backgroundImageSetter);

                
                SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    // Manually set focus to a different component
                    submitButton.requestFocusInWindow(); // Set focus to Submit button or another component
                }
            });
            
        
            }
            
        
            private void fetchWarehouseIDs(JComboBox<String> dropdown) {
                // TODO Auto-generated method stub
                if (dropdown == null) {
                    JOptionPane.showMessageDialog(null, "Dropdown is not initialized.");
                    return;
                }
            
                try {
                    Connection connection = DBConnection.getInstance().getConnection();
                    if (connection == null) {
                        JOptionPane.showMessageDialog(null, "Database connection failed.");
                        return;
                    }
            
                    String sql = "SELECT warehouse_id, warehouse_name FROM warehouse";  // Assuming warehouse_name exists
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    ResultSet resultSet = preparedStatement.executeQuery();
            
                    // Clear any previous items in the dropdown
                    dropdown.removeAllItems();
                    dropdown.addItem("Please select a warehouse");
                    // Check if any records are found
                    boolean found = false;
                    while (resultSet.next()) {
                        //String warehouseId = resultSet.getString("warehouse_id");
                        String warehouseName = resultSet.getString("warehouse_name");
            
                        // Add the warehouse name and ID to the dropdown
                        dropdown.addItem(warehouseName);
                        found = true;
                    }
                    dropdown.setSelectedItem("Please select");
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "No warehouses found.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error fetching warehouse names: " + ex.getMessage());
                }
                
    }
    // Method to get Warehouse ID based on Warehouse Name
    public String getWarehouseIdByName(String warehouseName) {
        String warehouseId = null;
        try {
            String query = "SELECT Warehouse_ID FROM Warehouse WHERE Warehouse_Name = ?";
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, warehouseName);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                warehouseId = rs.getString("Warehouse_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return warehouseId;
    }
    
    
    
}
