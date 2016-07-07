package org.qpt.receipt;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Sora on 2016/7/6.
 */
public class Buy3Free1OfferTest {

    private static Goods getOfferGoods() {
        Goods goods = new Goods("ITEM000001", "可口可乐");
        goods.setCategory("食品", "饮料");
        goods.setPrice(BigDecimal.valueOf(3.00), "瓶");
        return goods;
    }

    private static Goods getNormalGoods() {
        Goods goods = new Goods("ITEM000002", "雪碧");
        goods.setCategory("食品", "饮料");
        goods.setPrice(BigDecimal.valueOf(3.00), "瓶");
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
        assertThat(BigDecimal.valueOf(0.00).compareTo(
                offer.discount(item)), is(0));

        item.setQuantity(3);
        assertThat(BigDecimal.valueOf(3.00).compareTo(
                offer.discount(item)), is(0));

        item.setQuantity(5);
        assertThat(BigDecimal.valueOf(3.00).compareTo(
                offer.discount(item)), is(0));

        item.setQuantity(6);
        assertThat(BigDecimal.valueOf(6.00).compareTo(
                offer.discount(item)), is(0));

        item.setQuantity(7);
        assertThat(BigDecimal.valueOf(6.00).compareTo(
                offer.discount(item)), is(0));
    }

    @Test
    public void shouldNormalItemGetNoDiscount() throws Exception {
        Buy3Free1Offer offer = Buy3Free1OfferTest.getOffer();
        Item item = new Item(Buy3Free1OfferTest.getNormalGoods());

        item.setQuantity(2);
        assertThat(BigDecimal.valueOf(0.00).compareTo(
                offer.discount(item)), is(0));

        item.setQuantity(3);
        assertThat(BigDecimal.valueOf(0.00).compareTo(
                offer.discount(item)), is(0));

        item.setQuantity(5);
        assertThat(BigDecimal.valueOf(0.00).compareTo(
                offer.discount(item)), is(0));

        item.setQuantity(6);
        assertThat(BigDecimal.valueOf(0.00).compareTo(
                offer.discount(item)), is(0));

        item.setQuantity(7);
        assertThat(BigDecimal.valueOf(0.00).compareTo(
                offer.discount(item)), is(0));
    }

}