package Interfaces;

//Imports
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.buyerController;
import dto.buyerDto;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import java.awt.*;

//Java Class Imports

import Interfaces.SignUpScreenBuyer;



public class SignUpScreenBuyer extends JFrame{
    public SignUpScreenBuyer(){
        buyerController buyerController = new buyerController();


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

        // JFrame Background Image
        ImageIcon backgroundImageSet = new ImageIcon(getClass().getResource("Assets/sideView.png"));
        Image imageSet = backgroundImageSet.getImage();
        Image resizedImage = imageSet.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
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
        JLabel SignUpText = new JLabel("Sign-Up");
        SignUpText.setBounds(150, 140, 300, 100);
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
                        String password = userPasswordTextBox.getText().trim();
                        String confirmPassword = userConfirmPasswordTextBox.getText().trim();

                            String userId = userIDTextBox.getText().trim();
                            if (!userId.matches("B\\d{3}")) { // Check if userID matches the format S followed by three digits
                                JOptionPane.showMessageDialog(null, "User ID must be like B001.");
                                return;
                            }
                
                            // Check if passwords match
                            if (!password.equals(confirmPassword)) {
                                JOptionPane.showMessageDialog(null, "Passwords do not match.");
                                return;
                            }
                
                           
                            try{
                            buyerDto buyerDto = new buyerDto(userIDTextBox.getText(),fullName,password,userMobileTextBox.getText());
        
                            String result = buyerController.createAccount(buyerDto);
                            JOptionPane.showMessageDialog(null, result);
                            clearFields();
                            dispose(); // Close the current Signup screen
                            new DashboardView().setVisible(true); // Open the new Dashboard screen
                            
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Failed to create Employee account.");
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
            
}

