import expression.Expression;
import expression.ExpressionTree;
import intervals.Interval;
import intervals.IntervalTree;
import intervals.Intervals;

public class Tester {
  public static void main(String[] args) {
    //Expression e = new ExpressionTree("1 2 +");
    /*Expression e = new ExpressionTree("6 2 / 5 +");
    double res = e.evaluate();
    System.out.println(res);
*/
    Intervals i = new IntervalTree("-4,4 2,5 U");
    Interval r = i.evaluate();
    System.out.println(r);
  }
}