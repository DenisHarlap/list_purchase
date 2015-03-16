package com.exadel.lab;

/**
 * Created by Denis on 13.02.15.
 */
public class PricePurchase extends Purchase {
    private int unitDiscount;

    public PricePurchase (){}

    public PricePurchase(String commodityName, int price, int numberUnit, int unitDiscount) {
        super(commodityName, price, numberUnit);
        this.unitDiscount = unitDiscount;
    }

    public int getUnitDiscount() {
        return unitDiscount;
    }

    @Override
    public String toString() {
        return  super.toString() + unitDiscount + ";";
    }

    @Override
    public int getCost() {
        return (this.getPrice() - unitDiscount)* this.getNumberUnit();
    }
}
