package com.example.pizzaorderproject;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {

    public static void main(String[] args) {

        ArrayList<PizzaOrder> orders = new ArrayList<>();

        orders.add(new Delivery("Ahmad",PizzaOrder.LARGE,3,10,10,3));
        orders.add(new Delivery("Suha",PizzaOrder.MEDIUM,2,5,20,2));
        orders.add(new ToGo("Ribhi", PizzaOrder.MEDIUM,4,5));
        orders.add(new Seated("Rana", PizzaOrder.SMALL,3,1,2,3));
        orders.add(new Seated("Jamal", PizzaOrder.LARGE,4,2,4,5));

        //Sort orders based on their calculated order price
        Collections.sort(orders);

        //Print sorted orders customer names and prices
        for (PizzaOrder order : orders) {
            order.printOrderInfo();
        }

        //Print total sum of all order prices
        System.out.println("\nTotal Price: " + calculateTotalOrdersPrice(orders));

        //Print report for the second Delivery order
        PizzaOrder secondDeliveryOrder = orders.get(1);
        System.out.println("\nReport for the second Delivery order: " + secondDeliveryOrder.toString());
    }

    public static void sortOrders(ArrayList<PizzaOrder> orders) {
        Collections.sort(orders);
    }

    public static double calculateTotalOrdersPrice(ArrayList<PizzaOrder> orders) {
        double total = 0;
        for (PizzaOrder order : orders) {
            total += order.calculateOrderPrice();
        }
        return total;
    }

}
