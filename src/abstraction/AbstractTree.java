package abstraction;

import java.util.Stack;
import java.util.function.BiFunction;

import binarytree.GroupNode;
import binarytree.LeafNode;
import binarytree.TreeNode;
import data.Operand;
import data.Operator;

abstract class AbstractTree {
  protected TreeNode treeRoot;
  private Stack<TreeNode> validationStack;

  protected AbstractTree(String input) {
    validationStack = new Stack<>();
    if (input == null || input.length() == 0) {
      throw new IllegalArgumentException("Illegal Arugmnets");
    }
    validateInput(input);
  }

  public String textTree() {
    StringBuilder result = new StringBuilder();
    treeRoot.getTextTree(result, 0);
    return result.toString();
  }

  public String infix() {
    return this.treeRoot.getInOrder();
  }

  protected abstract boolean isOperator(String identifier);

  protected abstract boolean isOperand(String identifier) throws IllegalArgumentException;

  private void isInvalidAfterParsing() {
    if (validationStack.size() == 1) {
      this.treeRoot = validationStack.pop();
      return;
    }
    if (validationStack.size() > 1) {
      throw new IllegalArgumentException("Exception");
    }
  }

  private void validateInput(String input) throws IllegalArgumentException {
    String[] terms = input.split(" ");
    for (String term : terms) {
      if (term.length() == 0) {
        continue;
      }
      if (isOperator(term)) {
        if (validationStack.size() < 2) {
          throw new IllegalArgumentException("Illegal arguments");
        } else {
          TreeNode right = validationStack.pop();
          TreeNode left = validationStack.pop();
          BiFunction biFunction = createBiFunctionObject(term);
          Operator operator = new Operator(term, biFunction);
          this.treeRoot = new GroupNode(operator, left, right);
          validationStack.push(this.treeRoot);
        }
      } else if (isOperand(term)) {
        Operand operand = createOperand(term);
        validationStack.push(new LeafNode(operand));
      }
    }
    isInvalidAfterParsing();
  }

  protected abstract Operand createOperand(String identifier);

  protected abstract BiFunction createBiFunctionObject(String identifier);
}
