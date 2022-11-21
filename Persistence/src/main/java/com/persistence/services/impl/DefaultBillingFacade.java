package com.persistence.services.impl;

import com.persistence.Control;
import com.persistence.database.BillChargingDao;
import com.persistence.database.impl.DefaultBillChargingDao;
import com.persistence.entities.BillCharge;
import com.persistence.entities.Token;
import com.persistence.entities.User;

import java.sql.SQLException;

public class DefaultBillingFacade {

    BillChargingDao billChargingDao = new DefaultBillChargingDao();

   public void  addBill(BillCharge billCharge, Token token){
        try {
            billChargingDao.addBill(billCharge,token);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public  BillCharge getBill(int id){
        try {
            return billChargingDao.getBill(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





}
