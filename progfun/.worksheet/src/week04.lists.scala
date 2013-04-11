package week04

object lists {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(49); 
  val t1 = List(5);System.out.println("""t1  : List[Int] = """ + $show(t1 ))}
}


trait List[T] {
  def isEmpty: Boolean
  def Head: T
  def Tail: List[T]
  
}

class Cons[T](val head: T, val tail: List[T]) extends List[T]{
	def isEmpty = false
}

class Nil[T] extends List[T] {
	def isEmpty = true
	def Head: Nothing = throw new NoSuchElementException("Nil.head")
	def Tail: Nothing = throw new NoSuchElementException("Nil.tail")
}
