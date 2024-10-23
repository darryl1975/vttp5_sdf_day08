import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// import ArithmaticOperation;
// import Product;

public class App {

    public static void main(String[] args) throws IOException {

        List<Product> products = new ArrayList<>();

        if (args.length > 0) {
            String[] arguments = args[0].split("/");

            File newDir = new File(arguments[0]);

            if (!newDir.exists()) {
                newDir.mkdir();
            }

            File newPathFile = new File(args[0]);

            if (!newPathFile.exists()) {
                newPathFile.createNewFile();
            }

        }

        LocalDate ldCreated = LocalDate.of(2024, 10, 21);
        Date createDt = Date.from(ldCreated.atStartOfDay(ZoneId.systemDefault()).toInstant());

        products.add(new Product(1L, "mouse", "mouse input", "computer", 99.0F, createDt));
        products.add(new Product(2L, "keyboard", "keyboard input", "computer", 235.5F, createDt));
        products.add(new Product(3L, "15.6 inch monitor", "display panel", "computer", 157.0F, createDt));
        products.add(new Product(4L, "Huawei Pura 70 Ultra", "Huawei Phone", "mobile", 900.0F, createDt));
        products.add(new Product(5L, "Huawei Mate X50 Pro", "Huawei Phone", "mobile", 1200.0F, createDt));
        products.add(new Product(6L, "iPhone 16 Pro", "iPhone", "mobile", 2000.0F, createDt));
        products.add(new Product(7L, "iPhone 14 Pro", "iPhone", "mobile", 1800.0F, createDt));

        List<Product> filteredProducts = new ArrayList<>();
        filteredProducts = products.stream().filter(p -> p.getCategory().equals("mobile") && (p.getPrice() > 1500.0f))
                .collect(Collectors.toList());
        filteredProducts.forEach(System.out::println);

        // write the list of filtered objects to a file
        FileWriter fw = new FileWriter(args[0], false);
        BufferedWriter bw = new BufferedWriter(fw);
        Iterator<Product> iterator = filteredProducts.iterator();
        while (iterator.hasNext()) {
            bw.append(iterator.next().toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        fw.close();

        // using Comparator to perform sorting
        // single column comparison
        Comparator<Product> comparator = Comparator.comparing(Product::getName);
        products.sort(comparator);
        products.forEach(System.out::println);

        products.sort(comparator.reversed());
        products.forEach(System.out::println);

        // sort an array of string "Bernard" "Zachary" "Alpha" "Theophilis" "Sammy"
        // "Christopher"
        // sort ascending and print
        // sort descending and print
        // String arr[] = { "Bernard", "Zachary", "Alpha", "Theophilis", "Sammy",
        // "Christopher" };
        // Arrays.sort(arr);
        // System.out.println("Ascending order: " + arr.toString());

        // Arrays.sort(arr, Collections.reverseOrder());
        // System.out.println("Descending order: " + arr.toString());

        // Threading recap
        // MyImplementation myImpl01 = new MyImplementation();
        // MyImplementation myImpl02 = new MyImplementation();
        // MyImplementation myImpl03 = new MyImplementation();

        // ExecutorService es = Executors.newFixedThreadPool(3);
        // es.execute(myImpl01);
        // es.execute(myImpl02);
        // es.execute(myImpl03);
        // es.shutdown();

        // Create Map objects
        // Sort the map object
        Map<String, Integer> mapObjectList = new HashMap<>();
        mapObjectList.put("Bernard", 100);
        mapObjectList.put("Robert", 80);
        mapObjectList.put("Carrot", 150);
        mapObjectList.put("Blockhead", 30);
        mapObjectList.put("Crazy", 200);
        mapObjectList.put("Clown", 300);
        mapObjectList.forEach((k, v) -> System.out.println(k + " --> " + v));

        List<Entry<String, Integer>> mapList = new ArrayList<>();
        mapList.sort(Entry.comparingByKey());
        mapList.forEach(System.out::println);

        mapObjectList.entrySet().stream().sorted(Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // calling functional interface method through the class
        ArithmaticOperation ao = new ArithmaticOperation();
        Integer addResults = ao.AddOperation(2, 3);
        System.out.println("Addition Results: " + addResults);

        // Given 4digits or 4 alphabets
        // Find the number of permutations
        // put the permutation into Set Collection
        String word = "";
        Console console = System.console();
        word = console.readLine("Enter a word to compute permutations: ");
        permutations(word);

    }

    public static void permutations(String str) {
        List<String> ans = new ArrayList<>(); // ArrayList

        ans.add(String.valueOf(str.charAt(0)));

        for (int i = 1; i < str.length(); i++) {
            for (int j = ans.size() - 1; j >= 0; j--) {
                String temp = ans.remove(j);
                for (int k = 0; k <= temp.length(); k++) {
                    ans.add(temp.substring(0, k) + str.charAt(i) + temp.substring(k));
                }
            }
        }

        System.out.println("Array size: " + ans.size() + " > " + ans);
    }
}
