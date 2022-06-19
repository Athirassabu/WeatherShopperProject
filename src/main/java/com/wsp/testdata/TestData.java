package com.wsp.testdata;

import com.creditdatamw.zerocell.annotation.Column;

public class TestData {

    @Column(name = "testcasename", index = 0)
    public String testCaseName;

    @Column(name = "username",index = 1)
    public String username;

    @Column(name= "password",index = 2)
    public String password;

    @Column(name="expectedtitle",index=3)
    public String expectedTitle;

    @Column(name="email",index=4)
    public String email;

    @Column(name="cardNumber",index=5)
    public String cardNumber;

    @Column(name="expiryDate",index=6)
    public String expiryDate;

    @Column(name="cvv",index=7)
    public String cvv;

    @Column(name="zip",index=8)
    public String zip;

}
