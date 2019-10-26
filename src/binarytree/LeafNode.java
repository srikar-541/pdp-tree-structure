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

  @Override
  public void getTextTree(StringBuilder result, int operatorCount) {
    for (int i=0;i<operatorCount-1;i++){
      result.append(" ");
    }
    result.append("|\n");
    result.append("|\n");
    result.append("_\n");
    result.append("_\n");
    result.append("_\n");
    result.append(this.operand.toString());
  }
}
