package org.qpt.util;

import org.junit.Test;
import org.qpt.receipt.Goods;

import java.io.InputStream;
import java.util.List;

/**
 * Created by JonirRings on 2016/7/6.
 */
public class parserJsonTest {
    private static void printGood(Goods good) {
        System.out.println("BARCODE     " + good.getBarcode());
        System.out.println("NAME        " + good.getName());
        System.out.println("UNIT        " + good.getUnit());
        System.out.println("CATEGORY    " + good.getCategory());
        System.out.println("SUBCATEGORY " + good.getSubCategory());
        System.out.println("PRICE       " + good.getPrice());
        System.out.println("*********************************");
    }

    @Test
    public void readFromFile() throws Exception {
        InputStream in = parserJsonTest.class.getClassLoader().getResourceAsStream("goods.json");
        List<Goods> list = parserJson.ReadFromStream(in);
        list.stream().forEach(parserJsonTest::printGood);
    }

}