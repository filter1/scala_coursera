package greeter

object Hi {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(72); 
  println("Welcome to the Scala worksheet");$skip(57); 

  
  def and(x:Boolean, y:Boolean) = if(x) y else false;System.out.println("""and: (x: Boolean, y: Boolean)Boolean""");$skip(56); 
  def or(x: Boolean, y: => Boolean) = if(x) true else y;System.out.println("""or: (x: Boolean, y: => Boolean)Boolean""");$skip(29); 
  
  def loop:Boolean = loop;System.out.println("""loop: => Boolean""");$skip(18); 
  
  val a = true;System.out.println("""a  : Boolean = """ + $show(a ));$skip(15); 
  def b = loop;System.out.println("""b: => Boolean""");$skip(18); 
  val c = or(a,b);System.out.println("""c  : Boolean = """ + $show(c ))}
}
