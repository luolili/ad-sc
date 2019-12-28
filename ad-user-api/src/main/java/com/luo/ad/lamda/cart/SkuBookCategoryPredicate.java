package com.luo.ad.lamda.cart;

//判断逻辑参数化
public class SkuBookCategoryPredicate implements SkuPredicate {
    @Override
    public boolean test(Sku sku) {
        return SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory());
    }
}
