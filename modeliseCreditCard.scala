sealed abstract class BrandingName {

}

case object Amex extends BrandingName {}
case object Visa extends BrandingName {}
case object Mastercard extends BrandingName {}

object Digits {
    def unapply(s:String,l:Int): Option[Int]= {
        if(s.length()==l) {
            util.Try(s.toInt).toOption
        } else { None}
    }
}

class CardNumber private (number:String,branding:BrandingName) {}

object CardNumber {
    def apply(number:String):Option[CardNumber]=number match {
        case Digits (1,16) => Some(new CardNumber(number))
        case _ => None
    }
}

case class CreditCard(brand:BrandingName,numbers:CardNumber,expirationMonth:Month,expirationYear: Year,cvc:Int) {}