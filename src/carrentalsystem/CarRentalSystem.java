package carrentalsystem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CarRentalSystem implements ActionListener{
    private  JButton customer,admin;
    private  JFrame frame;
    private  JPanel panel;
    
    
    public CarRentalSystem (){
        panel = new JPanel();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,300);
        frame.setLocation(800,300);
        frame.add(panel);
        frame.setVisible(true);
        frame.setTitle("Car Rental System");
        
        admin = new JButton("Admin");
        admin.addActionListener(this);
        panel.add(admin);
        frame.add(panel,BorderLayout.CENTER);
        
        customer = new JButton("Customer");
        customer.addActionListener(this);
        panel.add(customer);
        if(customer.getModel().isPressed()==false)
        {
            
            Main_frame_Customer m=new Main_frame_Customer();
            m.setVisible(true);
            
            //frame.dispose();
        }
        
          
    }
    
    public static void main(String[] args){
        CarRentalSystem carRentalSystem = new CarRentalSystem();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==customer){
            frame.dispose();
        }else if (ae.getSource()==admin){
            frame.dispose();
            AdminSignin adminInfo = new AdminSignin();
            
        }
    }  
}
