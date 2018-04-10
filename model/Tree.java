package model;

public class Tree {

	private Node root;
	
	public void addNode(Node node) {
		if(root != null) {
			add(root, node);
		}else {
			root = node;
		}
	}

	private void add(Node base, Node node) {
		base.addNode(node);
	}
}