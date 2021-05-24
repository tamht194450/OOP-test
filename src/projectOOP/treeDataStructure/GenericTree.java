package projectOOP.treeDataStructure;

import java.util.LinkedList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GenericTree {
	private Node rootNode;
	private LinkedList<Node> queue;
	private Node currentNode;
	
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
	
	public void traversalBFS() {
		queue = new LinkedList<Node>();
		queue.add(rootNode);
		
		Timeline timeline = new Timeline();
		
		KeyFrame kf1 = new KeyFrame(Duration.seconds(1),
	        new EventHandler<ActionEvent>() {
		  		public void handle(ActionEvent event) {
		  			nextStep();
		  		}
		} );
		
		KeyFrame kf2 = new KeyFrame(Duration.seconds(2),
	        new EventHandler<ActionEvent>() {
		  		public void handle(ActionEvent event) {
			  		currentNode.getCircle().setFill(Color.LIGHTGREEN);
			  	}
		} );
		
		timeline.getKeyFrames().add(kf1);
		timeline.getKeyFrames().add(kf2);
		timeline.setCycleCount(3);
		timeline.play();
		}
	
	public void nextStep() {
		currentNode = this.queue.getFirst();
		currentNode.getCircle().setFill(Color.LIGHTBLUE);
    	
		if (!currentNode.getChildNodes().isEmpty()) {
			for (Node node: currentNode.getChildNodes()) {
				node.getCircle().setFill(Color.LIGHTYELLOW);
				queue.add(node);
			}
		}
		queue.removeFirst();
	}
	
}
