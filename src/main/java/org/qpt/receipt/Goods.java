package org.qpt.receipt;

/**
 * Created by Sora on 2016/7/5.
 */
public class Goods {

    private String m_strBarcode;
    private String m_strName;
    private String m_strCategory;
    private String m_strSubCategory;
    private String m_strUnit;
    private float  m_fPrice;

    public Goods(String barcode, String name) {
        m_strBarcode = barcode;
        m_strName = name;
    }

    public String getBarcode() {
        return m_strBarcode;
    }

    public String getName() {
        return m_strName;
    }

    public void setCategory(String category, String subcategory) {
        m_strCategory = category;
        m_strSubCategory = subcategory;
    }

    public String getCategory() {
        return m_strCategory;
    }

    public String getSubCategory() {
        return m_strSubCategory;
    }

    public void setPrice(float price, String unit) {
        m_strUnit = unit;
        m_fPrice = price;
    }

    public String getUnit() {
        return m_strUnit;
    }

    public float getPrice() {
        return m_fPrice;
    }
}
