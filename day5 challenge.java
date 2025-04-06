import java.util.*;

class Order {
    String orderId;
    String customerId;
    List<String> productCodes;

    public Order(String orderId, String customerId, List<String> productCodes) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productCodes = productCodes;
    }
}

public class Day5Challenge {
    private List<Order> orders = new ArrayList<>();
    private Set<String> uniqueProducts = new HashSet<>();
    private Map<String, Integer> productSales = new HashMap<>();
    private Map<String, Set<String>> customerProducts = new HashMap<>();

    public void addOrder(String orderId, String customerId, List<String> productCodes) {
        orders.add(new Order(orderId, customerId, productCodes));

      
        uniqueProducts.addAll(productCodes);

       
        for (String product : productCodes) {
            productSales.put(product, productSales.getOrDefault(product, 0) + 1);
        }

       
        customerProducts.putIfAbsent(customerId, new HashSet<>());
        customerProducts.get(customerId).addAll(productCodes);
    }

    public Set<String> getUniqueProducts() {
        return uniqueProducts;
    }

    public Map<String, Integer> getProductSalesCount() {
        return productSales;
    }

    public String getTopCustomer() {
        String topCustomer = null;
        int maxUniqueProducts = 0;

        for (Map.Entry<String, Set<String>> entry : customerProducts.entrySet()) {
            if (entry.getValue().size() > maxUniqueProducts) {
                maxUniqueProducts = entry.getValue().size();
                topCustomer = entry.getKey();
            }
        }
        return topCustomer;
    }

    public static void main(String[] args) {
        Day5Challenge analyzer = new Day5Challenge();

      
        analyzer.addOrder("O1", "C1", Arrays.asList("P1", "P2", "P3"));
        analyzer.addOrder("O2", "C2", Arrays.asList("P2", "P3", "P4"));
        analyzer.addOrder("O3", "C1", Arrays.asList("P1", "P4", "P5"));
        analyzer.addOrder("O4", "C3", Arrays.asList("P6", "P7"));
        analyzer.addOrder("O5", "C2", Arrays.asList("P2", "P8"));

       
        System.out.println("Unique Products:");
        for (String product : analyzer.getUniqueProducts()) {
            System.out.println(product);
        }

        System.out.println("\nProduct Sales Count:");
        for (Map.Entry<String, Integer> entry : analyzer.getProductSalesCount().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nTop Customer (most distinct products bought):");
        System.out.println(analyzer.getTopCustomer());
    }
}