package org.qpt.receipt;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sora on 2016/7/6.
 */
public class Buy3Free1OfferTest {

    private static Goods getOfferGoods() {
        Goods goods = new Goods("ITEM000001", "可口可乐");
        goods.setCategory("食品", "饮料");
        goods.setPrice(3.00f, "瓶");
        return goods;
    }

    private static Goods getNormalGoods() {
        Goods goods = new Goods("ITEM000002", "雪碧");
        goods.setCategory("食品", "饮料");
        goods.setPrice(3.00f, "瓶");
        return goods;
    }

    private static Buy3Free1Offer getOffer() {
        Buy3Free1Offer offer = new Buy3Free1Offer();
        offer.addBarcode("ITEM000001");
        offer.addBarcode("ITEM000005");
        return offer;
    }

    @Test
    public void shouldTellGoodsGetOfferOrNot() throws Exception {
        Buy3Free1Offer offer = Buy3Free1OfferTest.getOffer();

        assertTrue(offer.checkOffer(
                Buy3Free1OfferTest.getOfferGoods()));
        assertFalse(offer.checkOffer(
                Buy3Free1OfferTest.getNormalGoods()));
    }

    @Test
    public void shouldOfferItemGetRightDiscount() throws Exception {
        Buy3Free1Offer offer = Buy3Free1OfferTest.getOffer();
        Item item = new Item(Buy3Free1OfferTest.getOfferGoods());

        item.setQuantity(2);
        assertEquals(0.00f, offer.discount(item), 0.001f);

        item.setQuantity(3);
        assertEquals(3.00f, offer.discount(item), 0.001f);

        item.setQuantity(5);
        assertEquals(3.00f, offer.discount(item), 0.001f);

        item.setQuantity(6);
        assertEquals(6.00f, offer.discount(item), 0.001f);

        item.setQuantity(7);
        assertEquals(6.00f, offer.discount(item), 0.001f);
    }

    @Test
    public void shouldNormalItemGetNoDiscount() throws Exception {
        Buy3Free1Offer offer = Buy3Free1OfferTest.getOffer();
        Item item = new Item(Buy3Free1OfferTest.getNormalGoods());

        item.setQuantity(2);
        assertEquals(0.00f, offer.discount(item), 0.001f);

        item.setQuantity(3);
        assertEquals(0.00f, offer.discount(item), 0.001f);

        item.setQuantity(5);
        assertEquals(0.00f, offer.discount(item), 0.001f);

        item.setQuantity(6);
        assertEquals(0.00f, offer.discount(item), 0.001f);

        item.setQuantity(7);
        assertEquals(0.00f, offer.discount(item), 0.001f);
    }

}