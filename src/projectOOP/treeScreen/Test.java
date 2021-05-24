package projectOOP.treeScreen;

import projectOOP.treeDataStructure.GenericTree;
import projectOOP.treeDataStructure.Node;

public class Test {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		GenericTree tree = new GenericTree(n1);
		
		
		TreeScreen treeScreen = new TreeScreen(tree);
	}
}
