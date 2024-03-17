@startuml

class Customer
{
    String name
    String email
    void login(email,password)
    
}
class Store
{
    String name
}
Class Website
{
    String URL
    Customer currentCustomer
    Customer logout()
}
Entity _Order_
Entity  _Item_
{
    String ProductID

}
Entity _Notification_

Customer "1" -- Website : logs in
Website -- Store
Customer -- _Item_
_Item_ -- _Order_
Customer -- _Notification_
@enduml