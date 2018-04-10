package view;

import javax.swing.JFrame;

public class MainWindowJFrame extends JFrame{

	private static final String TITLE = "FolderExtension";
	private static final long serialVersionUID = 1L;

	public MainWindowJFrame() {
		setTitle(TITLE);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
	}
}