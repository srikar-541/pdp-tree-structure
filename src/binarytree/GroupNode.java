package binarytree;

import data.Operand;
import data.Operator;

public class GroupNode implements TreeNode {
  final private Operator operator;
  final private TreeNode left;
  final private TreeNode right;

  public GroupNode(Operator operator, TreeNode left, TreeNode right) {
    this.operator = operator;
    this.left = left;
    this.right = right;
  }

  @Override
  public String getPreOrder() {
    StringBuilder result = new StringBuilder();
    result.append("(" + this.operator + " ")
            .append(this.left.getPreOrder() + " ")
            .append(this.right.getPreOrder() + ")");
    return result.toString();
  }

  @Override
  public String getInOrder() {
    StringBuilder result = new StringBuilder();
    result.append("( " + this.left.getInOrder() + " ")
            .append(this.operator + " ")
            .append(this.right.getInOrder() + " )");

    return result.toString();
  }

  @Override
  public Operand calculate() {
    Operand leftResult = this.left.calculate();
    Operand rightResult = this.right.calculate();
    return this.operator.evaluate(leftResult, rightResult);
  }

  @Override
  public void getTextTree(StringBuilder result, int operatorCount) {
    if (operatorCount == 0) {
      result.append(this.operator.toString());
      result.append("\n|\n|\n|");
    } else {
      result.append("   ".repeat(Math.max(0, operatorCount - 1)));
      result.append("|\n");
      result.append("   ".repeat(Math.max(0, operatorCount - 1)));
      result.append("|___");
      result.append(this.operator.toString());
      result.append('\n');
      result.append("   |".repeat(Math.max(0, operatorCount)));
      result.append("\n");
    }
    operatorCount = operatorCount + 1;
    this.left.getTextTree(result, operatorCount);
    this.right.getTextTree(result, operatorCount);
  }
}
