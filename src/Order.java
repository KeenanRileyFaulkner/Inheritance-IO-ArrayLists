import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Order {
    private ArrayList<Object> order;
    public Order(List<Cupcake> cupcakeMenu, List<Drink> drinkMenu) {
        System.out.println("Hello! Would you like to place an order?");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();

        if(answer.equalsIgnoreCase("n")) {
            System.out.println("Have a nice day then!");
            return;
        }

        ArrayList<Object> order = new ArrayList<>();
        Collections.addAll(order, LocalDate.now(), LocalTime.now());

        System.out.println("Here is the menu:\n");
        System.out.println("CUPCAKES:");
        for(int i = 0; i < cupcakeMenu.size(); ++i) {
            System.out.println((i+1) + ". " + cupcakeMenu.get(i).getFlavor() + "Price: $" +
                    cupcakeMenu.get(i).getPrice());
        }
        System.out.println("\nDRINKS:");
        for(int i = 0; i < drinkMenu.size(); ++i) {
            System.out.println((i+4) + ". " + drinkMenu.get(i).getDrinkName() + "Price $" +
                    drinkMenu.get(i).getPrice());
        }

        System.out.println("What would you like to order? (Please use the number associated with the item," +
                " as listed above.)");

        boolean stillOrdering = true;
        while(stillOrdering) {
            int itemNum = input.nextInt();
            input.nextLine();
            switch (itemNum) {
                case 1:
                    order.add(cupcakeMenu.get(0));
                    break;
                case 2:
                    order.add(cupcakeMenu.get(1));
                    break;
                case 3:
                    order.add(cupcakeMenu.get(2));
                    break;
                case 4:
                    order.add(drinkMenu.get(0));
                    break;
                case 5:
                    order.add(drinkMenu.get(1));
                    break;
                case 6:
                    order.add(drinkMenu.get(2));
                    break;
                default:
                    System.out.println("That's not a valid item.");
            }

            System.out.println("Would you like to continue ordering? (Y/N)");
            answer = input.nextLine();
            if(answer.equalsIgnoreCase("n")){
                stillOrdering = false;
            } else {
                System.out.println("Enter another item number.");
            }
        }

        this.order = order; //can use = operator and pass reference since we want the order to be this specific list
    }

    public ArrayList<Object> getOrder() {
        return new ArrayList<>(order); //returning a copy of the order, rather than the actual order
    }
}