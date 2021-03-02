/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individ;

/**
 *
 * @author najma
 */
abstract class Products {
   private String name;
   private String description;
   private int cost;

   public Products(String name, String description, int cost) {
      System.out.println("Constructing a product " + name);
      this.name = name;
      this.description = description;
      this.cost = cost;
   }
   
   public String getName() {
      return name;
   }
 
   public String getDescription() {
      return description;
   }
   
   public int getCost() {
      return cost;
   }
   
   public abstract void description();
   public abstract void use();
 
}

// Subclass (inherit from Product)
class Drink extends Products {
    public Drink(String name, String description, int cost) {
      super(name, description, cost);
   }
  public void description() {
    // The body of description is provided here
    System.out.println("Drinks " + getDescription());
  }
    
    public void use() {
    // The body of use() is provided here
    System.out.println("Drinking product " + getName());
  }
  
  

}
public class MyClass {
    public static void main(String args[]) {

      Drink myDrink = new Drink("Coke", "Good", 10); // Create a object
      Drink myDrink1 = new Drink("Apple Juice", "Concentarted Flavoured, banana inside", 10); // Create a object
      Drink myDrink2 = new Drink("Mango Juice", "Good", 20); // Create a object
      Drink myDrink3 = new Drink("Watermelon Juice", "Good", 10); // Create a object
      Drink myDrink4 = new Drink("Lime Juice", "Green with little sugar", 15); // Create a object
      myDrink1.description();

      
    }
}
