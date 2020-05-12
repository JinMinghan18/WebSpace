package bank.com.model;

import sun.security.util.Password;

public class Customer {
    private String email;
    private Password password;
    private String custName;
    private String phone;

    public Customer(){}
    public Customer(String email,String custName,String phone){
        this.email = email;
        this.custName = custName;
        this.phone = phone;
    }

    public String getEmail(){
        return email;
    }
    public Password getPassword(){
        return password;
    }
    public String getCustName(){
        return custName;
    }
    public String getPhone(){
        return phone;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
