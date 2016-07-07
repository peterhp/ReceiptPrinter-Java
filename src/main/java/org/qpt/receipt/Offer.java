package org.qpt.receipt;

import java.util.List;

/**
 * Created by JonirRings on 2016/7/7.
 */
public class Offer {
    String type;
    List<String> barcodes;

    public Offer() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getBarcodes() {
        return barcodes;
    }

    public void setBarcodes(List<String> barcodes) {
        this.barcodes = barcodes;
    }
}
