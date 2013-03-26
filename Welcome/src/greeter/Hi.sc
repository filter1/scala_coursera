package greeter

object Hi {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  
  def and(x:Boolean, y:Boolean) = if(x) y else false
                                                  //> and: (x: Boolean, y: Boolean)Boolean
  def or(x: Boolean, y: => Boolean) = if(x) true else y
                                                  //> or: (x: Boolean, y: => Boolean)Boolean
  
  def loop:Boolean = loop                         //> loop: => Boolean
  
  val a = true                                    //> a  : Boolean = true
  def b = loop                                    //> b: => Boolean
  val c = or(a,b)                                 //> c  : Boolean = true
}