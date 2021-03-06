package org.qpt.receipt;

import java.math.BigDecimal;

/**
 * Created by Sora on 2016/7/5.
 */
public class Goods {

    private String barcode;
    private String name;
    private String category;
    private String SubCategory;
    private String unit;
    private BigDecimal price;

    public Goods(String barcode, String name) {
        this.barcode = barcode;
        this.name = name;
    }

    public Goods() {
    }

    public void setCategory(String category, String subcategory) {
        this.category = category;
        SubCategory = subcategory;
    }

    //fastjson required method

    public void setPrice(BigDecimal price, String unit) {
        this.unit = unit;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return SubCategory;
    }

    public void setSubCategory(String subCategory) {
        SubCategory = subCategory;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
