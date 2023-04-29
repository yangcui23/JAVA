

public class Cafe {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = ". Your total is $";
        String newMessage = "Your new total is $";
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 2.5;
        int latte = 3;
        int cappuccino = 5;
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1 + pendingMessage + displayTotalMessage); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //

        if(isReadyOrder4){
            System.out.println(customer4 + readyMessage + displayTotalMessage + cappuccino);
        } else {
            System.out.println(customer4 + pendingMessage);
        }

        if(isReadyOrder2) {
            System.out.println(customer2 + readyMessage + displayTotalMessage + (cappuccino+cappuccino));
        } else {
            System.out.println(customer2 + pendingMessage );
        }

        System.out.println(customer3 + newMessage + (latte-dripCoffee));
    }
}
