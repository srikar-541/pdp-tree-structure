
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
    Interval expexted=new Interval(1,5);
    assertEquals(expexted,i1.evaluate());
  }

}