package com.persistence.database;

import com.persistence.entities.BillCharge;
import com.persistence.entities.Token;

import java.sql.SQLException;

public interface BillChargingDao {

        void addBill(BillCharge billCharge, Token token) throws SQLException;
        BillCharge getBill(int id) throws SQLException;

}
