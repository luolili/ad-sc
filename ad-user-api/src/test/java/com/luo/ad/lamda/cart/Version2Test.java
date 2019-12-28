package com.luo.ad.lamda.cart;

import org.junit.Test;

import java.util.List;

public class Version2Test {

    @Test
    public void filterSkusByCategory() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> list = CartService.filterSkusByCategory(cartSkuList, SkuCategoryEnum.BOOKS);

    }
}
