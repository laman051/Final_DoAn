package com.example.dacs3.Domain;

import java.util.List;

public class CategoryModel {
    boolean success;
    String message;
    List<CategoryDomain>listcategory;

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

    public List<CategoryDomain> getListcategory() {
        return listcategory;
    }

    public void setListcategory(List<CategoryDomain> listcategory) {
        this.listcategory = listcategory;
    }
}
