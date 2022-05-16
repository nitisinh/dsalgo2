package binarytreeproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given the following relationships:

        Child Parent IsLeft
        15 20 true
        19 80 true
        17 20 false
        16 80 false
        80 50 false
        50 null false
        20 50 true

        You should return the following tree:

         50
        /  \
       20   80
      / \   / \
     15 17 19 16
Function Signature

/**
 * Represents a pair relation between one parent node and one child node inside a binary tree
 * If the _parent is null, it represents the ROOT node
 */
class Relation {
    Integer parent;
    Integer child;
    boolean isLeft;
    public Relation(Integer child, Integer parent, boolean isLeft){
        this.parent = parent;
        this.child = child;
        this.isLeft = isLeft;
    }
}


/**
 * Represents a single Node inside a binary tree
 */
class Node {
    int id;
    Node left;
    Node right;
    public  Node(int id){
        this.id = id;
        this.left = null;
        this.right = null;
    }
}


public class BuildTreeFromRelation {
    /**
     * Implement a method to build a tree from a list of parent-child relationships
     * And return the root Node of the tree
     */
    public static Node buildTree (List<Relation> relations)
    {
        Node root = null, currentNode,currentNodeParent ;
        if(relations == null) return null;
        //create a map which will contain the record of all the nodes where key will be  the id (integer value) for each node.
        Map<Integer,Node> nodeMap = new HashMap<>();
        //Iterate through each entry in relations list to create the node and update the map simultaneously.
        for(Relation relation : relations){
            //Get the current Node (from map) or create one if not present.
            currentNode = nodeMap.getOrDefault(relation.child, new Node(relation.child));
            //Handle the condition if the current node is a root node.
            if(relation.parent == null && !relation.isLeft){
                root =  currentNode;
                //update the node map.
                nodeMap.put(relation.child, root);
            }
            //Handle the non-root nodes.
            else {
                //currentNode = !nodeMap.containsKey(relation.child) ? new Node(relation.child) : nodeMap.get(relation.child);
                //Find the parent of the current node from the map or create the parent node if not found.
                currentNodeParent = nodeMap.getOrDefault(relation.parent, new Node(relation.parent));
                //Place the current node to the left or right based on the entry in relation
                if(relation.isLeft) currentNodeParent.left = currentNode;
                else currentNodeParent.right = currentNode;
                //update the current node entry in the map
                nodeMap.put(relation.child,currentNode);
                //update the entry for the parent node in the map/
                nodeMap.put(relation.parent,currentNodeParent);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        List<Relation> relations = new ArrayList<>();
        relations.add(new Relation(15 ,20, true));
        relations.add(new Relation(19, 80, true));
        relations.add(new Relation(17, 20, false));
        relations.add(new Relation(16, 80, false));
        relations.add(new Relation(80, 50, false));
        relations.add(new Relation(50, null, false));
        relations.add(new Relation(20, 50, true));
        System.out.println(relations);
        Node root = buildTree(relations);
        System.out.println(root.id);
    }
}
