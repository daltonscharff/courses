/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.pkg2;
import java.io.*;
import java.util.*;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Main {
    private ArrayList<Product> arrayOfProducts = new ArrayList<Product>();
    private File filename;
    private double balance;
    private Product product;
    private int menuSelection;
    private int menuSelection2;
    private int arraySize;
    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        boolean repeater = true;
        Main m = new Main();
        File filename = new File(m.getFilename());
        m.openFile(filename);

        while (repeater == true){
            m.printMainMenu();
            m.menuSelection = m.getValidInteger(0, m.arrayOfProducts.size()+1, "Please make a selection: ");
            if (m.menuSelection == 0){
                PrintWriter outputFile = new PrintWriter(filename);
                outputFile.println(m.balance);
                for (int count = 0; count < m.arraySize; count++){
                    outputFile.println(m.arrayOfProducts.get(count).getName() + " " + m.arrayOfProducts.get(count).getPrice() + " " + m.arrayOfProducts.get(count).getQuantity());
                }
                outputFile.close();
                m.exit();
            }else if (m.menuSelection > 0 && m.menuSelection <= m.arrayOfProducts.size()){
                m.menuSelection2 = m.changeProduct(m.arrayOfProducts.get(m.menuSelection-1));
                if (m.menuSelection2 == 0){
                    //Do nothing.
                }else if(m.menuSelection2 == 1){
                    m.arrayOfProducts.set(m.menuSelection-1, m.printSellMenu(m.arrayOfProducts.get(m.menuSelection-1), m.arrayOfProducts.get(m.menuSelection-1).getQuantity()));
                }else if(m.menuSelection2 == 2){
                    m.arrayOfProducts.set(m.menuSelection-1, m.printBuyMenu(m.arrayOfProducts.get(m.menuSelection-1)));
                }else if(m.menuSelection2 == 3){
                    m.arrayOfProducts.set(m.menuSelection-1, m.printChangePriceMenu(m.arrayOfProducts.get(m.menuSelection-1)));
                }
            }else{
                m.arrayOfProducts.add(m.newProduct());
            }
            m.arraySize = m.arrayOfProducts.size();
        }
    }
    /**
     * Makes sure input filename is valid.
     * @return String of filename
     * @throws IOException 
     */
    private String getFilename() throws IOException{
        boolean repeater = true;
        Scanner reader = new Scanner(System.in);
        String input = "";
        while (repeater == true){
            System.out.print("Please enter a filename: ");
            input = reader.next();
            File filename = new File(input);
            if (filename.exists()){
                repeater = false;
            }else{
                System.out.println("Please enter a valid filename and try again.");
            }
        }
        return input;
    }
    /**
     * Makes sure an integer entered by user is between a given range
     * @param lower Lowest possible value
     * @param upper Highest possible value
     * @param message User prompt
     * @return Valid integer
     */
    private int getValidInteger(int lower, int upper, String message){
        boolean repeater = true;
        int input = -1;
        Scanner reader = new Scanner(System.in);
        while (repeater == true){
            System.out.print(message);
            input = reader.nextInt();
            if (input >= lower && input <= upper){
                repeater = false;
            }else{
                System.out.println("Please input a number between " + lower + " and " + upper + ".");
            }
        }
        return input;
    }
    /**
     * Makes sure a double entered by user is between a given range
     * @param lower Lowest possible value
     * @param upper Highest possible value
     * @param message User prompt
     * @return Valid integer
     */
    private double getValidDouble(double lower, double upper, String message){
        boolean repeater = true;
        double input = -1;
        Scanner reader = new Scanner(System.in);
        while (repeater == true){
            System.out.print(message);
            input = reader.nextDouble();
            if (input >= lower && input <= upper){
                repeater = false;
            }else{
                System.out.println("Please input a number between " + lower + " and " + upper + ".");
            }
        }
        return input;
    }
    /**
     * Parses file line by line to be read into the setFromLine method in the
     * Product class
     * @param filename Valid file to be read
     * @return Method completed successfully
     * @throws IOException 
     */
    private boolean openFile(File filename) throws IOException{
        Scanner parse = new Scanner(filename);
        balance = parse.nextDouble();
        while(parse.hasNextLine() == true){
            Product product = new Product();
            arrayOfProducts.add(product.setFromLine(parse.nextLine()));
        }
        arrayOfProducts.remove(0);
        return true;
    }
    /**
     * Displays a menu for users to interact with each product
     * @param p Product of interest
     * @return Which option the user would like to perform
     */
    private int changeProduct(Product p){
        System.out.printf("\nCurrent balance: $%.2f\nCurrent quantity: %d\nCurrent price: $%.2f\n", balance, p.getQuantity(),p.getPrice());
        System.out.printf("1. Sell %s\n2. Buy %s\n3. Change Price\n0. Return to Main Menu\n", p.getName(), p.getName());
        menuSelection2 = getValidInteger(0, 3, "Please enter a choice: ");
        return menuSelection2;
    }
    /**
     * Creates a new product
     * @return Product that had just been created
     */
    private Product newProduct(){
        Product newProd = new Product();
        boolean repeater1 = true;
        boolean repeater2 = true;
        boolean repeater3 = true;
        Scanner reader = new Scanner(System.in);
        while (repeater1 == true){
            System.out.print("Please enter the name of the new product: ");
            if (newProd.setName(reader.nextLine()) == false){
                System.out.println("Please enter a valid name.");
            }else{
                repeater1 = false;
            }
        }
        while (repeater2 == true){
            System.out.print("Please enter the quantity: ");
            newProd.setQuantity(reader.nextInt());
            repeater2 = false;
        }
        while (repeater3 == true){
            System.out.print("Please enter the price: ");
            if (newProd.setPrice(reader.nextDouble()) == false){
                System.out.println("Please enter a valid price.");
            }else{
                repeater3 = false;
            }
        }
        return newProd;
    }
    /**
     * Displays the main menu for the user to interact with
     */
    private void printMainMenu(){
        System.out.println("\n***** Main Menu *****");
        System.out.printf("Current balance: $%.2f\n", balance);
        for (int index = 0; index < arrayOfProducts.size(); index++){
                System.out.printf("%d. %-20s %,10d at $%.2f\n", index + 1, arrayOfProducts.get(index).getName(), arrayOfProducts.get(index).getQuantity(), arrayOfProducts.get(index).getPrice());
        }
        System.out.printf("%d. Add New Item\n", arrayOfProducts.size() + 1);
        System.out.println("0. Exit\n");
    }
    /**
     * Displays the menu where a user can sell products
     * @param p Product being sold
     * @param quantity Amount currently available
     * @return Updated product information
     */
    private Product printSellMenu(Product p, int quantity){
        Scanner reader = new Scanner(System.in);
        String warning = "yes";
        int sell = getValidInteger(0, 999999999, "Amount to sell: ");
        if (sell > quantity){
            System.out.print("Warning! Selling more than are in stock!\nDo you wish to proceed (yes or no): ");
            warning = reader.next();
        }
        if (warning.equalsIgnoreCase("no")){
            System.out.println("Go ahead and try that again.");
        }else if(warning.equalsIgnoreCase("yes")){
            p.setQuantity(p.getQuantity() - sell);
            balance += sell * p.getPrice();
            System.out.println("----------------------------------------------");
        }else{
            System.out.println("Please input 'no' or 'yes'!"); 
        }
        return p;
    }
    /**
     * Displays the menu where a user can buy products
     * @param p Product being bought
     * @return Updated product information
     */
    private Product printBuyMenu(Product p){
        double buyPrice = getValidDouble(0, 999999999, "Buying price: $");
        int buy = getValidInteger(0, 999999999, "Amount to buy: ");
        if (buy * buyPrice > balance){
            System.out.println("You are spending more than you have. Try again.");
        }else{
            p.setQuantity(p.getQuantity() + buy);
            balance -= buy * buyPrice;
            System.out.println("----------------------------------------------");
        }
        return p;
    }
    /**
     * Displays the menu where a user can change a product's price
     * @param p Product that will have its price changed
     * @return Updated product information
     */
    private Product printChangePriceMenu(Product p){
        double newPrice = getValidDouble(0, 999999999, "New price: $");
        p.setPrice(newPrice);
        System.out.println("----------------------------------------------");
        return p;
    }
    /**
     * Exits the program
     */
    private void exit(){
        System.exit(0);
    }
}
