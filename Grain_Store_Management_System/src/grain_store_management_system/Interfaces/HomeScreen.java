package Interfaces;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;

public class HomeScreen extends JFrame{
    public HomeScreen(){
        //JFrame Definitions
        setTitle("Grain Store Managment System");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        //JFrame Logo
        ImageIcon iconImage = new ImageIcon(getClass().getResource("assets/icon.png"));
        Image image = iconImage.getImage();
        setIconImage(image);
    }
    
}
