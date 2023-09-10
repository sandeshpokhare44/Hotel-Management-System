package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class UpdateRoom extends JFrame implements ActionListener{
    
    JTextField aroomnumber, ravailability, cleanstatus, amountpaid;
    Choice ccustomer;
    JButton check, update, back;
    
    UpdateRoom(){
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 25));
        text.setBounds(150, 30, 250, 30);
        add(text);
        
        JLabel cid = new JLabel("Customer ID");
        cid.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cid.setBounds(30, 90, 100, 30);
        add(cid);

        ccustomer = new Choice();
        ccustomer.setBounds(150, 90, 150, 30);
        add(ccustomer);
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JLabel rnumber = new JLabel("Room Number");
        rnumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rnumber.setBounds(30, 130, 100, 30);
        add(rnumber);
        
        aroomnumber = new JTextField();
        aroomnumber.setBounds(150, 130, 150, 30);
        add(aroomnumber);
        
        JLabel cname = new JLabel("Availability");
        cname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cname.setBounds(30, 170, 100, 30);
        add(cname);
        
        ravailability = new JTextField();
        ravailability.setBounds(150, 170, 150, 30);
        add(ravailability);
        
        JLabel ctime = new JLabel("Clean Status");
        ctime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ctime.setBounds(30, 210, 100, 30);
        add(ctime);
        
        cleanstatus = new JTextField();
        cleanstatus.setBounds(150, 210, 150, 30);
        add(cleanstatus);
        
        check = new JButton("Check");
        check.setBounds(100, 300, 80, 30);
        check.setBackground(Color.BLUE);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBounds(200, 300, 80, 30);
        update.setBackground(Color.BLUE);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(300, 300, 80, 30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setBounds(200, 30, 700, 600);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            
            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                while(rs.next()){
                    aroomnumber.setText(rs.getString("room"));
                    }                
                ResultSet rs2 = conn.s.executeQuery("select * from room where roomnumber = '"+aroomnumber.getText()+"'"); 
                while(rs2.next()){
                    ravailability.setText(rs2.getString("availability"));
                    cleanstatus.setText(rs2.getString("cleaning_status"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == update){
            String number = ccustomer.getSelectedItem();
            String room = aroomnumber.getText();
            String available = ravailability.getText();
            String status = cleanstatus.getText();
            try {
                Conn c = new Conn();
                c.s.executeUpdate("update room set availability = '"+available+"', cleaning_status = '"+status+"' where roomnumber = '"+room+"'");
                    
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
                new Reception();
        }
    }
    
    public static void main(String[] args){
        new UpdateRoom();
    }    
}
