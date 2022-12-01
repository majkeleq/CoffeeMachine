package machine;

import java.util.Scanner;

public class Machine {

    private int waterQuantity = 400;
    private int milkQuantity = 540;
    private int coffeeBeansQuantity = 120;
    private int disposableCups = 9;
    private int moneyAvailable = 550;


    public void displayInfo() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", waterQuantity);
        System.out.printf("%d ml of milk\n", milkQuantity);
        System.out.printf("%d g of coffee beans\n", coffeeBeansQuantity);
        System.out.printf("%d disposable cups\n", disposableCups);
        System.out.printf("%d $ of money\n", moneyAvailable);
    }

    public void chooseAction() {
        Scanner sc = new Scanner(System.in);
        boolean toContinue = true;
        while (toContinue) {
            System.out.println("Write action (buy, fill, take, remaining, exit)");
            //String input = sc.nextLine();
            switch (sc.nextLine()) {
                case "buy":
                    buyCoffee(sc);
                    break;
                case "fill":
                    fillMachine(sc);
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    displayInfo();
                    break;
                case "exit":
                    toContinue = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void buyCoffee(Scanner sc) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        switch (sc.nextLine()) {
            case "1":
                if(checkEspresso()) {
                    buyEspresso();
                }
                break;
            case "2":
                if (checkLatte()) {
                    buyLatte();
                }
                break;
            case "3":
                if (checkCappuccino()) {
                    buyCappuccino();
                }
                break;
            case "back":
                break;
            default:
                break;
        }
    }

    private boolean checkEspresso() {
        StringBuilder missing = new StringBuilder("Sorry! Not enough:");
        boolean enoughResources = true;
        if (waterQuantity < 250) {
            missing.append("\n\twater");
            enoughResources = false;
        }
        if (coffeeBeansQuantity < 16) {
            missing.append("\n\tcoffee beans");
            enoughResources = false;
        }
        if (disposableCups < 1) {
            missing.append("\n\tcups");
            enoughResources = false;
        }
        if (enoughResources) {
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println(missing);
        }
        return enoughResources;
    }
    private void buyEspresso() {
        waterQuantity -= 250;
        coffeeBeansQuantity -= 16;
        disposableCups -=1;
        moneyAvailable += 4;
    }

    private boolean checkLatte() {
        StringBuilder missing = new StringBuilder("Sorry! Not enough:");
        boolean enoughResources = true;
        if (waterQuantity < 350) {
            missing.append("\n\twater");
            enoughResources = false;
        }
        if (milkQuantity < 75) {
            missing.append("\n\tmilk");
            enoughResources = false;
        }
        if (coffeeBeansQuantity < 20) {
            missing.append("\n\tcoffee beans");
            enoughResources = false;
        }
        if (disposableCups < 1) {
            missing.append("\n\tcups");
            enoughResources = false;
        }
        if (enoughResources) {
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println(missing);
        }
        return enoughResources;
    }
    private void buyLatte() {
        waterQuantity -= 350;
        milkQuantity -= 75;
        coffeeBeansQuantity -= 20;
        disposableCups -=1;
        moneyAvailable += 7;
    }

    private boolean checkCappuccino() {
        StringBuilder missing = new StringBuilder("Sorry! Not enough:");
        boolean enoughResources = true;
        if (waterQuantity < 200) {
            missing.append("\n\twater");
            enoughResources = false;
        }
        if (milkQuantity < 100) {
            missing.append("\n\tmilk");
            enoughResources = false;
        }
        if (coffeeBeansQuantity < 12) {
            missing.append("\n\tcoffee beans");
            enoughResources = false;
        }
        if (disposableCups < 1) {
            missing.append("\n\tcups");
            enoughResources = false;
        }
        if (enoughResources) {
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println(missing);
        }
        return enoughResources;
    }
    private void buyCappuccino() {
        waterQuantity -= 200;
        milkQuantity -= 100;
        coffeeBeansQuantity -= 12;
        disposableCups -=1;
        moneyAvailable += 6;
    }

    private void fillMachine(Scanner sc) {
        System.out.println("Write how many ml of water you want to add:");
        waterQuantity += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milkQuantity += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeansQuantity += sc.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        disposableCups += sc.nextInt();
        sc.nextLine();
    }

    private void takeMoney() {
        System.out.println("I give you $"+moneyAvailable);
        moneyAvailable = 0;
    }

}
