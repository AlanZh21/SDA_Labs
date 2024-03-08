@startuml
/'Should have at least Customer, StoreStaff, Order and Complaint instances'/
__Customer__ -> __StoreStaff__ : requestItem(customerID)
activate __StoreStaff__
alt#Gold #LightBlue accountID == customerID
    __StoreStaff__ -> __Customer__: confirmsID()
else #LightPink accountID != customerID
    __StoreStaff__ -> __Complaint__ **: raiseComplaint()
end
__StoreStaff__ -> __Order__ : requestItem()
activate __Order__
return itemID
return Item
activate __Customer__
__Customer__ -> __Customer__ : verifyItem()
alt#Gold #LightGreen itemID == item
    __Customer__ -> __StoreStaff__ : completeOrder()
    deactivate __Customer__
    activate __StoreStaff__
else #LightPink item != itemID
    __Customer__ -> __Complaint__ **: raiseComplaint()
end
__StoreStaff__ -> __Order__ : completeOrder()
deactivate __StoreStaff__
@enduml