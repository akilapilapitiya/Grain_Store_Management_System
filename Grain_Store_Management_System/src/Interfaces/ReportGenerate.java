package Interfaces;

import javax.swing.BorderFactory;
//Imports
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class ReportGenerate extends JFrame{
    public ReportGenerate(){
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
        JLabel titleLabel = new JLabel("Reports");
        titleLabel.setBounds(310, 15, 400, 50);
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
        reportButton.setBounds(10, 300, 250, 50);
        reportButton.setBackground(Color.WHITE);
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

        //Buttons defined for Logout
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(10, 570, 200, 50);
        logoutButton.setBackground(new Color(237, 235, 235));
        logoutButton.setForeground(Color.BLACK);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 20));
        logoutButton.setBorder(border);

        //JLabel For Scope Selection
        JLabel scopeLabel = new JLabel("Select the Desired Field");
        scopeLabel.setBounds(420, 100, 400, 20);
        scopeLabel.setForeground(Color.BLACK);
        scopeLabel.setFont(new Font("Arial", Font.BOLD, 20));

        //Drop Down List to Select if private or goverment
        String[] options = {"Private Stocks", "Goverment Stocks", "Overall Stocks"};
        JComboBox<String> dropdown = new JComboBox<>(options);
        dropdown.setBounds(420, 140, 200, 20);

        //JLabel For Crop Selection
        JLabel cropLabel = new JLabel("Select Crops");
        cropLabel.setBounds(420, 200, 400, 20);
        cropLabel.setForeground(Color.BLACK);
        cropLabel.setFont(new Font("Arial", Font.BOLD, 20));

        //Checkboxes for crops
        JCheckBox checkbox1 = new JCheckBox("Rice");
        JCheckBox checkbox2 = new JCheckBox("Corn");
        JCheckBox checkbox3 = new JCheckBox("Barley");
        JCheckBox checkbox4 = new JCheckBox("Mustard");
        checkbox1.setBounds(420, 240, 100, 20);
        checkbox2.setBounds(420, 260, 100, 20);
        checkbox3.setBounds(420, 280, 100, 20);
        checkbox4.setBounds(420, 300, 100, 20);

        //Buttons defined for Report Download
        JButton downloadButton = new JButton("Download Report");
        downloadButton.setBounds(420, 340, 200, 40);
        downloadButton.setBackground(new Color(237, 235, 235));
        downloadButton.setForeground(Color.BLACK);
        downloadButton.setFont(new Font("Arial", Font.BOLD, 18));
        downloadButton.setBorder(border);

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

        //Event actions defined for Dashboard Button
        manageStocksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new ManageStocks().setVisible(true);
            }
        });

        //Event actions defined for Logout Button
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new HomeScreen().setVisible(true);
            }
        });

        //Add Elements to the Frame
        add(logoImageSetter);
        add(dashBoardButton);
        add(titleLabel);
        add(availabilityButton);
        add(reportButton);
        add(manageStocksButton);
        add(logoutButton);
        add(scopeLabel);
        add(cropLabel);
        add(checkbox1);
        add(checkbox2);
        add(checkbox3);
        add(checkbox4);
        add(dropdown);
        add(downloadButton);
        add(titleBox);
        add(menuBox);
        //add(bodyBox);
        add(backgroundImageSetter);
    }   
}