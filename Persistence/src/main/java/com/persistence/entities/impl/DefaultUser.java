package com.persistence.entities.impl;

import com.persistence.entities.User;

public class DefaultUser implements User {

    private int customerId;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String contactAddress;

    public DefaultUser() {
    }

    public DefaultUser(String firstName, String lastName, String userName,
                       String email, String password, String contactAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.contactAddress = contactAddress;
    }

    public DefaultUser(int customerId, String firstName, String lastName, String userName, String email, String password, String contactAddress) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.contactAddress = contactAddress;
    }

    @Override
    public int getConsumerId() {
        return customerId;
    }

    @Override
    public void setConsumerId(int consumerId) {
        this.customerId=consumerId;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName=userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password=password;
    }

    @Override
    public String getEmailAdress() {
        return email;
    }

    @Override
    public void setEmailAddress(String emailAddress) {
        this.email=emailAddress;
    }

    @Override
    public String getContactAddress() {
        return contactAddress;
    }

    @Override
    public void setContactAddress(String customerAddress) {
        this.contactAddress=customerAddress;
    }
}
