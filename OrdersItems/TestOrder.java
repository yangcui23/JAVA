import java.util.ArrayList;
public class TestOrder {
    public static void main(String[] args) {
    
        // Menu items   
        Item menuItem1 = new Item();
        menuItem1.name = "mocha";
        menuItem1.price = 5.5;
        Item menuItem2 = new Item();
        menuItem2.name = "latte";
        menuItem2.price = 3.0;
        Item menuItem3 = new Item();
        menuItem3.name = "drip coffee";
        menuItem3.price = 1.5;
        Item menuItem4 = new Item();
        menuItem4.name = "cappuccino";
        menuItem4.price = 2;
        
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        order1.name = "Cindhuri";
        System.out.println(order1.total);
        Order order2 = new Order();
        order2.name = "Jimmy";
        Order order3 = new Order();
        order3.name = "Noah";
        Order order4 = new Order();
        order4.name = "Sam";

        // Application Simulations

        order2.items.add(menuItem1);
        order2.total += menuItem1.price;
        order2.ready = true;

        order3.items.add(menuItem4);
        order3.total += menuItem4.price;

        order4.items.add(menuItem2);
        order4.items.add(menuItem2);
        order4.total += menuItem2.price * 2;

        order1.ready = true;
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);

        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);

        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
    }
}
