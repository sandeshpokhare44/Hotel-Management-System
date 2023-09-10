package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.sql.*;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comboid;
    JTextField bnumber, bname, bcountry, bdeposit;
    JRadioButton amale, female;
    Choice croom;
    JLabel checkintime;
    JButton addbutton, backbutton;
    
    AddCustomer(){
        
        setLayout(null);
        
        JLabel customerform = new JLabel("New Customer Form");
        customerform.setFont(new Font("Raleway", Font.BOLD, 18));
        customerform.setBounds(120, 30, 200, 30);
        add(customerform);
        
        JLabel aid = new JLabel("ID");
        aid.setFont(new Font("Raleway", Font.PLAIN, 14));
        aid.setBounds(50, 100, 200, 30);
        add(aid);
        
        String options[] = {"SSN", "Passport", "Driving License", "Voter ID"};
        comboid = new JComboBox(options);
        comboid.setBounds(200, 100, 150, 30);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel anumber = new JLabel("Number");
        anumber.setFont(new Font("Raleway", Font.PLAIN, 14));
        anumber.setBounds(50, 140, 200, 30);
        add(anumber);
        
        bnumber = new JTextField();
        bnumber.setBounds(200, 140, 150, 30);
        add(bnumber);
        
        JLabel aname = new JLabel("Name");
        aname.setFont(new Font("Raleway", Font.PLAIN, 14));
        aname.setBounds(50, 180, 200, 30);
        add(aname);
        
        bname = new JTextField();
        bname.setBounds(200, 180, 150, 30);
        add(bname);
        
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway", Font.PLAIN, 14));
        gender.setBounds(50, 220, 200, 30);
        add(gender);
        
        amale = new JRadioButton("Male");
        amale.setFont(new Font("Raleway", Font.PLAIN, 14));
        amale.setBackground(Color.WHITE);
        amale.setBounds(200, 220, 80, 30);
        add(amale);
        
        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.PLAIN, 14));
        female.setBackground(Color.WHITE);
        female.setBounds(280, 220, 80, 30);
        add(female);
        
        JLabel acountry = new JLabel("Country");
        acountry.setFont(new Font("Raleway", Font.PLAIN, 14));
        acountry.setBounds(50, 260, 200, 30);
        add(acountry);
        
        bcountry = new JTextField();
        bcountry.setBounds(200, 260, 150, 30);
        add(bcountry);
        
        JLabel aroomnumber = new JLabel("Room Number");
        aroomnumber.setFont(new Font("Raleway", Font.PLAIN, 14));
        aroomnumber.setBounds(50, 300, 100, 30);
        add(aroomnumber);
        
        croom = new Choice();
        try{
            Conn conn = new Conn();
            String query = "select * from room where availability = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        }catch (Exception e){
            e.printStackTrace();  
        }
        croom.setBounds(200, 300, 150, 30);
        add(croom);
        
        
        JLabel checktime = new JLabel("Checkin Time");
        checktime.setFont(new Font("Raleway", Font.PLAIN, 14));
        checktime.setBounds(50, 340, 340, 30);
        add(checktime);
        
        Date date = new Date();
        
        checkintime = new JLabel("" + date);
        checkintime.setFont(new Font("Raleway", Font.PLAIN, 14));
        checkintime.setBounds(200, 340, 200, 30);
        add(checkintime);
        
        JLabel adeposit = new JLabel("Deposit");
        adeposit.setFont(new Font("Raleway", Font.PLAIN, 14));
        adeposit.setBounds(50, 380, 200, 30);
        add(adeposit);
        
        bdeposit = new JTextField();
        bdeposit.setBounds(200, 380, 150, 30);
        add(bdeposit);
        
        addbutton = new JButton("Add");
        addbutton.setBounds(100, 430, 80, 30);
        addbutton.setBackground(Color.BLUE);
        addbutton.setForeground(Color.WHITE);
        addbutton.setFont(new Font("Raleway", Font.PLAIN, 14));
        addbutton.addActionListener(this);
        add(addbutton);
        
        backbutton = new JButton("Back");
        backbutton.setBounds(220, 430, 80, 30);
        backbutton.setBackground(Color.BLUE);
        backbutton.setForeground(Color.WHITE);
        backbutton.setFont(new Font("Raleway", Font.PLAIN, 14));
        backbutton.addActionListener(this);
        add(backbutton);
        
        setBounds(400, 120, 500, 550);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
     
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == addbutton){
            String id = (String) comboid.getSelectedItem();
            String number = bnumber.getText();
            String name = bname.getText();
            String gender = null;
           
            if(amale.isSelected()){
                gender = "Male";
            }else{
                gender = "Female";
            }
            
            String country = bcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = bdeposit.getText();
            
            try {
                String query = "insert into customer values('" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + room + "', '" + time +"', '" + deposit + "')";
                String query2 = "update room set availability = 'Occupied' where roomnumber = '"+room+"' ";
                
                Conn conn = new Conn();
                
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                
                setVisible(false);
                new Reception();
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == backbutton){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        
        new AddCustomer();
        
    }
    
}
