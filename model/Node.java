package model;

import java.util.ArrayList;

public class Node {

	private String info;
	private ArrayList<Node> nodeList;
	
	public Node(String info) {
		this.info = info;
		nodeList = new ArrayList<>();
	}
	
	public String getInfo() {
		return info;
	}

	public ArrayList<Node> getNodeList() {
		return nodeList;
	}

	@Override
	public String toString() {
		return "Node [info=" + info + ", nodeList=" + nodeList.size() + "]";
	}
}