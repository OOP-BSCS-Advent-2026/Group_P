public class Main {

    // Method to calculate total amount
    public static double calculateTotalAmount(double[] subtotals) {
        double totalAmount = 0;

        for (double subtotal : subtotals) {
            totalAmount += subtotal;
        }

        return totalAmount;
    }

    // Method to print receipt
    public static void printReceipt(Item[] items, int[] quantities, double[] subtotals) {
        System.out.println("\n================ RECEIPT ================\n");

        for (int a = 0; a < items.length; a++) {

            System.out.print(items[a].getName() + " x " + quantities[a]
                    + " = UGX " + subtotals[a]);

            // Display discount applied, if any
            if (a == 0 && quantities[a] >= 4) {
                System.out.print(" (5% discount applied)");
            } else if (a == 2 && quantities[a] >= 2) {
                System.out.print(" (UGX 20,000 discount applied)");
            } else if (a == 3 && quantities[a] >= 2) {
                System.out.print(" (10% discount applied)");
            }

            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {

        System.out.println("===== Welcome to Home Comfort Furniture! =====\n");

        Item[] items = {
            new PercentDiscountItem("Chair", 45000.00, 4, 5),
            new NoDiscountItem("Table", 120000.00),
            new FlatDiscountItem("Bed", 350000.00, 2, 20000.00),
            new PercentDiscountItem("Sofa", 500000.00, 2, 10)
        };

        int[] quantities = {
            3,
            2,
            1,
            2
        };

        System.out.println("Available Items:");

        for (int num = 0; num < items.length; num++) {
            System.out.println(
                (num + 1) + ". " + items[num].getName() + "     UGX " + items[num].getPrice()
            );
        }

        double[] subtotals = new double[items.length];

        for (int i = 0; i < items.length; i++) {
            subtotals[i] = items[i].calculateTotal(quantities[i]);
        }

        double totalAmount = calculateTotalAmount(subtotals);

        printReceipt(items, quantities, subtotals);

        System.out.println("\n------------------------------------------");
        System.out.printf("Total Amount: UGX %.2f%n", totalAmount);
    }
}