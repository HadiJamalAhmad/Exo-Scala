sealed trait Peugeot {
val registration:String
}
abstract class Velo(model:String) extends Peugeot
case class Voiture(registration:String,model:String) extends Peugeot
case class Moto(registration:String,model:String) extends Peugeot
