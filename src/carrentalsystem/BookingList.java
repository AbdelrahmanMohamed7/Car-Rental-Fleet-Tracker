package carrentalsystem;
public class BookingList {
    private String cusName;
    private String carBrand;
    private String plateNum;
    private String dateIn;
    private String dateOut;
    private String Paymentc;
    
    public BookingList(String cn, String cb, String pn, String dti, String dto,String pay){
        cusName = cn;
        carBrand = cb;
        plateNum = pn;
        dateIn = dti;
        dateOut = dto;
        Paymentc = pay;
        
    }
    public String getCusName(){
        return cusName;
    }
    public String getBrand(){
        return carBrand;
    }
    public String getPlate(){
        return plateNum;
    }
    public String getDateIn(){
        return dateIn;
    }
    public String getDateOut(){
        return dateOut;
    }
    public String getPayment(){
        return Paymentc;
    }
    public void setBrand(String carBrand){
        this.carBrand = carBrand;
    }
    public void setPlate(String plateNum){
        this.plateNum = plateNum;
    }
    public void setDateIn(String dateIn){
        this.dateIn = dateIn;
    }
    public void setDateOut(String dateOut){
        this.dateOut = dateOut;
    }
    public void setPayment(String pay){
        this.Paymentc = pay;
    }
    
}
