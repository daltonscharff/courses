
package randomnumsnoecker;
import java.util.Random;
/**
 *
 * @author 14dscharff
 */
public class RandomNumsNoecker {

    
    public static void main(String[] args) {
        Random generator = new Random();
        double num = 0; int count = 0;
        double avg = 0; double sum = 0;
        while (num != 10){
            while (num == 0){
                num = generator.nextInt(11);
            }
            if(num <10){
                count ++;
                sum += num;
                System.out.println("We generated a " + num + "." + "\n" +
                "Our sum is " + sum + ".");
                num = 0;
            }
        }
        avg = sum / count;
        avg = (Math.round(avg * 100.0)) / 100.0;
        System.out.println("OOPS! We generated a 10." + "\n" + 
                "So " + sum + " divided by " + count + " is " + avg + ".");
    }
}
