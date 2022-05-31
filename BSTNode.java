class BstNode {
  public long val;
  public BstNode left;
  public BstNode right;

  public BstNode(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }

  public BstNode(int val, BstNode Left, BstNode Right) {
    this.val = val;
    this.left = Left;
    this.right = Right;
  }

  public String printTree(){
    StringBuilder sb = new StringBuilder();
    if (this.left != null) {
      sb.append(this.left.printTree());
    } else {
      sb.append("[N ");
    }
    
    sb.append("(" + this.val + ")");
    
    if (this.right != null) {
      sb.append(this.right.printTree());
    }
    else {
      sb.append(" N]");
    }

    return sb.toString();
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("BST Node\n");
    sb.append("Value = " + this.val + "\n");
    if (this.left != null) {
      sb.append("Immeditate Left = " + this.left.val + "\n");
    }
    else {
      sb.append("Nothing on left side\n");
    }
    if (this.right != null) {
      sb.append("Immeditate Right = " + this.right.val + "\n");
    }
    else {
      sb.append("Nothing on right side\n");
    }
    return sb.toString();
  }


  // LC Validate Binary Tree 
  public static boolean checkBalancedBinaryTree(BstNode tree) {
    if (tree == null) return true;
    return tree.isBalancedTree(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  // return true if this binary tree is a balanced binary tree
  public boolean isBalancedTree(BstNode root, long min, long max){
    // root nodes are always balanced, but check for root value against endpoint
    if (root.left == null && root.right == null) {
      return (root.val >= min && root.val <= max);
    }

    // check middle, left side, then check right
    return 
      (root.val >= min && root.val <= max) &&
       (root.left == null || isBalancedTree(root.left, min, ((long)root.val - 1L))) &&
       (root.right == null || isBalancedTree(root.right, ((long)root.val + 1L), max));
  }
}