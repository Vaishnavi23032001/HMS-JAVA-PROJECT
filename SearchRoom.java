package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class SearchRoom extends JFrame implements ActionListener{
    
    JComboBox c1;
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    
    SearchRoom(){
        
        super("Search Room");
        
        JLabel l1=new JLabel("Search for Room");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(400,10,200,30);
        add(l1);
                
        JLabel l2=new JLabel("Room Bed Type");
        l2.setBounds(50,70,100,20);
        add(l2);
        
        c1=new JComboBox(new String[] {"Single Bed","Double Bed"});
        c1.setBounds(170,70,150,25);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2=new JCheckBox("Only display Available");
        c2.setBounds(650,70,200,25);
        c1.setBackground(Color.WHITE);
        add(c2);
        
        t1=new JTable();
        t1.setBounds(0,150,1000,300);
        add(t1);
        
        b1=new JButton("Search");
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
                
        JLabel l3=new JLabel("Room Number");
        l3.setBounds(60,120,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Availability");
        l4.setBounds(260,120,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Cleaning Status");
        l5.setBounds(450,120,100,20);
        add(l5);
        
        JLabel l6=new JLabel("Price");
        l6.setBounds(670,120,100,20);
        add(l6);
        
        JLabel l7=new JLabel("Bed Type");
        l7.setBounds(850,120,100,20);
        add(l7);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(150,120,1000,550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1)
        {
            try{
                  String str="select * from room where bed_type ='"+c1.getSelectedItem()+"'";
                  String str2="select * from room where available='Available' AND bed_type='"+c1.getSelectedItem()+"'";
                  conn c=new conn();
                  ResultSet rs=c.s.executeQuery(str);
                  t1.setModel(DbUtils.resultSetToTableModel(rs));
                  
                  if(c2.isSelected()){
                    ResultSet rs2=c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs2));
                  }
                }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
       new SearchRoom().setVisible(true);
   } 
}
