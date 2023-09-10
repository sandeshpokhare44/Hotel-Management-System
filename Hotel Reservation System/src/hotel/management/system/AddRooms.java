package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRooms extends JFrame implements ActionListener {
    
    JButton addbutton, cancelbutton;
    JTextField broomnumber, bprices;
    JComboBox cbavailable, cbstatus, cbbedtype;
      
    AddRooms(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
              
        JLabel heading = new JLabel("Add Rooms");
        heading.setBounds(100, 10, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);
        
        JLabel aroomnumber = new JLabel("Room Number");
        aroomnumber.setBounds(30, 50, 300, 30);
        add(aroomnumber);
        
        broomnumber = new JTextField();
        broomnumber.setBounds(150, 50, 150, 30);
        add(broomnumber);
        
        JLabel available = new JLabel("Available Rooms");
        available.setBounds(30, 90, 300, 30);
        add(available);
        
        String availableOptions[] = {"Available", "Occupied"};
        cbavailable = new JComboBox(availableOptions);
        cbavailable.setBounds(150, 90, 150, 30);
        cbavailable.setBackground(Color.WHITE);
        add(cbavailable);
        
        JLabel clean = new JLabel("Cleaning Status");
        clean.setBounds(30, 130, 300, 30);
        add(clean);
        
        String cleanOptions[] = {"Ready", "Require Cleaning"};
        cbstatus = new JComboBox(cleanOptions);
        cbstatus.setBounds(150, 130, 150, 30);
        cbstatus.setBackground(Color.WHITE);
        add(cbstatus);
        
        JLabel aprices = new JLabel("Prices");
        aprices.setBounds(30, 170, 300, 30);
        add(aprices);
        
        bprices = new JTextField();
        bprices.setBounds(150, 170, 150, 30);
        add(bprices);
        
        JLabel bedtype = new JLabel("Bed Type");
        bedtype.setBounds(30, 210, 300, 30);
        add(bedtype);
        
        String bedOptions[] = {"Single Room", "Double Room"};
        cbbedtype = new JComboBox(bedOptions);
        cbbedtype.setBounds(150, 210, 150, 30);
        cbbedtype.setBackground(Color.WHITE);
        add(cbbedtype);
        
        addbutton = new JButton("Add Room");
        addbutton.setBounds(70, 270, 100, 30);
        addbutton.setBackground(Color.BLUE);
        addbutton.setForeground(Color.WHITE);
        addbutton.addActionListener(this);
        add(addbutton);
        
        cancelbutton = new JButton("Cancel");
        cancelbutton.setBounds(200, 270, 100, 30);
        cancelbutton.setBackground(Color.BLUE);
        cancelbutton.setForeground(Color.WHITE);
        cancelbutton.addActionListener(this);
        add(cancelbutton);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(400, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320, 20, 350, 280);
        add(image);
        
        setBounds(300, 150, 700, 350);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addbutton){
            String roomnumber = broomnumber.getText();
            String availability = (String) cbavailable.getSelectedItem();
            String status = (String) cbstatus.getSelectedItem();
            String price = bprices.getText();
            String bedtype = (String) cbbedtype.getSelectedItem();
            
            try{
                Conn conn = new Conn();
                String str = "insert into room values('" + roomnumber + "', '" + availability + "', '" + status + "', '" + price + "', '" + bedtype + "')";
                
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New room added successfully");
                
                setVisible(false);  
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddRooms();
    }
    
}
