package Interfaces;

//Imports
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AddNewWarehouses extends JFrame{
    public AddNewWarehouses(){
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
        JLabel titleLabel = new JLabel("Add New Warehouse");
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
        manageStocksButton.setBounds(10, 380, 200, 50);
        manageStocksButton.setBackground(new Color(237, 235, 235));
        manageStocksButton.setForeground(Color.BLACK);
        manageStocksButton.setFont(new Font("Arial", Font.BOLD, 20));
        manageStocksButton.setBorder(border);

        //Buttons defined for manage Warehouses
        JButton manageWarehouseButton = new JButton("Manage Warehouses");
        manageWarehouseButton.setBounds(10, 460, 250, 50);
        manageWarehouseButton.setBackground(Color.WHITE);
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

        //TextBox defined for WarehouseID
        JTextField WarehouseIDTextBox = new JTextField("Enter Warehouse ID");
        WarehouseIDTextBox.setBounds(360, 160, 240, 40);
        WarehouseIDTextBox.setFont(new Font("Arial", Font.ITALIC, 20));

        //TextBox defined for WarehouseName
        JTextField WarehouseNameTextBox = new JTextField("Enter Warehouse Name");
        WarehouseNameTextBox.setBounds(620, 160, 240, 40);
        WarehouseNameTextBox.setFont(new Font("Arial", Font.ITALIC, 20));

        //TextBox defined for StockName
        JTextField WarehouseTelTextBox = new JTextField("Enter Warehouse Tel.");
        WarehouseTelTextBox.setBounds(360, 220, 240, 40);
        WarehouseTelTextBox.setFont(new Font("Arial", Font.ITALIC, 20));
        
        //Save Warehouse button
        JButton saveItemButton = new JButton("Add Warehouse");
        saveItemButton.setBounds(360, 300, 200, 50);
        saveItemButton.setBackground(new Color(237, 235, 235));
        saveItemButton.setForeground(Color.BLACK);
        saveItemButton.setFont(new Font("Arial", Font.BOLD, 20));
        saveItemButton.setBorder(border);


        //Table Column Headings Defined
        String []columnNames = {"Warehouse ID", "Name", "Tel"};
        Object[][] StoreArray = {
            {"G001", "Rice",   104582400},
            {"G002", "Barley", 501254700},
            {"G003", "Corn",   780054542}
        };

        // Create a table model
        DefaultTableModel model = new DefaultTableModel(StoreArray, columnNames);

        // Create a JTable using the model
        JTable viewTable = new JTable(model);

        //Table Appearance Customizations
        viewTable.setFont(new Font("Arial",Font.PLAIN, 14));
        viewTable.setRowHeight(30);
        viewTable.setBackground(new Color(237, 235, 235));
        viewTable.setForeground(Color.BLACK);
        viewTable.setGridColor(Color.DARK_GRAY);
        viewTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        viewTable.getTableHeader().setBackground(new Color(172, 145, 127));
        viewTable.getTableHeader().setForeground(Color.WHITE);

        //Column Width Customizations
        viewTable.getColumnModel().getColumn(0).setPreferredWidth(30); 
        viewTable.getColumnModel().getColumn(1).setPreferredWidth(30);
        viewTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        

        // Add the table to a JScrollPane for scroll functionality
        JScrollPane scrollPane = new JScrollPane(viewTable);
        scrollPane.setBounds(300, 390, 600, 150);
        scrollPane.setBackground(new Color(237, 235, 235));
        scrollPane.getViewport().setBackground(new Color(237, 235, 235));
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));

        // Add a FocusListener for WarehouseIDTextBox
        WarehouseIDTextBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Add Focus
                WarehouseIDTextBox.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Lose Focus
                if (WarehouseIDTextBox.getText().isEmpty()) {
                    WarehouseIDTextBox.setText("Enter Warehouse ID");
                }
            }
        });

        // Add a FocusListener for WarehouseTelTextBox
        WarehouseNameTextBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Add Focus
                WarehouseNameTextBox.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Lose Focus
                if (WarehouseNameTextBox.getText().isEmpty()) {
                    WarehouseNameTextBox.setText("Enter Warehouse Name");
                }
            }
        });

        // Add a FocusListener for WarehouseTelTextBox
        WarehouseTelTextBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Add Focus
                WarehouseTelTextBox.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Lose Focus
                if (WarehouseTelTextBox.getText().isEmpty()) {
                    WarehouseTelTextBox.setText("Enter Warehouse Tel.");
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

        //Add Elements to the Frame
        add(logoImageSetter);
        add(titleLabel);
        add(dashBoardButton);
        add(availabilityButton);
        add(reportButton);
        add(manageStocksButton);
        add(manageWarehouseButton);
        add(logoutButton);
        add(WarehouseIDTextBox);
        add(WarehouseNameTextBox);
        add(WarehouseTelTextBox);
        add(saveItemButton);

        add(scrollPane);
        add(titleBox);
        add(menuBox);
        //add(bodyBox);
        add(backgroundImageSetter);
    } 


}
