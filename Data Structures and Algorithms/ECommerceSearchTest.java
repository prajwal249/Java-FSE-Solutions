import java.util.Arrays;

// 1. Product Class
class Product implements Comparable<Product> {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    @Override
    public int compareTo(Product other) {
        return this.productName.compareToIgnoreCase(other.productName);
    }

    @Override
    public String toString() {
        return "Product[ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
    }
}

// 2. Search Algorithms Class
class SearchAlgorithms {

    // Linear Search: O(n) Time Complexity
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search: O(log n) Time Complexity
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

// 3. Main Execution Class (Filename must match this name)
public class ECommerceSearchTest {
    public static void main(String[] args) {
        // Create sample product array
        Product[] products = {
            new Product("P101", "Wireless Mouse", "Electronics"),
            new Product("P102", "Gaming Keyboard", "Electronics"),
            new Product("P103", "Mechanical Pencil", "Stationery"),
            new Product("P104", "Bluetooth Speaker", "Electronics"),
            new Product("P105", "Leather Wallet", "Accessories")
        };

        String target = "Bluetooth Speaker";

        // --- Linear Search ---
        System.out.println("=== Testing Linear Search ===");
        Product result1 = SearchAlgorithms.linearSearch(products, target);
        System.out.println("Search target: " + target);
        System.out.println("Result: " + (result1 != null ? result1 : "Product Not Found") + "\n");

        // --- Binary Search ---
        System.out.println("=== Testing Binary Search ===");
        // Sorting is required before executing Binary Search
        Arrays.sort(products);
        
        System.out.println("Sorted products list for Binary Search:");
        for (Product p : products) {
            System.out.println(" - " + p.getProductName());
        }

        Product result2 = SearchAlgorithms.binarySearch(products, target);
        System.out.println("\nSearch target: " + target);
        System.out.println("Result: " + (result2 != null ? result2 : "Product Not Found"));
    }
}
