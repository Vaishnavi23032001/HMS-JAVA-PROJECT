package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class PickUp extends JFrame implements ActionListener{
    
    Choice c1;
    JButton b1,b2;
    JTable t1;
    
    PickUp(){
        
        super("PickUp");
        
        JLabel l1=new JLabel("PickUp Service");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(400,10,200,30);
        add(l1);
                
        JLabel l2=new JLabel("Type of car");
        l2.setBounds(50,70,100,20);
        add(l2);
        
        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                c1.add(rs.getString("brand"));
            }
        }catch(Exception e){
            
        }
        c1.setBounds(150,70,200,25);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        t1=new JTable();
        t1.setBounds(0,150,1000,300);
        add(t1);
        
        b1=new JButton("Display ");
        b1.setBounds(330,470,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(530,470,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
                
        JLabel l3=new JLabel("Name");
        l3.setBounds(50,120,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Age");
        l4.setBounds(200,120,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Gender");
        l5.setBounds(340,120,100,20);
        add(l5);
        
        JLabel l6=new JLabel("Company");
        l6.setBounds(470,120,100,20);
        add(l6);
        
        JLabel l7=new JLabel("Brand");
        l7.setBounds(620,120,100,20);
        add(l7);
        
        JLabel l8=new JLabel("Availability");
        l8.setBounds(750,120,100,20);
        add(l8);
        
        JLabel l9=new JLabel("Location");
        l9.setBounds(890,120,100,20);
        add(l9);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(150,130,1000,550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource()==b1)
        {
            try{
                  String str="select * from driver where brand ='"+c1.getSelectedItem()+"'";
                  conn c=new conn();
                  ResultSet rs=c.s.executeQuery(str);
                  t1.setModel(DbUtils.resultSetToTableModel(rs));
                  
                }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
       new PickUp().setVisible(true);
   } 
}
