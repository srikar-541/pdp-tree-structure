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
  public void getTextTree(StringBuilder result,StringBuilder common, int operatorCount, boolean left) {
    result.append("\n");
    if (operatorCount-1==0){
      result.append("|\n");
      result.append("|");
    }
    else{
      result.append("    |".repeat(Math.max(0, operatorCount - 2)));
      result.append("   |".repeat(1));
      result.append("\n");
      result.append("    |".repeat(Math.max(0, operatorCount - 2)));
      result.append("   |".repeat(1));
    }
    result.append("___");
    result.append(this.operand.toString());
  }


}
