package Interfaces;

//Imports
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;

//Java Class Imports

import Interfaces.LoginScreenBuyer;
import db.DBConnection;


public class LoginScreenBuyer extends JFrame{

    private JTextField userIdTextBox;
    private JPasswordField userPasswordTextBox;

    public LoginScreenBuyer(){

        // JFrame Definitions
        setTitle("Grain Store Management System"); // Title Changed
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        // JFrame Logo
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

        // JFrame Logo Image
        ImageIcon logoImageSet = new ImageIcon(getClass().getResource("Assets/Logo.png"));
        Image logoSet = logoImageSet.getImage();
        Image resizedLogoImage = logoSet.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        ImageIcon logoImage = new ImageIcon(resizedLogoImage);
        JLabel logoImageSetter = new JLabel(logoImage);
        logoImageSetter.setBounds(60, 50, 400, 200);

        // JPanel for Context Box
        JPanel contentBox = new JPanel();
        contentBox.setBounds(30, 30, 400, 600);
        contentBox.setBackground(new Color(237, 235, 235));

        // JLabel For Login Text
        JLabel loginText = new JLabel("Login  for Buyers");
        loginText.setBounds(170, 210, 200, 100);
        loginText.setForeground(Color.black);
        loginText.setFont(new Font("Arial", Font.BOLD, 24));

        // Text Fields Defined for UserId
        userIdTextBox = new JTextField("Enter your User ID");
        userIdTextBox.setBounds(120, 320, 180, 40);
        userIdTextBox.setFont(new Font("Arial", Font.ITALIC, 13));

        // Text Fields Defined for Password
        userPasswordTextBox = new JPasswordField("Enter your Password");
        userPasswordTextBox.setBounds(120, 380, 180, 40);
        userPasswordTextBox.setFont(new Font("Arial", Font.ITALIC, 13));

        // Buttons defined for Submit
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(225, 440, 100, 40);
        submitButton.setBackground(new Color(166, 164, 164));
        submitButton.setForeground(Color.white);
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));

        // Buttons defined for Back
        JButton backButton = new JButton("Back");
        backButton.setBounds(100, 440, 100, 40);
        backButton.setBackground(new Color(166, 164, 164));
        backButton.setForeground(Color.white);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));

        // Buttons defined for NoAccount
        JButton noAccountButton = new JButton("I don't have an Account");
        noAccountButton.setBounds(100, 500, 220, 40);
        noAccountButton.setBorder(null);
        noAccountButton.setForeground(Color.BLACK);
        noAccountButton.setBackground(new Color(237, 235, 235));
        noAccountButton.setFont(new Font("Arial", Font.BOLD, 16));

        // Event actions defined for backButton
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomeScreen().setVisible(true);
            }
        });

        // Event actions defined for I dont have an Account
        noAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SignUpScreenBuyer().setVisible(true);
            }
        });
 
        // Event actions defined for Submit Button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    loginOnAction();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Add Focus Listeners for Placeholder Text (User ID and Password)
        userIdTextBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (userIdTextBox.getText().equals("Enter your User ID")) {
                    userIdTextBox.setText("");
                    userIdTextBox.setFont(new Font("Arial", Font.PLAIN, 13));
                    userIdTextBox.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (userIdTextBox.getText().isEmpty()) {
                    userIdTextBox.setText("Enter your User ID");
                    userIdTextBox.setFont(new Font("Arial", Font.ITALIC, 13));
                    userIdTextBox.setForeground(Color.GRAY);
                }
            }
        });
 
        userPasswordTextBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (new String(userPasswordTextBox.getPassword()).equals("Enter your Password")) {
                    userPasswordTextBox.setText("");
                    userPasswordTextBox.setFont(new Font("Arial", Font.PLAIN, 13));
                    userPasswordTextBox.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (new String(userPasswordTextBox.getPassword()).isEmpty()) {
                    userPasswordTextBox.setText("Enter your Password");
                    userPasswordTextBox.setFont(new Font("Arial", Font.ITALIC, 13));
                    userPasswordTextBox.setForeground(Color.GRAY);
                }
            }
        });

        // Add Elements to the Frame
        add(logoImageSetter);
        add(loginText);
        add(userPasswordTextBox);
        add(userIdTextBox);
        add(submitButton);
        add(noAccountButton);
        add(backButton);
        add(contentBox);
        add(backgroundImageSetter);
    }

    // Load Dashboard after successful login
    private void loadDashboard() {
        new DashboardView().setVisible(true);
        this.dispose();
    }
 
    // Method for handling login actions
    public void loginOnAction() throws IOException, SQLException {
         String user = userIdTextBox.getText();
        String pw = String.valueOf(userPasswordTextBox.getPassword());

        PreparedStatement ps;
        ResultSet rst;

        String query = "SELECT * FROM BUYER WHERE Buyer_ID = ? AND Buyer_Password = ?";

        if (user.trim().toLowerCase().equals("Buyer_ID") || pw.trim().toLowerCase().equals("Buyer_Password")) {
            System.out.println("Enter a valid username & password");
        } else {
            ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pw);
            rst = ps.executeQuery();
            if (rst.next()) {
                loadDashboard();
            } else {
                JOptionPane.showMessageDialog(LoginScreenBuyer.this, "Invalid username or password");
            }
        }
    }
}


