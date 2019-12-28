package com.luo.ad.lamda.cart;

import java.util.ArrayList;
import java.util.List;

public class CartService {

    private static List<Sku> cartSkuList = new ArrayList<Sku>() {
        {
            add(new Sku(654032, "无人机", 4999.00, 1, 4999.00, SkuCategoryEnum.ELECTRONICS));
            add(new Sku(642934, "VR一体机", 2299.00, 1, 2299.00, SkuCategoryEnum.ELECTRONICS));
            add(new Sku(643321, "村色衬衫", 409.00, 1, 1227.00, SkuCategoryEnum.CLOTHING));
            add(new Sku(642234, "牛仔裤", 528.00, 1, 528.00, SkuCategoryEnum.CLOTHING));
            add(new Sku(612934, "运动裤", 200.00, 1, 200.00, SkuCategoryEnum.SPORTS));
            add(new Sku(649934, "java", 11.00, 1, 11.00, SkuCategoryEnum.BOOKS));
            add(new Sku(647734, "c", 102.00, 1, 102.00, SkuCategoryEnum.BOOKS));

        }

    };

    public static List<Sku> getCartSkuList() {
        return cartSkuList;
    }

    /**
     * v1
     */
    public static List<Sku> filterElectronList(List<Sku> skuList) {
        List<Sku> result = new ArrayList<>();
        for (Sku sku : skuList) {
            if (SkuCategoryEnum.ELECTRONICS.equals(sku.getSkuCategory())) {
                result.add(sku);
            }
        }
        return result;
    }

    /**
     * v2：判断条件参数化
     */
    public static List<Sku> filterSkusByCategory(List<Sku> skuList, SkuCategoryEnum categoryEnum) {

        List<Sku> result = new ArrayList<>();
        for (Sku sku : skuList) {
            if (categoryEnum.equals(sku.getSkuCategory())) {
                result.add(sku);
            }
        }
        return result;

    }

    /**
     * 策略模式
     *
     * @param skuPredicate
     * @return
     */
    public static List<Sku> filterSkus(List<Sku> skuList, SkuPredicate skuPredicate) {

        List<Sku> result = new ArrayList<>();
        for (Sku sku : skuList) {
            if (skuPredicate.test(sku)) {
                result.add(sku);
            }
        }
        return result;

    }

}
