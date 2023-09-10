package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import net.proteanit.sql.*;
import javax.swing.JComboBox;


public class Pickup extends JFrame implements ActionListener{
   
    JTable table;
    JLabel text, availability, status, price, bedtype;
    JButton backbutton, submitbutton;
    Choice cartype;
    JCheckBox available;

    
   Pickup(){
       
       setLayout(null);
       
       getContentPane().setBackground(Color.WHITE);
       
       text = new JLabel("Pick Up Service");
       text.setFont(new Font("Tahoma", Font.PLAIN, 20));
       text.setBounds(300, 30, 200, 30);
       add(text);
       
       JLabel label = new JLabel("Car Model");
       label.setBounds(50, 100, 100, 25);
       add(label);
       
       cartype = new Choice();
       cartype.setBounds(150, 100, 150, 30);
       add(cartype);
       
       try{
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from driver");
           while(rs.next()){
               cartype.add(rs.getString("carmodel"));
           }
       }catch (Exception e){
           e.printStackTrace();
       }
       
       
       
       label = new JLabel("Name");
       label.setBounds(15, 170, 150, 30);
       add(label);
       
       availability = new JLabel("Age");
       availability.setBounds(180, 170, 100, 30);
       add(availability);
       
       status = new JLabel("Gender");
       status.setBounds(340, 170, 100, 30);
       add(status);
          
       price = new JLabel("Car Model");
       price.setBounds(610, 170, 150, 30);
       add(price);
       
       bedtype = new JLabel("Availability");
       bedtype.setBounds(470, 170, 150, 30);
       add(bedtype);
       
        bedtype = new JLabel("Location");
       bedtype.setBounds(780, 170, 150, 30);
       add(bedtype);
       
       table = new JTable();
       table.setBounds(5, 200, 900, 300);
       add(table);
       
       backbutton = new JButton("Back");
       backbutton.setBackground(Color.BLUE);
       backbutton.setForeground(Color.WHITE);
       backbutton.setBounds(250, 500, 100, 30);
       backbutton.addActionListener(this);
       add(backbutton);
       
       submitbutton = new JButton("Submit");
       submitbutton.setBackground(Color.BLUE);
       submitbutton.setForeground(Color.WHITE);
       submitbutton.setBounds(400, 500, 100, 30);
       submitbutton.addActionListener(this);
       add(submitbutton);
       
       try{
           
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from driver");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
       }catch (Exception e){
           e.printStackTrace();
       }
 
       setBounds(250, 30, 900, 600);
       setVisible(true);
 
   }
   
   public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == submitbutton){
        try{
            String query = "select * from driver where carmodel = '"+cartype.getSelectedItem()+"'";
            
            Conn conn = new Conn();
            ResultSet rs;
            rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
    }else{
       setVisible(false);
       new Reception();
       }
    }
   public static void main(String[] args){
       
       new Pickup();
       
   }
   
}
