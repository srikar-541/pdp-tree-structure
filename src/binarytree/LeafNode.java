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
  public StringBuilder getTextTree(StringBuilder result, int operatorCount) {
    result.append("   |".repeat(Math.max(0, operatorCount - 1)));
    if(operatorCount-1!=0) { result.append("\n");}

    result.append("   |".repeat(Math.max(0, operatorCount - 1)));
    result.append("___");
    result.append(this.operand.toString());
    result.append("\n");
    return result;
  }

}
