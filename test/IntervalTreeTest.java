import org.junit.Before;
import org.junit.Test;

import intervals.Interval;
import intervals.IntervalTree;
import intervals.Intervals;

import static org.junit.Assert.assertEquals;

class IntervalTreeTest {

  Intervals i;
  Intervals i1;
  Intervals i2;

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
    assertEquals(new Interval(1,5), i2.evaluate());
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
    assertEquals(new Interval(1,2), i2.evaluate());
  }

  @Test
  public void test9() {
    i2 = new IntervalTree("1,2 3,4 I");
    Interval i = i2.evaluate();
    Interval iExpected = new Interval(-2147483648, -2147483648);
    assertEquals(i, iExpected);
  }

  @Test
  public void test10() {
    i2 = new IntervalTree("-100,100 100,1000 U 3,4 I");
    assertEquals(new Interval(3, 4), i2.evaluate());
  }

  @Test(expected = IllegalArgumentException.class)
  public void test11() {
    i2 = new IntervalTree("a,b c,d U e,f I");
  }

  @Test
  public void test14() {
    i = new IntervalTree("1,3 3,5 I");
    assertEquals(new Interval(3,3), i.evaluate());
    i1 = new IntervalTree("1,2 1,2 I");
    assertEquals(new Interval(1,2), i1.evaluate());
  }

  @Test(expected = IllegalArgumentException.class)
  public void test15() {
    i = new IntervalTree("1,3 3,5");
    i1 = new IntervalTree("1,2 1,2 I");
    assertEquals(new Interval(1,2), i.evaluate());
  }

  @Test
  public void test16() {
    i = new IntervalTree("-2147483648,1 3,2147483647 U");
    assertEquals(new Interval(-2147483648, 2147483647), i.evaluate());
    i = new IntervalTree("-2147483648,1 3,2147483647 U");
    assertEquals(new Interval(-2147483648, 2147483647), i.evaluate());
    i = new IntervalTree("-2147483648,-2147483648 -2147483648,-2147483648 I");
    assertEquals(new Interval(-2147483648, -2147483648), i.evaluate());
    i = new IntervalTree("-2147483648,-2147483648 -2147483648,-2147483648 U");
    assertEquals(new Interval(-2147483648, -2147483648), i.evaluate());
    i = new IntervalTree("3,10 5,12 U 4,4 I");
    assertEquals(new Interval(4, 4), i.evaluate());
  }

  @Test
  public void test12() {
    i = new IntervalTree("1,4 2,5 I");
    assertEquals(new Interval(2, 4), i.evaluate());
    i = new IntervalTree(" -2147483648,1 3,2147483647 U");
    assertEquals(new Interval(-2147483648, 2147483647), i.evaluate());
    i = new IntervalTree("1,3 4,8 I 3,18 U 1,2 9,10 I  7,10 U I");
    assertEquals(new Interval(-2147483648, 10), i.evaluate());
    i = new IntervalTree("1,4 2,8 I 3,6 4,20 I I");
    assertEquals(new Interval(4, 4), i.evaluate());
    i = new IntervalTree("-4,4 2,5 U  -1,4 I ");
    assertEquals(new Interval(-1, 4), i.evaluate());
    i = new IntervalTree("3,7 2,6 4,10 I U");
    assertEquals(new Interval(3, 7), i.evaluate());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid1() {
    i = new IntervalTree("1,2 2,3 u");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid2() {
    i = new IntervalTree("1,2 2,3 i");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid3() {
    i = new IntervalTree("1,2 U 2,3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid4() {
    i = new IntervalTree("U 1,2 2,3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid5() {
    i = new IntervalTree("1 2 U");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid6() {
    i = new IntervalTree("1 U 2");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid7() {
    i = new IntervalTree("1,2 2,3 + 3,4 -");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid8() {
    i2 = new IntervalTree("2.3,1.2 3.1,5 U");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid9() {
    i2 = new IntervalTree("1*");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid10() {
    i2 = new IntervalTree("1 I 5");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid11() {
    i2 = new IntervalTree("1,3I2,4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid12() {
    i2 = new IntervalTree("0");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid13() {
    i2 = new IntervalTree("10");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid14() {
    i2 = new IntervalTree("2,3 + 3,6 4,8 5,7 U I 6,8 I 8,9 U");
  }

  @Test
  public void valid1() {
    i2 = new IntervalTree("1,2 2,3 U 4,5 U -8,6 I");
    String s = i2.textTree();
    s = s.replace("|", "");
    s = s.replace("_", "");
    s = s.replace("\n", "");
    s = s.replace(" ", "");
    assertEquals("IUU1,22,34,5-8,6", s);
  }

  @Test
  public void valid2() {
    i2 = new IntervalTree("1,2 -2,3 U");
    String s = i2.textTree();
    s = s.replace("|", "");
    s = s.replace("_", "");
    s = s.replace("\n", "");
    s = s.replace(" ", "");
    assertEquals("U1,2-2,3", s);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid15() {
    i2 = new IntervalTree("1, 2");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid16() {
    i2 = new IntervalTree("1 2 3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid17() {
    i2 = new IntervalTree("1,2 3 U");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid18() {
    i2 = new IntervalTree("1,2 3,4 K");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid19() {
    i2 = new IntervalTree("1,0 -2,-3 U");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid20() {
    i2 = new IntervalTree("1.1,2.2 2,3 U");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalid21() {
    i2 = new IntervalTree("(1,2) (2,3) U");
  }
}