package carrentalsystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminSignin implements ActionListener  {
    private JLabel adminLabel, passLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton, quitButton;
    private JLabel message;
    private JFrame frame;
    private JPanel panel;
    
    AdminSignin(){
        panel = new JPanel();
        panel.setLayout(null);
        //Frame
        frame = new JFrame();
        frame.setSize(350,300);
        frame.setLocation(800,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Admin Login");
        
        //creating labels
        adminLabel = new JLabel("Username");
        adminLabel.setBounds(10,20,80,25);
        panel.add(adminLabel);
        passLabel = new JLabel("Password");
        passLabel.setBounds(10,50,80,25);
        panel.add(passLabel);
        //creating textfields
        userField = new JTextField(20);
        userField.setBounds(100,20,165,25);
        panel.add(userField);
        passField = new JPasswordField();
        passField.setBounds(100,50,165,25);
        panel.add(passField);
        //creating buttons
        loginButton = new JButton("Sign In");
        loginButton.setBounds(100,80,80,25);
        loginButton.addActionListener(this);
        panel.add(loginButton);
        quitButton = new JButton("Quit");
        quitButton.setBounds(180,80,80,25);
        quitButton.addActionListener(this);
        panel.add(quitButton);
        //message display
        message = new JLabel("");
        message.setBounds(100,110,300,25);
        panel.add(message);
        
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==loginButton){
            String admin = userField.getText();
            String password = passField.getText();
            if(admin.equals("Jazli")&&password.equals("tp062159")){
                message.setForeground(Color.green);
                message.setText("Login successful");
                frame.dispose();
                SelectionInterface selectionInterface = new SelectionInterface();
            }else if(admin.equals("mohammed")&&password.equals("tp056498")){
                message.setForeground(Color.green);
                message.setText("Login successful");
                frame.dispose();
                SelectionInterface selectionInterface = new SelectionInterface();
            }
            else if(admin.equals("1")&&password.equals("1")){
                message.setForeground(Color.green);
                message.setText("Login successful");
                frame.dispose();
                SelectionInterface selectionInterface = new SelectionInterface();
            }
            else{
                message.setForeground(Color.red);
                message.setText("Username or Password Invalid");
            }
        }else{
            System.exit(0);
        }
    }
}
