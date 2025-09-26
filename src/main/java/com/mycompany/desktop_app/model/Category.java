/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.desktop_app.model;

/**
 * Category entity class
 * 
 * 
 * @author ltd9605
 */
public class Category {
    private int categoryId;
    private String categoryName;

    // Constructor
    public Category() {
    }

    public Category(int id, String name) {
        this.categoryId = id;
        this.categoryName = name;
    }

    // GETTER
    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    // SETTER
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryId=" + categoryId + ", categoryName=" + categoryName + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Category other = (Category) obj;
        return categoryId == other.categoryId &&
                (categoryName != null ? categoryName.equals(other.categoryName) : other.categoryName == null);
    }
}
