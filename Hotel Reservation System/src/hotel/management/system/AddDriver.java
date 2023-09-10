package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddDriver extends JFrame implements ActionListener {
    
    JButton addbutton, cancelbutton;
    JTextField bname, bage, blocation, carmodel;
    JComboBox bgender, davailable;
      
    AddDriver(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
              
        JLabel heading = new JLabel("Add Drivers");
        heading.setBounds(170, 30, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);
        
        JLabel name = new JLabel("Name");
        name.setBounds(100, 90, 100, 30);
        add(name);
        
        bname = new JTextField();
        bname.setBounds(200, 90, 150, 30);
        add(bname);
        
        JLabel aage = new JLabel("Age");
        aage.setBounds(100, 130, 100, 30);
        add(aage);
        
        bage = new JTextField();
        bage.setBounds(200, 130, 150, 30);
        add(bage);
        
        JLabel agender = new JLabel("Gender");
        agender.setBounds(100, 170, 300, 30);
        add(agender);
        
        String genderOptions[] = {"Male", "Female"};
        bgender = new JComboBox(genderOptions);
        bgender.setBounds(200, 170, 150, 30);
        bgender.setBackground(Color.WHITE);
        add(bgender);
        
        JLabel cmodel = new JLabel("Car Model");
        cmodel.setBounds(100, 210, 300, 30);
        add(cmodel);
        
        carmodel = new JTextField();
        carmodel.setBounds(200, 210, 150, 30);
        add(carmodel);
        
        JLabel availability = new JLabel("Availability");
        availability.setBounds(100, 260, 300, 30);
        add(availability);
        
        String availableOptions[] = {"Available", "Busy"};
        davailable = new JComboBox(availableOptions);
        davailable.setBounds(200, 260, 150, 30);
        davailable.setBackground(Color.WHITE);
        add(davailable);
        
        JLabel alocation = new JLabel("Location");
        alocation.setBounds(100, 300, 300, 30);
        add(alocation);
        
        blocation = new JTextField();
        blocation.setBounds(200, 300, 150, 30);
        add(blocation);
        
        addbutton = new JButton("Add Driver");
        addbutton.setBounds(130, 350, 100, 30);
        addbutton.setBackground(Color.BLUE);
        addbutton.setForeground(Color.WHITE);
        addbutton.addActionListener(this);
        add(addbutton);
        
        cancelbutton = new JButton("Cancel");
        cancelbutton.setBounds(250, 350, 100, 30);
        cancelbutton.setBackground(Color.BLUE);
        cancelbutton.setForeground(Color.WHITE);
        cancelbutton.addActionListener(this);
        add(cancelbutton);
        
        setBounds(400, 150, 500, 450);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addbutton){
            String name = bname.getText();
            String age = bage.getText();
            String gender = (String) bgender.getSelectedItem();
            String available = (String) davailable.getSelectedItem();
            String model = carmodel.getText();
            String location = blocation.getText();

            try{
                Conn conn = new Conn();
                String str = "insert into driver values('" + name + "', '" + age + "', '" + gender + "', '" + available + "', '" + model + "', '" + location + "')";
                
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Driver added successfully");
                
                setVisible(false);  
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddDriver();
    }
    
}
