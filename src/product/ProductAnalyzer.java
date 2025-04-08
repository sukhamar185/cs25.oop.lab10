package product;
import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    // toString
    @Override
    public String toString() {
        return name + " (" + price + ")";
    }
}

public class ProductAnalyzer {
    public static Map<String, List<Product>> analyze(List<Product> products) {
        return products.stream()
            // 1000₮-с дээш бүтээгдэхүүн шүүх
            .filter(product -> product.getPrice() >= 1000)
            // Категориара бүлэглэх, үнийг буурах дарааллаар эрэмбэлэх
            .collect(Collectors.groupingBy(
                Product::getCategory, 
                TreeMap::new, // Категориудыг дараалалтай хадгалах
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    list -> {
                        list.sort(Comparator.comparingDouble(Product::getPrice).reversed());
                        return list;
                    }
                )
            ));
    }

    public static void main(String[] args) {
        List<Product> items = Arrays.asList(
            new Product("Гутал", 1500, "Хувцас"),
            new Product("Тоглоом", 800, "Тоглоом"),
            new Product("Цамц", 1200, "Хувцас")
        );
        
        Map<String, List<Product>> result = analyze(items);

        // Гаралт хэвлэх
        result.forEach((category, products) -> 
            System.out.println(category + ": " + products));
    }
}
