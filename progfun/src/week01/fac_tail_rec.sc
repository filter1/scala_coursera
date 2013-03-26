package week01

object fac_tail_rec {

  def fac(n: Int): Int = {

    def fac_rec(n: Int, res: Int): Int =
      if (n == 0) res
      else fac_rec(n - 1, n * res)

    fac_rec(n, 1)
  }                                               //> fac: (n: Int)Int
  
  fac(3)                                          //> res0: Int = 6
}