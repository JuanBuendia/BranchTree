package view;

import model.Node;
import javax.swing.JFrame;
import javax.swing.JTree;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class MainWindowJFrame extends JFrame{

	private JTree folderTree;
	private String folderRoute;
	private DefaultMutableTreeNode treeNode;
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "FolderExtension";

	public MainWindowJFrame(ActionListener controller) {
		setTitle(TITLE);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		treeNode = new DefaultMutableTreeNode();
		folderTree = new JTree(treeNode);
		add(folderTree, BorderLayout.CENTER);
		
		JButton btnSelectFolder = new JButton("Select image");
		btnSelectFolder.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSelectFolder.addActionListener(controller);
		btnSelectFolder.setActionCommand("LOAD FOLDER");
		add(btnSelectFolder, BorderLayout.PAGE_END);
		folderRoute = null;
		
		setVisible(true);
	}

	public String getFolderRoute() {
		return folderRoute;
	}
	
	public void showFileChooser() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int option = chooser.showOpenDialog(getContentPane());
		if (option == JFileChooser.APPROVE_OPTION) {
			folderRoute = chooser.getSelectedFile().getPath();
		}
	}
	
	public void paintTree(Node root) {
		DefaultMutableTreeNode uiRoot = new DefaultMutableTreeNode(root);
		treeNode.add(uiRoot);
		showTreeNode(uiRoot, root.getNodeList());
	}
	
	public void showTreeNode(DefaultMutableTreeNode actual, ArrayList<Node> list) {
		if(list != null) {
			for (Node node : list) {
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(node);
				actual.add(newNode);
				showTreeNode(newNode, node.getNodeList());
			}
		}
	}
}