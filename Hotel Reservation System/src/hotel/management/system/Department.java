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

public class Department extends JFrame implements ActionListener{
   
    JTable table;
    JLabel department, budget;
    JButton back;
    
   Department(){
       setLayout(null);
       
       getContentPane().setBackground(Color.WHITE);

       department = new JLabel("Department");
       department.setBounds(50, 10, 150, 30);
       add(department);
       
       budget = new JLabel("Budget");
       budget.setBounds(230, 10, 100, 30);
       add(budget);
       
       table = new JTable();
       table.setBounds(0, 50, 350, 370);
       add(table);
       
       try{
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from department");
           table.setModel(DbUtils.resultSetToTableModel(rs));
       }catch (Exception e){
           e.printStackTrace();
       }
 
       back = new JButton("Back");
       back.setBackground(Color.BLUE);
       back.setForeground(Color.WHITE);
       back.setBounds(130, 420, 100, 30);
       back.addActionListener(this);
       add(back);
       
       setBounds(250, 30, 400, 500);
       setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae){
       setVisible(false);
       new Reception();
   }
   
   public static void main(String[] args){
       new Department();
   }
}
