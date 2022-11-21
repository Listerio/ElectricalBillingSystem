package com.persistence.services.impl;


import com.persistence.entities.Appliance;
import com.persistence.entities.User;

import com.persistence.services.ApplianceService;

import java.util.List;

public class DefaultBillChargingManagement  {

    User user;
    private  static DefaultBillChargingManagement instance;
    private final int DAYS_PER_MONTH=30;
    private final double KILO_WATT_CONVERTER=1000.0;
    private final double MULTIPLIER=DAYS_PER_MONTH/KILO_WATT_CONVERTER;
    private int wattageOfAppliance;
    private int numberOfAppliance;
    private double numberOfHrsUsedDaily;
    private ApplianceService service;
    List<Appliance> appliances;
    double maintainance;
    {
        service=new DefaultApplianceService();
    }
    public DefaultBillChargingManagement(){

    }
    public static DefaultBillChargingManagement getInstance() {
        if(instance==null){
        instance=new DefaultBillChargingManagement();
        }
        return instance;
    }
    private double getTotalWattsPerMonth(){
        appliances= service.getAppliancePerUserId(user.getConsumerId());
        double total=0;
        for (Appliance a:appliances) {
            wattageOfAppliance=a.getAppliancePower();
            numberOfAppliance=a.getNumberOfAppliances();
            numberOfHrsUsedDaily=a.getTimeUsed();
            total+=formulaeKWH_m(wattageOfAppliance,numberOfAppliance,numberOfHrsUsedDaily);
        }
        return total;
    }
    private double formulaeKWH_m(int wattageOfAppliance,int numberOfAppliance,double numberOfHrsUsedDaily){
        double init=wattageOfAppliance*numberOfAppliance*numberOfHrsUsedDaily;
        return init*MULTIPLIER;
    }
    private double totalBillingPrice(){
       return getTotal_K_W_H_perMonth()*10;
    }

    public double getTotal_K_W_H_perMonth() {
        return getTotalWattsPerMonth();
    }

    public double getTotalBillingCharge() {
        return totalBillingPrice();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
