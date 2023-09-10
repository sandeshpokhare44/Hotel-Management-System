package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HotelManagementSystem extends JFrame implements ActionListener{
JButton next, signup;
    HotelManagementSystem(){
        setSize(960, 625);
        setLocation(120, 30);
        setLayout(null);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 960, 625);
        add(image);
        
        JLabel text = new JLabel("Welcome To Fulbari Resort");
        text.setBounds(170, 200, 1000, 90);
        text.setForeground(Color.white);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);
       
        signup = new JButton("Sign Up");
        signup.setBounds(720, 10, 90, 30);
        signup.setBackground(Color.BLUE);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        image.add(signup);
        
        next = new JButton("Sign In");
        next.setBounds(820, 10, 90, 30);
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        image.add(next);
        
        setVisible(true);
        
        while(true){
            text.setVisible(true);
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(false);
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
        setVisible(false);
        new Login();
    }else if(ae.getSource() == signup){
        setVisible(false);
        new Signup();
    }
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
        
    }
    
}
