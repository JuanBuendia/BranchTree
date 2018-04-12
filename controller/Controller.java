package controller;

import model.Tree;
import view.MainWindowJFrame;
import persistence.FileManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{

	private Tree treeManager;
	private FileManager fileManager;
	private MainWindowJFrame mainWindow;
	
	public Controller() {
		treeManager = new Tree();
		fileManager = new FileManager();
		mainWindow = new MainWindowJFrame(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "LOAD FOLDER":
			loadFolder();
			break;
		default:
			break;
		}
	}
	
	private void loadFolder() {
		mainWindow.showFileChooser();
		fileManager.getFiles(mainWindow.getFolderRoute());
	}

	public static void main(String[] args) {
		new Controller();
	}
}