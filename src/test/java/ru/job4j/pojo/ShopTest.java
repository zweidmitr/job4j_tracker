package ru.job4j.pojo;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void indexOfNull() {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        int result = Shop.indexOfNull(products);
        Assert.assertThat(result, Matchers.is(3));
    }

    @Test
    public void whenFirstNull() {
        Product[] products = new Product[5];
        products[1] = new Product("Milk", 10);
        int result = Shop.indexOfNull(products);
        Assert.assertThat(result, Matchers.is(0));
    }
}