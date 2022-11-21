package com.persistence.entities;

import java.util.List;

public interface Appliance {
    void  addToAppliances(Appliance appliance);
    void setApplianceName(String name);
    void setAppliancePower(int powerInWatts);
    String getApplianceName();
    int  getAppliancePower();
    void setNumberOfAppliance(int howMany);
    void setTimeUsed(double hrs);
    int getNumberOfAppliances();
    double getTimeUsed();
    List<Appliance> getAllAppliance();
    void setAllAppliance(List<Appliance> allAppliance);


}
