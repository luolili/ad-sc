package com.luo.ad.lamda.cart;

import org.junit.Test;

import java.util.List;

public class Version3Test {

    @Test
    public void filterSkusByCategory() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> list = CartService.filterSkus(cartSkuList, new SkuTotalPricePredicate());

    }

    @Test
    public void filterSkus2() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> list = CartService.filterSkus(cartSkuList, new SkuPredicate() {
            @Override
            public boolean test(Sku sku) {
                return sku.getTotalPrice() > 300;
            }
        });

    }


    @Test
    public void filterSkus3() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> list = CartService.filterSkus(cartSkuList, (Sku sku) ->
                sku.getSkuPrice() > 300
        );

    }

}
