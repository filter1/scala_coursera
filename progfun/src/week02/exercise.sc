package week02

object exercise {

  def product(f: Int => Int)(a: Int, b: Int): Int =
    	if(a > b) 1
  	else f(a) * product(f)(a + 1,b)           //> product: (f: Int => Int)(a: Int, b: Int)Int
  	

  
  def fac(x: Int): Int =
  	product(x => x)(1,x)                      //> fac: (x: Int)Int
  	
  product(x => x)(1,5)                            //> res0: Int = 120
  fac(0)                                          //> res1: Int = 1
  fac(1)                                          //> res2: Int = 1
  fac(3)                                          //> res3: Int = 6
  
  def mapReduce(f: Int => Int, combine:(Int, Int) => Int, zero: Int)(a: Int, b: Int): Int=
  	if(a > b) zero
  	else combine(f(a),mapReduce(f, combine, zero)(a + 1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
  	
  def product_2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> product_2: (f: Int => Int)(a: Int, b: Int)Int
  
  product_2(x => x)(1,5)                          //> res4: Int = 120
}