package com.luo.ad.lamda.stream;

import com.luo.ad.lamda.cart.CartService;
import com.luo.ad.lamda.cart.Sku;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamColl {
    private List<Sku> list;

    @Before
    public void init() {
        list = CartService.getCartSkuList();
    }

    @Test
    public void toList() {
        list.stream().filter(sku -> sku.getTotalPrice() > 300)
                .collect(Collectors.toList());
    }

    @Test
    public void group() {
        Map<Enum, List<Sku>> collect = list.stream()
                .collect(Collectors.groupingBy(sku -> sku.getSkuCategory()));
    }

    @Test
    public void partition() throws Exception {

        Map<Boolean, List<Sku>> collect = list.stream()
                .collect(Collectors.partitioningBy(sku -> sku.getTotalPrice() > 300));
    }

    //无限流
    @Test
    public void byFunc() throws Exception {
        //Stream<Integer> stream = Stream.iterate(0, n -> n + 2);
        Stream<Double> stream = Stream.generate(Math::random);
        stream.forEach(System.out::println);
    }
}
