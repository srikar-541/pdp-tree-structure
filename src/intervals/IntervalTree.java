package intervals;

import java.util.Stack;

import BinaryTree.GroupNode;
import BinaryTree.LeafNode;
import BinaryTree.TreeNode;
import data.IntervalOperand;
import data.Operand;
import data.Operator;

public class IntervalTree implements Intervals {

  private TreeNode treeRoot;
  private Stack<TreeNode> validationStack;

  public IntervalTree(String input) {
    if (input == null) {
      throw new IllegalArgumentException("Invalid data");
    }
    validationStack = new Stack<>();
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
          Operator d = new Operator(s);
          this.treeRoot = new GroupNode(d, left, right);
          validationStack.push(this.treeRoot);
        }
      } else if (isOperand(s)) {
        Operand d = new IntervalOperand(s);
        validationStack.push(new LeafNode(d));
      }
    }
    if (validationStack.size() > 1) {
      throw new IllegalArgumentException("Incomplete Input");
    }
  }

  private boolean isOperand(String id) throws IllegalArgumentException {
    if (!id.contains(",")) {
      throw new IllegalArgumentException("Invalid data");
    }
    String[] iList = id.split(",");
    for (int i = 0; i < iList.length; i++) {
      checkValidInteger(iList[i]);
    }
    return true;
  }

  private void checkValidInteger(String id) {
    if (id.contains(".")) {
      throw new IllegalArgumentException("da");
    }
    int i = 0;
    if (id.charAt(0) == '-' || id.charAt(0) == '+') {
      i = 1;
    }
    while (i < id.length()) {
      char c = id.charAt(i);
      if (!Character.isDigit(c)) {
        throw new IllegalArgumentException("Illegal");
      }
      i++;
    }
  }

  private boolean isOperator(String id) {
    return (id.equals("U") || id.equals("I"));
  }

  @Override
  public Interval evaluate() {
    return ((IntervalOperand) this.treeRoot.calculate()).getData();
  }
}
