/**
 * This is the class that defines the Inventory Item of a company 
 * Remember: NO USER INPUTS
 * @author  Qurrat-al-Ain Siddiqui
 * 
 */
public class Item
{
    // the instance variables (fields)
    private String itemNo;
    private String itemName;
    private int onHand;
    private int committed;
    private int onOrder;
    private double unitPrice;
    private int reorderPoint;
    private int econOrderQty;
    
    // FOUR constructors
    /**
     * Default constructor of the Item class
     * 
     */
    public Item ()
    {
        itemNo = null;
        itemName = null;
        onHand = 0;
        committed = 0;
        onOrder = 0;
        unitPrice = 0;
        reorderPoint = 0;
        econOrderQty = 0;
    }
    
    /**
     * Constructor that accepts parameters BUT not committed and on onOrder
     * 
     * @param       num         item number 
     *              name        item name
     *              onH         on hand 
     *              unitP       unit price
     *              reorderP    reorder point
     *              econOQ      economic order quantity 
     * 
     */
    public Item(String num, String name,int onH, double unitP, int reorderP, int econOQ)
    {
        itemNo = num;
        itemName = name;
        onHand = onH;
        unitPrice = unitP;
        reorderPoint = reorderP;
        econOrderQty = econOQ;
    }
    
    //Accepts parmeters (all fields)
    /**
     * Constructor that accepst all parameters
     * 
     * @param       num         item number 
     *              name        item name
     *              onH         on hand
     *              c           committed
     *              onO         on order
     *              unitP       unit price
     *              reorderP    reorder point
     *              econOQ      economic order quantity 
     * 
     */
    public Item(String num, String name, int onH, int c, int onO, double unitP, int reorderP, int econOQ)
    {
        itemNo = num;
        itemName = name;
        onHand = onH;
        committed = c;
        onOrder = onO;
        unitPrice = unitP;
        reorderPoint = reorderP;
        econOrderQty = econOQ;
    }

    //Copy Constructor 
    /**
     * The copy constructor
     * 
     * @param       otherItem       the copy of the item
     * 
     */
    public Item(Item otherItem)
    {
        this.itemNo = otherItem.getItemNo();
        this.itemName = otherItem.getItemName();
        this.onHand = otherItem.getOnHand();
        this.committed = otherItem.getCommitted();
        this.onOrder = otherItem.getOnOrder();
        this.unitPrice = otherItem.getUnitPrice();
        this.econOrderQty = otherItem.getEconOrderQty();
    }
    
    // the Accessors
    /**
     * Accessor method for item number
     * 
     * @return      itemNo
     * 
     */
    public String getItemNo()
    {
        return itemNo;
    }
    
    /**
     * Accessor method for item name
     * 
     * @return      itemName
     * 
     */
    public String getItemName()
    {
        return itemName;
    }
    
    /**
     * Accessor method for on hand
     * 
     * @return      onHand
     * 
     */
    public int getOnHand()
    {
        return onHand;
    }
    
    /**
     * Accessor method for committed
     * 
     * @return      committed
     * 
     */
    public int getCommitted()
    {
        return committed;
    }
    
    /**
     * Accessor method for on order
     * 
     * @return      onOrder
     * 
     */
    public int getOnOrder()
    {
        return onOrder;
    }
    
    /**
     * Accessor method for unit price
     * 
     * @return      unitPrice
     * 
     */
    public double getUnitPrice()
    {
        return unitPrice;
    }
    
    /**
     * Accessor method for reorder point
     * 
     * @return      reorderPoint
     * 
     */
    public int getReorderPoint()
    {
        return reorderPoint;
    }
    
    /**
     * Accessor method for economic order quantity
     * 
     * @return      getEconOrderQty
     * 
     */
    public int getEconOrderQty()
    {
        return econOrderQty;
    }
    
    // the mutators
    /**
     * Mutator method for item number
     * 
     * @param       num     item number
     * 
     */
    public void setItemNo(String num)
    {
        itemNo = num;
    }
    
    /**
     * Mutator method for item name
     * 
     * @param       name    item name
     * 
     */
    public void setItemName(String name)
    {
        itemName = name;
    }
    
    /**
     * Mutator method for on hand
     * 
     * @param       onH     on hand
     * 
     */
    public void setOnHand(int onH)
    {
        onHand = onH;
    }
    
    /**
     * Mutator method for unit price
     * 
     * @param       uPrice      unit price
     * 
     */
    public void setUnitPrice(double uPrice)
    {
        unitPrice = uPrice;
    }
    
    /**
     * Mutator method for reorder point
     * 
     * @param       rPoint      reorder point
     * 
     */
    public void setReorderPoint(int rPoint)
    {
        reorderPoint = rPoint;
    }
    
    /**
     * Mutator method for economic order quantity
     * 
     * @param       eOrderQ     econmic order quantity
     * 
     */
    public void setEconOrderQty(int eOrderQ)
    {
        econOrderQty = eOrderQ;
    }
    
    //Helper method
    //Processing methods
    /**
     * This method calculates and updates the on order amount
     * 
     * Method is for Requirement #2
     * 
     * @param       orderAmt    the amount to be ordered
     * 
     */
    public void ordering(int orderAmt)
    {
        onOrder = onOrder + orderAmt;
    }
    
    /**
     * This method validates if the on order will go under zero (become negative)
     * 
     * If the new on order is negative method returns a false boolean
     * 
     * If the new on order is not negative the onOrder is updated and a true boolean is returned.
     * 
     * Method is for Requirement #3.
     * 
     * @param       shipment        the amount received from shipment
     * 
     * @return      valid
     */
    public boolean validOrder(int shipment)
    {
        boolean valid = false;
        int testOrder;
        int zero;
        
        zero = 0;
        
        testOrder = onOrder;
        
        testOrder = testOrder - shipment; //Calculate new on order value
        
        if(testOrder >= zero) //Not negative
        {
            onOrder = testOrder;
            valid = true;
        }
        
        return valid;
    }
    
    /**
     * This method calculates the new committed value 
     * 
     * Method is for Requirement #5
     * 
     * @param       amtShipped      the amount shipped to customer
     * 
     */
    public void underCommitted(int amtShipped)
    {
        committed = committed - amtShipped;
    }
    
    /**
     * This method sets the committed to zero
     * 
     * Method is for Requirement #5
     * 
     * @param       amtShipped      the amount shipped to customer
     * 
     */
    public void overCommitted(int amtShipped)
    {
        committed = 0;
    }
    
    /**
     * This method calculates the new committed value
     * 
     * Method is for Requirement #6
     * 
     * @param       order       the amount orderd by the customer
     * 
     */
    public void underOnHand(int order)
    {
        committed = committed + order;
    }
    
    /**
     * This method calculates the new committed value and new on order value 
     * 
     * Method is for Requirement #6
     * 
     * @param       order       the amount ordered by the customer
     *              diff        the difference of order value and the on hand value(calculated in requriement method in warehouse)
     * 
     */
    public void overOnHand(int order , int diff)
    {
        committed = committed + order;
        onOrder = onOrder + diff;
    }
    
    /**
     * This method procsses specific item data into String
     * 
     * Method is for Requirement #8
     * 
     * @param       itemValue       the calculated item value
     * 
     * @return      output
     * 
     */
    public String endOfDay(double itemValue)
    {
        String output;
        
        output = String.format("%-17s" , itemNo);
        output = output + String.format("%-14s" , itemName);
        output = output + String.format("%-12d" , onHand);
        output = output + String.format("%-14d" , committed);
        output = output + String.format("%-13d" , onOrder);
        output = output + String.format("%s%-14.2f" , "$" , unitPrice);
        output = output + String.format("%s%-14.2f" , "$" , itemValue);
        
        return output;
    }
    
    /**
     * This method calculates the item value
     * 
     * Method is for Requirement #8
     * 
     * @return  itemVal
     * 
     */
    public double itemValue()
    {
        double itemVal;
        
        itemVal = unitPrice * (onHand + committed);
        
        return itemVal;
    }
    
    /**
     * This method processes the automatic ordering 
     * 
     * Method for Requirement #8
     */
    public void autoOrder()
    {
        if(onHand < reorderPoint)
        {
            onOrder = onOrder + econOrderQty;
        }
    }
    
    //Print and toString methods
    /**
     * This method processes the item data and its labels to a String 
     * 
     * Method for Requirement #1
     * 
     * @return output
     * 
     */
    public String print()
    {
        String output;
        
        output = String.format("%s%s%n" , "Item Number:\t" , itemNo);
        output = output + String.format("%s%s%n" , "Item Name:\t" , itemName);
        output = output + String.format("%s%d%n" , "On Hand:\t" , onHand);
        output = output + String.format("%s%d%n" , "Committed:\t" , committed);
        output = output + String.format("%s%d%n" , "On Order:\t" , onOrder);
        output = output + String.format("%s%s%.2f%n" , "Unit Price:\t" , "$ " , unitPrice);
        output = output + String.format("%s%d%n" , "Reorder Point:\t" , reorderPoint);
        output = output + String.format("%s%d" , "Economoic Order Quantity:\t" , econOrderQty);
        
        return output;
    }
    
    /**
     * This method processes the data from the item to a String
     * 
     * @return      output
     * 
     */
    public String toString()
    {
        String output;
        
        output = String.format("%s" , itemName);
        output = output + String.format("%s" , itemName);
        output = output + String.format("%d" , onHand);
        output = output + String.format("%d" , committed);
        output = output + String.format("%d" , onOrder);
        output = output + String.format("%.2f" , unitPrice);
        output = output + String.format("%d" , reorderPoint);
        output = output + String.format("%d%n" , econOrderQty);
        
        return output;
    }
}