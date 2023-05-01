import java.util.ArrayList;
import java.util.Arrays;
import java.text.DecimalFormat;
import java.util.Date;
public class CafeUtil {
    
    public int getStreakGoal(int count){
        int i = 0;
        int sum = 0;
        while(i < count){
            sum = sum + (i + 1);
            i++;
        }
        return sum;
    }


    public double getOrderTotal(double[] prices){
        double total = 0.0;
        for(int i = 0; i <prices.length; i++){
            total += prices[i];
        }
        
        return total;
    }


    public void displayMenu(ArrayList<String> menu){
        for(int i = 0; i < menu.size(); i++){
            System.out.println(i + " " + menu.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name: ");
        String name = System.console().readLine();
        System.out.println(("Hello, " + name));
        System.out.println("There are " + customers.size() + " in front of you.");
        customers.add(name);
    }

    
}
