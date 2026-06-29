package carrentalsystem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SelectionInterface implements ActionListener{
    private  JButton customerbook,carlistpage;
    private  JFrame frame;
    private  JPanel panel;
    public SelectionInterface(){
        panel = new JPanel();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,300);
        frame.setLocation(800,300);
        frame.add(panel);
        frame.setVisible(true);
        frame.setTitle("Select Action");
        
        customerbook = new JButton("Customer Booking");
        customerbook.addActionListener(this);
        panel.add(customerbook);
        carlistpage = new JButton("List of Cars Info");
        carlistpage.addActionListener(this);
        panel.add(carlistpage);
        frame.add(panel,BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==customerbook){
            frame.dispose();
            CustomerBooking customerBooking = new CustomerBooking();
        }else if(ae.getSource()==carlistpage){
            frame.dispose();
            CarsInfoPage carsInfoPage = new CarsInfoPage();
        }
    }
    
}
