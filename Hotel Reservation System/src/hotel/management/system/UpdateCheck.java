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

public class UpdateCheck extends JFrame implements ActionListener{
    
    JTextField aroomnumber, customername, checkintime, amountpaid, pendingamount;
    Choice ccustomer;
    JButton check, update, back;
    
    UpdateCheck(){
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 18));
        text.setBounds(150, 30, 200, 30);
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
        
        JLabel cname = new JLabel("Name");
        cname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cname.setBounds(30, 170, 100, 30);
        add(cname);
        
        customername = new JTextField();
        customername.setBounds(150, 170, 150, 30);
        add(customername);
        
        JLabel ctime = new JLabel("Checkin Time");
        ctime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ctime.setBounds(30, 210, 100, 30);
        add(ctime);
        
        checkintime = new JTextField();
        checkintime.setBounds(150, 210, 150, 30);
        add(checkintime);
        
        JLabel apaid = new JLabel("Amount Paid");
        apaid.setFont(new Font("Tahoma", Font.PLAIN, 14));
        apaid.setBounds(30, 250, 100, 30);
        add(apaid);
        
        amountpaid = new JTextField();
        amountpaid.setBounds(150, 250, 150, 30);
        add(amountpaid);
        
        JLabel apending = new JLabel("Pending Amount");
        apending.setFont(new Font("Tahoma", Font.PLAIN, 14));
        apending.setBounds(30, 290, 100, 30);
        add(apending);
        
        pendingamount = new JTextField();
        pendingamount.setBounds(150, 290, 150, 30);
        add(pendingamount);
        
        check = new JButton("Check");
        check.setBounds(100, 380, 80, 30);
        check.setBackground(Color.BLUE);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBounds(200, 380, 80, 30);
        update.setBackground(Color.BLUE);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(300, 380, 80, 30);
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
                    customername.setText(rs.getString("name"));
                    checkintime.setText(rs.getString("checkin_time"));
                    amountpaid.setText(rs.getString("deposit"));
                }
                ResultSet rs2 = conn.s.executeQuery("select * from room where roomnumber = '"+aroomnumber.getText()+"'"); 
                while(rs2.next()){
                    String price = rs2.getString("price");
                    int paidAmount = Integer.parseInt(price) - Integer.parseInt(amountpaid.getText());
                    pendingamount.setText("" + paidAmount);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == update){
            String number = ccustomer.getSelectedItem();
            String room = aroomnumber.getText();
            String name = customername.getText();
            String checkin = checkintime.getText();
            String deposit = amountpaid.getText();
            try {
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', checkin_time = '"+checkin+"', deposit = '"+deposit+"' where number = '"+number+"'");
                    
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
        new UpdateCheck();
    }    
}
