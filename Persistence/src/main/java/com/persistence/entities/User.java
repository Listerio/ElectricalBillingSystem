package com.persistence.entities;

public interface User {

    int getConsumerId();
    void  setConsumerId(int consumerId);

    String getFirstName();
    void  setFirstName(String firstName);

    String getLastName();
    void  setLastName(String lastName);

    String getUserName();
    void  setUserName(String userName);

    String getPassword();
    void  setPassword(String password);

    String getEmailAdress();
    void  setEmailAddress(String emailAddress);

    String getContactAddress();
    void  setContactAddress(String contactAddress);

}
