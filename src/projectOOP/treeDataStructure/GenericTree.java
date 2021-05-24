package projectOOP.treeDataStructure;

import java.util.LinkedList;

public class GenericTree {
	private Node rootNode;
	
	public GenericTree(Node node) {
		this.rootNode = node;
	}
	
	public Node searchNode(int nodeValue) {
		if (rootNode.getValue() == nodeValue) {
			return rootNode;
		}
		
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(rootNode);
		Node currentNode;
		
		while(!queue.isEmpty()) {
			currentNode = queue.getFirst();
			
			if (!currentNode.getChildNodes().isEmpty()) {
				for (Node node: currentNode.getChildNodes()) {
					if (node.getValue() == nodeValue) {
						return node;
					} else {
						queue.add(node);
					}
				}
			}
			queue.removeFirst();
		}
		return new Node(0);
	}
	
	public boolean insertNode(int parentValue, int nodeValue) {
		Node parentNode = this.searchNode(parentValue);
		parentNode.addChild(new Node(nodeValue));
		return true;
	}

	public Node getRootNode() {
		return rootNode;
	}
	
}
