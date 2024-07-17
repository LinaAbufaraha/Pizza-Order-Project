package com.example.pizzaorderproject;

public class Seated extends PizzaOrder{
    private double serviceCharge;
    private int numberOfPeople;

    public Seated(double serviceCharge, int numberOfPeople) {
        super();
        this.serviceCharge = serviceCharge;
        this.numberOfPeople = numberOfPeople;
    }

    public Seated(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double serviceCharge, int numberOfPeople) {
        super(customerName, pizzaSize, numberOfToppings, toppingPrice);
        this.serviceCharge = serviceCharge;
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public String toString() {
        return "Seated{" +
                "serviceCharge=" + serviceCharge +
                ", numberOfPeople=" + numberOfPeople +
                '}';
    }

    public double calculateOrderPrice() {
        return super.calculateOrderPrice()+(serviceCharge*numberOfPeople);
    }

}
