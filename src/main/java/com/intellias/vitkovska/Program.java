package com.intellias.vitkovska;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Program {
    List<Product> listOfProducts = new ArrayList<>();
    List<User> listOfUsers = new ArrayList<>();
    Map<Product, List<User>> boughtProducts = new HashMap<>();
    Map<User, List<Product>> userProducts = new HashMap<>();

    public void run() {
        createProducts();
        createUsers();
        fillMaps();
        System.out.println("Hello, user!");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                System.out.println();
                navigation();
                caseLogic(reader);
            }
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    private void createProducts() {

        listOfProducts.add(new Product("0", "Iphone11", 22000.0));
        listOfProducts.add(new Product("1", "MacBookAir", 33000.0));
        listOfProducts.add(new Product("2", "Coca-cola", 17.5));
    }

    private void createUsers() {

        listOfUsers.add(new User("0", "Olena", "Vitkovska", 40000.50));
        listOfUsers.add(new User("1", "Serhii", "Vitkovskiy", 100000.0));
        listOfUsers.add(new User("2", "Viktor", "Pavlik", 10.00));
    }

    private void fillMaps() {
        boughtProducts.put(listOfProducts.get(0), new ArrayList<>());
        boughtProducts.put(listOfProducts.get(1), new ArrayList<>());
        boughtProducts.put(listOfProducts.get(2), new ArrayList<>());

        userProducts.put(listOfUsers.get(0), new ArrayList<>());
        userProducts.put(listOfUsers.get(1), new ArrayList<>());
        userProducts.put(listOfUsers.get(2), new ArrayList<>());
    }

    private void navigation() {
        System.out.println("Please, choose what do yo want to do");
        System.out.println("If you want to see list of products, enter 1");
        System.out.println("If you want to see list of users, enter 2");
        System.out.println("If you want to buy product, enter 3");
        System.out.println("If you want to see what you have bought, enter 4");
        System.out.println("If you want to see which users have bought some product, enter 5");
        System.out.println("If you want to exit, enter 0");
    }

    private void caseLogic(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        switch (line) {
            case "1" -> System.out.println(listOfProducts);
            case "2" -> System.out.println(listOfUsers);
            case "3" -> buyProduct(reader);
            case "4" -> userProducts(reader);
            case "5" -> boughtProducts(reader);
            case "0" -> System.exit(0);
        }
    }

    private void buyProduct(BufferedReader reader) throws IOException {
        System.out.println(listOfProducts);
        System.out.println("Please, enter id of product you want to buy");
        String productIndex = reader.readLine();
        System.out.println(listOfUsers);
        System.out.println("Please, enter your id");
        String userIndex = reader.readLine();
        try {
            if (listOfUsers.get(Integer.parseInt(userIndex)).getAmountOfMoney() - listOfProducts.get(Integer.parseInt(productIndex)).getPrice() < 0) {
                throw new NotEnoughMoneyException();
            } else {
                listOfUsers.get(Integer.parseInt(userIndex)).setAmountOfMoney(listOfUsers.get(Integer.parseInt(userIndex)).getAmountOfMoney() - listOfProducts.get(Integer.parseInt(productIndex)).getPrice());
                boughtProducts.get(listOfProducts.get(Integer.parseInt(productIndex))).add(listOfUsers.get(Integer.parseInt(userIndex)));
                userProducts.get(listOfUsers.get(Integer.parseInt(userIndex))).add(listOfProducts.get(Integer.parseInt(productIndex)));
                System.out.println("Successful purchase, " + listOfUsers.get(Integer.parseInt(userIndex)).getFistName() + "! You have bought " + listOfProducts.get(Integer.parseInt(productIndex)).getName());

            }
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
    }

    private void userProducts(BufferedReader reader) throws IOException {
        System.out.println("Please, enter your id");
        System.out.println(listOfUsers);
        String userIndex = reader.readLine();
        if (userProducts.get(listOfUsers.get(Integer.parseInt(userIndex))).isEmpty()) {
            System.out.println("This user hasn't bought anything yet");
        }
        System.out.println(userProducts.get(listOfUsers.get(Integer.parseInt(userIndex))));
    }

    private void boughtProducts(BufferedReader reader) throws IOException {
        System.out.println("Please, enter id of product you want to see");
        System.out.println(listOfProducts);
        String productIndex = reader.readLine();
        if (boughtProducts.get(listOfProducts.get(Integer.parseInt(productIndex))).isEmpty()) {
            System.out.println("No one has bought this product yet");
        }
        System.out.println(boughtProducts.get(listOfProducts.get(Integer.parseInt(productIndex))));
    }
}
