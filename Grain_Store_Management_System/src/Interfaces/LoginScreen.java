package Interfaces;

//Imports
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.*;

public class LoginScreen extends JFrame{
    public LoginScreen(){
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
        backgroundImageSetter.setBounds(0, 0, 1000, 700);

        //JFrame Logo Image
        ImageIcon logoImageSet = new ImageIcon(getClass().getResource("Assets/Logo.png"));
        Image logoSet = logoImageSet.getImage();
        Image resizedLogoImage = logoSet.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        ImageIcon logoImage = new ImageIcon(resizedLogoImage);
        JLabel logoImageSetter = new JLabel(logoImage);
        logoImageSetter.setBounds(60, 50, 400, 200);

        //JPanel for Context Box
        JPanel contentBox = new JPanel();
        contentBox.setBounds(30, 30, 400, 600);
        contentBox.setBackground(new Color(237, 235, 235));

        //JLabel For Login Text
        JLabel LoginText = new JLabel("Login");
        LoginText.setBounds(170, 210, 150, 100);
        LoginText.setForeground(Color.black);
        LoginText.setFont(new Font("Arial", Font.BOLD, 24));

        //Text Fields Defined for UserId
        JTextField userIdTextBox = new JTextField("Enter your User ID");
        userIdTextBox.setBounds(120, 320, 180, 40);
        userIdTextBox.setFont(new Font("Arial", Font.ITALIC, 13));

        //Text Fields Defined for Password
        JTextField userPasswordTextBox = new JTextField("Enter your Password");
        userPasswordTextBox.setBounds(120, 380, 180, 40);
        userPasswordTextBox.setFont(new Font("Arial", Font.ITALIC, 13));

        //Buttons defined for Submit
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(225, 440, 100, 40);
        submitButton.setBackground(new Color(166, 164, 164));
        submitButton.setForeground(Color.white);
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));

        //Buttons defined for Back
        JButton backButton = new JButton("Back");
        backButton.setBounds(100, 440, 100, 40);
        backButton.setBackground(new Color(166, 164, 164));
        backButton.setForeground(Color.white);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));

        //Buttons defined for NoAccount
        JButton noAccountButton = new JButton("I don't have an Account");
        noAccountButton.setBounds(100, 500, 220, 40);
        noAccountButton.setBorder(null);
        noAccountButton.setForeground(Color.BLACK);
        noAccountButton.setBackground(new Color(237, 235, 235));
        noAccountButton.setFont(new Font("Arial", Font.BOLD, 16));

        // Add a FocusListener for userIdTextBox
        userIdTextBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Add Focus
                userIdTextBox.setText("");    
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Lose Focus
                if (userIdTextBox.getText().isEmpty()) {
                    userIdTextBox.setText("Enter your User ID");
                }
            }
        });

        // Add a FocusListener for userPasswordTextBox
        userPasswordTextBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Add Focus
                userPasswordTextBox.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Lose Focus
                if (userPasswordTextBox.getText().isEmpty()) {
                    userPasswordTextBox.setText("Enter your Password");
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

        //Event actions defined for I dont have an Account
        noAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new SignupScreen().setVisible(true);
            }
        });

        //Event actions defined for Submit Button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new DashboardView().setVisible(true);
            }
        });


        //Add Elements to the Frame
        add(logoImageSetter);
        add(LoginText);
        add(userPasswordTextBox);
        add(userIdTextBox);
        add(submitButton);
        add(noAccountButton);
        add(backButton);
        add(contentBox);
        add(backgroundImageSetter);


    
    }
    
    
}
