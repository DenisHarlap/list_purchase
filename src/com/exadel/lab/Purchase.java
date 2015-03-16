package com.exadel.lab;

import java.util.Comparator;

/**
 * Created by Denis on 13.02.15.
 */
public class Purchase implements Comparator<Purchase> {

    private String commodityName;
    private int price;
    private int numberUnit;

    public Purchase(){
        super();
    }

    public Purchase(String commodityName, int price, int numberUnit) {
        this.commodityName = commodityName;
        this.price = price;
        this.numberUnit = numberUnit;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public int getPrice() {
        return price;
    }

    public int getNumberUnit() {
        return numberUnit;
    }

    public void setNumberUnit(int numberUnit) {
        this.numberUnit = numberUnit;
    }

    public int getCost(){
        return numberUnit*price;
    }

    @Override
    public String toString() {
        return commodityName + ";" + price + ";" + numberUnit + ";";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (price != purchase.price) return false;
        if (commodityName != null ? !commodityName.equals(purchase.commodityName)
                : purchase.commodityName != null)
            return false;

        return true;
    }

    @Override
    public int compare(Purchase ref1, Purchase ref2) {
        if (ref1.getCommodityName().equals(ref2.getCommodityName())) {
            if (ref1.getClass() != ref2.getClass()) {
                if (ref1 instanceof PricePurchase)
                    return 1;
                else
                    return -1;
            }
            else
                return ref1.getCost() - ref2.getCost();
        }
        else
            return ref1.getCommodityName().compareTo(ref2.getCommodityName());

    }
}
