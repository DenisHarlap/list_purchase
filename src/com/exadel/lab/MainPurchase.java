package com.exadel.lab;

import java.io.*;
import java.util.*;

/**
 * Created by Denis on 13.02.15.
 */
public class MainPurchase {

    private List <Purchase> dataPurchase = new ArrayList<Purchase>();

    public MainPurchase () {}

    public MainPurchase(String filename) {
        File f = new File(filename);
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String temp;
            while ((temp = br.readLine()) != null) {
                String [] arr = temp.split(";");
                if (arr.length == 3)
                    dataPurchase.add(new Purchase(arr[0],Integer.valueOf(arr[1]),
                            Integer.valueOf(arr[2])));
                if (arr.length == 4)
                    dataPurchase.add(new PricePurchase(arr[0],Integer.valueOf(arr[1]),
                            Integer.valueOf(arr[2]),Integer.valueOf(arr[3])));
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error on the reading file");
            System.exit(1);
        }
    }

    public void insert(int index, Purchase ref){
        if (dataPurchase.size()-1 < index)
            dataPurchase.add(ref);
        else
            dataPurchase.add(index, ref);
    }

    public int delete(int index){
        if (dataPurchase.size()-1 < index || index < 0)
            return -1;
        else {
            dataPurchase.remove(index);
            return index;
        }
    }

    public int totalCost(){
        int sumCost = 0;
       Iterator<Purchase> it = dataPurchase.iterator();
        while (it.hasNext()){
            sumCost += it.next().getCost();
        }
        return sumCost;
    }

    public List<Purchase> getDataPurchase() {
        return dataPurchase;
    }

    public void print(PrintWriter outFile) {

        outFile.printf("%10s%18s%16s%14s%19s%n", "Name", "Price", "Number", "Cost", "Discount");
        for (Purchase obj : dataPurchase) {
            outFile.printf("%10s%18d%16d%14d", obj.getCommodityName(), obj.getPrice(),
                    obj.getNumberUnit(), obj.getCost());
            if (obj instanceof PricePurchase)
                outFile.printf("%19d%n", ((PricePurchase) obj).getUnitDiscount());
            else
                outFile.println("");
        }
        outFile.printf("%10s%48d%n", "Total cost", totalCost());
        outFile.println("");
    }

    public void sort(){
        try {
            Collections.sort(dataPurchase,Purchase.class.newInstance());
        } catch (InstantiationException e1){
            System.err.println("Impossible create object of this class");
        } catch (IllegalAccessException e2){
            System.err.println("Illegal access to object of this class");
        }
    }

    public int binarySearch(Purchase purchase){
        int index = -1;
        try {
            index = Collections.binarySearch(dataPurchase, purchase, Purchase.class.newInstance());
        }catch (InstantiationException e1){
            System.err.println("Impossible create object of this class");
        } catch (IllegalAccessException e2){
            System.err.println("Illegal access to object of this class");
        }
        return index;
    }

}
