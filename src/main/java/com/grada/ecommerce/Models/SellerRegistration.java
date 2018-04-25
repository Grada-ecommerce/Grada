/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grada.ecommerce.Models;

/**
 *
 * @author Rishabh Gupta
 */
public class SellerRegistration {
    
   private String username;
   private String password;
   private String name;
   private String email;
   private int adhaarno;
   private String addressproofid;
   private String panno;
   private String gstno;
   private boolean isIndividual;
   private int bankaccountno;
   private String bankaccountname;
   private String bankifsccode;

    public String getAddressproofid() {
        return addressproofid;
    }

    public void setAddressproofid(String addressproofid) {
        this.addressproofid = addressproofid;
    }

    public String getGstno() {
        return gstno;
    }

    public void setGstno(String gstno) {
        this.gstno = gstno;
    }

    public boolean isIsIndividual() {
        return isIndividual;
    }

    public void setIsIndividual(boolean isIndividual) {
        this.isIndividual = isIndividual;
    }

    public int getBankaccountno() {
        return bankaccountno;
    }

    public void setBankaccountno(int bankaccountno) {
        this.bankaccountno = bankaccountno;
    }

    public String getBankaccountname() {
        return bankaccountname;
    }

    public void setBankaccountname(String bankaccountname) {
        this.bankaccountname = bankaccountname;
    }

    public String getBankifsccode() {
        return bankifsccode;
    }

    public void setBankifsccode(String bankifsccode) {
        this.bankifsccode = bankifsccode;
    }
   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAdhaarno() {
        return adhaarno;
    }

    public void setAdhaarno(int adhaarno) {
        this.adhaarno = adhaarno;
    }

    public String getPanno() {
        return panno;
    }

    public void setPanno(String panno) {
        this.panno = panno;
    }
   
   
   
   
}
