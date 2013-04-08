package week02

object objects {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(60); 
  val x = new Rational(1,3);System.out.println("""x  : week02.Rational = """ + $show(x ));$skip(28); 
  val y = new Rational(5,7);System.out.println("""y  : week02.Rational = """ + $show(y ));$skip(28); 
  val z = new Rational(3,2);System.out.println("""z  : week02.Rational = """ + $show(z ));$skip(14); val res$0 = 
  
  x.add(y);System.out.println("""res0: week02.Rational = """ + $show(res$0));$skip(11); val res$1 = 
  x.sub(y);System.out.println("""res1: week02.Rational = """ + $show(res$1));$skip(18); val res$2 = 
  x.sub(y).sub(z);System.out.println("""res2: week02.Rational = """ + $show(res$2));$skip(11); val res$3 = 
  x.add(x);System.out.println("""res3: week02.Rational = """ + $show(res$3));$skip(14); val res$4 = 
  
  x.max(y);System.out.println("""res4: week02.Rational = """ + $show(res$4))}
  //val strange = new Rational(1, 0)
  
}

class Rational(x: Int, y: Int){
	require(y != 0, "denom must be nonzero")
	
	def this(x: Int) = this(x, 1)
	
	private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
	//private def g = gcd(x, y)
	//def numer = x / g
	//def denom = y / g
	
	def numer = x
	def denom = y
	
	def add(that: Rational)=
		new Rational(numer * that.denom + that.numer * denom,
		denom * that.denom)
		
	def neg: Rational = new Rational(-numer , denom)
	
	def sub(that: Rational): Rational = this.add(that.neg)
	
	def less(that: Rational): Boolean = numer * that.denom < denom * that.numer
	
	def max(that: Rational): Rational = if (this.less(that)) that else this
	
	override def toString = numer / gcd(numer, denom) + "/" + denom / gcd(numer, denom)
}
