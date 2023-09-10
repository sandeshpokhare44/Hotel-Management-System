package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Signup extends JFrame implements ActionListener {
    
    JTextField fname, lname, email, username;
    JPasswordField password;
    JButton  asignup, cancel, login;
    
    Signup(){
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        JLabel signup = new JLabel("Sign Up");
        signup.setBounds(150, 30, 100, 30);
        signup.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(signup);
        
        JLabel firstname = new JLabel("First Name");
        firstname.setBounds(30, 70, 100, 30);
        add(firstname);
        
        fname = new JTextField();
        fname.setBounds(150, 70, 200, 30);
        add(fname);
        
        JLabel lastname = new JLabel("Last Name");
        lastname.setBounds(30, 110, 100, 30);
        add(lastname);
        
        lname = new JTextField();
        lname.setBounds(150, 110, 200, 30);
        add(lname);
        
        JLabel mail = new JLabel("Email");
        mail.setBounds(30, 150, 100, 30);
        add(mail);
        
        email = new JTextField();
        email.setBounds(150, 150, 200, 30);
        add(email);

        
        JLabel user = new JLabel("Username");
        user.setBounds(30, 190, 100, 30);
        add(user);
        
        username = new JTextField();
        username.setBounds(150, 190, 200, 30);
        add(username);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(30, 230, 100, 30);
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(150, 230, 200, 30);
        add(password);
 
        asignup = new JButton("Signup");
        asignup.setBounds(80, 280, 80, 25);
        asignup.setBackground(Color.BLUE);
        asignup.setForeground(Color.WHITE);
        asignup.addActionListener(this);
        add(asignup);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 280, 80, 25);
        cancel.setBackground(Color.BLUE);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        JLabel text = new JLabel("Already Have Account?");
        text.setBounds(150, 380, 200, 20);
        text.setForeground(Color.BLUE);
        add(text);
        
        login = new JButton("Login");
        login.setBounds(170, 410, 80, 25);
        login.setBackground(Color.BLUE);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        setBounds(400, 120, 500, 500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == asignup){
            String firstname = fname.getText();
            String lastname = lname.getText();
            String Email = email.getText();
            String userName = username.getText();
            String passWord = password.getText();
            
            try {
                Conn c = new Conn();
                String query = "insert into signup values('" + firstname + "', '" + lastname + "', '" + Email + "', '" + userName + "', '" + passWord + "')"; 
                c.s.executeUpdate(query);

                    setVisible(false);
                    new Dashboard();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == login){
        setVisible(false);
        new Login();
        }else if(ae.getSource() == cancel){
        setVisible(false);
    }
    }
    
    public static void main(String[] args){
        new Signup();
    }
}

