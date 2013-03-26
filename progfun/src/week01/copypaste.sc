package week01

object copypaste {

  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x: Double)Double

  def sqrt(x: Double) = {
  
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.0001

    def improve(guess: Double) =
      (guess + x / guess) / 2
    sqrtIter(1.0)
  }                                               //> sqrt: (x: Double)Double

  sqrt(1e60)                                      //> res0: Double = 1.0000000031080746E30
  sqrt(1e-6)                                      //> res1: Double = 0.0010000001533016628
  sqrt(0.001)                                     //> res2: Double = 0.03162278245070105
  sqrt(0.1e-20)                                   //> res3: Double = 3.1622778383672726E-11
  sqrt(1.0e20)                                    //> res4: Double = 1.0000021484861237E10
  sqrt(1.0e50)                                    //> res5: Double = 1.0000003807575104E25

}