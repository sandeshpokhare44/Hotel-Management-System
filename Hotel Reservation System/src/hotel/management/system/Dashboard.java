package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame implements ActionListener {
    
    Dashboard(){
        setBounds(0, 0, 1550, 1000);
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);
        
        JLabel text = new JLabel("Welcome To Fulbari Resort");
        text.setBounds(350, 20, 1000, 90);
        text.setFont(new Font("Tahoma", Font.PLAIN, 50));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);
        
        JMenu reservation = new JMenu("Reservation");
        reservation.setForeground(Color.BLUE);
        mb.add(reservation);
        
        JMenuItem reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        reservation.add(reception);
        
        JMenu management = new JMenu("Management");
        management.setForeground(Color.BLUE);
        mb.add(management);
        
        JMenuItem employee = new JMenuItem("Employees");
        employee.addActionListener(this);
        management.add(employee);
          
        JMenuItem rooms = new JMenuItem("Rooms");
        rooms.addActionListener(this);
        management.add(rooms);
        
        JMenuItem drivers = new JMenuItem("Drivers");
        drivers.addActionListener(this);
        management.add(drivers);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Employees")){
        new AddEmployee();
       }else if(ae.getActionCommand().equals("Rooms")){
            new AddRooms();
        }else if(ae.getActionCommand().equals("Drivers")){
            new AddDriver();
        }else if(ae.getActionCommand().equals("Reception")){
            new Reception();
        }
    }
    
    public static void main(String[] args){
    new Dashboard();
}
    
}

