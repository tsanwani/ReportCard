package com.example.codetribe.reportcard;

/**
 * Created by CodeTribe on 2017/08/01.
 */

public class Product {

    private int id;
    private String productname;
    private String surname;
    private String subjectone;
    private String subjecttwo;
    private String subjectthree;
    private int quantity;
    private int quantity2;
    private int quantity3;
    private int quantity4;


    public Product() {

    }

    public Product(int id, String productname, String surname, String subjectone, String subjecttwo, String subjectthree, int quantity, int quantity2, int quantity3, int quantity4) {
        this.id = id;
        this.productname = productname;
        this.surname = surname;
        this.subjectone = subjectone;
        this.subjecttwo = subjecttwo;
        this.subjectthree = subjectthree;
        this.quantity = quantity;
        this.quantity2 = quantity2;
        this.quantity3 = quantity3;
        this.quantity4 = quantity4;


    }

    public Product(String productname, String surname, String subjectone, String subjecttwo, String subjectthree, int quantity, int quantity2, int quantity3, int quantity4) {
        this.productname = productname;
        this.surname = surname;
        this.subjectone = subjectone;
        this.subjecttwo = subjecttwo;
        this.subjectthree = subjectthree;
        this.quantity = quantity;
        this.quantity2 = quantity2;
        this.quantity3 = quantity3;
        this.quantity4 = quantity4;


    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }


    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSubjectone() {
        return subjectone;
    }

    public void setSubjectone(String subjectone) {
        this.subjectone = subjectone;
    }

    public String getSubjecttwo() {
        return subjecttwo;
    }

    public void setSubjecttwo(String subjecttwo) {
        this.subjecttwo = subjecttwo;
    }

    public String getSubjectthree() {
        return subjectthree;
    }

    public void setSubjectthree(String subjectthree) {
        this.subjectthree = subjectthree;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(int quantity2) {
        this.quantity2 = quantity2;
    }

    public int getQuantity3() {
        return quantity3;
    }

    public void setQuantity3(int quantity3) {
        this.quantity3 = quantity3;
    }

    public int getQuantity4() {
        return quantity4;
    }

    public void setQuantity4(int quantity4) {
        this.quantity4 = quantity4;
    }
}