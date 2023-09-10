package hotel.management.system;

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


public class SearchRoom extends JFrame implements ActionListener{
   
    JTable table;
    JLabel text, availability, status, price, bedtype;
    JButton backbutton, submitbutton;
    JComboBox abedtype;
    JCheckBox available;

    
   SearchRoom(){
       
       setLayout(null);
       
       getContentPane().setBackground(Color.WHITE);
       
       text = new JLabel("Search For Rooms");
       text.setFont(new Font("Tahoma", Font.PLAIN, 20));
       text.setBounds(300, 30, 200, 30);
       add(text);
       
       JLabel label = new JLabel("Bed Type");
       label.setBounds(50, 100, 150, 25);
       add(label);
       
       abedtype = new JComboBox (new String[]{"Single Bed", "Double Bed"});
       abedtype.setBackground(Color.WHITE);
       abedtype.setBounds(150, 100, 200, 30);
       add(abedtype);
       
       available = new JCheckBox("Available Rooms");
       available.setBounds(450, 100, 150, 30);
       available.setBackground(Color.WHITE);
       add(available);
       
       label = new JLabel("Room Number");
       label.setBounds(15, 170, 150, 30);
       add(label);
       
       availability = new JLabel("Availability");
       availability.setBounds(200, 170, 100, 30);
       add(availability);
       
       status = new JLabel("Status");
       status.setBounds(370, 170, 100, 30);
       add(status);
          
       price = new JLabel("Price");
       price.setBounds(560, 170, 150, 30);
       add(price);
       
       bedtype = new JLabel("Bed Type");
       bedtype.setBounds(740, 170, 150, 30);
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
           ResultSet rs = c.s.executeQuery("select * from room");
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
            String query1 = "select * from room where bed_type = '"+abedtype.getSelectedItem()+"'";
            String query2 = "select * from room where availability = 'Available' AND bed_type = '"+abedtype.getSelectedItem()+"'";
            
            Conn conn = new Conn();
            ResultSet rs;
            if(available.isSelected()){
                rs = conn.s.executeQuery(query2);
            }else{
                rs = conn.s.executeQuery(query1);
            }
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
       
       new SearchRoom();
       
   }
   
}
