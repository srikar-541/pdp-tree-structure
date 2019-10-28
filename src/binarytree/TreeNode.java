package binarytree;

import data.Operand;

public interface TreeNode {

  String getPreOrder();

  String getInOrder();

  Operand calculate();

  void getTextTree(StringBuilder result,StringBuilder common, int operatorCount, boolean left);
}
