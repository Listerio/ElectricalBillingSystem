package com.persistence.entities.impl;

import com.persistence.entities.Appliance;

import java.util.List;

public class DefaultAppliance implements Appliance {
    String applianceName;
    int powerInWatts;
    int howMany;
    double hrs;
    List<Appliance> appliances;


    public DefaultAppliance() {
    }

    public DefaultAppliance(List<Appliance> appliances) {
        this.appliances = appliances;
    }

    public DefaultAppliance(String applianceName, int powerInWatts, int howMany, double hrs) {
        this.applianceName = applianceName;
        this.powerInWatts = powerInWatts;
        this.howMany = howMany;
        this.hrs = hrs;
    }

    @Override
    public void setApplianceName(String name) {
        this.applianceName=name;
    }

    @Override
    public void setAppliancePower(int powerInWatts) {
        this.powerInWatts=powerInWatts;
    }

    @Override
    public String getApplianceName() {
        return applianceName;
    }

    @Override
    public int getAppliancePower() {
        return powerInWatts;
    }

    @Override
    public void setNumberOfAppliance(int howMany) {
        this.howMany=howMany;
    }
    public void  addToAppliances(Appliance appliance){
        appliances.add(this);
    }
    @Override
    public void setTimeUsed(double hrs) {
        this.hrs=hrs;
    }

    @Override
    public int getNumberOfAppliances() {
        return howMany;
    }

    @Override
    public double getTimeUsed() {
        return hrs;
    }

    @Override
    public List<Appliance> getAllAppliance() {
        return appliances;
    }

    @Override
    public void setAllAppliance(List<Appliance> allAppliance) {
        this.appliances=allAppliance;
    }

}
