package com.model;

import java.io.Serializable;

public class Customer  implements Serializable {
    private String cust_id;
    private String cname;
    private String email;
    private double balance;

    public String getCname() {
        return cname;
    }

    public String getCust_id() {
        return cust_id;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }
}
