package org.qpt.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.qpt.receipt.Cart;
import org.qpt.receipt.Goods;
import org.qpt.receipt.Offer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by JonirRings on 2016/7/6.
 */
public class JsonDataParser {

    public static List<Goods> ReadGoodsFromStream(InputStream in)
            throws IOException {
        StringBuilder sb = getStringBuilderFromJSON(in);
        return JSONArray.parseArray(sb.toString(), Goods.class);
    }

    public static void ReadCartFromStream(InputStream in, Cart cart) throws IOException {
        StringBuilder sb = getStringBuilderFromJSON(in);
        JSONArray ja = JSON.parseArray(sb.toString());
        for (Object o :
                ja) {
            cart.AddGoods(o.toString());
        }
    }

    public static List<Offer> ReadOfferFromStream(InputStream in) throws IOException {
        StringBuilder sb = getStringBuilderFromJSON(in);
        return JSONArray.parseArray(sb.toString(), Offer.class);
    }

    private static StringBuilder getStringBuilderFromJSON(InputStream in) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(in, "UTF-8"));
        StringBuilder sb = new StringBuilder();

        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
            sb.append(sCurrentLine);
        }
        return sb;
    }
}
