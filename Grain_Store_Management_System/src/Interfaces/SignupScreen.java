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
        JLabel SignUpText = new JLabel("Sign-up");
        SignUpText.setBounds(170, 140, 150, 100);
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
        String[] options = {"Goverment Sector", "Public Sector"};
        JComboBox<String> dropdown = new JComboBox<>(options);
        dropdown.setBounds(140, 540, 180, 40);
        dropdown.setBackground(Color.WHITE);
        //fetchWarehouseIDs(dropdown);
        
        

        // Add a FocusListener for userNameTextBox
        userNameTextBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Add Focus
                userNameTextBox.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Lose Focus
                if (userNameTextBox.getText().isEmpty()) {
                    userNameTextBox.setText("Enter your Name");
                }
            }
        });

        // Add a FocusListener for userMobileTextBox
        userMobileTextBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Add Focus
                userMobileTextBox.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Lose Focus
                if (userMobileTextBox.getText().isEmpty()) {
                    userMobileTextBox.setText("Enter your Mobile Number");
                }
            }
        });

        // Add a FocusListener for userPasswordTextBox 
        userPasswordTextBox .addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Add Focus
                userPasswordTextBox .setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Lose Focus
                if (userPasswordTextBox .getText().isEmpty()) {
                    userPasswordTextBox .setText("Enter a Password");
                }
            }
        });

        // Add a FocusListener for userConfirmPasswordTextBox
        userConfirmPasswordTextBox .addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Add Focus
                userConfirmPasswordTextBox.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Lose Focus
                if (userConfirmPasswordTextBox .getText().isEmpty()) {
                    userConfirmPasswordTextBox.setText("Confirm Password");
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

                //Variables Defined
                String userName = userNameTextBox.getText();
                String phoneNumber = userMobileTextBox.getText();
                String passwordDefined = userPasswordTextBox.getText();
                String confirmPasswordDefined = userConfirmPasswordTextBox.getText();
                
                if((userName == "Enter your Name")||(phoneNumber == "Enter your Mobile Number")||(passwordDefined == "Enter a Password")){
                        System.out.println("Hello");
                }
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

    }
    
}
