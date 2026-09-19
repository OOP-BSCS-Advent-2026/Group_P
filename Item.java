/**
 * Item is the superclass for every product the till sells.
 * It holds what all items have in common: a name, a price, and the
 * ability to calculate a total for some quantity with no discount.
 *
 * Subclasses (PercentDiscountItem, FlatDiscountItem, NoDiscountItem)
 * extend this class and override calculateTotal() where their
 * discount rule differs.
 */
public class Item {

    // Encapsulation: fields are private, so they can only be
    // accessed through the constructor and getters below.
    private String name;
    private double price;

    /**
     * Creates an item with a name and a price.
     *
     * @param name  the item's name
     * @param price the price of one unit (must be greater than zero)
     * @throws IllegalArgumentException if the price is zero or negative
     */
    public Item(String name, double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Calculates the total for the given quantity with no discount.
     * Subclasses override this method to apply their own discount rule.
     *
     * @param quantity number of units bought (cannot be negative)
     * @return price multiplied by quantity
     * @throws IllegalArgumentException if the quantity is negative
     */
    public double calculateTotal(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        return price * quantity;
    }
}
