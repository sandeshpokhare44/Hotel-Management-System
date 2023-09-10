package hotel.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
   
    JTable table;
    JLabel id, number, name, gender, country, room, checkintime, deposit;
    JButton backbutton;
    
   CustomerInfo(){
       
       setLayout(null);
       
       getContentPane().setBackground(Color.WHITE);
             
     
       
       id = new JLabel("ID");
       id.setBounds(10, 10, 150, 30);
       add(id);
       
       number = new JLabel("Number");
       number.setBounds(160, 10, 100, 30);
       add(number);
       
       name = new JLabel("Name");
       name.setBounds(280, 10, 100, 30);
       add(name);
       
       gender = new JLabel("Gender");
       gender.setBounds(400, 10, 100, 30);
       add(gender);
          
       country = new JLabel("Country");
       country.setBounds(530, 10, 150, 30);
       add(country);
       
       room = new JLabel("Room");
       room.setBounds(640, 10, 150, 30);
       add(room);
       
       checkintime = new JLabel("Chech In TIme");
       checkintime.setBounds(770, 10, 150, 30);
       add(checkintime);
       
       deposit = new JLabel("Deposit");
       deposit.setBounds(900, 10, 150, 30);
       add(deposit);
       
       table = new JTable();
       table.setBounds(5, 40, 1000, 400);
       add(table);
       
       backbutton = new JButton("Back");
       backbutton.setBackground(Color.BLUE);
       backbutton.setForeground(Color.WHITE);
       backbutton.setBounds(450, 450, 100, 30);
       backbutton.addActionListener(this);
       add(backbutton);
       
       try{
           
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from customer");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
       }catch (Exception e){
           e.printStackTrace();
       }
 
       setBounds(150, 30, 1000, 550);
       setVisible(true);
 
   }
   
   public void actionPerformed(ActionEvent ae){
    
       setVisible(false);
       new Reception();
       
   }
   
   public static void main(String[] args){
       
       new CustomerInfo();
       
   }
   
}
