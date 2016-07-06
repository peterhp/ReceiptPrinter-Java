package org.qpt.receipt;

import org.qpt.util.JsonDataParser;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by JonirRings on 2016/7/6.
 */
public class Cart {
    Hashtable<String, Goods> goodInfoTable = new Hashtable<>();
    Hashtable<String, Item> itemTable = new Hashtable<>();

    public Cart() throws IOException {
        List<Goods> list = JsonDataParser.ReadGoodsFromStream(Cart.class.getClassLoader().getResourceAsStream("goods.json"));
        for (Goods good :
                list) {
            goodInfoTable.put(good.getBarcode(), good);
        }
    }

    public int AddGoods(String mixedCode) {
        String[] strs = mixedCode.split("-");
        if (strs.length < 2) {
            throw new IllegalArgumentException("expect a string with \"-\"!");
        }
        return AddGoods(strs[0], Integer.parseInt(strs[1]));
    }

    public int AddGoods(String barcode, int quantity) throws IllegalArgumentException {
        if (itemTable.isEmpty() || !itemTable.containsKey(barcode)) {
            Goods goods = goodInfoTable.get(barcode);
            if (goods != null) {
                itemTable.put(barcode, new Item(goodInfoTable.get(barcode), quantity));
                return quantity;
            }
            throw new IllegalArgumentException("the barcode " + barcode + " does not match any goods");
        }
        Item item = itemTable.get(barcode);
        item.setQuantity(item.getQuantity() + quantity);
        return item.getQuantity();
    }

    public int ReduceGoods(String barcode, int quantity) throws IllegalArgumentException {
        if (itemTable.isEmpty() || !itemTable.containsKey(barcode)) {
            throw new IllegalArgumentException("the barcode " + barcode + " does not match any goods");
        }
        Item item = itemTable.get(barcode);
        item.setQuantity(item.getQuantity() + quantity);
        int retQuantity = item.getQuantity();
        if (item.getQuantity() <= 0)
            itemTable.remove(barcode);
        return retQuantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item :
                itemTable.values()) {
            sb.append(item.getGoods().getBarcode()).append("-").append(item.getQuantity()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
