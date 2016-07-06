package org.qpt.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.qpt.receipt.Goods;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by JonirRings on 2016/7/6.
 */
public class parserJson {
    static List<Goods> ReadFromFile(File file) throws IOException {
        ArrayList<Goods> retArray=new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
            sb.append(sCurrentLine);
        }
        JSONArray ja = JSON.parseArray(sb.toString());
        for (Object o:
             ja) {
            Goods goods = JSON.parseObject(o.toString(),Goods.class);
            retArray.add(goods);
        }
        return retArray;
    }
}
