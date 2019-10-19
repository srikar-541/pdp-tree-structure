package expression;
import java.util.Stack;
import data.ExpressionOperand;
import data.Operand;
import data.Operator;
import BinaryTree.GroupNode;
import BinaryTree.LeafNode;
import BinaryTree.TreeNode;

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
  }

  private boolean isOperand(String id) throws IllegalArgumentException {
    boolean doubleValue = false;
    for (int i = 0; i < id.length(); i++) {
      char c = id.charAt(i);
      if (c == '.') {
        if (doubleValue) {
          throw new IllegalArgumentException("Invalid data");
        }
        doubleValue = true;
      } else if (!Character.isDigit(c)) {
        throw new IllegalArgumentException("Give valid input");
      }
    }
    return true;
  }

  private boolean isOperator(String id) {
    return (id.equals("+") || id.equals("-") || id.equals("/")
            || id.equals("%") || id.equals("*"));
  }

  @Override
  public double evaluate() {
    return ((ExpressionOperand)this.treeRoot.calculate()).getData();
  }

  @Override
  public String infix() {
    return null;
  }

  @Override
  public String schemeExpression() {
    return null;
  }
}
