package org.qpt.receipt;

/**
 * Created by Sora on 2016/7/6.
 */
public class Item {

    private Goods goods = null;
    private int quantity = 0;

    public Item(Goods goods) {
        this.goods = goods;
    }

    public Item(Goods goods, int quantity) {
        this.goods = goods;
        this.quantity = quantity;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void add(int count) {
        this.quantity += count;
    }

    public void remove(int count) {
        this.quantity -= count;
    }
}
