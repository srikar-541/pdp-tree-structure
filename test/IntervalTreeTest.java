import org.junit.Before;
import org.junit.Test;
import intervals.Interval;
import intervals.IntervalTree;
import intervals.Intervals;
import static org.junit.Assert.*;
public class IntervalTreeTest {

  Intervals i;
  Intervals i1;
  Intervals i2;
  Intervals i3;
  Intervals i4;
  Intervals tree;

  @Before
  public void setUp() {
    i1 = new IntervalTree("1,4 2,5 U");
  }

  @Test
  public void test1() {
    Interval expected = new Interval(1, 5);
    assertEquals(expected, i1.evaluate());
    i1 = new IntervalTree("1,2 3,4 4,6 U 3,5 I U");
  }

  @Test
  public void test2() {
    i2 = new IntervalTree("1,2 3,4 4,6 U 3,5 I U");
  }

  @Test(expected = IllegalArgumentException.class)
  public void test3() {
    i2 = new IntervalTree(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test4() {
    i2 = new IntervalTree("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void test5() {
    i2 = new IntervalTree("   ");
  }

  @Test
  public void test6() {
    i2 = new IntervalTree("1,2 ");
  }

  @Test(expected = IllegalArgumentException.class)
  public void test8() {
    i2 = new IntervalTree("1, 2");
    i2 = new IntervalTree("1 2 3");
    i2 = new IntervalTree("1,2 3 U");
    i2 = new IntervalTree("1,2 3,4 K");
  }

  @Test
  public void test9() {
    i2 = new IntervalTree("1,2 3,4 I");
    Interval i = i2.evaluate();
    Interval iExpected = new Interval(-2147483648,-2147483648);
    assertEquals(i, iExpected);
  }

  @Test
  public void test10() {
    i2 = new IntervalTree("-100,100 100,1000 U 3,4 I");
    assertEquals(new Interval(3,4), i2.evaluate());
  }

  @Test(expected = IllegalArgumentException.class)
  public void test11() {
    i2 = new IntervalTree("a,b c,d I");
  }

  @Test(expected = IllegalArgumentException.class)
  public void test13() {
    i2 = new IntervalTree("2.3,1.2 3.1,5 U");
    i2 = new IntervalTree("1*");
    i2 = new IntervalTree("1 I 5");
    i2 = new IntervalTree("1,3I2,4");
    i2 = new IntervalTree("0");
    i2 = new IntervalTree("10");
  }

  @Test
  public void test14() {
    tree = new IntervalTree("1,3 3,5 I");
    System.out.println(tree.evaluate());
    i1 = new IntervalTree("1,2 1,2 I");
    System.out.println(i1.evaluate());
    i1 = new IntervalTree("1,2 1,2 U");
    System.out.println(i1.evaluate());
  }

  @Test(expected = IllegalArgumentException.class)
  public void test15() {
    tree = new IntervalTree("1,3 3,5");
    tree = new IntervalTree("2,3 + 3,6 4,8 5,7 U I 6,8 I 8,9 U");
  }

  @Test
  public void test16() {
    tree = new IntervalTree("-2147483648,1 3,2147483647 U");
    assertEquals(new Interval(-2147483648,2147483647), tree.evaluate());
    tree = new IntervalTree("-2147483648,1 3,2147483647 U");
    assertEquals(new Interval(-2147483648,2147483647), tree.evaluate());
    tree = new IntervalTree("-2147483648,-2147483648 -2147483648,-2147483648 I");
    assertEquals(new Interval(-2147483648,-2147483648), tree.evaluate());
    i = new IntervalTree("-2147483648,-2147483648 -2147483648,-2147483648 U");
    assertEquals(new Interval(-2147483648,-2147483648), tree.evaluate());
    i = new IntervalTree("3,10 5,12 U 4,4 I");
    assertEquals(new Interval(-2147483648,-2147483648), tree.evaluate());
  }

  @Test
  public void test12() {
    i = new IntervalTree("1,4 2,5 I");
    i = new IntervalTree(" -2147483648,1 3,2147483647 U");
    i = new IntervalTree("1,3 4,8 I 3,18 U 1,2 9,10 I  7,10 U I");
    i = new IntervalTree("1,4 2,8 I 3,6 4,20 I I");
    i = new IntervalTree("-4,4 2,5 U  -1,4 I ");
    i = new IntervalTree("3,7 2,6 4,10 I U");
    i = new IntervalTree("1,4 2,5 I");
  }
}