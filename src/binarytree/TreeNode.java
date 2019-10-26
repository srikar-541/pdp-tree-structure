package binarytree;

import data.Operand;

public interface TreeNode {

  String getPreOrder();

  String getInOrder();

  Operand calculate();

  StringBuilder getTextTree(StringBuilder result, int operatorCount);
}
