@startuml 
__Customer__ -> __Store__ : login(email,password)
__Customer__ -> __Item__ **: reserve()
activate __Item__
__Item__ -> __Order__: addToCart(productID,cost)
deactivate __Item__
activate __Order__
__Order__ -> __Item__: changeStock(quantity)
deactivate __Order__
activate __Item__
__Item__ -> __Store__: changeStorePage(productID,quantity)
deactivate __Item__
__Customer__ -> __Order__ : requestNotification(type)
__Order__ -> __Notification__ ** : createNotification(type)
__Notification__ -> __Notification__ : calculateEstimate()
activate __Notification__
__Notification__ -> __Customer__ : showNotification()
deactivate __Notification__
__Order__ -> __Store__ : completeOrder()
activate __Store__
__Store__ -> __Customer__ : changeOrder()
deactivate __Store__ 

/' least Customer, Store, Order, Item and Notification instances '/

@enduml

