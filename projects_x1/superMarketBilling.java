package projects_x1;

import java.util.ArrayList;
import java.util.Scanner;

public class superMarketBilling {

    static String returnItems() {
        Scanner in = new Scanner(System.in);
        superMarketBilling SPM = new superMarketBilling();

        ArrayList<String> groceryItems = new ArrayList<String>();
        groceryItems.add(
                "Hoagie-Rolls-4ct,Italian-Five-Grain, Mini-Croissants 13ct, Buttercream-iced-Cupcakes, Apple-Pie. \n");
        groceryItems.add(
                "Bbq-Wieners, Beef-Jalapeno-Burgers, Buffalo-Wings, Steak-unit, Ribs-unit \n");
        groceryItems.add(
                "Welch's-Grape-Juice, Minute-Maid-Lemonade,Mountain-Dew, Gatorade, Lemon-Lime, Pure-Leaf-Sweet-Tea\n");
        groceryItems.add(
                "Doritos-Spicy-Sweet,Tostitos-Cantina , Takis-Fuego , Barbecue-Flavored-Potato-Chips , Ruffles \n");

        // Gas details
        ArrayList<String> gasDetails = new ArrayList<String>();
        gasDetails.add("\n 1-Gulf, 2 - Sunoco, 3 - BJ's, 4 - Angelo's, 5 - Prime-Energy");

        System.out.println(
                "Hello, Welcome to Deli SuperMarket System \n How can we help you?\nA) Taxes \nB) Groceries \nC) Gas");
        String choiceToDo = in.next();
        String toGiveBack = "";
        try {
            while (true) {

                if (choiceToDo.equals("Taxes") || choiceToDo.equals("Gas") || choiceToDo.equals("Groceries")) {
                    break;
                } else {
                    System.out.println("Invalid input, try again");
                    choiceToDo = in.next();
                }
            }
            if (choiceToDo.equals("Taxes")) {
                System.out.println("What is your income?");
                int incomeAmount = in.nextInt();
                System.out.println(
                        "What state do you live from the list below? \n MA \t Michigan \t Kansas \t NYC \t LA");
                String stateUser = in.next();

                double Taxes = SPM.Taxes(incomeAmount, stateUser);
                System.out.printf("$ %.3f is the amount of taxes to be paid for the %s", Taxes, stateUser);
            }

            if (choiceToDo.equals("Gas")) {
                System.out.println("The follwing options are available" + gasDetails.toString().strip()
                        + "\n What store location do you want to see? ");
                String gasValueLocation = SPM.gasLocation();
                toGiveBack = gasValueLocation;
            }

            if (choiceToDo.equals("Groceries")) {
                String costofOneItem = SPM.costOfGroceries(groceryItems.toString());
                toGiveBack = costofOneItem;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return toGiveBack;
    }

    String gasLocation() {
        Scanner in = new Scanner(System.in);
        String choiceGas = in.next();
        String[] locationsOfGas = {
                "Belle Chasse (9654 Hwy 23)", "124 Maple Street, Afton, NY 13730",
                "278 Middlesex Ave Medford, MA 02155",
                "Saugus (367 Lincoln Ave), 1898 S Clyde Morris Blvd Daytona Beach FL 32119" };

        try {
            while (true) {
                if (choiceGas.equals("")) {
                    System.out.println("Please enter a valid gas provider");
                    choiceGas = in.next();
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        String returnValue = "";
        switch (choiceGas) {
            case ("Gulf"):
                returnValue = locationsOfGas[0];
            case ("Sunoco"):
                returnValue = locationsOfGas[1];
            case ("BJ's"):
                returnValue = locationsOfGas[2];
            case ("Angelo's"):
                returnValue = locationsOfGas[3];
            case ("Prime-Energy"):
                returnValue = locationsOfGas[3];
        }
        return returnValue;
    }

    String costOfGroceries(String items) {
        Scanner in = new Scanner(System.in);

        System.out.println("We have the follwoing for the menu \n " + items);
        System.out.println("Which one do you want? ");
        String groceyItem = in.next();
        try {
            while (groceyItem.equals("")) {
                System.out.println("Please choose one of the options");
                System.out.println("We have the follwoing for the menu \n " + items);
                System.out.println("Which one do you want? ");
                groceyItem = in.next();
            }

        } catch (Exception e) {
            System.out.println("Something caused an exception");
        }
        // If nothing happens wrongly then we would check and return the cost of the
        // item choosen.
        int[] costItems = { 4, 3, 2, 2, 5, 5, 8, 2, 10, 1 };
        int randomNumber = (int) (Math.random() * 9) * 1;
        int valueBack = 1;
        switch (groceyItem) {
            case ("Hoagie-Rolls-4ct"):
                valueBack = costItems[randomNumber];
            case ("Italian-Fiven Grain"):
                valueBack = costItems[randomNumber];
            case ("Mini-Croissants-13ct"):
                valueBack = costItems[randomNumber];
            case ("Buttercream-Iced-Cupcakes"):
                valueBack = costItems[randomNumber];
            case ("Apple-Pie"):
                valueBack = costItems[randomNumber];
            case ("Bbq-Wieners"):
                valueBack = costItems[randomNumber];
            case ("Beef-Jalapeno-Burgers-unit"):
                valueBack = costItems[randomNumber];
            case ("Ribs/unit"):
                valueBack = costItems[randomNumber];
            case ("Welch's-Grape-Juice"):
                valueBack = costItems[randomNumber];
            case ("Minute-Miad-Lemonade"):
                valueBack = costItems[randomNumber];
            case ("Mountain-Dew"):
                valueBack = costItems[randomNumber];
            case ("Lemon-Lime"):
                valueBack = costItems[randomNumber];
            case ("Pure-Leaf-Sweet-Tea"):
                valueBack = costItems[randomNumber];
            case ("Gatorade"):
                valueBack = costItems[randomNumber];
            case ("Doritos-Spicy-Sweet"):
                valueBack = costItems[randomNumber];
            case ("Tostitos-Catina"):
                valueBack = costItems[randomNumber];
            case ("Takis-Fuego"):
                valueBack = costItems[randomNumber];
            case ("Barbecue-Flavored-Potato-Chips"):
                valueBack = costItems[randomNumber];
            case ("Ruffles"):
                valueBack = costItems[randomNumber];
        }
        return ("$" + valueBack);
    }

    double Taxes(double income, String state) {
        ArrayList<String> states = new ArrayList<String>();
        states.add("MA");
        states.add("Michigan");
        states.add("Kansas");
        states.add("NYC");
        states.add("LA");

        double[] statesArray = { 0.05, 0.0425, 0.0310, 0.040, 0.010 };
        double moneyOwed = 0;

        switch (state) {
            case ("MA"):
                moneyOwed = (income * statesArray[0]);
                System.out.println(statesArray[0]);
            case ("Michigan"):
                moneyOwed = (income * statesArray[1]);
            case ("Kansas"):
                moneyOwed = (income * statesArray[2]);
            case ("NYC"):
                moneyOwed = (income * statesArray[3]);
            case ("LA"):
                moneyOwed = (income * statesArray[4]);
        }

        return moneyOwed;
    }

    public static void main(String[] args) {
        superMarketBilling SPM = new superMarketBilling();
        String valueAll = SPM.returnItems();
        System.out.println("\n" + valueAll);
        System.out.println("Thank you for coming, hope to see you soon!");

    }
}