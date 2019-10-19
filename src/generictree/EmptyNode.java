package generictree;

import data.Operand;

public class EmptyNode implements GenericTreeNode {
  Operand operand;

  public EmptyNode(Operand d) {
    this.operand = d;
  }

  @Override
  public String getPreOrder() {
    return "";
  }

  @Override
  public String getInOrder() {
    return "";
  }

  @Override
  public Operand calculate() {
    return this.operand;
  }
}
