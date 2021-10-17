

object Main extends App {
  

  println("""|Hello, World!""".stripMargin)

  // case class to tuple example
  case class Shop(address: String,number:Int)
  val s = Shop("Rue de Paris Case Class",22)
  println(s)
  val (str, in) = Shop.unapply(Shop("Rue de Paris Tuple", 22)).get
  val caseclassToTuple = (str, in)
  println(caseclassToTuple)

  // tuple to case class example
  val tupleToCaseClass = ("Tuple to Case Class", 1)
  case class newCaseClassFromTuple(address: String, number: Int)
  val f = new newCaseClassFromTuple(tupleToCaseClass._1, tupleToCaseClass._2)
  println(f)

  // the recursive function pow(x, n), 
  // which calculates the result of x to the power of n
  
  def pow(x: BigInt,n: Int): BigInt = {  
      if (n+1 <= 1)
         1  
      else    
      x * pow(x,n-1)
   }

   val resultpow = pow(2,4)
   
   println("result pow  : "+resultpow)

def eval = {
      val x = { print("x"); 1}
      lazy val y = { print("y"); 2}
      def z = { print("z"); 3}
      z + x + y + z + x + y
   }
   
   println(eval)
 
  def listLength[A](xs: List[A]): Int = xs match {
  case Nil => 0
  case _ :: tail => 1 + listLength(tail)
}


/* fonction récursive terminal calculant la longueur d'une liste de Loic 

def longlistAcc(list: List[Int], acc: Int): Int = list match {
  case Nil => acc
  case _ => longlistAcc(list.drop(1), acc+1)
}

 def longlist(list: List[Int]): Int = longlistAcc(list,0)

val l = List(1,2,544,7,45,8,6)
longlist(l)

*/
 
   val theList : List[Int] = List(1,3,7,9,11)
 
   
   
   println("The length of the list is : "+listLength(theList))
 
   def lastElementList[A](l:List[A]):A = l match {
    case h :: Nil => h
    case _ :: tail => lastElementList(tail)
    case _ => throw new NoSuchElementException
 
}
 
println("The last element of the list is : "+lastElementList(theList))



 def last[A](l:List[A]):A = l match {
    case h :: Nil => h
    case _ :: tail => last(tail)
    case _ => throw new NoSuchElementException
 
}

println("Last element of list : "+last(List(1,1,2,3,5,8)))

def nth[A](k:Int, l:List[A]):A = k match {
    case 0 => l.head
    case k if k > 0 => nth(k - 1, l.tail)
    case _ => throw new NoSuchElementException  
}

println("nth element of list : "+nth(2, List(1, 1, 2, 3, 5, 8)))

def reverse[A](l: List[A]): List[A] = l match {
    case h :: tail => reverse(tail) ::: List(h)
    case Nil => Nil
}

println("Reverse list : "+reverse(List(1, 1, 2, 3, 5, 8)))

def compress[A](l: List[A]):List[A] = l match {
    case Nil => Nil
    case h::List() => List(h)
    case h::tail if (h == tail.head) => compress(tail)
    case h::tail => h::compress(tail)
}

println("Eliminate consecutive duplicate : "+compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

def encodeDirect[A](l: List[A]):List[(Int, A)] = {
    def _encodeDirect(res: List[(Int, A)], rem: List[A]):List[(Int, A)] = rem match {
        case Nil => res
        case ls => {
            val (s, r) = rem span { _ == rem.head }
            _encodeDirect(res:::List((s.length, s.head)), r)
        }
    }
    _encodeDirect(List(), l)
}

println("Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E"+encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))


def decode[A](l: List[(Int, A)]):List[A] = {
    def _expand(res: List[A], rem:(Int, A)):List[A] = rem match {
        case (0, _) => res
        case (n, h) => _expand(res:::List(h), (n -1, h))
    }

    l flatMap { e => _expand(List(),e) }
}

println("Decode a run-length encoded list : "+decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))


}






object NoneEmptyString {

    def apply(s : String): Option[NoneEmptyString] = {
      s  match {
          case null => None
          case " "  => None
          case str  => Some(new NoneEmptyString(str))
      }
   }
}


class NoneEmptyString(val s: String){

}

// NoneEmptyString("Hello")


sealed abstract class Existe [A]

// Envoyer lien vers le repo git avec le hash (4 ou 16 caractètes identifiants commit) avec un push
// Ce push concerne le code scala qui implémente est une sealed abstract class Véhicule avec trois possibilités
// Véhicule, Motobirke, Boat (il s'agit d'un équivalent de l'héritage avec le mot clé extends)