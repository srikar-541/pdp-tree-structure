package binarytree;

import data.Operand;

public class LeafNode implements TreeNode {
  Operand operand;

  public LeafNode(Operand d) {
    this.operand = d;
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
}
