package week04

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