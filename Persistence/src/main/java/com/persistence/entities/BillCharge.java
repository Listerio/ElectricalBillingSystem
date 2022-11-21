package com.persistence.entities;

public interface BillCharge {
    void setTotalUnit(double totalUnit);
    double getTotalUnit();
    int getGrandTotal();
    void setTotalCharge(int totalCharge);
    BillCharge getCharge();
    int getTotalCharge();
    void setMaintainanceCharge(int maintainanceCharge);
    int getMaintainanceCharge();
    void setFixCharge(int fixCharge);
    int getFixCharge();
    void setBillId(int billId);
    int getBillId();
    void setBillDate(String date);
    String getBillDate();
}
