package org.qpt.receipt;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sora on 2016/7/6.
 */
public class Buy3Free1Offer {

    Set<String> barcodeSet = new HashSet<>();

    public void addBarcode(String barcode) {
        barcodeSet.add(barcode);
    }

    public boolean checkOffer(Goods goods) {
        return barcodeSet.contains(goods.getBarcode());
    }

    public float discount(Item item) {
        float save = 0.0f;

        if (this.checkOffer(item.getGoods())) {
            save = item.getGoods().getPrice() *
                    (item.getQuantity() / 3);
        }

        return save;
    }
}
