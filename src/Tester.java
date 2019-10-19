import expression.Expression;
import expression.ExpressionTree;

public class Tester {
  public static void main(String[] args) {
    //Expression e = new ExpressionTree("1 2 +");
    Expression e = new ExpressionTree("1.2 5.4 *   -4.5 + ");
    double res = e.evaluate();
    System.out.println(res);
  }
}