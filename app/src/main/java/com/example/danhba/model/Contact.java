package com.example.danhba.model;

public class Contact {

    private String mName;
    private String mNumberPhone;
    private boolean isMale;

    public Contact(String mName, String mNumberPhone, boolean isMale) {

        this.mName = mName;
        this.mNumberPhone = mNumberPhone;
        this.isMale = isMale;
    }

    public Contact(String mName, String mNumberPhone) {
        this.mName = mName;
        this.mNumberPhone = mNumberPhone;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmNumberPhone() {
        return mNumberPhone;
    }

    public void setmNumberPhone(String mNumberPhone) {
        this.mNumberPhone = mNumberPhone;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}

