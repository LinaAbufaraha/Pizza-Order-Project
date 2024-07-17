package com.example.pizzaorderproject;

public class Delivery extends PizzaOrder{
    private double tripRate;
    private int zone;

    public Delivery() {
    }

    public Delivery(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double tripRate, int zone) {
        super(customerName, pizzaSize, numberOfToppings, toppingPrice);
        setTripRate(tripRate);
        setZone(zone);
    }

    public double getTripRate() {
        return tripRate;
    }

    public void setTripRate(double tripRate) {
        this.tripRate = tripRate;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        if (zone < 1 || zone > 4) {
            throw new IllegalArgumentException("Zone must be between 1 and 4.");
        }
        this.zone = zone;
    }

    @Override
    public String toString() {
        String pizzaSizeString="";
        if(getPizzaSize() == 1)
            pizzaSizeString =  "small";
        else if(getPizzaSize() == 2)
            pizzaSizeString =  "medium";
        else if(getPizzaSize() == 3)
            pizzaSizeString = "larg";
        return "Delivery{" +
                "\n Customer Name = '" + getCustomerName() + '\'' +
                "\n Date Ordered = " + getDateOrdered() +
                "\n Pizza Size = " + pizzaSizeString +
                "\n Number Of Toppings = " + getNumberOfToppings() +
                "\n Topping Price = " + getToppingPrice() +
                "\n Trip Rate = " + tripRate +
                "\n Zone = " + zone +
                "\n Order Price = " + calculateOrderPrice() +
                "\n"+
                '}';
    }

    @Override
    public double calculateOrderPrice() {        //method which overrides the method in PizzaOrder

        return super.calculateOrderPrice()+((tripRate/100)*zone*super.calculateOrderPrice());     //super.calculateOrderPrice()=totalprice
    }

}
