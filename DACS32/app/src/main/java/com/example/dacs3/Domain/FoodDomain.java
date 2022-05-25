package com.example.dacs3.Domain;

import java.io.Serializable;

public class FoodDomain implements Serializable {
    int id_food;
    String name_food;
  String image_food;
  String description_food;
   String price_food;
   String imgAdd_food;
   int star_food;
    int time_food;
    int calories_food;
    int numberInCart;

    public FoodDomain(int id_food, String name_food, String image_food, String description_food, String price_food, int star_food, int time_food, int calories_food, int numberInCart, String imgAdd_food) {
        this.id_food = id_food;
        this.name_food = name_food;
        this.image_food = image_food;
        this.description_food = description_food;
        this.price_food = price_food;
        this.star_food = star_food;
        this.time_food = time_food;
        this.calories_food = calories_food;
        this.numberInCart = numberInCart;
        this.imgAdd_food = imgAdd_food;
    }

    public static boolean get(int position) {
        return false;
    }

    public int getId_food() {
        return id_food;
    }

    public void setId_food(int id_food) {
        this.id_food = id_food;
    }

    public String getName_food() {
        return name_food;
    }

    public void setName_food(String name_food) {
        this.name_food = name_food;
    }

    public String getImage_food() {
        return image_food;
    }

    public void setImage_food(String image_food) {
        this.image_food = image_food;
    }

    public String getDescription_food() {
        return description_food;
    }

    public void setDescription_food(String description_food) {
        this.description_food = description_food;
    }

    public String getPrice_food() {
        return price_food;
    }

    public void setPrice_food(String price_food) {
        this.price_food = price_food;
    }

    public int getStar_food() {
        return star_food;
    }

    public void setStar_food(int star_food) {
        this.star_food = star_food;
    }

    public int getTime_food() {
        return time_food;
    }

    public void setTime_food(int time_food) {
        this.time_food = time_food;
    }

    public int getCalories_food() {
        return calories_food;
    }

    public void setCalories_food(int calories_food) {
        this.calories_food = calories_food;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public String getImgAdd_food() {
        return imgAdd_food;
    }

    public void setImgAdd_food(String imgAdd_food) {
        this.imgAdd_food = imgAdd_food;
    }
}
