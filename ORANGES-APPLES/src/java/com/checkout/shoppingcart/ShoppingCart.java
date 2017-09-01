package com.checkout.shoppingcart;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public class ShoppingCart {

    private static final int ORANGES_TO_DISCOUNT = 3;
    private static final int APPLES_TO_DISCOUNT = 2;
    enum Fruit {
        APPLE(new BigDecimal("00.60")),ORANGE(new BigDecimal("00.25"));
        private BigDecimal cost;
        Fruit(BigDecimal cost) {
            this.cost=cost;
        }
    }

    private List<Fruit> fruits;
    ShoppingCart(List<Fruit> fruits) {
        this.fruits=fruits;
    }

    public BigDecimal getTotalBill() {
        BigDecimal totalBills  = new BigDecimal("0.00");
        Map<Boolean,Long> partitionFruits =
                fruits.stream()
                        .collect(
                                partitioningBy( fruit -> fruit.equals(Fruit.APPLE),
                                        counting()));

        long totalApples = partitionFruits.get(true);
        long totalOranges = partitionFruits.get(false);

        return totalBills.add(getApplesCost(totalApples)).add(getOrangesCost(totalOranges));
    }

    private BigDecimal getOrangesCost(long countOranges) {
        long orangesToDiscount = countOranges / ORANGES_TO_DISCOUNT;
        long totalOrangesToCharge = (orangesToDiscount*2) + (countOranges%ORANGES_TO_DISCOUNT);
        return new BigDecimal(Long.valueOf(totalOrangesToCharge)).multiply(Fruit.ORANGE.cost);
    }

    private BigDecimal getApplesCost(long countApple) {
        long appletodiscount = countApple / APPLES_TO_DISCOUNT;
        long totalApplestoCharge = appletodiscount + (countApple%APPLES_TO_DISCOUNT);
        return new BigDecimal(Long.valueOf(totalApplestoCharge)).multiply(Fruit.APPLE.cost);
    }
}
