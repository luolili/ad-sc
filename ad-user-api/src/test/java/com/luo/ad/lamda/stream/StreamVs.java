package com.luo.ad.lamda.stream;

import com.luo.ad.lamda.cart.CartService;
import com.luo.ad.lamda.cart.Sku;
import com.luo.ad.lamda.cart.SkuCategoryEnum;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class StreamVs {

    @Test
    public void streamWay() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.0));
        List<String> list = cartSkuList.stream()

                //打印
                .peek(sku -> System.out.println(sku))
                .filter(sku -> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                //从大道小
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                //前2个
                .limit(2)
                //累加
                .peek(sku -> money.set(money.get() + sku.getTotalPrice()))
                .map(sku -> sku.getSkuName())
                .collect(Collectors.toList());

    }
}
