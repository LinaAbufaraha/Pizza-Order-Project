package com.example.pizzaorderproject;

import java.util.Date;

public class PizzaOrder implements Comparable<PizzaOrder> {

    private String customerName;
    private Date dateOrdered;
    private int pizzaSize;
    final static int  SMALL=1;
    final static int MEDIUM=2;
    final static int  LARGE =3;
    private int numberOfToppings;
    private double toppingPrice;

    PizzaOrder() {
        setDateOrdered(new Date());
    }
    PizzaOrder (String customerName,int pizzaSize,int numberOfToppings,double  toppingPrice) {
        setCustomerName(customerName);
        setDateOrdered(new Date());
        setPizzaSize(pizzaSize);
        setNumberOfToppings(numberOfToppings);
        setToppingPrice(toppingPrice);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public int getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(int pizzaSize) {
        if (pizzaSize !=SMALL && pizzaSize !=MEDIUM && pizzaSize !=LARGE) {
            throw new IllegalArgumentException("Pizza size must be either 1 (SMALL), 2 (MEDIUM), or 3 (LARGE).");
        }else
            this.pizzaSize = pizzaSize;
    }

    public int getNumberOfToppings() {
        return numberOfToppings;
    }

    public void setNumberOfToppings(int numberOfToppings) {
        if(numberOfToppings < 0){
            throw new IllegalArgumentException("Error: Number of toppings must be greater than 0.");
        }else
            this.numberOfToppings = numberOfToppings;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(double toppingPrice) {
        if(toppingPrice < 0){
            throw new IllegalArgumentException("Error: topping Price must be greater than 0.");
        }else
            this.toppingPrice = toppingPrice;
    }

    @Override
    public String toString() {

        String pizzaSizeString="";
        if(pizzaSize == 1)
            pizzaSizeString =  "small";
        else if(pizzaSize == 2)
            pizzaSizeString =  "medium";
        else if(pizzaSize == 3)
            pizzaSizeString = "larg";

        return "PizzaOrder{" +
                "customerName='" + customerName + '\'' +
                ", dateOrdered=" + dateOrdered +
                ", pizzaSize=" + pizzaSizeString +
                ", numberOfToppings=" + numberOfToppings +
                ", toppingPrice=" + toppingPrice +
                ", orderPrice=" + calculateOrderPrice() +
                '}';
    }

    public double calculateOrderPrice() {
        return ((numberOfToppings*toppingPrice)*pizzaSize);
    }

    public void printOrderInfo() {
        System.out.println(customerName + "   " +(int) calculateOrderPrice());
    }

    public void print(Object obj) {
        System.out.println(obj);
    }

    public int compareTo(PizzaOrder newPizzaOrder) {
        if(calculateOrderPrice() > newPizzaOrder.calculateOrderPrice())
            return 1;
        else if(calculateOrderPrice() < newPizzaOrder.calculateOrderPrice())
            return -1;
        else
            return 0;
    }

}
