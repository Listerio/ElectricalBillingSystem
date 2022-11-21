package com.persistence.database.impl;

import com.persistence.database.BillChargingDao;
import com.persistence.entities.BillCharge;
import com.persistence.entities.Token;
import com.persistence.entities.impl.DefaultBillCharge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DefaultBillChargingDao implements BillChargingDao {

    private  String query;
    int count = (billCount() + 1);

    @Override
    public void addBill(BillCharge billCharge, Token token) throws SQLException {
        query = "insert into electrical_billing_system.`bill_charge-table`" +
                " (Bill_id, Fix_charge, Maintenance_charge, Total_charge, Total_unit) values(?,?,?,?,?)";
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, count);//automatic
            statement.setInt(2, billCharge.getFixCharge());
            statement.setInt(3, billCharge.getMaintainanceCharge());
            statement.setInt(4, billCharge.getGrandTotal());//auto
            statement.setDouble(5, billCharge.getTotalUnit());
            statement.executeUpdate();
        }
        query = "insert into electrical_billing_system.`bill_calculation`" +
                "(bill_number,amount,token) values(?,?,?)";
        try (Connection connection1 = DbUtil.getConnection();
             PreparedStatement statement = connection1.prepareStatement(query)) {
            statement.setInt(1,count);//auto
            statement.setInt(2,billCharge.getTotalCharge());
            statement.setString(3,token.getToken());
            statement.executeUpdate();
        }
    }
        @Override
    public BillCharge getBill(int id)   {
        query="select * from electrical_billing_system.`bill_charge-table` where Bill_id=?";
        BillCharge bill=new DefaultBillCharge();
            try(Connection connection=DbUtil.getConnection();
                PreparedStatement statement=connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet set = statement.executeQuery()) {
                    while (set.next()) {
                        bill.setBillId(set.getInt("Bill_id"));
                        bill.setFixCharge(set.getInt("Fix_charge"));
                        bill.setMaintainanceCharge(set.getInt("Total_charge"));
                        bill.setTotalUnit(set.getInt("Total_unit"));
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
                query = "select * from electrical_billing_system.`bill_calculation` where bill_number=?";
                try (Connection connection = DbUtil.getConnection();
                     PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, id);
                    try (ResultSet set = statement.executeQuery()) {
                        while (set.next()) {
                            bill.setBillDate(set.getString("bill_date"));
                            bill.setTotalCharge(set.getInt("amount"));
                        }
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                return bill;
    }

    private int billCount(){
        query="select count(Bill_id) from electrical_billing_system.`bill_charge-table`";
        try(Connection connection=DbUtil.getConnection();
            PreparedStatement statement=connection.prepareStatement(query)){
            try(ResultSet set=statement.executeQuery()){
                while (set.next()){
                    return set.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }


}
