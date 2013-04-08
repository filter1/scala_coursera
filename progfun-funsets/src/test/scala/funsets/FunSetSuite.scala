package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet with contains") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton 1")
      assert(contains(s2, 2), "Singleton 2")
      assert(contains(s3, 3), "Singleton 3")
      assert(!contains(s3, 4), "Singleton 4")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
  test("intersect does the job") {
    new TestSets {
      val u = union(s1, s2)
      val i = intersect(s1, u)
      val ii = intersect(i, s1)
      
      assert(contains(i, 1),"intersect 1")
      assert(!contains(i, 2),"intersect 2")
      assert(contains(ii, 1),"intersect 3")
      assert(!contains(ii, 2),"intersect 4")
    }
  }
  
  test("diff") {
    new TestSets {
      val u = union(s1, s2)
      val d = diff(u, s2)
      val dd = diff(d, s1)
      assert(contains(d, 1), "diff 1")
      assert(!contains(d, 2), "diff 2")
      assert(!contains(dd, 1), "diff 3")
      assert(!contains(dd, 2), "diff 4")
    }
  }
  
  test("forall") {
    new TestSets {
      val u = union(s1, s2)
      assert(forall(s1, s1),"forall 1")
      assert(!forall(s1, s2),"forall 2")
      assert(forall(s1, u),"forall 3")
      assert(!forall(u, s1),"forall 4")
    }
  }
  
  test("exists") {
    new TestSets {
      val u = union(s1, s2)
      assert(exists(u, s1),"exist 1")
      assert(!exists(u, s3),"exist 2")
    }
  }
  
  test("map") {
    new TestSets {
      val m = map(s1, x => x * 3)
      assert(contains(m, 3), "map 1")
      assert(!contains(m, 1),"map 2")
    }
  }
  
}
