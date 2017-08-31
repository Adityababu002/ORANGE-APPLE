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

   