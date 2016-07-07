package org.qpt.receipt;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sora on 2016/7/6.
 */
public class Buy3Free1Offer extends Offer {

    Set<String> barcodeSet = new HashSet<>();

    public void addBarcode(String barcode) {
        barcodeSet.add(barcode);
    }

    public boolean checkOffer(Goods goods) {
        return barcodeSet.contains(goods.getBarcode());
    }

    public BigDecimal discount(Item item) {
        BigDecimal save = BigDecimal.valueOf(0.00);

        if (this.checkOffer(item.getGoods())) {
            save = item.getGoods().getPrice().multiply(new BigDecimal(item.getQuantity() / 3));
        }

        return save;
    }

}
