package Interfaces;

//Imports
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class HomeScreen extends JFrame{
    public HomeScreen(){
        //JFrame Definitions
        setTitle("Grain Storage Managment System"); //Title Changed
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        //JFrame Logo
        ImageIcon iconImage = new ImageIcon(getClass().getResource("assets/icon.png"));
        Image image = iconImage.getImage();
        setIconImage(image);

        //JFrame Background Image
        ImageIcon backgroundImageSet = new ImageIcon(getClass().getResource("assets/HomeScreenBackground.png"));
        Image imageSet = backgroundImageSet.getImage();
        Image resizedImage = imageSet.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(resizedImage);
        JLabel backgroundImageSetter = new JLabel(backgroundImage);
        backgroundImageSetter.setBounds(0, 0, 1000, 700);

        /*//JFrame Logo Image
        ImageIcon logoImageSet = new ImageIcon(getClass().getResource("Assets/Logo.png"));
        Image logoSet = logoImageSet.getImage();
        Image resizedLogoImage = logoSet.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        ImageIcon logoImage = new ImageIcon(resizedLogoImage);
        JLabel logoImageSetter = new JLabel(logoImage);
        logoImageSetter.setBounds(50, 20, 400, 200);*/
        
        //JButton for Login Link
        JButton loginPageButton = new JButton("Login");
        loginPageButton.setBounds(50, 370, 300, 80);
        loginPageButton.setBackground(new Color(27, 17, 14));
        loginPageButton.setBorderPainted(false);
        loginPageButton.setForeground(Color.WHITE);
        loginPageButton.setFont(new Font("Arial", Font.BOLD, 40));

        //JButton for SignUp Link
        JButton SignUpPageButton = new JButton("Signup");
        SignUpPageButton.setBounds(50, 470, 300, 80);
        SignUpPageButton.setBackground(new Color(27, 17, 14));
        SignUpPageButton.setBorderPainted(false);
        SignUpPageButton.setForeground(Color.WHITE);
        SignUpPageButton.setFont(new Font("Arial", Font.BOLD, 40));


        //Event actions defined for Login
        loginPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new LoginScreen().setVisible(true);
            }
        });

        //Event actions defined for SignUp
        SignUpPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new SignupScreen().setVisible(true);
            }
        });
    
    
    //Add Elements to the Frame
    add(loginPageButton);
    //add(SignUpPageButton);
    //add(logoImageSetter);
    //add(backgroundImageSetter);
    
    
}   
}
