import java.util.ArrayList;
import java.util.Random;
import In

class Item
{
    public String ProductID;
}

class Order
{
    protected ArrayList<Item> cartList;
    protected int orderNumber;
    protected int deliveryNumber;
    protected boolean isCompleted;

    public Order(Item item)
    {
        cartList = new ArrayList<Item>();
        cartList.add(item);

        Random rand = new Random();
        orderNumber =  rand.nextInt(999999999);

        isCompleted = false;
    }
    protected List addToOrder(Item item)
    {
        cartList.add(item);
        return cartList;
    }
    protected void completeOrder(){isCompleted = true;}

    protected boolean authorizePayment(String somePayment)
    {
        //authorize payment
        if(somePayment.equals("false"))
        {
            return false;
        }
        else if(somePayment.equals("true"))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}

class Customer
{
    public String name;
    private String email;
    private String password;
    private Order currentOrder;

    public Customer()
    {
        this.name = "";
        this.email = "";
        this.password = "";
        this.currentOrder = null;
    }
    public Customer(String name, String email, String password)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.currentOrder = null;
    }
    public Order addItemToCart(Item item)
    {
        if (this.currentOrder == null)
        {
            currentOrder = new Order(item);
        }
        else if(this.currentOrder != null)
        {
            currentOrder.addToOrder(item);
        }
        return currentOrder;
    }
    public Order viewOrder(){return currentOrder;}
    public String getName(){return name;}
    public String getEmail(){return email;}
    
    public void resetPass(String oldPass, String newPass)
    {
        if(oldPass.equals(this.password))
        {
            this.password = newPass;
        }
    }
    public boolean payForOrder(String somePayment)
    {
        return currentOrder.authorizePayment(somePayment);
    }
}

public class lab08
{
    public static void main(String[] args)
    {
        System.out.println("LOGIN:");
        System.out.print("ENTER EMAIL:");
        input
    }
}