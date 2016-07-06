package org.qpt.receipt;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sora on 2016/7/5.
 */
public class GoodsTest {

    private static final String BARCODE     = "ITEM000001";
    private static final String NAME        = "�ɿڿ���";
    private static final String UNIT        = "ƿ";
    private static final String CATEGORY    = "ʳƷ";
    private static final String SUBCATEGORY = "̼������";
    private static final float  PRICE        = 3.00f;

    @Test
    public void shouldStoreGoodsInfoOK() throws Exception {
        Goods goods = new Goods(BARCODE, NAME);
        goods.setCategory(CATEGORY, SUBCATEGORY);
        goods.setPrice(PRICE, UNIT);

        assertNotNull(goods);

        assertEquals(BARCODE,       goods.getBarcode());
        assertEquals(NAME,          goods.getName());
        assertEquals(CATEGORY,      goods.getCategory());
        assertEquals(SUBCATEGORY,   goods.getSubCategory());
        assertEquals(UNIT,          goods.getUnit());
        assertEquals(PRICE,         goods.getPrice());
    }
}