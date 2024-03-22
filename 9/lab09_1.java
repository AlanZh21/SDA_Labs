@startuml
hide empty description

state fork_state <<fork>>

[*] -down-> displayingHomePage : opens product page
displayingHomePage -right-> displayingProductList : browse products
displayingProductList --> displayProductInformation : select product 
displayProductInformation --> fork_state : finished browsing 
displayProductInformation --> displayingProductList : added item to cart \n [item in stock]

displayProductInformation --> displayingHomePage : no item selected

fork_state --> initializingDeliveryOrder : select delivery

state initializingReserveOrder{
    [*] --> customerInformationPage
    customerInformationPage --> customerInformationPage : invalid customerInformationPage
    customerInformationPage --> showDeliveryOptions : [confirmed info]

    state delivery_fork <<fork>>
    showDeliveryOptions --> delivery_fork
    
    delivery_fork --> displayDeliveryEstimates
    delivery_fork --> displayTotal 

    state delivery_join <<join>>
    displayDeliveryEstimates --> delivery_join : selects a carrier
    displayTotal --> delivery_join : procceeds

    delivery_join --> waitingConfirmationOfOrder : procceeds
    waitingConfirmationOfOrder --> receivingPayment : confirmed
    receivingPayment -right-> authorizingPayment
    authorizingPayment -down-> displayingOrderStatus : [payment authorized]
    
    displayingOrderStatus --> [*]
}
fork_state --> initializingReserveOrder : select reserve \n [check items not delivery only]


@enduml