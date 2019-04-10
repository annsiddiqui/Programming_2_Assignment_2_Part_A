/**
 * Warehouse contains the different items in stock
 * Remember: NO USER INPUTS 
 * @author Qurrat-al-Ain Siddiqui
 *
 */
public class Warehouse
{
    // instance variables (fields)
    private final int MAX_INVENTORY = 60;
    private Item [] inventory = new Item[MAX_INVENTORY]; //Array

    // the constructor
    /**
     * Constructor for Warehouse class 
     */
    public Warehouse()
    {    
    }

    /**
     * This is the hardcoded data to be loaded into the instance variables.  
     */
    public int loadData()
    {
        final int NUM_ITEM = 5;

        Item itemInfo = new Item("A11111","Widgets", 30, 50, 70, 2.50, 20, 50);
        inventory[0] = itemInfo;

        itemInfo = new Item("B22222", "Gadgets", 10, 20, 0, 4.00, 50, 100);
        inventory[1] = itemInfo;

        itemInfo = new Item("C33333", "Trinkets", 100, 20, 35, 3.75, 80, 150);
        inventory[2] = itemInfo;

        itemInfo = new Item("D44444", "Pickets", 0, 100, 20, 8.35, 25, 75);
        inventory[3] = itemInfo;

        itemInfo = new Item("E55555", "Sockets", 200, 300, 150, 1.00, 200, 400);
        inventory[4] = itemInfo;

        //("A11111", "Widgets", 30, 50, 70, 2.50, 20, 50);
        //("B22222", "Gadgets", 10, 20, 0, 4.00, 50, 100);
        //("C33333", "Trinkets", 100, 20, 35, 3.75, 80, 150);
        //("D44444", "Pickets", 0, 100, 20, 8.35, 25, 75);
        //("E55555", "Sockets", 200, 300, 150, 1.00, 200, 400);
        // number of items is 5;

        return NUM_ITEM;
    }
    
    /**
     * This method validates the item number, then finds and outputs the 
     * information of inputted item number.
     *
     * @param       itemNum         the inputted item number
     *              totalItem       the total number of items in inventory
     * 
     */
    public void inventoryInfo(String itemNum , int totalItems)
    {
        int item;
        String output;

        item = findItem(totalItems , itemNum); //Finding the intentory item
        output = inventory[item].print(); //Calling method in Item class with output string

        System.out.print(output);  //Outputting data
    }
    
    /**
     * This method processes the inputted item number's data 
     * and the amount of invenory ordered.
     * 
     * This updates the data of the on order.
     * 
     * @param       itemNum         the inputted item number
     *              totalItems      the total number of items in inventory
     *              order           the inputted amount being ordered 
     * 
     */
    public void orderInventory(String itemNum , int totalItems , int order)
    {
        int item;

        item = findItem(totalItems , itemNum); //Finding the intentory item
        inventory[item].ordering(order); //Calls for method in Item class to processes order 

        System.out.println("Item has been orderd."); //Prints completion message
    }

    /**
     * This method processes the inputted item number's data and the received 
     * shipment of inventory from supplier.
     * 
     * The method validates if the inputted value of 
     * received shipment of inventory from supplier is valid and 
     * then updates item data accordingly.
     * 
     * @param       itemNum         the inputted item number
     *              totalItems      the total number of items in invetory
     *              shipment        the inputted amount recived from shipment
     */
    public void shipmentReceived(String itemNum , int totalItems , int shipment)
    {
        int item;
        int onHand;
        boolean valid = false;

        item = findItem(totalItems , itemNum); //Finding the inventory item
        valid = inventory[item].validOrder(shipment); //To see if shipment value is valid(on order is not negative)
        
        if(valid == true)//Process if shipment value is valid
        {
            onHand = inventory[item].getOnHand(); //Call for on hand value from Item class
            onHand = onHand + shipment; //Adds shipment to on hand value
            inventory[item].setOnHand(onHand); //Calls Item class method to returns/sets on hand value back to Item class 
            System.out.println("Item information has been updated."); //Output completion message           
        }
        else //Error message if on order will go under zero/negative (invalid shipment value)
        {
            System.out.println("Invalid value. The on order amount caonnt be negative."); //Error message
        }
    }
    
    /**
     * This method processes the inputted item number's data and the 
     * amount of inventory being returned to supplier. 
     * 
     * The method validates if the inputted amount of inventory bring 
     * returned is valid and then updates item data accordingly.
     * 
     * @param       itemNum         the inputted item number
     *              totalItems      the total number of items in inventory
     *              returnAmt       the inputted amount being returned to supplier
     */
    public void returnItems(String itemNum , int totalItems , int returnAmt)
    {
        int item;
        int onHand;
        int zero;

        zero = 0;

        item = findItem(totalItems , itemNum); //Finding the intentory item
        onHand = inventory[item].getOnHand(); //Calls for on hand value from Item class 

        onHand = onHand - returnAmt; //Calculates new on hand amount 

        if(onHand >= zero) //Valid on hand value (not negative)
        {
            inventory[item].setOnHand(onHand); //Calls Item class method to sets/returns onhand amount back to Item class 
            System.out.println("Item information has been updated."); //Output completetion message 
        }
        else //Invalid on hand value (negative)
        {
            System.out.println("Invalid value. The on hand amount cannot be negative."); //Error message 
        }
    }

    /**
     * This method processes the inputted item number's data and the 
     * amount of inventory being shipped to customer.
     * 
     * The method validates if the inputted amount of inventory inputted 
     * is valid and then updates item data accordingly.
     * 
     * @param       itemNum         the inputted item number
     *              totalItems      the total number of items in inventory
     *              amtShipped      the inputted amount being shipped to customer
     *              
     */
    public void shiptoCustomer(String itemNum , int totalItems , int amtShipped)
    {
        int item;
        int onHand;
        int committed;
        int diff;

        item = findItem(totalItems , itemNum); //Finding the intentory item
        onHand = inventory[item].getOnHand(); //Calls for on hand amount from the Item class
        committed = inventory[item].getCommitted(); //Calls for committed amount from the Item class 

        
        if(amtShipped <= committed) //Input amount is valid 
        {
            inventory[item].underCommitted(amtShipped); //Calls method from Item class to update committed value
            System.out.println("Shipment is complete."); //Outputs completion message
        }
        else if(amtShipped > committed && amtShipped < onHand) //Inputted amount is valid
        {
            diff = amtShipped - committed; //Calculate difference of inputted amount and committed 
            onHand = onHand - diff; //Calculates new on hand amount 
            inventory[item].setOnHand(onHand); //Calls Item class method to returns/sets new on hand amount
            inventory[item].overCommitted(amtShipped); //Calls method from Item class to update committed value 
            System.out.println("Shipment is complete."); //Ouputs completion message 
        }
        else //Input amount is invalid 
        {
            System.out.println("Shipment cannot be made."); //Error message
        }
    }

    /**
     * This method processes the inputted item number's data 
     * and the amount of inventory the customer ordered.
     * 
     * The data is updated according to the inputted amount. 
     * 
     * @param       itemNum         the inputted item number
     *              totalItems      the total number of items in invetory
     *              orderByCust     the inputted amount the customer ordered
     */
    public void customerOrder(String itemNum , int totalItems , int orderByCust)
    {
        int item;
        int onHand;
        int diff;

        item = findItem(totalItems , itemNum); //Finding the inventory item
        onHand = inventory[item].getOnHand(); //Calls the on hand amount from the Item class
        
        if(orderByCust <= onHand) //If inputted amount is smaller than the on hand value from Item class
        {
            onHand = onHand - orderByCust; //Calculates new on hand value
            inventory[item].setOnHand(onHand);//Calls Item class method to returns/sets new on hand amount 
            inventory[item].underOnHand(orderByCust);//Calls method in Item class to update committed amount 
            System.out.println("Process has been complete."); //Output completion message
        }
        else
        {
            diff = orderByCust - onHand; //Calculates new on hand value
            inventory[item].overOnHand(orderByCust , diff); //Calls method in Item class to update committed amount and on order amount 
            onHand = 0; //New on hand value 
            inventory[item].setOnHand(onHand); //Calls Item class method to returns/sets new on hand amount 
            System.out.println("Process has been complete."); //Output completion message
        }
    }

    /**
     * This method processes the imputted item number's dat and the amount of inventory the customer is returning
     * The method updates the data of the on hand accordingly.
     * 
     * @param       itemNum     the inputted item number
     *              totalItems  the total number of items in invetory
     *              returnAmt   the inputted amount the customer is returning 
     */
    public void customerReturn(String itemNum , int totalItems , int returnedAmt)
    {
        int item;
        int onHand;

        item = findItem(totalItems , itemNum); //Finding the intentory item
        onHand = inventory[item].getOnHand(); //Calls for on hand value from Item class 

        onHand = onHand + returnedAmt; //Calculates new on hand value 

        inventory[item].setOnHand(onHand); //Calls Item method to returns/sets new on hand amount 
        System.out.println("Item information has been updated."); //Output completion message
    }

    /**
     * This method ouputs the end of the day report.
     * This method calls a method from the Item class to 
     * calculate the item value and also calls a method to do the automatic ordering.
     * 
     * @param       total       the total number of items in inventory 
     */
    public void endDay(int total)
    {
        int i;
        double value;
        String output;
        
        //Output
        System.out.format("%11s%5s" , "Item Number" , " "); 
        System.out.format("%10s%5s" , "Item Name" , " ");
        System.out.format("%7s%5s" , "On Hand" , " ");
        System.out.format("%9s%5s" , "Committed" , " ");
        System.out.format("%8s%5s" , "On Order" , " ");
        System.out.format("%10s%5s" , "Unit Price" , " ");
        System.out.format("%10s%5s%n" , "Item Value" , " ");
        
        //Output of item details
        for(i = 0; i < total; i++)
        {
            value = inventory[i].itemValue(); //Calls method from Item class to calculate item value
            output = inventory[i].endOfDay(value); //Calls method from Item class to return output string
            System.out.println(output); //Output data
        }

        for(i = 0; i < total; i++)
        {
            inventory[i].autoOrder(); //Automatic ordering 
        }
        
        System.out.println();
        System.out.println("Automatic ordering is complete."); //Output completion message 
    }

    //Helper Methods 
    /**
     * This method is used to determine whether the user inputted item number
     * is valid or not.
     * 
     * @param       itemNo      the inputted item number
     *              total       the total number of items in inventory 
     *              
     * @return      valid
     */
    public boolean validator(String itemNo , int total)
    {
        boolean valid = false;
        String items;
        int i;

        i = 0;
        
        while(i < total && valid == false)
        {
            items = inventory[i].getItemNo(); //Gets item number from Item class
            
            if(itemNo.equals(items)) //Valid item number 
            {
                valid = true;
            }

            i++;
        }

        //Invalid item number ouput
        if(valid == false)
        {
            System.out.println();
            System.out.println("Invalid item number."); //Error message
        }

        return valid;
    }
    
    /**
     * This method finds the item which is being called for 
     * and returns the index of that item.
     * 
     * @param       total       the total number of items in inventory
     *              itemNo      the inputted item number
     *              
     * @return      index
     */
    private int findItem(int total , String itemNo)
    {
        boolean valid = false;
        int index;
        String items;
        int i;

        i = 0;
        index = 0;

        while(i < total && valid == false) //Loops through each element in array to find item number
        {
            items = inventory[i].getItemNo(); //Calls for item number from Item class
            if(itemNo.equals(items))
            {
                index = i;
                valid = true;
            }
            i++;
        }

        return index;
    }
}
