public class FlatDiscountItem extends Item {

    private int minQuantity;
    private double flatAmount;

    public FlatDiscountItem(String name, double price, int minQuantity, double flatAmount) {
        super(name, price);
        this.minQuantity = minQuantity;
        this.flatAmount = flatAmount;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public double getFlatAmount() {
        return flatAmount;
    }

    @Override
    public double calculateTotal(int quantity) {
        double subtotal = super.calculateTotal(quantity);

        if (quantity >= minQuantity) {
            subtotal = Math.max(0, subtotal - flatAmount);
        }

        return subtotal;
    }
}