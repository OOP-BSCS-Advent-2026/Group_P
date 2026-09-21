public class PercentDiscountItem extends Item {

    private int minQuantity;
    private double percentOff;

    public PercentDiscountItem(String name, double price, int minQuantity, double percentOff) {
        super(name, price);
        this.minQuantity = minQuantity;
        this.percentOff = percentOff;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public double getPercentOff() {
        return percentOff;
    }

    @Override
    public double calculateTotal(int quantity) {
        double subtotal = super.calculateTotal(quantity);
        if (quantity >= minQuantity) {
            subtotal = subtotal * (1 - percentOff / 100.0);
        }
        return subtotal;
    }
}