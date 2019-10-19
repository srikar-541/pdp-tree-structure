package expression;

import java.util.Stack;

import data.ExpressionOperand;
import data.Operand;
import data.Operator;
import binarytree.GroupNode;
import binarytree.LeafNode;
import binarytree.TreeNode;

public class ExpressionTree implements Expression {
  private TreeNode treeRoot;
  private Stack<TreeNode> validationStack;

  public ExpressionTree(String input) {
    validationStack = new Stack<>();
    validateInput(input.trim());
  }

  private void validateInput(String input) throws IllegalArgumentException {
    if (input == null) {
      throw new IllegalArgumentException("Give non null string.");
    }
    if (input.length() == 0) {
      throw new IllegalArgumentException("Empty string");
    }

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
          Operator d = new Operator(s);
          this.treeRoot = new GroupNode(d, left, right);
          validationStack.push(this.treeRoot);
        }
      } else if (isOperand(s)) {
        Operand d = new ExpressionOperand(s);
        validationStack.push(new LeafNode(d));
      }
    }
    if (validationStack.size() > 1) {
      throw new IllegalArgumentException("Incomplete Input");
    }
  }

  private boolean isOperand(String id) throws IllegalArgumentException {
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

  private boolean isOperator(String id) {
    return (id.equals("+") || id.equals("-") || id.equals("/")
            || id.equals("%") || id.equals("*"));
  }

  @Override
  public double evaluate() {
    return ((ExpressionOperand) this.treeRoot.calculate()).getData();
  }

  @Override
  public String infix() {
    return this.treeRoot.getInOrder();
  }

  @Override
  public String schemeExpression() {
    return this.treeRoot.getPreOrder();
  }
}
