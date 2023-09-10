
package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Checkout extends JFrame implements ActionListener {
    Choice ccustomerid;
    JLabel roomnumber, checkintime, checkouttime;
    JButton checkout, back;
    
    Checkout(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(200, 30, 200, 30);
        text.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(text);
        
        JLabel cid = new JLabel("Customer ID");
        cid.setBounds(30, 70, 100, 30);
        add(cid);
        
        ccustomerid = new Choice();
        ccustomerid.setBounds(150, 80, 150, 30);
        add(ccustomerid);

        JLabel rnumber = new JLabel("Room Number");
        rnumber.setBounds(30, 120, 150, 30);
        add(rnumber);
        
        roomnumber = new JLabel();
        roomnumber.setBounds(150, 120, 150, 30);
        add(roomnumber);
        
        JLabel ctime = new JLabel("Checkin Time");
        ctime.setBounds(30, 160, 150, 30);
        add(ctime);
        
        checkintime = new JLabel();
        checkintime.setBounds(150, 160, 150, 30);
        add(checkintime);
        
        JLabel couttime = new JLabel("Checkout Time");
        couttime.setBounds(30, 200, 150, 30);
        add(couttime);
        
        Date date = new Date();
        checkouttime = new JLabel("" + date);
        checkouttime.setBounds(150, 200, 150, 30);
        add(checkouttime);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(50, 270, 100, 30);
        checkout.setBackground(Color.BLUE);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setBounds(180, 270, 100, 30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
         try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomerid.add(rs.getString("number"));
                roomnumber.setText(rs.getString("room"));
                checkintime.setText(rs.getString("checkin_time"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 100, 400, 250);
        add(image);
                
        setBounds(250, 120, 800, 400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkout){
             String query = "delete from customer where number = '"+ccustomerid.getSelectedItem()+"'";
             String query2 = "update room set availability = 'Available' where roomnumber = '"+roomnumber.getText()+"'";
            try{
               Conn c = new Conn();
               c.s.executeUpdate(query);
               c.s.executeUpdate(query2);
               JOptionPane.showMessageDialog(null, "Checkout Completed");
            
               setVisible(false);
               new Reception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new Checkout();
    }
    
}
