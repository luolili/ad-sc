package com.luo.ad.lamda.cart;

import org.junit.Test;

import java.util.List;

public class Version1Test {

    @Test
    public void filterElectronList() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> list = CartService.filterElectronList(cartSkuList);

    }
}
