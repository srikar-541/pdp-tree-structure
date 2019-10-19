package BinaryTree;
import data.Data;
import data.Operand;


public class GroupNode implements TreeNode {
  private Data operator;
  private TreeNode left;
  private TreeNode right;

  public GroupNode(Data operator, TreeNode left, TreeNode right) {
    this.operator = operator;
    this.left = left;
    this.right = right;
  }

  @Override
  public String getPreOrder() {
    StringBuilder result = new StringBuilder();

    result.append(this.operator)
            .append(this.left.getPreOrder())
            .append(this.right.getPreOrder());
    return result.toString();
  }

  @Override
  public String getInOrder() {
    StringBuilder result = new StringBuilder();
    result.append("(")
            .append(this.left.getInOrder())
            .append(this.operator)
            .append(this.right.getInOrder())
            .append(")");

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
      default:
        return leftOperand.divide(rightOperand);
    }
  }
}
