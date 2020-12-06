package com.edu.zjut.po;

import java.sql.Date;
import java.util.Objects;

public class Customer {
    private int customerId;
    private String account;
    private String password;
    private String name;
    private Boolean sex;
    private Date birthday;
    private String phone;
    private String email;
    private String address;
    private String zipcode;
    private String fax;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId &&
                Objects.equals(account, customer.account) &&
                Objects.equals(password, customer.password) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(sex, customer.sex) &&
                Objects.equals(birthday, customer.birthday) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(address, customer.address) &&
                Objects.equals(zipcode, customer.zipcode) &&
                Objects.equals(fax, customer.fax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, account, password, name, sex, birthday, phone, email, address, zipcode, fax);
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
