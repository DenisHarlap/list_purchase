import com.exadel.lab.MainPurchase;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        File filename = new File("d:\\Work\\list_purchase\\src\\Output.txt");
        filename.delete();
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter(filename,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);

        } catch(IOException e1){
            System.err.println("Stream open error");
            System.exit(1);
        }
        /*
         * Создание объекта класса MainPurchase
         */
        MainPurchase purList = new MainPurchase(args[0]);
        /*
         * Вывод в файл заданного списка
         */
        purList.print(printWriter);
        /*
         * Создание дополнительного объекта класса MainPurchase
         */
        MainPurchase addPurList = new MainPurchase(args[1]);
        /*
         * Вставить последний элемент второй коллекции на позицию 0
         * в первую коллекцию
         */
        purList.insert(0,addPurList.getDataPurchase().get(addPurList.getDataPurchase().size()-1));
        purList.print(printWriter);
        /*
         * Вставить начальный элемент второй коллекции на позицию 1000
         * в первую коллекцию
         */
        purList.insert(1000,addPurList.getDataPurchase().get(0));
        purList.print(printWriter);
        /*
         * Вставить элемент c индексом 2 второй коллекции в позицию 2
         * в первую коллекцию
         */
        purList.insert(2,addPurList.getDataPurchase().get(2));
        purList.print(printWriter);
        /*
         * Удалить элементы из первой коллекции с индексами 3,10 и -5
         */
        if (purList.delete(3) == -1) {
            printWriter.println("Element with number 3 is not found");
        }
        if (purList.delete(10) == -1) {
            printWriter.println("Element with number 10 is not found");
        }
        if (purList.delete(-5) == -1) {
            printWriter.println("Element with number -5 is not found");
        }
        purList.print(printWriter);
        /*
         * Сортировка первой коллекции
         */
        purList.sort();
        purList.print(printWriter);
        /*
         * Найти элемент с индексом 1 и с индексом 3 из второй коллекции в первой коллекции
         */
        printWriter.println("Search result:");
        printWriter.println("Element ");
        int index;
        printWriter.println(addPurList.getDataPurchase().get(1).toString());
        index = purList.binarySearch(addPurList.getDataPurchase().get(1));
        if (index >= 0)
            printWriter.println("Is found at position " + index);
        else
            printWriter.println("is not found");
        printWriter.println("Element ");
        printWriter.println(addPurList.getDataPurchase().get(3).toString());
        index = purList.binarySearch(addPurList.getDataPurchase().get(3));
        if (index >= 0)
            printWriter.println("is found at position " + index);
        else
            printWriter.println("is not found");
        printWriter.close();
    }
}
