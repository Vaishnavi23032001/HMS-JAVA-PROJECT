package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

    HotelManagementSystem()
    {
        
        //setsize(400,400);
        //setLocation(300,300);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1000,500);
        add(l1);
        
        JLabel l2= new JLabel("Hotel Management System");
        l2.setBounds(20,380,1000,90);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif",Font.PLAIN,50));
        l1.add(l2);
                
        JButton b1= new JButton("Next");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setBounds(800,400,150,50);
        b1.addActionListener(this);
        l1.add(b1);
         
        setLayout(null);
        setBounds(140,110,1000,500);
        setVisible(true);
        while(true){
            l2.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
            l2.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        new Login().setVisible(true);
        this.setVisible(false);
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
