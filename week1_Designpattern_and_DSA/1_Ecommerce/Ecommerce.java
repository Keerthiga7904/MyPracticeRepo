import java.util.*;

// Product class with id, name, and category
class Product {
    int productId;
    String productName;
    String category;

    public Product(int id, String name, String cat) {
        this.productId = id;
        this.productName = name;
        this.category = cat;
    }

    @Override
    public String toString() {
        return "[" + productId + ", " + productName + ", " + category + "]";
    }
}
public class Ecommerce {

    // Linear Search by Product Name
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null; // not found
    }

    // Binary Search by Product Name (requires sorted array)
    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null; // not found
    }

    public static void main(String[] args) {
        // Creating a list of products
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shoes", "Fashion"),
            new Product(3, "Book", "Education"),
            new Product(4, "Headphones", "Electronics"),
            new Product(5, "Watch", "Accessories")
        };

        // ---------- Linear Search ----------
        System.out.println("=== Linear Search ===");
        String searchKey1 = "Watch";
        Product result1 = linearSearch(products, searchKey1);
        if (result1 != null) {
            System.out.println("Product Found: " + result1);
        } else {
            System.out.println("Product Not Found");
        }

        // ---------- Binary Search ----------
        // Sorting the array by product name before binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("\n=== Binary Search ===");
        String searchKey2 = "Watch";
        Product result2 = binarySearch(products, searchKey2);
        if (result2 != null) {
            System.out.println("Product Found: " + result2);
        } else {
            System.out.println("Product Not Found");
        }
    }
}


// output:
// === Linear Search ===
// Product Found: [5, Watch, Accessories]

// === Binary Search ===
// Product Found: [5, Watch, Accessories]