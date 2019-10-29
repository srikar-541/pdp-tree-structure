package binarytree;

import data.Operand;
import data.Operator;

/**
 * The non-leafy nodes of the binary tree which contains data as operators.
 * It has specific implementation like textTree, data it carries, preorder, inorder operations etc.
 * The left pointer points to left subtree and right children may be operators or operands.
 */
public class GroupNode implements TreeNode {
  final private Operator operator;
  final private TreeNode left;
  final private TreeNode right;

  /**
   *  This constructor creates a new GroupNode object by  taking parameters as in data to be
   *  in group node and left and right pointers of the subtree.
   * @param operator      The data in the node which is always an operator.
   * @param left          The pointer to the left subtree.
   * @param right         The pointer to the right subtree.
   */
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
  public void getTextTree(StringBuilder result, int level) {
    if (level == 0) {
      result.append(this.operator.toString());
      result.append("\n|\n|\n|");
    } else {
      result.append("   ".repeat(Math.max(0, level - 1)));
      result.append("|\n");
      result.append("   ".repeat(Math.max(0, level - 1)));
      result.append("|___");
      result.append(this.operator.toString());
      result.append('\n');
      result.append("   |".repeat(Math.max(0, level)));
      result.append("\n");
    }
    level = level + 1;
    this.left.getTextTree(result, level);
    this.right.getTextTree(result, level);
  }
}
