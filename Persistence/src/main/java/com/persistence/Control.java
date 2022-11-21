package com.persistence;

import com.persistence.entities.Appliance;
import com.persistence.entities.BillCharge;
import com.persistence.entities.Token;
import com.persistence.entities.User;
import com.persistence.entities.impl.DefaultToken;

public class Control {

    private static Control instance;
    private User loggedInUser;
    private Appliance appliance;
    private BillCharge billCharge;
    private static Token token;

    public static Control getInstance() {
        if(instance==null){
            instance=new Control();
        }
        return instance;
    }
    public void setLoggedInUser(User user){
        this.loggedInUser=user;
    }
    public User getLoggedInUser(){
        return loggedInUser;
    }

    public void setAppliance(Appliance appliance) {
        this.appliance = appliance;
    }

    public Appliance getAppliance() {
        return appliance;
    }

    public BillCharge getBillCharge() {
        return billCharge;
    }

    public void setBillCharge(BillCharge billCharge) {
        this.billCharge = billCharge;
    }
    public  static Token getToken(){
        if (token==null){
            token=new DefaultToken();
        }
        return token;
    }
}
