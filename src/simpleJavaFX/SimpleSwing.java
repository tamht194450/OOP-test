package simpleJavaFX;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javafx.scene.*;

public class SimpleSwing extends JFrame implements ActionListener{
	private JLabel l;
	private JPanel panel;
	private JButton btnAdd;
	private Node node;
	
	public SimpleSwing() {
		Container cp = this.getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(this);
		cp.add(btnAdd);

		node = new Node(1);
		cp.add(node);
		
		
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(panel.getHeight());
		}
	}
	
	public static void main(String[] args) {
		new SimpleSwing();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		node.value += 1;
		node.repaint();
	}
}

class Node extends JPanel{
	public int value;
	
	Node(int value) {
		super();
		this.value = value;
		
	}
	public void drawOval(Graphics g) {
		g.setColor(Color.black);
		g.drawOval(0, 0, 100, 100);
	}
	
	public void paint(Graphics g) {
		drawOval(g);
		g.drawString(this.value +"", 50, 50);
		
	}
}
