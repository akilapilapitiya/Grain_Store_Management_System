package Interfaces;

//Imports
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
        backgroundImageSetter.setBounds(0, 0, 1000, 700);

        //JFrame Logo Image
        ImageIcon logoImageSet = new ImageIcon(getClass().getResource("Assets/Logo.png"));
        Image logoSet = logoImageSet.getImage();
        Image resizedLogoImage = logoSet.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        ImageIcon logoImage = new ImageIcon(resizedLogoImage);
        JLabel logoImageSetter = new JLabel(logoImage);
        logoImageSetter.setBounds(40, 20, 200, 100);

        //JPanel for menu Box
        JPanel menuBox = new JPanel();
        menuBox.setBounds(10, 121, 250, 530);
        menuBox.setBackground(new Color(172, 145, 127));

        //JPanel for Body Box
        JPanel bodyBox = new JPanel();
        bodyBox.setBounds(260, 10, 710, 640);
        bodyBox.setBackground(new Color(237, 235, 235));

        //JPanel for Title Box
        JPanel titleBox = new JPanel();
        titleBox.setBounds(260, 10, 710, 75);
        titleBox.setBackground(new Color(172, 145, 127));

        //JLabel For Interface Title
        JLabel titleLabel = new JLabel("Dashboard");
        titleLabel.setBounds(310, 25, 400, 50);
        titleLabel.setBackground(new Color(237, 235, 235));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));

        //Buttons defined for DashBoard
        JButton dashBoardButton = new JButton("Dashboard");
        dashBoardButton.setBounds(10, 140, 250, 50);
        dashBoardButton.setBackground(new Color(237, 235, 235));
        dashBoardButton.setBorderPainted(false);
        dashBoardButton.setForeground(Color.BLACK);
        dashBoardButton.setFont(new Font("Arial", Font.BOLD, 20));

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
        availabilityIconButton.setBounds(450, 140, 400, 80);
        availabilityIconButton.setBackground(new Color(172, 145, 127));
        availabilityIconButton.setBorderPainted(false);
        availabilityIconButton.setForeground(Color.WHITE);
        availabilityIconButton.setFont(new Font("Arial", Font.BOLD, 25));

        //Buttons defined for getReport
        JButton getReportButton = new JButton("Generate Reports");
        getReportButton.setBounds(450, 280, 400, 80);
        getReportButton.setBackground(new Color(172, 145, 127));
        getReportButton.setBorderPainted(false);
        getReportButton.setForeground(Color.WHITE);
        getReportButton.setFont(new Font("Arial", Font.BOLD, 25));
        

        //Buttons defined for Manage Stocks
        JButton manageStockIconButton = new JButton("Manage Stocks");
        manageStockIconButton.setBounds(450, 420, 400, 80);
        manageStockIconButton.setBackground(new Color(172, 145, 127));
        manageStockIconButton.setBorderPainted(false);
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
        add(availabilityButton);
        add(reportButton);
        add(manageStocksButton);
        add(logoutButton);
        add(titleBox);
        add(availabilityIconButton);
        add(getReportButton);
        add(manageStockIconButton);
        add(menuBox);
        add(bodyBox);
        add(backgroundImageSetter);
    }   
}