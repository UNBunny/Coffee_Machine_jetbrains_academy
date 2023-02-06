package machine;

import java.util.*;

public class Work {
    private final Scanner sc = new Scanner(System.in);
    private final int espressoWater = 250, espressoBeans = 16, espressoCost = 4;
    private final int latteWater = 350, latteMilk = 75, latteBeans = 20, latteCost = 7;
    private final int cappuccinoWater = 200, cappuccinoMilk = 100, cappuccinoBeans = 12, cappuccinoCost = 6;
    private int water, milk, beans, cups, money;

    public void machineHas() {
        System.out.printf("\nThe coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n\n", water, milk, beans, cups, money);
    }

    public Work(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    public void execute() {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = sc.next();
            if (action.equals("buy")) {
                Buy();
            } else if (action.equals("fill")) {
                Fill();
            } else if (action.equals("take")) {
                Take();
            } else if (action.equals("remaining")) {
                machineHas();
            } else if (action.equals("exit")) {
                break;
            }
        }
    }

    public void Buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (sc.next()) {
            case "1":
                makeCoffee(espressoWater, 0, espressoBeans, espressoCost);
                break;
            case "2":
                makeCoffee(latteWater, latteMilk, latteBeans, latteCost);
                break;
            case "3":
                makeCoffee(cappuccinoWater, cappuccinoMilk, cappuccinoBeans, cappuccinoCost);
                break;
            case "back":
                return;
            default:
                System.out.println("Unexpected option.");
                break;
        }
    }

    public void makeCoffee(int water, int milk, int beans, int cost) {
        if (water <= this.water) {
            if (beans <= this.beans) {
                if (milk <= this.milk) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    money += cost;
                    cups--;
                    this.water -= water;
                    this.milk -= milk;
                    this.beans -= beans;
                } else System.out.println("Sorry, not enough milk!\n");
            } else System.out.println("Sorry, not enough beans!\n");
        } else System.out.println("Sorry, not enough water!\n");
    }

    public void Fill() {
        System.out.println("\nWrite how many ml of water you want to add:");
        water += sc.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        milk += sc.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += sc.nextInt();

        System.out.println("Write how many disposable cups you want to add:");
        cups += sc.nextInt();
        System.out.println();
    }

    public void Take() {
        System.out.printf("\nI gave you $%d\n", money);
        money -= money;
        System.out.println();
    }
}