package week02

object exercise {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(138); 

  def product(f: Int => Int)(a: Int, b: Int): Int =
    	if(a > b) 1
  	else f(a) * product(f)(a + 1,b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(57); 
  	

  
  def fac(x: Int): Int =
  	product(x => x)(1,x);System.out.println("""fac: (x: Int)Int""");$skip(27); val res$0 = 
  	
  product(x => x)(1,5);System.out.println("""res0: Int = """ + $show(res$0));$skip(9); val res$1 = 
  fac(0);System.out.println("""res1: Int = """ + $show(res$1));$skip(9); val res$2 = 
  fac(1);System.out.println("""res2: Int = """ + $show(res$2));$skip(9); val res$3 = 
  fac(3);System.out.println("""res3: Int = """ + $show(res$3));$skip(172); 
  
  def mapReduce(f: Int => Int, combine:(Int, Int) => Int, zero: Int)(a: Int, b: Int): Int=
  	if(a > b) zero
  	else combine(f(a),mapReduce(f, combine, zero)(a + 1, b));System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(97); 
  	
  def product_2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b);System.out.println("""product_2: (f: Int => Int)(a: Int, b: Int)Int""");$skip(28); val res$4 = 
  
  product_2(x => x)(1,5);System.out.println("""res4: Int = """ + $show(res$4))}
}
