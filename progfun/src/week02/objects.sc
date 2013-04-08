package week02

object objects {
  val x = new Rational(1,3)                       //> x  : week02.Rational = 1/3
  val y = new Rational(5,7)                       //> y  : week02.Rational = 5/7
  val z = new Rational(3,2)                       //> z  : week02.Rational = 3/2
  
  x.add(y)                                        //> res0: week02.Rational = 22/21
  x.sub(y)                                        //> res1: week02.Rational = 8/-21
  x.sub(y).sub(z)                                 //> res2: week02.Rational = -79/42
  x.add(x)                                        //> res3: week02.Rational = 2/3
  
  x.max(y)                                        //> res4: week02.Rational = 5/7
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