package Interfaces;

//Imports
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class DashboardView extends JFrame{
    public DashboardView(){
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


        //JLabel For Interface Title
        JLabel titleLabel = new JLabel("Dashboard");
        titleLabel.setBounds(310, 15, 400, 50);
        titleLabel.setBackground(new Color(237, 235, 235));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));

        //JPanel for Dashboard Border Box
        JPanel dashBoardBorderBox = new JPanel();
        dashBoardBorderBox.setBounds(9, 139, 252, 52);
        dashBoardBorderBox.setBackground(new Color(27, 17, 14));
        //Buttons defined for DashBoard
        JButton dashBoardButton = new JButton("Dashboard");
        dashBoardButton.setBounds(10, 140, 250, 50);
        dashBoardButton.setBackground(Color.WHITE);
        dashBoardButton.setBorderPainted(false);
        dashBoardButton.setForeground(new Color(27, 17, 14));
        dashBoardButton.setFont(new Font("Arial", Font.BOLD, 20));

        //JPanel for Dashboard Border Box
        JPanel availableBorderBox = new JPanel();
        availableBorderBox.setBounds(9, 219, 202, 52);
        availableBorderBox.setBackground(new Color(27, 17, 14));
        //Buttons defined for Stock Availability
        JButton availabilityButton = new JButton("Stock Availability");
        availabilityButton.setBounds(10, 220, 200, 50);
        availabilityButton.setBackground(new Color(237, 235, 235));
        availabilityButton.setBorderPainted(false);
        availabilityButton.setForeground(Color.BLACK);
        availabilityButton.setFont(new Font("Arial", Font.BOLD, 20));

        //Buttons defined for Report Generation
        JButton reportButton = new JButton("Report");
        reportButton.setBounds(10, 300, 200, 50);
        reportButton.setBackground(new Color(237, 235, 235));
        reportButton.setBorderPainted(false);
        reportButton.setForeground(Color.BLACK);
        reportButton.setFont(new Font("Arial", Font.BOLD, 20));

        //Buttons defined for manage Stocks
        JButton manageStocksButton = new JButton("Manage Stocks");
        manageStocksButton.setBounds(10, 380, 200, 50);
        manageStocksButton.setBackground(new Color(237, 235, 235));
        manageStocksButton.setBorderPainted(false);
        manageStocksButton.setForeground(Color.BLACK);
        manageStocksButton.setFont(new Font("Arial", Font.BOLD, 20));

         //Buttons defined for Logout
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(10, 570, 200, 50);
        logoutButton.setBackground(new Color(237, 235, 235));
        logoutButton.setBorderPainted(false);
        logoutButton.setForeground(Color.BLACK);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 20));

        //Buttons defined for DashBoard
        JButton availabilityIconButton = new JButton("Check Stocks Availability");
        availabilityIconButton.setBounds(420, 160, 400, 80);
        availabilityIconButton.setBackground(new Color(172, 145, 127));
        availabilityIconButton.setBorder(new LineBorder(new Color(102,51,0), 4)); 
        availabilityIconButton.setForeground(Color.WHITE);
        availabilityIconButton.setFont(new Font("Arial", Font.BOLD, 25));

        //Buttons defined for getReport
        JButton getReportButton = new JButton("Generate Reports");
        getReportButton.setBounds(420, 300, 400, 80);
        getReportButton.setBackground(new Color(172, 145, 127));
        getReportButton.setBorder(new LineBorder(new Color(102,51,0), 4)); 
        getReportButton.setForeground(Color.WHITE);
        getReportButton.setFont(new Font("Arial", Font.BOLD, 25));
        

        //Buttons defined for Manage Stocks
        JButton manageStockIconButton = new JButton("Manage Stocks");
        manageStockIconButton.setBounds(420, 440, 400, 80);
        manageStockIconButton.setBackground(new Color(172, 145, 127));
        manageStockIconButton.setBorder(new LineBorder(new Color(102,51,0), 4)); 
        manageStockIconButton.setForeground(Color.WHITE);
        manageStockIconButton.setFont(new Font("Arial", Font.BOLD, 25));
        
        

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

        //Event actions defined for StockAvailabitity Button
        availabilityIconButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new StockAvailability().setVisible(true);
            }
        });

        //Event actions defined for getReport Button
        getReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new ReportGenerate().setVisible(true);
            }
        });

        //Event actions defined for manageStockIcon Button
        manageStockIconButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
                new ManageStocks().setVisible(true);
            }
        });

        //Add Elements to the Frame
        add(logoImageSetter);
        add(titleLabel);
        add(dashBoardButton);
        add(dashBoardBorderBox);
        add(availabilityButton);
        add(availableBorderBox);
        add(reportButton);
        add(manageStocksButton);
        add(logoutButton);
        add(titleBox);
        add(availabilityIconButton);
        add(getReportButton);
        add(manageStockIconButton);
        add(menuBox);
        //add(bodyBox);
        add(backgroundImageSetter);
    }   
}