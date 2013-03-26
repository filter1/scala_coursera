package week01

object fac_tail_rec {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(187); 

  def fac(n: Int): Int = {

    def fac_rec(n: Int, res: Int): Int =
      if (n == 0) res
      else fac_rec(n - 1, n * res)

    fac_rec(n, 1)
  };System.out.println("""fac: (n: Int)Int""");$skip(12); val res$0 = 
  
  fac(3);System.out.println("""res0: Int = """ + $show(res$0))}
}
