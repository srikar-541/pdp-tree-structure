import org.junit.Before;
import org.junit.Test;
import expression.Expression;
import expression.ExpressionTree;
import static org.junit.Assert.*;

public class ExpressionTreeTest {
  Expression e1;
  Expression e2;
  Expression e3;
  Expression e4;

  @Before
  public void setUp() {
    e1 = new ExpressionTree("3 2 + 65.12 -");
  }

  @Test
  public void test1() {
    assertEquals(-60.12, e1.evaluate(), 0.01);
    assertEquals("( ( 3.0 + 2.0 ) - 65.12 )", e1.infix());
    assertEquals("(- (+ 3.0 2.0) 65.12)", e1.schemeExpression());
  }

  @Test
  public void test2() {
    e2 = new ExpressionTree("1.2 5.4 *   -4.5 + ");
    assertEquals(1.98, e2.evaluate(), 0.01);
    assertEquals("( ( 1.2 * 5.4 ) + -4.5 )", e2.infix());
    assertEquals("(+ (* 1.2 5.4) -4.5)", e2.schemeExpression());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmpty() {
    e2 = new ExpressionTree("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIncompleteData1() {
    e2 = new ExpressionTree("1.2 5.4");
  }

  @Test
  public void test3() {
    e2 = new ExpressionTree("3.0 5.0 + 4.0 -");
    assertEquals(4.0, e2.evaluate(), 0.01);
    assertEquals("(- (+ 3.0 5.0) 4.0)", e2.schemeExpression());
    assertEquals("( ( 3.0 + 5.0 ) - 4.0 )", e2.infix());
  }

  @Test
  public void test4() {
    e2 = new ExpressionTree("1 4 6 - 5 + /");
    System.out.println(e2.textTree());
  }

  @Test (expected = IllegalArgumentException.class)
  public void test5(){
    e2=new ExpressionTree(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void test6() {
    e2 = new ExpressionTree("  ");
  }

  @Test(expected = IllegalArgumentException.class)
  public void test7() {
    e2 = new ExpressionTree(" 1 2");
  }

  @Test(expected = IllegalArgumentException.class)
  public void test8() {
    e2 = new ExpressionTree("1 2/");
  }

  @Test
  public void test9() {
    e2 = new ExpressionTree("1 2 /");
    assertEquals("( 1.0 / 2.0 )", e2.infix());
    e2 = new ExpressionTree("1 0 /");
    assertEquals(Double.POSITIVE_INFINITY, e2.evaluate(), 0.0001);
    e2 = new ExpressionTree("-1.2 5.4 *   -4.5 + ");
    assertEquals("( ( -1.2 * 5.4 ) + -4.5 )", e2.infix());
  }

  @Test(expected = IllegalArgumentException.class)
  public void test10() {
    e2 = new ExpressionTree("3 4 + / * -");
  }

  @Test(expected = IllegalArgumentException.class)
  public void test11() {
    e2 = new ExpressionTree("3 5 / 10 -12 * 5");
  }

  @Test
  public void test12() {
    e2 = new ExpressionTree("1 4 +6 - 5 + /");
  }

  @Test(expected = IllegalArgumentException.class)
  public void test13() {
    e2 = new ExpressionTree("1.2.2 2 /");
    e2 = new ExpressionTree("1/2 3 - 4 5 + 6 *");
  }

  @Test
  public void test14() {
    e2 = new ExpressionTree("4 -2 - 3 *");
    assertEquals("( ( 4.0 - -2.0 ) * 3.0 )", e2.infix());
  }

  @Test(expected = IllegalArgumentException.class)
  public void test15() {
    e2 = new ExpressionTree("4 -2 - 3 %");
    e2 = new ExpressionTree("4 -2 - 3 #");
  }

  @Test(expected = IllegalArgumentException.class)
  public void test16() {
    e2 = new ExpressionTree("+ 4");
    e2 = new ExpressionTree("4 5 + 6 * -");
  }

  @Test
  public void test17() {
    e2 = new ExpressionTree("1 2 * 4 - 5 / 6 +");
    assertEquals("( ( ( ( 1.0 * 2.0 ) - 4.0 ) / 5.0 ) + 6.0 )", e2.infix());
    e2 = new ExpressionTree("2");
    assertEquals("2.0", e2.infix());
  }

  @Test
  public void test18() {
    e2 = new ExpressionTree("1 2 * 4 - 5 / 6 +");
    assertEquals(5.6, e2.evaluate(), 0.00001);
    e2 = new ExpressionTree(" 0 2 * 1 - 3 / 5 +");
    assertEquals(4.666666, e2.evaluate(), 0.00001);
    e2 = new ExpressionTree("0.00 1.1 + 2.5 - -3 + 6 * 5 /");
    assertEquals(-5.28, e2.evaluate(), 0.0001);
    assertEquals("( ( ( ( ( 0.0 + 1.1 ) - 2.5 ) + -3.0 ) * 6.0 ) / 5.0 )",
            e2.infix());
    e2 = new ExpressionTree("1 2 *");
    assertEquals("( 1.0 * 2.0 )", e2.infix());
  }

  @Test
  public void test19() {
    e2 = new ExpressionTree("1 2 /");
    assertEquals("( 1.0 / 2.0 )", e2.infix());
    e2 = new ExpressionTree("1 2 + -3 / 10.4 +");
    assertEquals("( ( ( 1.0 + 2.0 ) / -3.0 ) + 10.4 )", e2.infix());
    e2 = new ExpressionTree("0.00 1.1 + 2.5 - -3 + 6 * 5 /");
    assertEquals("( ( ( ( ( 0.0 + 1.1 ) - 2.5 ) + -3.0 ) * 6.0 ) / 5.0 )", e2.infix());
    e2 = new ExpressionTree("-1 2 + 0 /");
    assertEquals("( ( -1.0 + 2.0 ) / 0.0 )", e2.infix());
    e2 = new ExpressionTree("1 2 / 0 *");
    assertEquals(0.0, e2.evaluate(), 0.0001);
  }

  @Test
  public void test20() {
    e2 = new ExpressionTree("1 2 /");
    assertEquals("(/ 1.0 2.0)", e2.schemeExpression());
    e2 = new ExpressionTree("1 2 + -3 / 10.4 +");
    assertEquals("(+ (/ (+ 1.0 2.0) -3.0) 10.4)", e2.schemeExpression());
    e2 = new ExpressionTree("0.00 1.1 + 2.5 - -3 + 6 * 5 /");
    assertEquals("(/ (* (+ (- (+ 0.0 1.1) 2.5) -3.0) 6.0) 5.0)", e2.schemeExpression());
    e2 = new ExpressionTree("-1 2 + 0 /");
    assertEquals("(/ (+ -1.0 2.0) 0.0)", e2.schemeExpression());
    e2 = new ExpressionTree("1 2 / 0 *");
    assertEquals("(* (/ 1.0 2.0) 0.0)", e2.schemeExpression());
  }

  @Test
  public void test21() {
    e2 = new ExpressionTree("1 2 /");
    String s = e2.textTree();
    s = s.replace("|", "");
    s = s.replace(" ", "");
    s = s.replace("_", "");
    s = s.replace("\n", "");
    assertEquals("/1.02.0", s);
  }
}