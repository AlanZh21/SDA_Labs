@startuml

class Store
{
    + name : String
    + address : String
    - item : HashMap<String,Integer>
}
class Customer
{
    + name
    getInformation()
}
Entity "<u>:ID" as ID
{
    - picture
    - name : String
    - dateOfBirth : Date
}
Entity "<u>:Complaint" as Complaint
{
    - complaint : String
    setComplaint(message : String)
}
class StoreStaff
{
    - employeeID
    loadItems()
    receiveOrder()
    checkID()
}
Entity "<u>:Order" as Order
{
    - customerID : String
    + items : Item[]
    setIsCompleted(isCompleted : Boolean)
}
Entity "<u>:Item" as Item
{
    + itemID
    changeStock()
}

Customer "1" --right-- "1" ID 
(Customer,ID) -down-> "1" StoreStaff : requestOrder()
StoreStaff "1..*" -> "*" Order : searchOrder(orderNumber)
Customer "*" --> "*" Complaint : raiseComplaint()
Order "1..*" -up-> "1" Customer : giveProduct()
StoreStaff "1..*" ..> "1..*" Item : pickupItem()
Item "1..*" -up-> "1" Customer : receivedBy()
Item "*" .up.> "1" Store : changeStock()

@enduml