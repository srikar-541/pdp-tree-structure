package binarytree;

import data.Data;
import data.Operand;

public class GroupNode implements TreeNode {
  final private Data operator;
  final private TreeNode left;
  final private TreeNode right;

  public GroupNode(Data operator, TreeNode left, TreeNode right) {
    this.operator = operator;
    this.left = left;
    this.right = right;
  }

  @Override
  public String getPreOrder() {
    StringBuilder result = new StringBuilder();
    result.append("(")
            .append(this.operator)
            .append(" ")
            .append(this.left.getPreOrder())
            .append(" ")
            .append(this.right.getPreOrder())
            .append(")");
    return result.toString();
  }

  @Override
  public String getInOrder() {
    StringBuilder result = new StringBuilder();
    result.append("( ")
            .append(this.left.getInOrder() + " ")
            .append(this.operator + " ")
            .append(this.right.getInOrder())
            .append(" )");

    return result.toString();
  }

  @Override
  public Operand calculate() {
    Operand leftResult = this.left.calculate();
    Operand rightResult = this.right.calculate();
    return compute(leftResult, rightResult);
  }

  private Operand compute(Operand leftOperand, Operand rightOperand) {

    switch (operator.toString()) {
      case "+":
        return leftOperand.add(rightOperand);
      case "-":
        return leftOperand.subtract(rightOperand);
      case "*":
        return leftOperand.multiply(rightOperand);
      case "%":
        return leftOperand.modulo(rightOperand);
      case "U":
        return leftOperand.union(rightOperand);
      case "I":
        return leftOperand.intersect(rightOperand);
      default:
        return leftOperand.divide(rightOperand);
    }
  }
}
