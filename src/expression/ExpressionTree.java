package expression;

import java.util.Stack;
import java.util.function.BiFunction;

import abstraction.AbstractTree;
import data.ExpressionOperand;
import data.Operand;
import data.Operator;
import binarytree.GroupNode;
import binarytree.LeafNode;
import binarytree.TreeNode;

public class ExpressionTree extends AbstractTree implements Expression {

  public ExpressionTree(String input) {
    super(input);
    validateInput(input.trim());
  }

  private void validateInput(String input) throws IllegalArgumentException {
    String[] terms = input.split(" ");
    for (String s : terms) {
      if (s.length() == 0) {
        continue;
      }
      if (isOperator(s)) {
        if (validationStack.size() < 2) {
          throw new IllegalArgumentException("Give valid input");
        } else {
          TreeNode right = validationStack.pop();
          TreeNode left = validationStack.pop();
          BiFunction biFunction = createBiFunctionObject(s);
          Operator d = new Operator(s, biFunction);
          this.treeRoot = new GroupNode(d, left, right);
          validationStack.push(this.treeRoot);
        }
      } else if (isOperand(s)) {
        validationStack.push(new LeafNode(new ExpressionOperand(s)));
      }
    }
    isInvalidAfterParsing();
  }

  @Override
  protected boolean isOperand(String id) throws IllegalArgumentException {
    boolean doubleValue = false;
    int i = 0;
    if (id.charAt(0) == '-' || id.charAt(0) == '+') {
      i = 1;
    }
    while (i < id.length()) {
      char c = id.charAt(i);
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

  protected boolean isOperator(String id) {
    return (id.equals("+") || id.equals("-") || id.equals("/") || id.equals("*"));
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

  protected BiFunction<ExpressionOperand, ExpressionOperand, ExpressionOperand> createBiFunctionObject(String op) {
    switch (op) {
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
