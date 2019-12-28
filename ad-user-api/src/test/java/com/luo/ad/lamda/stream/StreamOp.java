package com.luo.ad.lamda.stream;

import com.luo.ad.lamda.cart.CartService;
import com.luo.ad.lamda.cart.Sku;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamOp {

    private List<Sku> list;

    @Before
    public void init() {
        list = CartService.getCartSkuList();
    }

    //中间操作
    @Test
    public void filter() {
        list.stream()
                .filter(sku -> sku.getTotalPrice() > 1000)
                .forEach(System.out::println);
    }

    @Test
    public void map() {
        list.stream()
                .map(sku -> sku.getSkuName())
                .forEach(System.out::println);
    }

    @Test
    public void flatMap() {
        list.stream()
                //返回值是 steam
                .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(System.out::println);
    }

    @Test
    public void peek() {
        list.stream()
                //返回值是 steam
                .peek(sku -> System.out.println(sku));//中间操作
    }

    @Test
    public void sort() {
        list.stream()
                //返回值是 steam
                .sorted(Comparator.comparing(sku -> sku.getTotalPrice()))
                .forEach(System.out::println);
    }

    @Test
    public void dist() {
        list.stream()
                //返回值是 steam
                .map(sku -> sku.getSkuCategory())
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void page() {
        list.stream()
                //返回值是 steam
                .skip(2 * 3)
                .limit(3)
                .forEach(System.out::println);
    }

    //terminal操作
    @Test
    public void allMatch() {
        list.stream()
                //返回值是 steam
                .allMatch(sku -> sku.getTotalPrice() > 300);


    }

}
