package machine;

import java.util.Scanner;

public class Machine {

    private int waterQuantity = 400;
    private int milkQuantity = 540;
    private int coffeeBeansQuantity = 120;
    private int disposableCups = 9;
    private int moneyAvailable = 550;

    enum Coffee {
        ESPRESSO(250, 0, 16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6);
        int water;
        int milk;
        int beans;
        int price;
        Coffee(int water, int milk, int beans, int price) {
            this.water = water;
            this.milk = milk;
            this.beans = beans;
            this.price = price;
        }

    }
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
                    chooseCoffee(sc);
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

    private void chooseCoffee(Scanner sc) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        switch (sc.nextLine()) {
            case "1":
                buyCoffee(Coffee.ESPRESSO);
                break;
            case "2":
                buyCoffee(Coffee.LATTE);
                break;
            case "3":
                buyCoffee(Coffee.CAPPUCCINO);
                break;
            case "back":
                break;
            default:
                break;
        }
    }

    private boolean checkCoffee(Coffee coffee) {
        StringBuilder missing = new StringBuilder("Sorry! Not enough:");
        boolean enoughResources = true;
        if (waterQuantity < coffee.water) {
            missing.append("\n\twater");
            enoughResources = false;
        }
        if (milkQuantity < coffee.milk) {
            missing.append("\n\tmilk");
            enoughResources = false;
        }
        if (coffeeBeansQuantity < coffee.beans) {
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
    private void buyCoffee(Coffee coffee) {
        if (checkCoffee(coffee)) {
            waterQuantity -= coffee.water;
            milkQuantity -= coffee.milk;
            coffeeBeansQuantity -= coffee.beans;
            disposableCups -= 1;
            moneyAvailable += coffee.price;
        }
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
