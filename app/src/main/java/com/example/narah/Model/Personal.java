package com.example.narah.Model;

public class Personal {

    private String Name="";
    private String ID="";
    private String Address="";
    private String CreditCard="";
    private String Pay="";
    private int OrderId=0;

    public Personal(){
        super();
    }

    @Override
    public String toString() {
        return "Personal{" +
                "Name='" + Name + '\'' +
                ", ID='" + ID + '\'' +
                ", Address='" + Address + '\'' +
                ", CreditCard='" + CreditCard + '\'' +
                ", Pay='" + Pay + '\'' +
                '}';
    }

    public Personal(String name, String address, String id, String CD, String p)
    {
      Name=name;
      ID=id;
      Address=address;
      CreditCard=CD;
      Pay=p;
    }
    public void setName(String name) {
        Name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setCreditCard(String creditCard) {
        CreditCard = creditCard;
    }

    public void setPay(String pay) {
        Pay = pay;
    }

    public String getName() {
        return Name;
    }

    public String getID() {
        return ID;
    }

    public String getAddress() {
        return Address;
    }

    public String getCreditCard() {
        return CreditCard;
    }

    public String getPay() {
        return Pay;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }
}
