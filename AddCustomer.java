package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;

public class AddCustomer extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    JComboBox c1;
    Choice c2;
    JRadioButton r1,r2;
    
 AddCustomer(){
     
     super("Add Customer Details");
        
     JLabel l1=new JLabel("New Customer Form");
     l1.setBounds(80,20,250,30);
     l1.setFont(new Font("Tahoma",Font.BOLD,20));
     l1.setForeground(Color.BLUE);
     add(l1);
     
     JLabel l2=new JLabel("ID");
     l2.setBounds(35,80,100,20);
     add(l2);
     
     c1=new JComboBox(new String[]{"Passport","Voter-id card","Driving License","Aadhar Card"});
     c1.setBounds(200,80,150,25);
     c1.setBackground(Color.WHITE);
     add(c1);
     
     JLabel l3=new JLabel("Number");
     l3.setBounds(35,120,100,20);
     add(l3);
     
     t1=new JTextField();
     t1.setBounds(200,120,150,25);
     add(t1);
        
     JLabel l4=new JLabel("Name");
     l4.setBounds(35,160,100,20);
     add(l4);
     
     t2=new JTextField();
     t2.setBounds(200,160,150,25);
     add(t2);
     
     JLabel l5=new JLabel("Gender");
     l5.setBounds(35,200,100,20);
     add(l5);
     
     r1=new JRadioButton("Male");
     //r1.setFont(new Font("Tahama",Font.PLAIN,13));
     r1.setBounds(200,200,60,25);
     r1.setBackground(Color.WHITE);
     add(r1);
     
     r2=new JRadioButton("Female");
     //r1.setFont(new Font("Tahama",Font.PLAIN,13));
     r2.setBounds(270,200,80,25);
     r2.setBackground(Color.WHITE);
     add(r2);
     
     JLabel l6=new JLabel("Country");
     l6.setBounds(35,240,100,20);
     add(l6);
     
     t3=new JTextField();
     t3.setBounds(200,240,150,25);
     add(t3);
     
     JLabel l7=new JLabel("Allocated Room Number");
     l7.setBounds(35,280,150,20);
     add(l7);
     
     c2=new Choice();
     try{
         conn c =new conn();
         String str="select * from room";
         ResultSet rs=c.s.executeQuery(str);
         while(rs.next())
         {
             c2.add(rs.getString("room_number"));
         }
     }catch(Exception e){
         
     }
     c2.setBounds(200,280,220,30);
     add(c2);
     
     JLabel l8=new JLabel("Checked in");
     l8.setBounds(35,320,100,20);
     add(l8);
     
     t4=new JTextField();
     t4.setBounds(200,320,150,25);
     add(t4);
     
     JLabel l9=new JLabel("Deposit");
     l9.setBounds(35,360,100,20);
     add(l9);
     
     t5=new JTextField();
     t5.setBounds(200,360,150,25);
     add(t5);
     
     b1=new JButton("Add Customer");
     b1.setBounds(50,410,120,25);
     b1.setBackground(Color.BLACK);
     b1.setForeground(Color.WHITE);
     b1.addActionListener(this);
     add(b1);

     b2=new JButton("Back");
     b2.setBounds(200,410,120,25);
     b2.setBackground(Color.BLACK);
     b2.setForeground(Color.WHITE);
     b2.addActionListener(this);
     add(b2);
     
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.png"));
    Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
    ImageIcon i3= new ImageIcon(i2);
    JLabel l10 = new JLabel(i3);
    l10.setBounds(370,50,320,400);
    add(l10);
     
     getContentPane().setBackground(Color.WHITE);
        
     setLayout(null);
     setBounds(270,130,730,500);
     setVisible(true);
 
 }
 public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1){
            String id=(String)c1.getSelectedItem();
            String number= t1.getText();
            String name= t2.getText();
            String gender=null;
            if(r1.isSelected()){
                gender="Male";
            }else if(r2.isSelected()){
                gender="Female";
            }
            String country= t3.getText(); 
            String room_number=c2.getSelectedItem();
            String status= t4.getText();
            String deposit= t5.getText();
            
            if(id==null){
                JOptionPane.showMessageDialog(null,"ID is manadatry");
            }else if(number.equals("")){
            JOptionPane.showMessageDialog(null,"Number is manadatry");
            }else if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name is manadatry");
            }else if(country.equals("")){
                JOptionPane.showMessageDialog(null,"Country is manadatry");
            }else if(gender==null){
                JOptionPane.showMessageDialog(null,"Gender is manadatry");
            }else if(status.equals("")){
                JOptionPane.showMessageDialog(null,"Checked status is manadatry");
            }else if(deposit.equals("")){
                JOptionPane.showMessageDialog(null,"Deposit is manadatry");
            }else{
                String str= "Insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room_number+"','"+status+"','"+deposit+"')";
                String str1="update room set available= 'Occupied' where room_number='"+room_number+"'";
                try{
                    conn c = new conn();
                     c.s.executeUpdate(str);
                     c.s.executeUpdate(str1);
                     JOptionPane.showMessageDialog(null,"New Customer Added");
                     new Reception().setVisible(true);
                     this.setVisible(false);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource()==b2){
             new Reception().setVisible(true);
             this.setVisible(false);
        }
    }
 public static void main(String[] args){
       new AddCustomer().setVisible(true);
   } 
}
