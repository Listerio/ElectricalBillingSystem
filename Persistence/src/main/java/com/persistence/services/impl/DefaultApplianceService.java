package com.persistence.services.impl;

import com.persistence.database.ApplianceDao;
import com.persistence.database.impl.DefaultApplianceDao;
import com.persistence.entities.Appliance;
import com.persistence.entities.User;
import com.persistence.services.ApplianceService;

import java.sql.SQLException;
import java.util.List;

public class DefaultApplianceService implements ApplianceService {
    ApplianceDao service=new DefaultApplianceDao();


    @Override
    public void registerAppliance(User user, List<Appliance> appliances)  {
        try {
            service.registerAppliance(user, appliances);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void registerAppliance(User user, Appliance appliance)  {
        try {
            service.registerAppliance(user, appliance);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Appliance retrieveAppliance(User user, String applianceName) {
        try {
            return service.retrieveAppliance(user, applianceName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editAppliance(User user,Appliance applianceOld, Appliance appliance)  {
        try {
            service.editAppliance(user,applianceOld ,appliance);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAppliance(User user, Appliance appliance)  {
        try {
            service.deleteAppliance(user,appliance);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Appliance> getAppliancePerUserId(int userId) {
        try {
            return service.getAppliancePerUserId(userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
