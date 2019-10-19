package intervals;

import java.util.Stack;

import generictree.ElementNode;
import generictree.EmptyNode;
import generictree.GenericTreeNode;

public class IntervalTree implements Intervals {

  private GenericTreeNode treeRoot;

  private Stack<GenericTreeNode> validationStack;

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
