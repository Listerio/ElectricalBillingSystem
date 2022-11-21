package com.persistence.entities.impl;

import com.persistence.entities.BillCharge;

public class DefaultBillCharge implements BillCharge {

    private int billId;
    private int fixCharge;
    private int maintainanceCharge;
    private int totalCharge;
    private double totalUnit;
    BillCharge charge;
    String billDate;
    public DefaultBillCharge() {
    }

    public DefaultBillCharge(int billId, int fixCharge, int maintainanceCharge, int totalCharge, int totalUnit) {
        this.billId = billId;
        this.fixCharge = fixCharge;
        this.maintainanceCharge = maintainanceCharge;
        this.totalCharge = totalCharge;
        this.totalUnit = totalUnit;

    }
    public BillCharge getCharge() {
        charge= new DefaultBillCharge();
        charge.setFixCharge(fixCharge);
        charge.setMaintainanceCharge(maintainanceCharge);
        charge.setTotalCharge(totalCharge);
        charge.setTotalUnit(totalUnit);
        return charge;
    }
    public int getBillId() {
        return billId;
    }
    @Override
    public void setBillDate(String date) {
        billDate=date;
    }
    @Override
    public String getBillDate() {
        return billDate;
    }
    public void setBillId(int billId) {
        this.billId = billId;
    }
    public int getFixCharge() {
        return fixCharge;
    }
    public void setFixCharge(int fixCharge) {
        this.fixCharge = fixCharge;
    }
    public int getMaintainanceCharge() {
        return maintainanceCharge;
    }
    public void setMaintainanceCharge(int maintainanceCharge) {
        this.maintainanceCharge = maintainanceCharge;
    }
    public  double getTotalUnit() {
        return totalUnit;
    }
    @Override
    public int getGrandTotal() {
        return maintainanceCharge+totalCharge+fixCharge;
    }
    public int getTotalCharge() {
        return totalCharge;
    }
    public void setTotalCharge(int totalCharge) {
        this.totalCharge = totalCharge;
    }
    public void setTotalUnit(double  totalUnit) {
        this.totalUnit = totalUnit;
    }
}

