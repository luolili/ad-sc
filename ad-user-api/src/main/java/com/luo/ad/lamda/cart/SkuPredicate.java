package com.luo.ad.lamda.cart;

/**
 * 策略接口
 */
public interface SkuPredicate {
    boolean test(Sku sku);
}
