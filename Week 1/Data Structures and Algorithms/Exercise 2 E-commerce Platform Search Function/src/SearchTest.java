import java.util.Arrays;
import java.util.Comparator;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(3, "Laptop", "Electronics"),
            new Product(1, "Book", "Books"),
            new Product(4, "Shirt", "Clothing"),
            new Product(2, "Phone", "Electronics"),
            new Product(5, "Shoes", "Clothing")
        };

        System.out.println("=== Linear Search ===");
        System.out.println("Searching for productId=4:");
        Product result = SearchAlgorithms.linearSearch(products, 4);
        System.out.println(result != null ? "Found: " + result : "Not found");

        System.out.println("\nSearching for productId=99:");
        result = SearchAlgorithms.linearSearch(products, 99);
        System.out.println(result != null ? "Found: " + result : "Not found");

        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparingInt(Product::getProductId));

        System.out.println("\nSorted products (by ID):");
        for (Product p : sortedProducts) {
            System.out.println("  " + p);
        }

        System.out.println("\n=== Binary Search ===");
        System.out.println("Searching for productId=4:");
        result = SearchAlgorithms.binarySearch(sortedProducts, 4);
        System.out.println(result != null ? "Found: " + result : "Not found");

        System.out.println("\nSearching for productId=99:");
        result = SearchAlgorithms.binarySearch(sortedProducts, 99);
        System.out.println(result != null ? "Found: " + result : "Not found");
    }
}
