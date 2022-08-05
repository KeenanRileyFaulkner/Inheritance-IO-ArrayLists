import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        List<Cupcake> cupcakeMenu = new ArrayList<>();
        Cupcake vanilla = new Vanilla();
        Cupcake redVelvet = new RedVelvet();
        Cupcake chocolate = new Chocolate();
        Collections.addAll(cupcakeMenu, vanilla, redVelvet, chocolate);

        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on\n" +
                "the menu but we need to decide on pricing.");
        Scanner input = new Scanner(System.in);
        for(Cupcake cupcake : cupcakeMenu) {
            System.out.println("We are deciding the price for our " + cupcake.getFlavor() + " cupcake." +
                    " Here is the description:");
            System.out.println(cupcake.getDescription());
            System.out.println("How much would you like to charge for the cupcake?" +
                    " (Enter a price with 2 decimal places) ");
            double price = input.nextDouble();
            input.nextLine();
            cupcake.setPrice(price);
        }

        List<Drink> drinkMenu = new ArrayList<>();
        Drink water = new Water();
        Drink milk = new Milk();
        Drink soda = new Soda();
        Collections.addAll(drinkMenu, water, milk, soda);

        System.out.println("We are in the middle of creating the drink menu. We currently have three types of\n" +
                "drinks on the menu but we need to decide on pricing.");
        for(Drink drink : drinkMenu) {
            System.out.println("We are deciding on the price for a bottle of " + drink.getDrinkName() + ". Here is the" +
                    " description:");
            System.out.println(drink.getDescription());
            System.out.println("How much would you like to charge for this item?");
            double price = input.nextDouble();
            input.nextLine();
            drink.setPrice(price);
        }

        Order customerOrder = new Order(cupcakeMenu, drinkMenu);
        ArrayList<Object> order = customerOrder.getOrder();

        double subTotal = 0;
        for(Object item : order) {
            if(cupcakeMenu.contains(item)) {
                subTotal += cupcakeMenu.get(cupcakeMenu.indexOf(item)).getPrice();
            } else if (drinkMenu.contains(item)) {
                subTotal += drinkMenu.get(drinkMenu.indexOf(item)).getPrice();
            }
        }
        System.out.println("Your subtotal is $" + (Math.round(subTotal * 100)/100.00));

        new CreateFile();
        new WriteToFile(order);
    }
}