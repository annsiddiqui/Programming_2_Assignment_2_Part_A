import java.util.Scanner;
/**
 * This is the interface that the user will use to process Inventory
 * 
 * @author Qurrat-al-Ain Siddiqui  
 * @due-date Feb 16, 2018
 */

public class UI 
{
    public static Scanner kb = new Scanner(System.in);
    public static Warehouse wh = new Warehouse();

    /**
     * This method is the main method for the inventory application. 
     * 
     * It calls a method in the warehouse class to load the data. 
     * 
     * It also loads the menu and the menu choices. 
     */
    public static void main(String args[])
    {
        //Variables
        boolean exit = false;
        int menuChoice;
        int totalItems;
        String item;
        boolean valid = false;
        int input;

        //Menu option variables
        final int CHOICE_1 = 1;
        final int CHOICE_2 = 2;
        final int CHOICE_3 = 3;
        final int CHOICE_4 = 4;
        final int CHOICE_5 = 5;
        final int CHOICE_6 = 6;
        final int CHOICE_7 = 7;
        final int CHOICE_8 = 8;
        final int CHOICE_9 = 9;

        // place here the code for the processing requirements
        System.out.println("Welcome to the Inventory Processing System");

        totalItems = wh.loadData(); //The total number of items in inventory 

        while(!exit) //Processing the menu input
        {
            showMenu(); //Outputs menu

            System.out.println();

            menuChoice = menuInput(); //Process user menu input
            System.out.println();

            if(menuChoice == CHOICE_1)//Requirement #1 
            {
                item = itemNumber(); //Input of item number
                valid = wh.validator(item , totalItems); //Calls validator method in Warehouse class
                System.out.println();
                if(valid == true)
                {
                    wh.inventoryInfo(item , totalItems); //Calls method in Warehouse class
                    System.out.println();
                }
            }
            else if(menuChoice == CHOICE_2)//Requirement #2
            {
                item = itemNumber(); //Input of item number
                valid = wh.validator(item , totalItems); //Calls validator method in Warehouse class
                System.out.println();
                if(valid == true)
                {
                    input = amtOrder(); //Amount input 
                    System.out.println();
                    wh.orderInventory(item , totalItems , input); //Calls method in Warehouse class
                    System.out.println();
                }
            }
            else if(menuChoice == CHOICE_3)//Requirement #3
            {
                item = itemNumber(); //Input of item number
                valid = wh.validator(item , totalItems); //Calls validator method in Warehouse class
                System.out.println();
                if(valid == true)
                {
                    input = shipmentTotal(); //Amount input 
                    System.out.println(); 
                    wh.shipmentReceived(item , totalItems , input); //Calls method in Warehouse class
                    System.out.println();
                }
            }
            else if(menuChoice == CHOICE_4)//Requirement #4
            {
                item = itemNumber(); //Input of item number
                valid = wh.validator(item , totalItems); //Calls validator method in Warehouse class
                System.out.println();
                if(valid == true)
                {
                    input = returnTotal(); //Amount input 
                    System.out.println();
                    wh.returnItems(item , totalItems , input); //Calls method in Warehouse class
                    System.out.println();
                }
            }
            else if(menuChoice == CHOICE_5)//Requirement #5
            {
                item = itemNumber(); //Input of item number
                valid = wh.validator(item , totalItems); //Calls validator method in Warehouse class
                System.out.println();
                if(valid == true)
                {
                    input = amtShipped(); //Amount input 
                    System.out.println();
                    wh.shiptoCustomer(item , totalItems , input); //Calls method in Warehouse class
                    System.out.println();
                }
            }
            else if(menuChoice == CHOICE_6)//Requirement #6
            {
                item = itemNumber(); //Input of item number
                valid = wh.validator(item , totalItems); //Calls validator method in Warehouse class
                System.out.println();
                if(valid == true)
                {
                    input = orderByCustomer(); //Amount input 
                    System.out.println();
                    wh.customerOrder(item , totalItems ,input); //Calls method in Warehouse class
                    System.out.println();
                }
            }
            else if(menuChoice == CHOICE_7)//Requirement #7
            {
                item = itemNumber(); //Input of item number
                valid = wh.validator(item , totalItems); //Calls validator method in Warehouse class
                System.out.println();
                if(valid == true)
                {
                    input = customerReturn(); //Amount input 
                    System.out.println();
                    wh.customerReturn(item , totalItems , input); //Calls method in Warehouse class
                    System.out.println();
                }
            }
            else if(menuChoice == CHOICE_8)//Requirement #8
            {
                wh.endDay(totalItems); //Calls method in Warehouse class
                System.out.println();
            }
            else if(menuChoice == CHOICE_9)//Exit program 
            {
                exit = true;
            }
            else //Invalid input 
            {
                System.out.println("Invalid menu choice.");
            }
        }

        System.out.println ("Thank you for using the Inventory Processing System");
    }

    /**
     *  The inventory processing menu.
     *  
     *  This outputs the menu.
     */
    public static void showMenu()
    {
        System.out.println("\nMENU:");
        System.out.println("1) Inventory Item Inquiry");
        System.out.println("2) Order inventory items from Supplier");
        System.out.println("3) Receive shipment from Suppliers");
        System.out.println("4) Return items to Supplier");
        System.out.println("5) Ship items to Customers");
        System.out.println("6) Process Customer Order");
        System.out.println("7) Process Customer Returns");
        System.out.println("8) End of Day Processing");
        System.out.println();
        System.out.println("9) Exit");
    }

    /**
     * This method processes the user input for the menu choices.
     * 
     * @return      menuInput
     * 
     */
    public static int menuInput()
    {
        int menuInput;

        menuInput = kb.nextInt(); //User input
        kb.nextLine();

        return menuInput; 
    }

    /**
     * This method processes the user input for the item number
     * 
     * @return      itemNo
     * 
     */
    public static String itemNumber()
    {
        String itemNo;

        System.out.println("Please enter the item number.");
        itemNo = kb.nextLine().toUpperCase(); //User input

        return itemNo;
    }

    /**
     * This method processes the user input for requriment #2.
     * @return      order
     * 
     */
    public static int amtOrder()
    {
        int order;
        
        System.out.println("Please enter the amount to be ordered.");
        order = kb.nextInt(); //User input
        kb.nextLine();

        return order;
    }
    
    /**
     * This method processes the user input for requriment #3.
     * 
     * @return      shipment
     * 
     */
    public static int shipmentTotal()
    {
        int shipment;
        
        System.out.println("Please enter the amount received from supplier.");
        shipment = kb.nextInt(); //User input
        kb.nextLine();
        
        return shipment;
    }
    
    /**
     * This method processes the user input for requriment #4.
     * 
     * @return      returnAmt
     * 
     */
    public static int returnTotal()
    {
        int returnAmt;
        
        System.out.println("Please enter the amount to be returned to the supplier.");
        returnAmt = kb.nextInt(); //User input
        kb.nextLine();
        
        return returnAmt;
    }
    
    /**
     * This method processes the user input for requriment #5.
     * 
     * @return      returnedAmt
     * 
     */
    public static int customerReturn()
    {
        int returnedAmt;
        
        System.out.println("Please enter the amount that was returned.");
        returnedAmt = kb.nextInt(); //User input
        kb.nextLine();
        
        return returnedAmt;
    }
    
    /**
     * This method processes the user input for requriment #6.
     * 
     * @return      shipped
     * 
     */
    public static int amtShipped()
    {
        int shipped;
        
        System.out.println("Please enter the amount to be shipped to the customer.");
        shipped = kb.nextInt(); //User input
        kb.nextLine();
        
        return shipped;
    }
    
    /**
     * This method processes the user input for requriment #7.
     * 
     * @return      order
     * 
     */
    public static int orderByCustomer()
    {
        int order;
        
        System.out.println("Please enter the amount to order by the customer.");
        order = kb.nextInt(); //User input
        kb.nextLine();
        
        return order;
    }
}
