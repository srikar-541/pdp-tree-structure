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
  public void setUp(){
    e1=new ExpressionTree("3 2 + 65.12 -");
  }

  @Test
  public void test1(){
    assertEquals(-60.12,e1.evaluate(),0.01);
    assertEquals("( ( 3 + 2 ) - 65.12 )",e1.infix());
    assertEquals("(- (+ 3 2) 65.12)",e1.schemeExpression());
  }

  @Test
  public void test2(){
    e2=new ExpressionTree("1.2 5.4 *   -4.5 + ");
    assertEquals(1.98,e2.evaluate(),0.01);
    assertEquals("( ( 1.2 * 5.4 ) + -4.5 )",e2.infix());
    assertEquals("(+ (* 1.2 5.4) -4.5)",e2.schemeExpression());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testEmpty(){
    e2=new ExpressionTree("");
  }

  @Test ( expected = IllegalArgumentException.class)
  public void testIncompleteData1(){
    e2=new ExpressionTree("1.2 5.4");
  }

  @Test
  public void test3(){
    e2=new ExpressionTree("3 5 + 4 -");
    assertEquals(4.0,e2.evaluate(),0.01);
    assertEquals("(- (+ 3 5) 4)",e2.schemeExpression());
    assertEquals("( ( 3 + 5 ) - 4 )",e2.infix());
  }

  @Test
  public void test4(){

  }

}