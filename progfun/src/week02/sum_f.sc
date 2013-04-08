package week02

object sum_f {

      def sum(f: Int => Int)(a: Int, b: Int): Int = {
        def loop(a: Int, acc: Int): Int = {
          if (a > b) acc
          else loop(a + 1, f(a) + acc)
        }
        loop(a, 0)
      }                                           //> sum: (f: Int => Int)(a: Int, b: Int)Int
      
      sum((x: Int) => x) (1,5)                    //> res0: Int = 15
}