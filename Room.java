package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{
     JTable t1;
    JButton b1,b2;
    Room(){
        
        super("Room Information");
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,470,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(450,0,500,470);
        add(icon);
        
        JLabel l1 = new JLabel("Room No");
        l1.setBounds(10,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(100,10,70,20);
        add(l2);
        
        JLabel l3 = new JLabel("Status");
        l3.setBounds(210,10,70,20);
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(300,10,70,20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(380,10,70,20);
        add(l5);
        
        
        t1=new JTable();
        t1.setBounds(0,40,450,370);
        add(t1);
        
        b1=new JButton("Load Data");
        b1.setBounds(100,420,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
               
        b2=new JButton("Back");
        b2.setBounds(250,420,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(200,140,950,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1)
        {
            try{
                conn c=new conn();
                String str="select * from Room";
                ResultSet rs = c.s.executeQuery(str);
                
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                
            }
        }else if(ae.getSource()==b2)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
       new Room().setVisible(true);
   } 
}
