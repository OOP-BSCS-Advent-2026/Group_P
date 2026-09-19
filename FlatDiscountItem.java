import java.util.Locale; //this helps with formating the number printed on the receipt

public class FlatDiscountItem extends Item {

    private int item_num;
    private double amount_off;

    public FlatDiscountItem(String name, double price, int item_num, double amount_off) {
        super(name, price);
        this.item_num = item_num;
        this.amount_off = amount_off;
    }

    @Override //this changes the calculateTotal from the parent to subtotal
    public double calculateTotal(int quantity) {
        double subtotal = super.calculateTotal(quantity);

        if (quantity >= item_num) {
            subtotal = Math.max(0, subtotal - amount_off);
        }

        return subtotal;
    }

    @Override//New discount with amount off subtracted
    public String getDiscountNote(int quantity) {
        if (quantity >= item_num) {
            return "UGX " + String.format(Locale.US, "%,.0f", amount_off) + " discount applied";
        }
        return "";
    }
}