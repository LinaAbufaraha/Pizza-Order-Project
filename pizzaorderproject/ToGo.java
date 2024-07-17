package com.example.pizzaorderproject;

public class ToGo extends PizzaOrder{

    public ToGo() {
    }

    public ToGo(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) {
        super(customerName, pizzaSize, numberOfToppings, toppingPrice);
    }
}
