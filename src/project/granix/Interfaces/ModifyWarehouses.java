package Interfaces;

//Imports
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import Interfaces.ModifyWarehouses;
import controller.warehouseController;
import db.DBConnection;
import dto.warehouseDto;


public class ModifyWarehouses extends JFrame{

    private JTextField WarehouseIDTextBox;
    private JTextField WarehouseNameTextBox;
    private JTextField WarehouseTelTextBox;
    private JTextField warehouseLocationTextField;
    private JTextField WarehouseCapacity;
    private JComboBox<String> dropdown;

    private JTable viewTable;
    private DefaultTableModel dtm;

    private warehouseController warehouseController;

    public ModifyWarehouses(){

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
        JLabel titleLabel = new JLabel("Modify Warehouse");
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
        WarehouseIDTextBox.setBounds(360, 140, 240, 40);
        WarehouseIDTextBox.setFont(new Font("Arial", Font.ITALIC, 20));

        //TextBox defined for WarehouseName
        WarehouseNameTextBox = new JTextField("Enter Warehouse Name");
        WarehouseNameTextBox.setBounds(620, 140, 240, 40);
        WarehouseNameTextBox.setFont(new Font("Arial", Font.ITALIC, 20));

        //TextBox defined for StockName
        WarehouseTelTextBox = new JTextField("Enter Warehouse Tel.");
        WarehouseTelTextBox.setBounds(360, 200, 240, 40);
        WarehouseTelTextBox.setFont(new Font("Arial", Font.ITALIC, 20));
        

        warehouseLocationTextField = new JTextField("Enter Location");
        warehouseLocationTextField.setBounds(620, 200, 240, 40);
        warehouseLocationTextField.setFont(new Font("Arial", Font.ITALIC, 20));

        WarehouseCapacity = new JTextField("Maximum Capacity");
        WarehouseCapacity.setBounds(620, 260, 240, 40);
        WarehouseCapacity.setFont(new Font("Arial", Font.ITALIC, 20));

        //Select Crop store Sector
        dropdown = new JComboBox<>();
        dropdown.setBounds(360, 260, 240, 40);
        dropdown.setFont(new Font("Arial", Font.ITALIC, 20));
        dropdown.setBackground(Color.WHITE);



        JButton updateItemButton = new JButton("Modify Warehouse");
        updateItemButton.setBounds(620, 320, 200, 50);
        updateItemButton.setBackground(new Color(237, 235, 235));
        updateItemButton.setForeground(Color.BLACK);
        updateItemButton.setFont(new Font("Arial", Font.BOLD, 20));
        updateItemButton.setBorder(border);

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

        WarehouseCapacity.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Add Focus
                WarehouseCapacity.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Lose Focus
                if (WarehouseCapacity.getText().isEmpty()) {
                    WarehouseCapacity.setText("Maximum Capacity");
                }
            }
        });

        warehouseLocationTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Add Focus
                warehouseLocationTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Lose Focus
                if (warehouseLocationTextField.getText().isEmpty()) {
                    warehouseLocationTextField.setText("Enter Location");
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

        
        updateItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
                try {
                    updateWarehouse();
                } catch (Exception e1) {
                    
                    e1.printStackTrace();
                }
                
            }
        });
        viewTable.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        tableMouseCliked(evt);
                    }

                    private void tableMouseCliked(java.awt.event.MouseEvent evt) {
                        searchWarehouse();
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
        add(WarehouseNameTextBox);
        add(WarehouseTelTextBox);
        add(warehouseLocationTextField);
        add(WarehouseCapacity);
        add(updateItemButton);
        add(dropdown);
        add(scrollPane);
        add(titleBox);
        add(menuBox);
        //add(bodyBox);
        add(backgroundImageSetter);

        loadallWarehouse();
        loadSectors();
    } 

            private void loadSectors() {
                dropdown.removeAllItems();
                try {
                    String query = "SELECT DISTINCT Sector FROM warehouse";
                    Connection connection = DBConnection.getInstance().getConnection();
                    PreparedStatement pst = connection.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        dropdown.addItem(rs.getString("Sector")); // Add each type
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


            private void Clear() {
                WarehouseIDTextBox.setText("");
                WarehouseNameTextBox.setText("");
                WarehouseCapacity.setText("");
                warehouseLocationTextField.setText("");
                WarehouseTelTextBox.setText("");

            }
            private void loadallWarehouse() {
                try {
                    String[] columns = {"Warehouse_ID", "Warehouse_name", "Max_Capacity", "Location","Warehouse_Telephone", "Sector"};
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
                            warehouse.getWarehouse_Telephone(),
                            warehouse.getSector()
                        };
                        dtm.addRow(rowData);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ModifyWarehouses.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
            private void updateWarehouse() {
                try {
                    warehouseDto warehouseDto = new warehouseDto(WarehouseIDTextBox.getText(), WarehouseNameTextBox.getText(),Double.parseDouble(WarehouseCapacity.getText()),warehouseLocationTextField.getText(), WarehouseTelTextBox.getText(),dropdown.getSelectedItem().toString());
                    String result = warehouseController.updateWarehouse(warehouseDto);
                    JOptionPane.showMessageDialog(this, result);
                    Clear();
                    loadallWarehouse();
                } catch (Exception ex) {
                    Logger.getLogger(ModifyWarehouses.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
            private void searchWarehouse() {
                try {
                    String warehouseId = viewTable.getValueAt(viewTable.getSelectedRow(), 0).toString();
                    warehouseDto warehouseDto = warehouseController.getWarehouse(warehouseId);

                    if (warehouseDto != null) {
                        WarehouseIDTextBox.setText(warehouseDto.getWarehouse_ID());
                        WarehouseNameTextBox.setText(warehouseDto.getWarehouse_name());
                        WarehouseCapacity.setText(String.valueOf(warehouseDto.getMax_Capacity()));
                        warehouseLocationTextField.setText(warehouseDto.getLocation());
                        WarehouseTelTextBox.setText(warehouseDto.getWarehouse_Telephone());
                        
                    } else {
                        JOptionPane.showMessageDialog(this, "Warehouse Not Found");
                    }

                } catch (Exception ex) {
                    Logger.getLogger(ModifyWarehouses.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }

}
