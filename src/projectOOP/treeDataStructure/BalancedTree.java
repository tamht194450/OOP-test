package projectOOP.treeDataStructure;

import java.util.ArrayList;

public class BalancedTree extends GenericTree{

    int k;
    private ArrayList<Node> listNode = new ArrayList<Node>();

    public BalancedTree(Node root){
        super(root);
        listNode.add(root);
    }

    public boolean insertNode(int parentValue, int nodeValue) {
        int depthDif = 0;
        Node parentNode = this.searchNode(parentValue);

        for (Node node:listNode){
            if (parentNode.getDepth() - node.getDepth() > depthDif){
                depthDif = parentNode.getDepth() + 1 - node.getDepth();
            }
        }

        if (depthDif <= k) {

            parentNode.addChild(new Node(nodeValue));
            return true;
        } else {
            return false;
        }
    }


}
