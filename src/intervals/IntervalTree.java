package intervals;

import java.util.Stack;

import BinaryTree.TreeNode;

public class IntervalTree implements Intervals {

  private TreeNode treeRoot;

  private Stack<TreeNode> validationStack;

  private boolean isOperand(String id) throws IllegalArgumentException {
    return false;
  }

  private boolean isOperator(String id) {
    return (id.equals("U") || id.equals("I"));
  }

  @Override
  public Interval evaluate() {
    return null;
  }
}
