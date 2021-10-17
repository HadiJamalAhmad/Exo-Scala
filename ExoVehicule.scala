sealed trait Vehicle {
protected val registration:String
}
case class Car(registration:String,model:String) extends Vehicle
case class Motorcycle(registration:String,model:String) extends Vehicle
case class Boat(registration:String,model:String) extends Vehicle