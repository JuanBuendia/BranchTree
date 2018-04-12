package controller;

import view.MainWindowJFrame;
import persistence.FileManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{

	private FileManager fileManager;
	private MainWindowJFrame mainWindow;
	
	public Controller() {
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
		fileManager.readFolder(mainWindow.getFolderRoute(), mainWindow.getTotalSize()*1024);
		mainWindow.paintTree(fileManager.getRoot());
	}

	public static void main(String[] args) {
		new Controller();
	}
}