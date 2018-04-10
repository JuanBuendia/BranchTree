package model;

import java.util.ArrayList;

public class Node {

	private String info;
	private Node superiorNode;
	private ArrayList<Node> nodeList;
	
	public Node(String info) {
		this.info = info;
		nodeList = new ArrayList<>();
	}
	
	public Node(String info, Node superior) {
		this.info = info;
		this.superiorNode = superior;
		nodeList = new ArrayList<>();
	}
	
	public String getInfo() {
		return info;
	}
	
	public Node getFather() {
		return superiorNode;
	}

	public Node getBranch(Node nodeToSearch) {
		for (Node node : nodeList) {
			if(nodeToSearch.equals(node)) {
				return node;
			}
		}return null;
	}
	
	public void addNode(Node son) {
		nodeList.add(son);
	}

	public ArrayList<Node> getNodeList() {
		return nodeList;
	}

	@Override
	public String toString() {
		return "Node [info=" + info + ", nodeList=" + nodeList + "]";
	}
}