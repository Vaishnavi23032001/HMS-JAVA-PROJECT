package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener{
    
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c2;
    JButton b1,b2;
    
AddDriver(){
    
    super("Add Driver Details");
        
    JLabel title= new JLabel("Add Drivers");
    title.setBounds(140,20,150,30);
    title.setFont(new Font("Tahoma",Font.BOLD,20));
    add(title);
    
    JLabel name= new JLabel("Name");
    name.setBounds(60,70,100,30);
    name.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(name);
    
    t1= new JTextField();
    t1.setBounds(200,70,150,30);
    add(t1);
    
    JLabel age= new JLabel("Age");
    age.setBounds(60,110,100,30);
    age.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(age);
    
    t2= new JTextField();
    t2.setBounds(200,110,150,30);
    add(t2);
    
    JLabel gender= new JLabel("Gender");
    gender.setBounds(60,150,100,30);
    gender.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(gender);
    
    c1= new JComboBox(new String[] {"Male","Female"});
    c1.setBounds(200,150,150,30);
    c1.setBackground(Color.WHITE);
    add(c1);
    
    JLabel car= new JLabel("Car Company");
    car.setBounds(60,190,100,30);
    car.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(car);
     
    t3= new JTextField();
    t3.setBounds(200,190,150,30);
    add(t3);
    
    JLabel brand= new JLabel("Car Model");
    brand.setBounds(60,230,100,30);
    brand.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(brand);
    
    t4= new JTextField();
    t4.setBounds(200,230,150,30);
    add(t4);
    
    
    JLabel available= new JLabel("Available");
    available.setBounds(60,270,100,30);
    available.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(available);
    
    c2= new JComboBox(new String[] {"Available","Busy"});
    c2.setBounds(200,270,150,30);
    c2.setBackground(Color.WHITE);
    add(c2);
    
    JLabel location= new JLabel("Location");
    location.setBounds(60,310,100,30);
    location.setFont(new Font("Tahoma",Font.PLAIN,16));
    add(location);
    
    t5= new JTextField();
    t5.setBounds(200,310,150,30);
    add(t5);
    
    b1 = new JButton("Add Driver"); 
    b1.setBounds(60,370,130,30);
    b1.addActionListener(this);
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    add(b1);

    b2 = new JButton("Cancle");
    b2.setBounds(220,370,130,30);
    b2.addActionListener(this);
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    add(b2);

    getContentPane().setBackground(Color.WHITE);

    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
    Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
    ImageIcon i3= new ImageIcon(i2);
    JLabel l1 = new JLabel(i3);
    l1.setBounds(400,80,500,300);
    add(l1);
        
    setLayout(null);
    setBounds(170,140,950,480);
    setVisible(true);
}   
 public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1)
        {
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String)c1.getSelectedItem(); 
            String company = t3.getText();
            String brand = t4.getText();
            String available = (String)c2.getSelectedItem();
            String location = t5.getText();
           
            if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name is manadatry");
            }else if(age.equals("")){
            JOptionPane.showMessageDialog(null,"Age is manadatry");
            }else if(gender==null){
            JOptionPane.showMessageDialog(null,"Gender is manadatry");
            }else if(company.equals("")){
            JOptionPane.showMessageDialog(null,"Car Company is manadatry");
            }else if(brand.equals("")){
            JOptionPane.showMessageDialog(null,"Car model is manadatry");
            }else if(available.equals("")){
            JOptionPane.showMessageDialog(null,"Available status is manadatry");
            }else if(location.equals("")){
            JOptionPane.showMessageDialog(null,"Location is manadatry");
            }else{
              
                conn c=new conn();
                 try{    
                    String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Driver Sucessfully Added");
                    this.setVisible(false);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource()==b2){
            new Dashboard().setVisible(true);
            setVisible(false);
        }
 }
public static void main(String[] args){
       new AddDriver().setVisible(true);
   } 
}
