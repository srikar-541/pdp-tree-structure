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
    assertEquals("((3+2)-65.12)",e1.infix());
    assertEquals("(-(+32)65.12)",e1.schemeExpression());
  }

}