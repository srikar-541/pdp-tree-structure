package abstraction;

import java.util.Stack;
import java.util.function.BiFunction;

import binarytree.TreeNode;

public abstract class AbstractTree {
  protected TreeNode treeRoot;
  protected Stack<TreeNode> validationStack;

  protected AbstractTree(String input) {
    validationStack = new Stack<>();
  }

  public String textTree() {
    StringBuilder result=new StringBuilder();
    return treeRoot.getTextTree(result,0).toString();
  }

  public String infix() {
    return this.treeRoot.getInOrder();
  }

  protected abstract boolean isOperator(String id);

  protected abstract boolean isOperand(String id) throws IllegalArgumentException;

  protected void isInvalidAfterParsing() {
    if (validationStack.size() == 1) {
      this.treeRoot = validationStack.pop();
      return;
    }
    if (validationStack.size() > 1) {
      throw new IllegalArgumentException("Exception");
    }
  }
}
