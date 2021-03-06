package org.qpt.receipt;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sora on 2016/7/6.
 */
public class ItemTest {

    private static Goods getGoods() {
        Goods goods = new Goods("ITEM000001", "可口可乐");
        goods.setCategory("食品", "饮料");
        goods.setPrice(BigDecimal.valueOf(3.00), "瓶");
        return goods;
    }

    @Test
    public void shouldStoreRightQuantity() throws Exception {
        Item item = new Item(ItemTest.getGoods());
        assertEquals(0, item.getQuantity());

        item.add(1);
        assertEquals(1, item.getQuantity());

        item.setQuantity(3);
        assertEquals(3, item.getQuantity());

        item.add(2);
        assertEquals(5, item.getQuantity());

        item.remove(3);
        assertEquals(2, item.getQuantity());

        item = new Item(ItemTest.getGoods(), 2);
        assertEquals(2, item.getQuantity());
    }

}