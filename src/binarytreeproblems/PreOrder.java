package binarytreeproblems;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


public class PreOrder {
    /**
     * A non - recursive approach to print the pre order traversal of the Binary Tree
     * pseudo code -
     *  push root to stack
     *  while stack is not empty
     *      pop the node
     *      process the node
     *      if node has right
     *          push node.right
     *      if node has left
     *          push node.left
     * @param root
     */
    public static List<Integer> iterativeTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root != null) {
            Stack<TreeNode> nodeStack = new Stack<TreeNode>();

            nodeStack.push(root);
            while(!nodeStack.isEmpty()){
                TreeNode temp= nodeStack.pop();
                result.add(temp.data);
                if(temp.right != null) nodeStack.push(temp.right);
                if(temp.left !=null ) nodeStack.push(temp.left);
            }
        }
        return result;

    }
}
