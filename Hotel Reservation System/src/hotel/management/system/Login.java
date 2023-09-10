package hotel.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener {
    
    JTextField username;
    JPasswordField password;
    JButton  login, cancel, signup;
    
    Login(){
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        JLabel signin = new JLabel("Sign In");
        signin.setBounds(250, 10, 100, 30);
        add(signin);
        
        JLabel user = new JLabel("Username");
        user.setBounds(150, 50, 100, 30);
        add(user);
        
        username = new JTextField();
        username.setBounds(230, 50, 200, 30);
        add(username);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(150, 100, 100, 30);
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(230, 100, 200, 30);
        add(password);
        
        
        login = new JButton("Login");
        login.setBounds(180, 160, 80, 25);
        login.setBackground(Color.BLUE);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(320, 160, 80, 25);
        
        cancel.setBackground(Color.BLUE);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        JLabel text = new JLabel("Don't Have Account?");
        text.setBounds(230, 230, 200, 20);
        text.setForeground(Color.BLUE);
        add(text);
        
        signup = new JButton("Signup");
        signup.setBounds(250, 260, 80, 25);
        signup.setBackground(Color.BLUE);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        setBounds(400, 150, 600, 350);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == login){
            String user = username.getText();
            String pass = password.getText();
            
            try {
                Conn c = new Conn();
                
                String query = "select * from signup where username = '" + user + "' and password = '" + pass + "'"; 
                
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                }else{      
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
                
            }catch (Exception e){
                e.printStackTrace();
            }
        
        }else if(ae.getSource() == signup){
        setVisible(false);
        new Signup();
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}

