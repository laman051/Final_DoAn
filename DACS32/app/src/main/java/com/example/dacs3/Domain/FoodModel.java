package com.example.dacs3.Domain;

import java.util.List;

public class FoodModel {
    boolean success;
    String message;
    List<FoodDomain> listfood;
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FoodDomain> getListfood() {
        return listfood;
    }

    public void setListfood(List<FoodDomain> listfood) {
        this.listfood = listfood;
    }
}
