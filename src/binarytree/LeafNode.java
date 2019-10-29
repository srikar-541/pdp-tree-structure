package binarytree;

import data.Operand;

/**
 * The leaf nodes in the tree-representation of the data.
 * This contains only operands as data.
 * It carries same methods as GroupNode because it implements TreeNode.
 */
public class LeafNode implements TreeNode {
  private final Operand operand;

  /**
   *  This creates a new LeafNode object of the tree  by taking param as the data i.e. an operand
   *  which should go into this node.
   * @param    operand The operand which is specific to implementation of ExpressionTree and
   *                   IntervalTree which is to be stored in the node's data.
   */
  public LeafNode(Operand operand) {
    this.operand = operand;
  }

  @Override
  public String getPreOrder() {
    return operand.toString();
  }

  @Override
  public String getInOrder() {
    return operand.toString();
  }

  @Override
  public Operand calculate() {
    return this.operand;
  }

  @Override
  public void getTextTree(StringBuilder result, int level) {
    result.append("   |".repeat(Math.max(0, level - 1)));
    if (level - 1 != 0) {
      result.append("\n");
    }
    result.append("   |".repeat(Math.max(0, level - 1)));
    result.append("___");
    result.append(this.operand.toString());
    result.append("\n");
  }
}
