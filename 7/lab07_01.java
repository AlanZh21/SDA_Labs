@startuml

class Customer
{
<<<<<<< HEAD
    + name : String 
    - email : String
    - password : String
    changePassword(pass)
=======
    String name
    String email
    void login(email,password)
    
>>>>>>> 89789653c78d68d9cecf61533381ee1543caf2f1
}
class Store
{
    + name : String
    + address : String
    - item : HashMap<String,Integer>
}
Class Website
{
    + URL : URL
    - currentCustomer : Customer
    logout() : Customer
    login(email,password) : Customer
}
Entity "<u>:Order" as Order
{
    - orderNumber : String
    - isCompleted : Boolean
    - deliveryNumber : String
    requestNotification(deliveryNumber)

}
Entity "<u>:Item" as Item
{
    + ProductID : String

}
Entity "<u>:Notification" as Notification
{
    notificationTimes : Time[]
    getNotification(Time) : void 
}
Entity "<u>:Payment" as Payment
{
    + price : Money
}

Customer "*" -left-> "1"Website : currentCustomer := login(email,password)
Website "1" -down> "1..*"Store : stores data 
Store "1" -down-> "*" Order : sendItemStock()
Item "*" .up.> "1" Store : getStockInfo()
Customer "1" -down-> "1"Order : startOrder()
Customer "1" --down--> "1,2,3"Payment : addPayment()
Payment"1" -left> "1..*"Order : pay() 
Customer"1" ..down..> "*"Item : addItemToCart()
Item"*" -up-> "1"Order : addToOrder()
Order"1" -down--> "*"Notification : requestNotification()
Order"*" -up-> "1"Store : getStock(itemId)
Notification"*" --up---> "1"Customer : sendNotification()
@enduml