package projectOOP.treeScreen;

import projectOOP.treeDataStructure.GenericTree;
import projectOOP.treeDataStructure.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class TreeScreenController {
	private GenericTree tree;
	private TreeScreen treeScreen;
	
    @FXML
    private TextField tfChild;

    @FXML
    private Pane drawingTreePane;

    private StackPane rootNode;

    @FXML
    private TextField tfParent;

	public TreeScreenController(GenericTree tree) {
		super();
		this.tree = tree;
		
	}
	public void initialize() {
		this.rootNode = this.tree.getRootNode();
		this.drawingTreePane.getChildren().add(this.rootNode);
		System.out.println(this.drawingTreePane.getWidth());
		this.rootNode.setLayoutX(this.drawingTreePane.getPrefWidth()/2);
	}
	
    @FXML
    void btnAddNodePressed(ActionEvent event) {
    	Node parentNode = tree.searchNode(Integer.parseInt(this.tfParent.getText()));
    	Node childNode = new Node(Integer.parseInt(this.tfChild.getText()));
    	
    	
    	parentNode.addChild(childNode);
    	this.drawingTreePane.getChildren().add(childNode);
    	this.drawingTreePane.getChildren().add(childNode.getParentLine());
    	
    }
}
