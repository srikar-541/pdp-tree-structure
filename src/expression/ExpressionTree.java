package expression;

import java.util.function.BiFunction;

import abstraction.AbstractTree;
import data.ExpressionOperand;
import data.Operand;

public class ExpressionTree extends AbstractTree implements Expression {

  public ExpressionTree(String input) {
    super(input);
  }

  @Override
  protected Operand createOperand(String identifier) {
    return new ExpressionOperand(identifier);
  }

  @Override
  protected boolean isOperand(String identifier) throws IllegalArgumentException {
    boolean doubleValue = false;
    int i = 0;
    if (identifier.charAt(0) == '-' || identifier.charAt(0) == '+') {
      i = 1;
    }
    while (i < identifier.length()) {
      char c = identifier.charAt(i);
      if (c == '.') {
        if (doubleValue) {
          throw new IllegalArgumentException("Invalid data");
        }
        doubleValue = true;
      } else if (!Character.isDigit(c)) {
        throw new IllegalArgumentException("Give valid input");
      }
      i++;
    }
    return true;
  }

  protected boolean isOperator(String identifier) {
    return (identifier.equals("+") || identifier.equals("-") || identifier.equals("/") || identifier.equals("*"));
  }

  @Override
  public double evaluate() {
    ExpressionOperand eo = ((ExpressionOperand) this.treeRoot.calculate());
    return eo.getValue();
  }

  @Override
  public String schemeExpression() {
    return this.treeRoot.getPreOrder();
  }

  @Override
  protected BiFunction<ExpressionOperand, ExpressionOperand,
          ExpressionOperand> createBiFunctionObject(String identifier) {
    switch (identifier) {
      case "+":
        return ExpressionOperand::add;
      case "-":
        return ExpressionOperand::subtract;
      case "*":
        return ExpressionOperand::multiply;
    }
    return ExpressionOperand::divide;
  }
}
