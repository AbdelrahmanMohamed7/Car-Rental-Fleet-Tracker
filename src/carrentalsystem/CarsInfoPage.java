package carrentalsystem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CarsInfoPage implements ActionListener{
    private static ArrayList<CarList> cars;
    private JFrame frame = new JFrame();
    private JPanel p1,p1a,p1c,p2,p1b1,p1b2,p1b3,p1b4;
    private JLabel plateNum, carBrand, carModel, carColour;
    private Button addButton, editButton, clearButton, delButton, quitButton, backButton;
    private JTextField plateField, brandField, modelField, colourField;
    private JTable table;
    private DefaultTableModel tablemodel;
    
    public CarsInfoPage(){
        p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        
        frame.setSize(600,420);
        frame.setLocation(600,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,1));
        frame.add(p1);
        frame.setTitle("Cars Info Page");
        //creating labels
        p1a = new JPanel();
        p1a.setLayout(new GridLayout(2,2)); //check(4,2);
        plateNum = new JLabel("Plate No.",JLabel.CENTER);
        p1a.add(plateNum);
        carBrand = new JLabel("Brand",JLabel.CENTER);
        p1a.add(carBrand);
        carModel = new JLabel("Model",JLabel.CENTER);
        p1a.add(carModel);
        carColour = new JLabel("Colour",JLabel.CENTER);
        p1a.add(carColour);
        //creating textfields
        p1b1 = new JPanel();
        p1b2 = new JPanel();
        p1b3 = new JPanel();
        p1b4 = new JPanel();
        plateField = new JTextField(10);
        p1b1.add(plateField);
        brandField = new JTextField(10);
        p1b2.add(brandField);
        modelField = new JTextField(10);
        p1b3.add(modelField);
        colourField = new JTextField(10);
        p1b4.add(colourField); 
        p1a.add(p1b1);
        p1a.add(p1b2);
        p1a.add(p1b3);
        p1a.add(p1b4);
        p1.add(p1a, BorderLayout.CENTER);
        //creating buttons
        p1c = new JPanel();
        addButton = new Button("Add");
        addButton.addActionListener(this);
        p1c.add(addButton);
        editButton = new Button("Edit");
        editButton.addActionListener(this);
        p1c.add(editButton);
        clearButton = new Button("Clear");
        clearButton.addActionListener(this);
        p1c.add(clearButton);
        delButton = new Button("Delete");
        delButton.addActionListener(this);
        p1c.add(delButton);
        backButton = new Button("Return");
        backButton.addActionListener(this);
        p1c.add(backButton);
        quitButton = new Button("Quit");
        quitButton.addActionListener(this);
        p1c.add(quitButton);
        p1.add(p1c,BorderLayout.SOUTH);
        frame.add(p1);
        
        p2 = new JPanel();
        
        try{
            Scanner su = new Scanner(new File("CarInfo.txt"));
            cars = new ArrayList<CarList>();
            while(su.hasNext()){
                String platenum = su.nextLine();
                String carbrand = su.nextLine();
                String carmodel = su.nextLine();
                String carcolour = su.nextLine();
                su.nextLine();
                CarList a = new CarList(platenum,carbrand,carmodel,carcolour);
                cars.add(a);
            }
        } catch(Exception e){
            cars = new ArrayList<CarList>();
        }
        
        int size = cars.size();
        String[][] data = new String[size][4];
        for(int i=0; i<size; i++){
            CarList a = cars.get(i);
            data[i][0] = a.getPlate();
            data[i][1] = ""+a.getBrand();
            data[i][2] = ""+a.getModel();
            data[i][3] = ""+a.getColour();
        }
        String colNames[] = {"Plate No.", "Brand", "Model", "Colour"};  
        tablemodel = new DefaultTableModel(data, colNames);
        table = new JTable(tablemodel);
        JScrollPane sp = new JScrollPane(table);
        p2.add(sp);
        frame.add(p2);
        
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==quitButton){
            try{
                PrintWriter p1 = new PrintWriter("CarInfo.txt");
                for(int i=0; i<cars.size(); i++){
                    CarList a = cars.get(i);
                    p1.println(a.getPlate());
                    p1.println(a.getBrand());
                    p1.println(a.getModel());
                    p1.println(a.getColour()+"\n");
                }
                p1.close();
                System.exit(0);
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }else if(ae.getSource()==addButton){
            String plate = plateField.getText();
            boolean found = false;
            for(int i=0;i<cars.size();i++){
                CarList a = cars.get(i);
                if(plate.equals(a.getPlate())){
                    found = true;
                    break;
                }
            }
            if(!found){
                String carbrand = brandField.getText();
                String carmodel = modelField.getText();
                String carcolour = colourField.getText();
                CarList a = new CarList(plate,carbrand,carmodel,carcolour);
                cars.add(a);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{plate,carbrand,carmodel,carcolour});
            }else{
                JOptionPane.showMessageDialog(frame,"Car Exists!");
            }
        }else if(ae.getSource()==editButton){
            CarList current = null;
            String plate = plateField.getText();
            boolean found = false;
            int i = 0;
            for(i=0;i<cars.size();i++){
                CarList a = cars.get(i);
                if(plate.equals(a.getPlate())){
                    found = true;
                    current = a;
                    break;
                }
            }
            if(found){
                String carbrand = brandField.getText();
                String carmodel = modelField.getText();
                String carcolour = colourField.getText();
                current.setBrand(carbrand);
                current.setModel(carmodel);
                current.setColour(carcolour);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setValueAt(carbrand, i, 1);
                model.setValueAt(carmodel, i, 2);
                model.setValueAt(carcolour, i, 3);
            }else{
                JOptionPane.showMessageDialog(frame, "Car does not exists!");
            }
        }else if(ae.getSource()==clearButton){
            plateField.setText("");
            brandField.setText("");
            modelField.setText("");
            colourField.setText("");
        }else if(ae.getSource()==backButton){
            try{
                PrintWriter p1 = new PrintWriter("CarInfo.txt");
                for(int i=0; i<cars.size(); i++){
                    CarList a = cars.get(i);
                    p1.println(a.getPlate());
                    p1.println(a.getBrand());
                    p1.println(a.getModel());
                    p1.println(a.getColour()+"\n");
                }
                p1.close();
                frame.dispose();
                SelectionInterface selectionInterface = new SelectionInterface();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }else{ //delete button
            CarList current = null;
            String plate = plateField.getText();
            boolean found = false;
            int i = 0;
            for(i=0;i<cars.size();i++){
                CarList a = cars.get(i);
                if(plate.equals(a.getPlate())){
                    found = true;
                    current = a;
                    cars.remove(a);
                    break;
                }
            }
            if(found){
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(i);
            }else{
                JOptionPane.showMessageDialog(frame,"Car does not exists!");
            }
        }
    }  
}
