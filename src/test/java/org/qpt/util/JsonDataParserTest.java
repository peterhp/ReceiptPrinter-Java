package org.qpt.util;

import org.junit.Test;
import org.qpt.receipt.Cart;
import org.qpt.receipt.Goods;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by JonirRings on 2016/7/6.
 * Updated by Sora on 2016/7/7.
 */
public class JsonDataParserTest {


    private static final String JSON_GOODS = "goods.json";
    private static final String JSON_CART = "cart.json";

    private static InputStream getJsonStream(String strFile) {
        return JsonDataParserTest.class.getClassLoader()
                .getResourceAsStream(strFile);
    }

    private static Goods getTrueGoodsInJson() {
        Goods goods = new Goods("ITEM000003", "苹果");
        goods.setCategory("食品", "水果");
        goods.setPrice(BigDecimal.valueOf(5.50), "斤");

        return goods;
    }

    @Test
    public void shouldReadGoodsFromJsonFileOk() throws Exception {
        InputStream in = JsonDataParserTest.getJsonStream(JSON_GOODS);
        List<Goods> goodsList = JsonDataParser.ReadGoodsFromStream(in);

        assertEquals(goodsList.size(), 6);

        Goods testGoods = JsonDataParserTest.getTrueGoodsInJson();
        for (Goods goods : goodsList) {
            if (goods.getBarcode().equals(testGoods.getBarcode())) {
                assertEquals(testGoods.getName(), goods.getName());
                assertEquals(testGoods.getCategory(), goods.getCategory());
                assertEquals(testGoods.getSubCategory(), goods.getSubCategory());
                assertEquals(testGoods.getUnit(), goods.getUnit());
                assertThat(testGoods.getPrice().compareTo(goods.getPrice()), is(0));
            }
        }
    }

    @Test
    public void readCartFromStream() throws Exception {
        InputStream in = JsonDataParserTest.getJsonStream(JSON_CART);
        Cart cart = new Cart();
        JsonDataParser.ReadCartFromStream(in, cart);
        assertEquals(cart.QueryQuantity("ITEM000001"), 3);
        assertEquals(cart.QueryQuantity("ITEM000003"), 2);
        assertEquals(cart.QueryQuantity("ITEM000005"), 5);
    }
}