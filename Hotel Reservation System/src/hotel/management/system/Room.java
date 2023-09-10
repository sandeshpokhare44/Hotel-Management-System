package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{
   
    JTable table;
    JLabel label, availability, status, price, bedtype;
    JButton backbutton;
    
   Room(){
       
       setLayout(null);
       
       getContentPane().setBackground(Color.WHITE);
             
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
       Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3); 
       image.setBounds(405, 0, 600, 600);
       add(image);
       
       label = new JLabel("Room Number");
       label.setBounds(2, 10, 150, 30);
       add(label);
       
       availability = new JLabel("Availability");
       availability.setBounds(95, 10, 100, 30);
       add(availability);
       
       status = new JLabel("Status");
       status.setBounds(170, 10, 100, 30);
       add(status);
          
       price = new JLabel("Price");
       price.setBounds(250, 10, 150, 30);
       add(price);
       
       bedtype = new JLabel("Bed Type");
       bedtype.setBounds(330, 10, 150, 30);
       add(bedtype);
       
       table = new JTable();
       table.setBounds(5, 40, 400, 400);
       add(table);
       
       backbutton = new JButton("Back");
       backbutton.setBackground(Color.BLUE);
       backbutton.setForeground(Color.WHITE);
       backbutton.setBounds(180, 500, 100, 30);
       backbutton.addActionListener(this);
       add(backbutton);
       
       try{
           
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from room");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
       }catch (Exception e){
           e.printStackTrace();
       }
 
       setBounds(250, 30, 900, 600);
       setVisible(true);
 
   }
   
   public void actionPerformed(ActionEvent ae){
    
       setVisible(false);
       new Reception();
       
   }
   
   public static void main(String[] args){
       
       new Room();
       
   }
   
}
