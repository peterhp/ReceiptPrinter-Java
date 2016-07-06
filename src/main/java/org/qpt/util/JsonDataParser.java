package org.qpt.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.qpt.receipt.Goods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JonirRings on 2016/7/6.
 */
public class JsonDataParser {

    public static List<Goods> ReadGoodsFromStream(InputStream in)
            throws IOException {
        ArrayList<Goods> retArray = new ArrayList<>();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(in, "UTF-8"));
        StringBuilder sb = new StringBuilder();

        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
            sb.append(sCurrentLine);
        }

        JSONArray ja = JSON.parseArray(sb.toString());
        for (Object o : ja) {
            Goods goods = JSON.parseObject(o.toString(), Goods.class);
            retArray.add(goods);
        }

        return retArray;
    }

}
