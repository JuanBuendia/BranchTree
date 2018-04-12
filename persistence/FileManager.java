package persistence;

import java.io.File;

import model.Node;
import model.Tree;

public class FileManager {
	
	private File father;
	private Tree fileTree;
	
	public void createTree(String route) {
		father = new File(route);
	}
	
	public void readFolder(String route, int totalSize) {
		father = new File(route);
		fileTree = new Tree(father, totalSize);
		fillTree();
	}
	
	public void fillTree(){
		fillTree(father);
	}
	
	private void fillTree(File actualFile){
		fileTree.addToTreeFiles(actualFile);
		if (actualFile.isDirectory()) {
			for (File file : actualFile.listFiles()) {
				fillTree(file);
			}
		}
	}

	public File getFather() {
		return father;
	}
	
	public Node getRoot() {
		return fileTree.getRoot();
	}
}