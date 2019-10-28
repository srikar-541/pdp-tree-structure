
import org.junit.Before;
import org.junit.Test;

import intervals.Interval;
import intervals.IntervalTree;
import intervals.Intervals;

import static org.junit.Assert.*;

public class IntervalTreeTest {

  Intervals i1;
  Intervals i2;
  Intervals i3;
  Intervals i4;

  @Before
  public void setUp(){
    i1=new IntervalTree("1,4 2,5 U");
  }

  @Test
  public void test1(){
    Interval expected=new Interval(1,5);
    assertEquals(expected,i1.evaluate());
    i1 = new IntervalTree("1,2 3,4 4,6 U 3,5 I U");
    System.out.printf("jds");
  }

  @Test
  public void test2(){
    i2=new IntervalTree("1,2 3,4 4,6 U 3,5 I U");
    System.out.println(i2.textTree());
  }
}