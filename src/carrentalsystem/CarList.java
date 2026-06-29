package carrentalsystem;
public class CarList {
    private String plateNum;
    private String carBrand;
    private String carModel;
    private String carColour;
    
    public CarList(String pn, String cb, String cm, String cc){
        plateNum = pn;
        carBrand = cb;
        carModel = cm;
        carColour = cc;
    }
    public String getPlate(){
        return plateNum;
    }
    public String getBrand(){
        return carBrand;
    }
    public String getModel(){
        return carModel;
    }
    public String getColour(){
        return carColour;
    }
    public void setBrand(String carBrand){
        this.carBrand = carBrand;
    }
    public void setModel(String carModel){
        this.carModel = carModel;
    }
    public void setColour(String carColour){
        this.carColour = carColour;
    }
}
