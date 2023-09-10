package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField bname, bage, bemail, bphone, bsalary, bssn;
    JRadioButton rmale, rfemale;
    JButton submit, cancel;
    JComboBox cbposition;
    
    AddEmployee() {
        setLayout(null);
        
        JLabel addemployee = new JLabel("New Employee Form");
        addemployee.setBounds(130, 20, 200, 30);
        addemployee.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(addemployee);
        
        JLabel fname = new JLabel("Name");
        fname.setBounds(60, 70, 120, 30);
        add(fname);
        
        bname = new JTextField();
        bname.setBounds(150, 70, 200, 30);
        add(bname);
        
        JLabel fage = new JLabel("Age");
        fage.setBounds(60, 110, 120, 30);
        add(fage);
        
        bage = new JTextField();
        bage.setBounds(150, 110, 200, 30);
        add(bage);
        
        JLabel agender = new JLabel("Gender");
        agender.setBounds(60, 150, 120, 30);
        add(agender);
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(150, 150, 70, 30);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(230, 150, 70, 30);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        JLabel fposition = new JLabel("Position");
        fposition.setBounds(60, 190, 120, 30);
        add(fposition);
        
        String str[] = {"Front Desk Clark", "Kitchen Staff", "Room Service", "HouseKeeping", "Chefs", "Manager", "Accountant"};
        cbposition = new JComboBox(str);
        cbposition.setBounds(150, 190, 150, 30);
        cbposition.setBackground(Color.WHITE);
        add(cbposition);
        
        JLabel asalary = new JLabel("Salary");
        asalary.setBounds(60, 230, 120, 30);
        add(asalary);
        
        bsalary = new JTextField();
        bsalary.setBounds(150, 230, 200, 30);
        add(bsalary);
        
        JLabel aphone = new JLabel("Phone");
        aphone.setBounds(60, 270, 120, 30);
        add(aphone);
        
        bphone = new JTextField();
        bphone.setBounds(150, 270, 200, 30);
        add(bphone);
        
        JLabel aemail = new JLabel("Email");
        aemail.setBounds(60, 310, 120, 30);
        aemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(aemail);
        
        bemail = new JTextField();
        bemail.setBounds(150, 310, 200, 30);
        add(bemail);
        
        JLabel assn = new JLabel("SSN");
        assn.setBounds(60, 350, 120, 30);
        assn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(assn);
        
        bssn = new JTextField();
        bssn.setBounds(150, 350, 200, 30);
        add(bssn);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.setBounds(120, 410, 80, 25);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLUE);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220, 410, 80, 25);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(400, 120, 470, 500);
        setVisible(true);
    }
    
    public  void actionPerformed(ActionEvent ae){
        String name = bname.getText();
        String age = bage.getText();
        
        String gender = null;
        if(rmale.isSelected()){
            gender = "Male";
        }else if(rfemale.isSelected()){
            gender = "Female";
        }
        String salary = bsalary.getText();
        String phone = bphone.getText();
        String email = bemail.getText();
        String ssn = bssn.getText();
        
        String job = (String) cbposition.getSelectedItem();
        if(ae.getSource() == submit){
        try{
            Conn conn = new Conn();
            String query = "Insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+ssn+"')";
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Employee added successfully");
            setVisible(false);
            new Reception();
        }catch (Exception e){
            e.printStackTrace();
        }
        }else if (ae.getSource() == cancel){
            setVisible(false);
            new Reception();
        }
        
    }
    
    public static void main(String[] args){
        
        new AddEmployee();
    }
}
