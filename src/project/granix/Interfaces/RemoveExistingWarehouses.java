package Interfaces;

//Imports
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//Java Class Imports

import Interfaces.RemoveExistingWarehouses;
import controller.warehouseController;
import dto.warehouseDto;


public class RemoveExistingWarehouses extends JFrame{

    private JTextField WarehouseIDTextBox;
    private JTextField warehouseNameText;
    private warehouseController warehouseController;
    private JTable viewTable;
    private DefaultTableModel dtm;

    public RemoveExistingWarehouses(){

        warehouseController = new warehouseController();

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
         JLabel titleLabel = new JLabel("Delete Warhouse");
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
        WarehouseIDTextBox = new JTextField("Enter Warehouse ID");
        WarehouseIDTextBox.setBounds(360, 160, 240, 40);
        WarehouseIDTextBox.setFont(new Font("Arial", Font.ITALIC, 20));


        //Search Item Button
        JButton searchItemItemButton = new JButton("Search Item");
        searchItemItemButton.setBounds(620, 160, 200, 50);
        searchItemItemButton.setBackground(new Color(237, 235, 235));
        searchItemItemButton.setForeground(Color.BLACK);
        searchItemItemButton.setFont(new Font("Arial", Font.BOLD, 20));
        searchItemItemButton.setBorder(border);

        //JLabel For Item Name
        JLabel itemNameLabel = new JLabel("Name from DB Update");
        itemNameLabel.setBounds(360, 240, 600, 20);
        itemNameLabel.setForeground(Color.BLACK);
        itemNameLabel.setFont(new Font("Arial", Font.BOLD, 20));

        //TextBox defined for StockId
        warehouseNameText = new JTextField();
        warehouseNameText.setBounds(360, 280, 240, 40);
        warehouseNameText.setFont(new Font("Arial", Font.ITALIC, 20));



        //JLabel For Interface Title
        JLabel deleteLabel = new JLabel("Are you Sure you want to delete?");
        deleteLabel.setBounds(360, 320, 500, 20);
        deleteLabel.setForeground(Color.BLACK);
        deleteLabel.setFont(new Font("Arial", Font.BOLD, 20));

        //Delete item button
        JButton deleteItemButton = new JButton("Yes");
        deleteItemButton.setBounds(680, 320, 100, 30);
        deleteItemButton.setBackground(new Color(237, 235, 235));
        deleteItemButton.setForeground(Color.BLACK);
        deleteItemButton.setFont(new Font("Arial", Font.BOLD, 20));
        deleteItemButton.setBorder(border);


        // Create a table model
        dtm = new DefaultTableModel();

        // Create a JTable using the model
        viewTable = new JTable(dtm);

        //Table Appearance Customizations
        viewTable.setFont(new Font("Arial",Font.PLAIN, 14));
        viewTable.setRowHeight(30);
        viewTable.setBackground(new Color(237, 235, 235));
        viewTable.setForeground(Color.BLACK);
        viewTable.setGridColor(Color.DARK_GRAY);
        viewTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        viewTable.getTableHeader().setBackground(new Color(172, 145, 127));
        viewTable.getTableHeader().setForeground(Color.WHITE);

        // Add the table to a JScrollPane for scroll functionality
        JScrollPane scrollPane = new JScrollPane(viewTable);
        scrollPane.setBounds(300, 390, 600, 150);
        scrollPane.setBackground(new Color(237, 235, 235));
        scrollPane.getViewport().setBackground(new Color(237, 235, 235));
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));

        // Add a FocusListener for StockIDTextBox
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

        searchItemItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                 searchWarehouse();
            }
        });

        deleteItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                 deleteWarehouse();
            }
        });

        //Add Elements to the Frame
        add(logoImageSetter);
        add(titleLabel);
        add(dashBoardButton);
        //add(availabilityButton);
        //add(reportButton);
        //add(manageStocksButton);
        //add(manageWarehouseButton);
        add(logoutButton);
        add(WarehouseIDTextBox);
        add(searchItemItemButton);
        add(itemNameLabel);
        add(deleteLabel);
        add(deleteItemButton);
        add(scrollPane);
        add(titleBox);
        add(menuBox);
        add(warehouseNameText);
        //add(bodyBox);
        add(backgroundImageSetter);

        loadallWarehouse();
    } 

            private void searchWarehouse() {
                try {
                    String warehouseId = WarehouseIDTextBox.getText();
                    warehouseDto warehouse = warehouseController.getWarehouse(warehouseId);
                    if(warehouse != null){
                        warehouseNameText.setText(warehouse.getWarehouse_name());
                    }else{
                         JOptionPane.showMessageDialog(this, "Item Not Found");
                    }
        
                } catch (Exception ex) {
                    Logger.getLogger(RemoveExistingStocks.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }

            private void deleteWarehouse() {
                try {
                    String result = warehouseController.deleteWarehouse(WarehouseIDTextBox.getText());
                    JOptionPane.showMessageDialog(this, result);
                    Clear();
                    loadallWarehouse();
                } catch (Exception ex) {
                    Logger.getLogger(RemoveExistingStocks.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
            private void Clear() {
                        WarehouseIDTextBox.setText("");
                        warehouseNameText.setText("");

            }
            private void loadallWarehouse() {
                try {
                    String[] columns = {"Warehouse_ID", "Warehouse_name", "Max_Capacity", "Warehouse_Telephone","Sector"};
                    DefaultTableModel dtm = new DefaultTableModel(columns, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    viewTable.setModel(dtm);
            
                    ArrayList<warehouseDto> warehouses = warehouseController.getAllWarehouse();
                    for (warehouseDto warehouse : warehouses) {
                        Object[] rowData = {
                            warehouse.getWarehouse_ID(),
                            warehouse.getWarehouse_name(),
                            warehouse.getMax_Capacity(),
                            warehouse.getLocation(),
                            warehouse.getWarehouse_Telephone()
                        };
                        dtm.addRow(rowData);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(RemoveExistingWarehouses.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
            

}


