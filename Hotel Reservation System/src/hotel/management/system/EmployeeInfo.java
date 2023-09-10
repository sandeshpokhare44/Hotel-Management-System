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

public class EmployeeInfo extends JFrame implements ActionListener{
   
    JTable table;
    JLabel name, age, gender, position, salary, phone, email, ssn;
    JButton backbutton;
    
   EmployeeInfo(){
       
       setLayout(null);
       
       getContentPane().setBackground(Color.WHITE);
             
     
       
       name = new JLabel("Name");
       name.setBounds(10, 10, 150, 30);
       add(name);
       
       age = new JLabel("Age");
       age.setBounds(150, 10, 100, 30);
       add(age);
       
       gender = new JLabel("Gender");
       gender.setBounds(280, 10, 100, 30);
       add(gender);
          
       salary = new JLabel("Salary");
       salary.setBounds(530, 10, 150, 30);
       add(salary);
       
       position = new JLabel("Position");
       position.setBounds(390, 10, 150, 30);
       add(position);
       
       phone = new JLabel("Phone");
       phone.setBounds(660, 10, 150, 30);
       add(phone);
       
       email = new JLabel("Email");
       email.setBounds(780, 10, 150, 30);
       add(email);
       
       ssn = new JLabel("SSN");
       ssn.setBounds(900, 10, 150, 30);
       add(ssn);
       
       table = new JTable();
       table.setBounds(5, 40, 1000, 400);
       add(table);
       
       backbutton = new JButton("Back");
       backbutton.setBackground(Color.BLUE);
       backbutton.setForeground(Color.WHITE);
       backbutton.setBounds(450, 500, 100, 30);
       backbutton.addActionListener(this);
       add(backbutton);
       
       try{
           
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from employee");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
       }catch (Exception e){
           e.printStackTrace();
       }
 
       setBounds(150, 30, 1000, 600);
       setVisible(true);
 
   }
   
   public void actionPerformed(ActionEvent ae){
    
       setVisible(false);
       new Reception();
       
   }
   
   public static void main(String[] args){
       
       new EmployeeInfo();
       
   }
   
}
