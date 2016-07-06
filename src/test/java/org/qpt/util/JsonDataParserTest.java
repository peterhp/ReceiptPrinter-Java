package org.qpt.util;

import org.junit.Test;
import org.qpt.receipt.Goods;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by JonirRings on 2016/7/6.
 * Updated by Sora on 2016/7/7.
 */
public class JsonDataParserTest {

    private static final String JSON_GOODS = "goods.json";

    private static InputStream getJsonStream(String strFile) {
        return JsonDataParserTest.class.getClassLoader()
                .getResourceAsStream(strFile);
    }

    private static Goods getTrueGoodsInJson() {
        Goods goods = new Goods("ITEM000003", "苹果");
        goods.setCategory("食品", "水果");
        goods.setPrice(5.50f, "斤");

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
                assertEquals(testGoods.getPrice(), goods.getPrice(), 0.001f);
            }
        }
    }

}