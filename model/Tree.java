package model;

import java.io.File;

public class Tree {

	private Node root;
	private int totalSize;

	public Tree(File father){
		if (father.isDirectory()) {
			root = new Node(father.getName());
		}else {
			throw new NullPointerException("Seleccion no valida");
		}
	}
	
	public Tree(File father, int totalSize){
		this.totalSize = totalSize;
		if (father.isDirectory()) {
			root = new Node(father.getName());
		}else {
			throw new NullPointerException("Seleccion no valida");
		}
	}
	
	public void addToTreeFiles(File file){
		if (!file.isDirectory()) {
			String fileExtension = "";
			fileExtension = file.getName().substring(file.getName().lastIndexOf("."));
			Node nodeExtension = searchExtension(fileExtension);
			if (nodeExtension == null) {
				createFileExtension(fileExtension);
				nodeExtension = searchExtension(fileExtension);
			}
			addFileToExtension(nodeExtension, file);
		}
	}
	
	private Node searchExtension(String fileExtension) {
		for (Node actual : root.getNodeList()) {
			if (actual.getInfo().equals(fileExtension)) {
				return actual;
			}
		}
		return null;
	}
	
	private void createFileExtension(String extension){
		Node newExtension = new Node(extension);
		newExtension.getNodeList().add(new Node("Menor Tamaño"));
		newExtension.getNodeList().add(new Node("Mayor Tamaño"));
		root.getNodeList().add(newExtension);
	}
	
	public void addFileToExtension(Node nodeExtension, File file){
		Node nodeSize;
		if (file.length() < totalSize) {
			nodeSize = nodeExtension.getNodeList().get(0);
		}else {
			nodeSize = nodeExtension.getNodeList().get(1);
		}
		nodeSize.getNodeList().add(new Node(file.getName()));
	}

	public void clearTree(){
		root.getNodeList().clear();
	}
	
	public Node getRoot() {
		return root;
	}
	
	public int getTotalSize() {
		return totalSize;
	}
}