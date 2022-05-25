package com.example.dacs3.Domain;

public class CategoryDomain {
 int id_cate;
 String name_cate;
    String image_cate;

    public CategoryDomain(int id_cate, String name_cate, String image_cate) {
        this.id_cate = id_cate;
        this.name_cate = name_cate;
        this.image_cate = image_cate;
    }

    public int getId_cate() {
        return id_cate;
    }

    public void setId_cate(int id_cate) {
        this.id_cate = id_cate;
    }

    public String getName_cate() {
        return name_cate;
    }

    public void setName_cate(String name_cate) {
        this.name_cate = name_cate;
    }

    public String getImage_cate() {
        return image_cate;
    }

    public void setImage_cate(String image_cate) {
        this.image_cate = image_cate;
    }
}
