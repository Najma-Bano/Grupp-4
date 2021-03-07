/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatnajma;
import java.util.*;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author najma
 */

abstract class Products {
	private final String name;
	private final String description;
	private final int cost;
	private int prodCount;

	public Products(String name, String description, int cost, int prodCount) {
		// System.out.println("Constructing a product " + name);
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.prodCount = prodCount;
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

	public int getProdCount() {
		return prodCount;
	}

	public int buy() {
		this.prodCount--;
		return prodCount;
	}

	public abstract String description();

	public abstract String use();

}

// Subclass (inherit from Product)
class Drink extends Products {
	public Drink(String name, String description, int cost, int prodCount) {
		super(name, description, cost, prodCount);
	}

        @Override
	public String description() {
		return "Drinks " + getDescription();
	}

        @Override
	public String use() {
		return "Drinking product " + getName();
	}
}

// Subclass (inherit from Product)
class Toy extends Products {
	public Toy(String name, String description, int cost, int prodCount) {
		super(name, description, cost, prodCount);
	}

        @Override
	public String description() {
		return "Toys " + getDescription();
	}

        @Override
	public String use() {
		return "Playing product " + getName();
	}
}

class Food extends Products {
	public Food(String name, String description, int cost, int prodCount) {
		super(name, description, cost, prodCount);
	}

        @Override
	public String description() {
		return "Food " + getDescription();
	}

        @Override
	public String use() {
		return "Eating product " + getName();
	}
}

class Wallet {
	private int number1;
	private int number5;
	private int number10;
	private int number20;

	public Wallet(int number1, int number5, int number10, int number20) {
		this.number1 = number1;
		this.number5 = number5;
		this.number10 = number10;
		this.number20 = number20;
	}

	public void setNumber1(int num) {
		this.number1 = num;
	}

	public void setNumber5(int num) {
		this.number5 = num;
	}

	public void setNumber10(int num) {
		this.number10 = num;
	}

	public void setNumber20(int num) {
		this.number20 = num;
	}

	public int getnumber1() {
		return this.number1;
	}

	public int getnumber5() {
		return this.number5;
	}

	public int getnumber10() {
		return this.number10;
	}

	public int getnumber20() {
		return this.number20;
	}

}

public class AutomatNajma {

    public static int[] parseMoney(String money) {
        String[] numberMoneyInText = money.split(",");
        int[] result = new int[numberMoneyInText.length];
        for (int index = 0; index < numberMoneyInText.length; index++) {
            result[index] = Integer.parseInt(numberMoneyInText[index]);
        }
        return result;
    }

    public static int getTotal(int[] money) {
        int total = 0;
        total = total + money[0];
        total = total + money[1] * 5;
        total = total + money[2] * 10;
        total = total + money[3] * 20;
        return total;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        Wallet wallet = new Wallet(10, 10, 10, 10);
        List<Products> listProducts;
        listProducts = new ArrayList<>();
        listProducts.add(new Drink("Coke", "SoftDrink", 10, 10));
        listProducts.add(new Drink("Apple Juice", "Concentarted Flavoured", 10, 20));
        listProducts.add(new Toy("Disney Frozen Doll", "Anna Doll", 10, 20));
        listProducts.add(new Food("Twix", "Choclate with buiscuit", 10, 20));
        listProducts.add(new Food("Mars", "Choclate with caramel", 10, 20));
        int kronor1 = wallet.getnumber1();
        int kronor5 = wallet.getnumber5();
        int kronor10 = wallet.getnumber10();
        int kronor20 = wallet.getnumber20();

        while (true) {

            System.out.println(" **************************************************************** ");
            System.out.println("                WELCOME TO THE VENDING MACHINE                    ");
            System.out.println(" **************************************************************** ");
            System.out.println("     Denomination of Money shall be entered in below order:       ");
            System.out.println("                      1,5,10,20                                   ");
            System.out.println(" For example 0,2,0,2 means two 5 and two 20 kronor denomination   ");
            System.out.println("                     Products available:                          ");

            int index = 0;
            for (Products product : listProducts) {
                index++;
                System.out.println("     " + index + "  " + product.getName() + " - Price: " + product.getCost()
                        + "   Available:" + product.getProdCount());
            }
            System.out.println("      Enter 0 to exit                                             ");
            System.out.println("                                                                  ");
            Scanner scanner = new Scanner(System.in);
            System.out.println("                                              ");

            System.out.println(" Please select your product: ");
            int prodNum = scanner.nextInt();
            if (prodNum == 0) {
                System.exit(0);
            }
            if (prodNum > index) {
                continue;
            }

            // System.out.println(" Please Enter your product: ");
            Products e = listProducts.get(prodNum - 1);
            if (e.getProdCount() == 0) {
                System.out.println(" Please select another product");
                continue;
            }
            int prodCost = e.getCost();
            //System.out.println("     " + e.getName());
            scanner.nextLine();
            System.out.println("Enter money denominator, comma separetd");
            String enteredMoney = scanner.nextLine();

            int[] AMoney = parseMoney(enteredMoney);
            // System.out.println(getTotal(AMoney));
            int totMoney = getTotal(AMoney);
            if (kronor1 < AMoney[0] || kronor5 < AMoney[1] || kronor10 < AMoney[2] || kronor20 < AMoney[3]) {
                System.out.println("More money entered than available in Wallet!");
                continue;
            }
            wallet.setNumber1(kronor1 - AMoney[0]);
            wallet.setNumber5(kronor5 - AMoney[1]);
            wallet.setNumber10(kronor10 - AMoney[2]);
            wallet.setNumber20(kronor20 - AMoney[3]);

            kronor1 = wallet.getnumber1();
            kronor5 = wallet.getnumber5();
            kronor10 = wallet.getnumber10();
            kronor20 = wallet.getnumber20();

            System.out.println("Confirm your pusrchase of option: " + index + " - " + e.getName() + " by pressing y");
            System.out.println("Press anyother key to return to menu");
            if (!scanner.nextLine().equals("y")) {
                continue;
            }
            totMoney = totMoney - prodCost;
            // System.out.println("Return money " + totMoney + " Kronor");
            int retKronor20 = totMoney / 20;
            totMoney = totMoney % 20;
            int retKronor10 = totMoney / 10;
            totMoney = totMoney % 10;
            int retKronor5 = totMoney / 5;
            totMoney = totMoney % 5;
            int retKronor1 = totMoney / 1;

            wallet.setNumber1(kronor1 + retKronor1);
            wallet.setNumber5(kronor5 + retKronor5);
            wallet.setNumber10(kronor10 + retKronor10);
            wallet.setNumber20(kronor20 + retKronor20);

            kronor1 = wallet.getnumber1();
            kronor5 = wallet.getnumber5();
            kronor10 = wallet.getnumber10();
            kronor20 = wallet.getnumber20();
            e.buy();

            System.out.println(" Money In wallet, 1 kronor: " + kronor1);
            System.out.println(" Denomination 5 kronor: " + kronor5);
            System.out.println(" Denomination 10 kronor: " + kronor10);
            System.out.println(" Denomination 20 kronor: " + kronor20);

        }

    }
}
