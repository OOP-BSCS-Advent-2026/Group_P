public class Main {
  public static void main(String[] args) {
    //Display welcome message
     System.out.println("===== Welcome to Home Comfort Furniture! =====\n");

    //Create an array of items for sale and their corresponding quantities 
     Item[]items = {
     new FlatDiscountItem("Bed", 350000.00, 2, 20000),
     
     };
      int[] quantities = {
            3,
            2,
            1,
            2
        };
    
    //Display available items
      System.out.println("Available Items:");

      for(int i =0;i<items.length;i++){
        System.out.println((i+1) + "."+ items[i].getName()+" UGX"+items[i].getPrice());
      }

      double totalAmount =0;

      System.out.println("\n================ RECEIPT ================\n");

      //Calculate the total for each item    
      for(int i= 0;i<items.length;i++){
        double subtotal = items[i].calculateTotal(quantities[i]);
        System.out.println(items[i].getName()+ " UGX "+item[i].getPrice()+ " x "+ quantities[i]+" = UGX"+subtotal);

        //Get the discount  note for the item and print it if it's not empty
        String discountNote = items[i].getDiscountNote(quantities[i]);
        if(!discountNote.isEmpty()){
          System.out.println("(" +discountNote + ")");
        }

         System.out.println();

        totalAmount += subtotal;
      }


      System.out.println("\n------------------------------------------");
      System.out.printf("Total Amount:UGX%.2f%n",totalAmount);
    }
}
