import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.stream.Collectors;

public class App {
    
    public static void main(String[] args) {
        
        List<Product> products = new ArrayList<>();

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
        filteredProducts = products.stream().filter(p -> p.getCategory().equals("mobile") && (p.getPrice() > 1500.0f)).collect(Collectors.toList());
        filteredProducts.forEach(System.out::println);


    }
}
