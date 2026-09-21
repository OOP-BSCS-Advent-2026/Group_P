# Phase 2

### **Encapsulation and Inheritance — an addition to your existing Business Simulator** 

_Same business. Same prices. Same discount rules. New structure._ 

## What's Changing

Nothing about your business changes. Your group's items, prices, and discount rules are exactly what they were in Phase 1 — go back to your original handout for those, they haven't moved. 

What changes is how your program is organised. Instead of four items handled with parallel arrays and if/else, you're going to give each item a class — and because your four discount rules were never really four different things, they were always one of three patterns (a percentage, a flat amount, or no discount at all), those three patterns become three classes that share one parent. 

This is the same retrofit we did with Animal in class: build the class properly, encapsulate it, then let inheritance take over the part of the logic that actually differs. 

## The Class Hierarchy Every Group Will Build

This part is identical for all 20 groups — only the names, prices, and numbers inside your objects will differ. 

### The Superclass: Item 

Holds what every item has in common: a name, a price, and the ability to calculate a total for some quantity with no discount at all. 

public class Item { private String name; private double price; public Item(String name, double price) { if (price <= 0) { throw new IllegalArgumentException("Price must be greater than zero"); } this.name = name; this.price = price; } public String getName() { return name; } public double getPrice() { return price; } public double calculateTotal(int quantity) { if (quantity < 0) { throw new IllegalArgumentException("Quantity cannot be negative"); } return price * quantity; } } 

### Subclass 1: PercentDiscountItem 

For any item whose rule is “buy N or more, get X% off” — this is two of your four items. 

public class PercentDiscountItem extends Item { private int threshold; private double percentOff; public PercentDiscountItem(String name, double price, int threshold, double percentOff) { super(name, price); this.threshold = threshold; this.percentOff = percentOff; } @Override public double calculateTotal(int quantity) { double subtotal = super.calculateTotal(quantity); if (quantity >= threshold) { subtotal = subtotal * (1 - percentOff / 100.0); } return subtotal; } } 

### Subclass 2: FlatDiscountItem 

For the one item whose rule is “buy N or more, UGX X comes straight off.” 

public class FlatDiscountItem extends Item { private int threshold; private double flatAmount; public FlatDiscountItem(String name, double price, int threshold, double flatAmount) { super(name, price); this.threshold = threshold; this.flatAmount = flatAmount; } @Override public double calculateTotal(int quantity) { double subtotal = super.calculateTotal(quantity); if (quantity >= threshold) { subtotal = Math.max(0, subtotal - flatAmount); } return subtotal; } } 

### Subclass 3: NoDiscountItem 

For the one item that never gets a discount — and notice this class needs no override at all. Item's own calculateTotal() already does exactly the right thing. 

public class NoDiscountItem extends Item { public NoDiscountItem(String name, double price) { super(name, price); } // No override needed — Item's calculateTotal() is already correct. } 

## Mapping Your Own Four Items 

Every group's Phase 1 rules follow the same pattern: item 1 and item 4 are percentage discounts, item 2 has no discount, item 3 is a flat discount. That means the mapping below is the same for everyone — only your own names, prices, thresholds, and rates go into it. 

- ☐  Your item 1 → a PercentDiscountItem 

- ☐  Your item 2 → a NoDiscountItem 

- ☐  Your item 3 → a FlatDiscountItem 

- ☐  Your item 4 → a second PercentDiscountItem (its own rate and threshold — not necessarily the same as item 1's) 

## Worked Example

This is the same Kabs example from Phase 1, rebuilt on the new hierarchy. Your own Main.java will look exactly like this in shape — only your business's names, prices, and numbers change. 

public class Main { public static void main(String[] args) { Item[] items = { new PercentDiscountItem("Sugar", 555.66, 5, 5), new NoDiscountItem("Salt", 6666.00), new FlatDiscountItem("Porridge", 44444.00, 3, 5000), new PercentDiscountItem("Bread", 444.00, 2, 10) }; int[] quantities = {4, 2, 2, 2}; double total = 0; for (int i = 0; i < items.length; i++) { double lineTotal = items[i].calculateTotal(quantities[i]); System.out.println(items[i].getName() + " x" + quantities[i] + " = UGX " + lineTotal); total += lineTotal; } System.out.println("TOTAL = UGX " + total); } } 

Run this and your total should come out to UGX 105,241.84 — the exact same number Phase 1's “check yourself” gave you, because it's the exact same business logic, just organised differently now. 

_Notice the array's type: Item[], not PercentDiscountItem[]. A single array can hold all three subclasses at once, because every one of them is an Item — and calling calculateTotal() on each runs whichever version actually belongs to that object. You haven't been formally taught the name for this yet; you've just built it._ 

## Deliverables 

1. Item.java — the superclass, encapsulated exactly as shown above (or with your own reasonable variable names). 

2. PercentDiscountItem.java, FlatDiscountItem.java, NoDiscountItem.java — the three subclasses. 

3. Main.java — builds your four real items (your own names, prices, thresholds, rates), stores them in one Item[] array, and prints the same style of itemised receipt as Phase 1. 

4. Every field in every class must be private. Every subclass constructor must call super(...) as its first line. 
