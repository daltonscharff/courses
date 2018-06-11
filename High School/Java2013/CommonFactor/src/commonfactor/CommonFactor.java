package commonfactor;
import java.util.Scanner;
/**
 *
 * @author 14dscharff
 */
public class CommonFactor {

    
    public static void main(String[] args) {
        int num1 = 0, num2 = 0, count, divisor1, counter = 0, temp;
        double ans;
        Scanner reader = new Scanner(System.in);
        System.out.println("This program will list common factors.");
        System.out.print("Please insert your first number: ");
        num1 = reader.nextInt();
        System.out.print("Please insert your second number: ");
        num2 = reader.nextInt();
        if (num2 < num1){
            temp = num1;
            num1 = num2;
            num2 = temp;
        }
        for (count = 1; count <= num1; count ++){
            divisor1 = count;
            ans = num1 % divisor1;
                if (ans == 0.0){
                ans = num2 % divisor1;
                    if (ans == 0.0)
                    System.out.println("One common factor of " + num1 + " and " + num2 + " is " + divisor1 + ".");
                    counter ++;
            }
        }
        System.out.println("There are " + counter + " factors of " + num1 + " and " + num2 + ".");
    }
}

