package project.pkg1.revised;
import java.io.*;
import java.util.*;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */

@SuppressWarnings("unchecked")
public class Project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        double currentBalance = 0;
        String tempItem = "", fileName = "";
        int index = 0, mainMenuSelection = -1, productSelection = -1;
        Scanner getFileName = new Scanner(System.in);
        boolean correctName = false, wasArg = true, wasCaught = false, repeater = true;
        
        ArrayList<String> item = new ArrayList();
        ArrayList<Double> price = new ArrayList();
        ArrayList<Integer> quantity = new ArrayList();
        
        while (correctName == false){
            try{
                fileName = args[0];
            }catch (IndexOutOfBoundsException e){
                System.out.print("Please enter a file name: ");
                fileName = getFileName.next();  
            }
            try (Scanner parse = new Scanner(new File(fileName))){
                currentBalance = Double.parseDouble(parse.nextLine());
                while (parse.hasNextLine() && parse.hasNext() == true){
                    tempItem  = parse.next();
                    while (parse.hasNextDouble() == false && parse.hasNextInt() == false){
                        tempItem += " " + parse.next();
                    }
                    item.add(tempItem);
                    price.add(parse.nextDouble());
                    quantity.add(parse.nextInt());
                }
                correctName = true;
            }catch (IOException e){
                System.out.println("File not found!");
                try{
                    args[0] = "";
                }catch (IndexOutOfBoundsException g){
                    wasArg = false;
                }finally{
                    if (wasArg == true){
                        System.exit(0);
                    }
                }
            }
        }
        
        while (mainMenuSelection != 0){
            index = 0; mainMenuSelection = -1; productSelection = -1; repeater = true;         
            
            //Main Menu
            Scanner reader = new Scanner(System.in);
            System.out.println("\n***** Main Menu *****");
            System.out.printf("Current balance: $%.2f\n", currentBalance);
            for (index = 0; index < item.size(); index++){
                System.out.printf("%d. %-20s %,10d at $%.2f\n", index + 1, item.get(index), quantity.get(index), price.get(index));
            }
            System.out.printf("%d. Add New Item\n", index + 1);
            System.out.println("0. Exit\n");
             
            while (repeater == true){
                System.out.print("Please enter a choice: ");
                mainMenuSelection = reader.nextInt();

                if (mainMenuSelection <= index + 1 && mainMenuSelection >= 0){
                    index = mainMenuSelection - 1;
                    repeater = false;
                }else{
                    System.out.println("Please enter a number on the list!");
                    mainMenuSelection = 0;
                }
            }
            
            System.out.println("------------------------------------");
            
            //Product Selection
            if (mainMenuSelection == 0){
                break;
                
            //Add A Product
            }else if(mainMenuSelection == (item.size() + 1)){
                System.out.print("Please enter the name of the new item: ");
                String test = reader.nextLine();
                String test2 = reader.nextLine();
                for (int count = 0; count < item.size(); count ++){
                    if (test2.equalsIgnoreCase(item.get(count))){
                        wasCaught = true;
                    }
                }
                if (wasCaught == false){
                    item.add(test2);
                    repeater = true;
                    while (repeater == true){
                        System.out.print("Please enter the price of the " + item.get(index) + ": $");
                        Double temp = reader.nextDouble();
                        if (temp > 0){
                            price.add(temp);
                            repeater = false;
                        }else{
                            System.out.println("Please enter a positive number.");
                        }
                    }
                    repeater = true;
                    while (repeater == true){
                        System.out.print("Please enter the quantity of " + item.get(index) + " in stock: ");
                        int temp = reader.nextInt();
                        if (temp > 0){
                            quantity.add(temp);
                            repeater = false;
                        }else{
                            System.out.println("Please enter a positive number!");
                        }
                    }
                }else{
                    System.out.println("You already have some of that item in stock!");
                }
                System.out.println("------------------------------------");
            }else{
                repeater = true;
                while (repeater == true){
                    System.out.printf("\nCurrent balance: $%.2f\nCurrent quantity: %d\nCurrent price: $%.2f\n", currentBalance, quantity.get(index),price.get(index));
                    System.out.printf("1. Sell %s\n2. Buy %s\n3. Change Price\n0. Return to Main Menu", item.get(index), item.get(index), item.get(index));
                    System.out.print("\nPlease enter a choice: ");
                    try{
                        productSelection = reader.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Please enter an integer value only!\n");
                    }
                    
                    //Sell Product
                    int sell = 0;
                    String warning = "yes";
                    if (productSelection == 1){
                        repeater = true;
                        while (repeater == true){
                            System.out.printf("\nAmount to Sell (current quantity): %d): ", quantity.get(index));
                            sell = reader.nextInt();
                            if (sell < 0){
                                System.out.println("Please enter a positive number!");
                            }else{
                                repeater = false;
                            }
                        }
                        if (sell > quantity.get(index)){
                            System.out.print("Warning! Selling more than are in stock!\nDo you wish to proceed (yes or no): ");
                            warning = reader.next();
                        }
                        if (warning.equalsIgnoreCase("no")){
                            System.out.println("Go ahead and try that again.");
                        }else if(warning.equalsIgnoreCase("yes")){
                            quantity.set((index), quantity.get(index) - sell);
                            currentBalance += sell * price.get(index);
                            System.out.println("----------------------------------------------");
                        }else{
                            System.out.println("Please input 'no' or 'yes'!"); 
                        }
                    }


                    //Buy Product
                    int buy = 0;
                    double cost = 0;
                    double tempCurrentBalance = currentBalance;
                    int tempQuantity = 0;
                    if (productSelection == 2){
                        repeater = true;
                        while (repeater == true){
                            System.out.print("\nAmount to Buy: ");
                            buy = reader.nextInt();
                            if (buy > 0){
                                tempQuantity = buy + quantity.get(index);
                                repeater = false;
                            }else{
                                System.out.print("Please enter a positive value.");
                            }
                        }
                        
                        repeater = true;
                        while (repeater == true){
                            System.out.print("Price Per Item: $");
                            cost = reader.nextDouble();
                            if (cost > 0){
                                tempCurrentBalance -= cost * buy;
                                repeater = false;
                            }else{
                                System.out.println("Please enter a positive value.");
                            }
                        }

                        if (tempCurrentBalance >= 0){
                            currentBalance = tempCurrentBalance;
                            quantity.set((index), tempQuantity);
                        }else{
                            System.out.println("You are spending more money than you have. This is not allowed.");
                        }
                        
                        System.out.println("------------------------------------");
                    }
                    
                    //Change Price
                    double newPrice;
                    if (productSelection == 3){ 
                        repeater = true;
                        while (repeater == true){
                            System.out.print("New Price: $");
                            newPrice = reader.nextDouble();
                            if (newPrice < 0){
                                System.out.println("Please enter a positive decimal value only!\n");
                            }else{
                                price.set(index, newPrice);
                                repeater = false;
                            }
                        }
                        System.out.println("------------------------------------");
                    }
                    
                    //Catches Product Selection Input Error
                    if (productSelection > 3 || productSelection < 0){
                        System.out.println("Please enter a number on the list!");
                    }
                    
                    //Exit Product Selection Menu
                    if (productSelection != 0){
                        repeater = true;
                    }else{
                        repeater = false;
                    }
                }
                System.out.println("------------------------------------");
            }
        }
        if (mainMenuSelection == 0){
            //System.out.println("Overwrite Successful");
            PrintWriter outputFile = new PrintWriter(new File(fileName));
            outputFile.println(currentBalance);
            for (int count = 0; count < item.size(); count++){
                outputFile.println(item.get(count) + " " + price.get(count) + " " + quantity.get(count));
            }
            outputFile.close();
        }
    }   
}
