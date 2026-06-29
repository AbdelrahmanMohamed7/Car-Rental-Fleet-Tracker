package carrentalsystem;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CustomerBooking implements ActionListener{
    private JLabel name,carbrand,platenum,datein,dateout,Rental_amount_lbl;
    private JTextField namef,brandf,platef,dinf,doutf,rental_amount_txt;
    private JFrame frame;
    private JPanel panel,panel2;
    private JButton book,edit,remove,back,quit,pay_save;
    private JTable table;
    private DefaultTableModel tablemodel;
    private static ArrayList<BookingList> bookings;
    
    public CustomerBooking(){
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setLayout(null);
        frame = new JFrame();
        frame.setSize(950,300);
        frame.setLocation(500,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,2));
        frame.add(panel);
        frame.setTitle("Customer Booking");
        
        name = new JLabel("Name:");
        name.setBounds(10,20,80,25);
        panel.add(name);
        carbrand = new JLabel("Car Brand:");
        carbrand.setBounds(10,50,80,25);
        panel.add(carbrand);
        platenum = new JLabel("Plate No.:");
        platenum.setBounds(10,80,80,25);
        panel.add(platenum);
        datein = new JLabel("Start Rent Date:");
        datein.setBounds(10,110,100,25);
        panel.add(datein);
        dateout = new JLabel("End Rent Date:");
        dateout.setBounds(10,140,100,25);
        panel.add(dateout);
        
        Rental_amount_lbl = new JLabel("Rental Amount:");
        Rental_amount_lbl.setBounds(10,170,100,25);
        panel.add(Rental_amount_lbl);
        
        namef = new JTextField();
        namef.setBounds(110,20,165,25);
        panel.add(namef);
        brandf = new JTextField();
        brandf.setBounds(110,50,165,25);
        panel.add(brandf);
        platef = new JTextField();
        platef.setBounds(110,80,165,25);
        panel.add(platef);
        dinf = new JTextField();
        dinf.setBounds(110,110,165,25);
        panel.add(dinf);
        doutf = new JTextField();
        doutf.setBounds(110,140,165,25);
        panel.add(doutf);
        
        rental_amount_txt=new JTextField();
        rental_amount_txt.setBounds(110,170,165,25);
        panel.add(rental_amount_txt);
      
        book = new JButton("Book");
        book.addActionListener(this);
        book.setBounds(110,200,80,25);
        panel.add(book);
        
        edit = new JButton("Edit");
        edit.addActionListener(this);
        edit.setBounds(190,200,80,25);
        panel.add(edit);
        
        remove = new JButton("Remove");
        remove.addActionListener(this);
        remove.setBounds(270,200,80,25);
        panel.add(remove);
        
        
        
        pay_save = new JButton("Pay & Save");
        pay_save.addActionListener(this);
        pay_save.setBounds(110,230,100,25);
        panel.add(pay_save);
        
        back = new JButton("Return");
        back.addActionListener(this);
        back.setBounds(210,230,80,25);
        panel.add(back);
        quit = new JButton("Quit");
        quit.addActionListener(this);
        quit.setBounds(290,230,80,25);
        panel.add(quit);
        
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        String colNames[] = {"Name","Car","Plate Number","Start Rent Date","End Rent Date","Rental amount"};
        
        try{
            Scanner su = new Scanner(new File("CustomerBookings.txt"));
            bookings = new ArrayList<BookingList>();
            while(su.hasNext()){
                String cusname = su.nextLine();
                String carbrand = su.nextLine();
                String platenum = su.nextLine();
                String datein = su.nextLine();
                String dateout = su.nextLine();
                String rental=su.nextLine();
                BookingList x = new BookingList(cusname,carbrand,platenum,datein,dateout,rental);
                bookings.add(x);
            }
        }catch (Exception e){
            bookings = new ArrayList<BookingList>();
        }
        int size = bookings.size();
        String[][] data = new String[size][6];
        for(int i=0;i<size;i++){
            BookingList x = bookings.get(i);
            data[i][0] = x.getCusName();
            data[i][1] = ""+x.getBrand();
            data[i][2] = ""+x.getPlate();
            data[i][3] = ""+x.getDateIn();
            data[i][4] = ""+x.getDateOut();
            data[i][5] = ""+x.getPayment();
        }
        tablemodel = new DefaultTableModel(data,colNames);
        table = new JTable(tablemodel);
        JScrollPane sp = new JScrollPane(table);
        panel2.add(sp);
        frame.add(panel2);
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            try{
                PrintWriter v = new PrintWriter("CustomerBookings.txt");
                for(int i=0;i<bookings.size();i++){
                    BookingList x = bookings.get(i);
                    v.println(x.getCusName());
                    v.println(x.getBrand());
                    v.println(x.getPlate());
                    v.println(x.getDateIn());
                    v.println(x.getDateOut());
                    v.println(x.getPayment());
                    
                    }
                v.close();
                frame.dispose();
                SelectionInterface selectionInterface = new SelectionInterface();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }else if(ae.getSource()==book){
            String cusname = namef.getText();
            boolean found = false;
            for(int i=0;i<bookings.size();i++){
                BookingList x = bookings.get(i);
                if(cusname.equals(x.getCusName())){
                    found = true;
                    break;
                }
            }
            if(!found){
                String carbrand = brandf.getText();
                String platenum = platef.getText();
                String datein = dinf.getText();
                String dateout = doutf.getText();
                String payment = rental_amount_txt.getText();
                BookingList x =new BookingList(cusname,carbrand,platenum,datein,dateout,payment);
                bookings.add(x);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{cusname,carbrand,platenum,datein,dateout,payment});
            }else{
                JOptionPane.showMessageDialog(frame,"Customer Booking alread exits");
            }
        }else if(ae.getSource()==edit){
            BookingList current = null;
            String cusname = namef.getText();
            boolean found = false;
            int i = 0;
            for(i=0;i<bookings.size();i++){
                BookingList x = bookings.get(i);
                if(cusname.equals(x.getCusName())){
                    found = true;
                    current = x;
                    break;
                }
            }
            if(found){
                String carbrand = brandf.getText();
                String platenum = platef.getText();
                String datein = dinf.getText();
                String dateout = doutf.getText();
                String payment = rental_amount_txt.getText();
                current.setBrand(carbrand);
                current.setPlate(platenum);
                current.setDateIn(datein);
                current.setDateOut(dateout);
                current.setPayment(payment);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setValueAt(carbrand, i, 1);
                model.setValueAt(platenum, i, 2);
                model.setValueAt(datein, i, 3);
                model.setValueAt(dateout, i, 4);
                model.setValueAt(payment, i, 5);
            }else{
                JOptionPane.showMessageDialog(frame,"Customer Booking does not exist!");
            }
        }else if(ae.getSource()==remove){ //check
            BookingList current = null;
            String cusname = namef.getText();
            boolean found = false;
            int i = 0;
            for(i=0;i<bookings.size();i++){
                BookingList x = bookings.get(i);
                if(cusname.equals(x.getCusName())){
                    found = true;
                    current = x;
                    bookings.remove(x);
                    break;
                }
            }
            if(found){
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(i);
            }else{
                JOptionPane.showMessageDialog(frame,"Customer Booking does not exist");
            }
        }else if(ae.getSource()==quit){
            
                System.exit(0);
            
        }
        else if(ae.getSource()==pay_save){
            try{
                PrintWriter v = new PrintWriter("CustomerBookings.txt");
                for(int i=0;i<bookings.size();i++){
                    BookingList x = bookings.get(i);
                    v.println(x.getCusName());
                    v.println(x.getBrand());
                    v.println(x.getPlate());
                    v.println(x.getDateIn());
                    v.println(x.getDateOut());
                    v.println(x.getPayment());
                    
                }
                v.close();
                JOptionPane.showMessageDialog(null, "Payment and Save id done");
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
