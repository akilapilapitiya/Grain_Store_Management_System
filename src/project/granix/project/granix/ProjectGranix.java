/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project.granix;


import Interfaces.AddNewStocks;
import Interfaces.AddNewWarehouses;
import Interfaces.DashboardView;
import Interfaces.GovernmentAvailability;
import Interfaces.HomeScreen;
import Interfaces.LoginScreenBuyer;
import Interfaces.PrivateAvailability;
import Interfaces.SignUpScreenBuyer;
import Interfaces.StockAvailability;
import Interfaces.StockPurchases;
import Interfaces.StockSales;



/**
 *
 * @author ASUS
 */
public class ProjectGranix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new HomeScreen().setVisible(true);
    }
    
}
