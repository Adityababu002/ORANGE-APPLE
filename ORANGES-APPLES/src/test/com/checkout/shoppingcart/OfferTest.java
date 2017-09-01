package com.checkout.shoppingcart;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.checkout.shoppingcart.ShoppingCart.Fruit.APPLE;
import static com.checkout.shoppingcart.ShoppingCart.Fruit.ORANGE;

public class OfferTest {

    @Test
    public void GIVEN_2apples_THEN_totalcost60p() {
        ShoppingCart shoppingCart = new ShoppingCart(createShoppingBasketItems(APPLE,APPLE));
        BigDecimal totalbill = shoppingCart.getTotalBill();
        assert totalbill.equals(new BigDecimal("00.60"));
    }

    @Test
    public void GIVEN_3oranges_THEN_totalcost50p() {
        ShoppingCart shoppingCart = new ShoppingCart(createShoppingBasketItems(ORANGE,ORANGE,ORANGE));
        BigDecimal totalbill = shoppingCart.getTotalBill();
        assert totalbill.equals(new BigDecimal("00.50"));
    }

    @Test
    public void GIVEN_4oranges_THEN_totalcost75p() {
        ShoppingCart shoppingCart = new ShoppingCart(
                createShoppingBasketItems(ORANGE,ORANGE,ORANGE,ORANGE));
        BigDecimal totalbill = shoppingCart.getTotalBill();
        assert totalbill.equals(new BigDecimal("00.75"));
    }

    @Test
    public void GIVEN_1oranges_THEN_totalcost25p() {
        ShoppingCart shoppingCart = new ShoppingCart(createShoppingBasketItems(ORANGE));
        BigDecimal totalbill = shoppingCart.getTotalBill();
        assert totalbill.equals(new BigDecimal("00.25"));
    }

    @Test
    public void GIVEN_6oranges_THEN_totalcost1pound() {
        ShoppingCart shoppingCart = new ShoppingCart(
                createShoppingBasketItems(ORANGE,ORANGE,ORANGE,ORANGE,ORANGE,ORANGE));
        BigDecimal totalbill = shoppingCart.getTotalBill();
        assert totalbill.equals(new BigDecimal("1.00"));
    }

    @Test
    public void GIVEN_4apples_THEN_totalcost1pound20pence() {
        ShoppingCart shoppingCart = new ShoppingCart(createShoppingBasketItems(APPLE,APPLE,APPLE,APPLE));
        BigDecimal totalbill = shoppingCart.getTotalBill();
        assert totalbill.equals(new BigDecimal("1.20"));
    }

    @Test
    public void GIVEN_4applesAnd6Oranges_THEN_totalcost2pound20pence() {
        ShoppingCart shoppingCart = new ShoppingCart(
                createShoppingBasketItems(APPLE,APPLE,APPLE,APPLE,
                        ORANGE,ORANGE,ORANGE,ORANGE,ORANGE,ORANGE));
        BigDecimal totalbill = shoppingCart.getTotalBill();
        assert totalbill.equals(new BigDecimal("2.20"));
    }

    @Test
    public void GIVEN_4applesAnd1orange_THEN_totalcost1pound45pence() {
        ShoppingCart shoppingCart = new ShoppingCart(
                createShoppingBasketItems(APPLE,APPLE,APPLE,APPLE,
                        ORANGE));
        BigDecimal totalbill = shoppingCart.getTotalBill();
        assert totalbill.equals(new BigDecimal("1.45"));
    }


    @Test
    public void GIVEN_1000Apples_THEN_totalcost300pounds() {
        ShoppingCart shoppingCart = new ShoppingCart(createBasketWith1000Apples());
        assert shoppingCart.getTotalBill().equals(new BigDecimal("300.00"));
    }


    private List<ShoppingCart.Fruit> createShoppingBasketItems(ShoppingCart.Fruit... items) {
        return Arrays.asList(items);
    }

    private List<ShoppingCart.Fruit> createBasketWith1000Apples() {
        List<ShoppingCart.Fruit> apples = new ArrayList<>();
        for(int i =0;i<1000;i++) {
            apples.add(APPLE);
        }
        return apples;
    }
}
