package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener{
    
    JButton form, rooms, department, employeedetails, customerinfo, managerinfo, checkstatus, 
            roomstatus, pickup, searchrooms, logout, checkout;
    
    Reception(){
        
        setLayout(null);
        
        form = new JButton("New Customer Form");
        form.setBackground(Color.BLUE);
        form.setForeground(Color.WHITE);
        form.setBounds(10, 30, 200, 30);
        form.addActionListener(this);
        add(form);
        
        rooms = new JButton("Rooms");
        rooms.setBackground(Color.BLUE);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        rooms.setBounds(10, 70, 200, 30);
        add(rooms);
        
        department = new JButton("Department");
        department.setBackground(Color.BLUE);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        department.setBounds(10, 110, 200, 30);
        add(department);
        
        employeedetails = new JButton("Employee Details");
        employeedetails.setBackground(Color.BLUE);
        employeedetails.setForeground(Color.WHITE);
        employeedetails.addActionListener(this);
        employeedetails.setBounds(10, 150, 200, 30);
        add(employeedetails);
        
        customerinfo = new JButton("Customer Info");
        customerinfo.setBackground(Color.BLUE);
        customerinfo.setForeground(Color.WHITE);
        customerinfo.addActionListener(this);
        customerinfo.setBounds(10, 190, 200, 30);
        add(customerinfo);
        
        managerinfo = new JButton("Manager Info");
        managerinfo.setBackground(Color.BLUE);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.addActionListener(this);
        managerinfo.setBounds(10, 230, 200, 30);
        add(managerinfo);
        
        checkstatus = new JButton("Update Status");
        checkstatus.setBackground(Color.BLUE);
        checkstatus.setForeground(Color.WHITE);
        checkstatus.addActionListener(this);
        checkstatus.setBounds(10, 270, 200, 30);
        add(checkstatus);
        
        roomstatus = new JButton("Update Room Status");
        roomstatus.setBackground(Color.BLUE);
        roomstatus.setForeground(Color.WHITE);
        roomstatus.addActionListener(this);
        roomstatus.setBounds(10, 310, 200, 30);
        add(roomstatus);
        
        pickup = new JButton("Pick up Service");
        pickup.setBackground(Color.BLUE);
        pickup.setForeground(Color.WHITE);
        pickup.setBounds(10, 350, 200, 30);
        pickup.addActionListener(this);
        add(pickup);
        
        searchrooms = new JButton("Search Rooms");
        searchrooms.setBackground(Color.BLUE);
        searchrooms.setForeground(Color.WHITE);
        searchrooms.setBounds(10, 390, 200, 30);
        searchrooms.addActionListener(this);
        add(searchrooms);
        
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLUE);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(10, 430, 200, 30);
        checkout.addActionListener(this);
        add(checkout);
        
        logout = new JButton("Logout");
        logout.setBackground(Color.BLUE);
        logout.setForeground(Color.WHITE);
        logout.setBounds(10, 470, 200, 30);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(220, 30, 450, 470);
        add(image);
                
        setBounds(300, 80, 700, 550);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == form){
            setVisible(false);
            new AddCustomer();
        }else if(ae.getSource() == rooms){
            setVisible(false);
            new Room();
        }else if(ae.getSource() == department){
            setVisible(false);
            new Department();
        }else if(ae.getSource() == employeedetails){
            setVisible(false);
            new EmployeeInfo();
        }else if(ae.getSource() == managerinfo){
            setVisible(false);
            new ManagerInfo();
        }else if(ae.getSource() == customerinfo){
            setVisible(false);
            new CustomerInfo();
        }else if(ae.getSource() == searchrooms){
            setVisible(false);
            new SearchRoom();
        }else if(ae.getSource() == checkstatus){
            setVisible(false);
            new UpdateCheck();
        }else if(ae.getSource() == roomstatus){
            setVisible(false);
            new UpdateRoom();
        }else if(ae.getSource() == pickup){
            setVisible(false);
            new Pickup();
        }else if(ae.getSource() == checkout){
            setVisible(false);
            new Checkout();
        }else if(ae.getSource() == logout){
            setVisible(false);
            System.exit(0);
        }
    }
    
    
    public static void main(String[] args){
       new Reception();
    }
    
}
