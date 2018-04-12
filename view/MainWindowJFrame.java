package view;

import model.Node;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class MainWindowJFrame extends JFrame{

	private JTree folderTree;
	private String folderRoute;
	private DefaultMutableTreeNode treeNode;
	private static final Color WHITE = Color.WHITE;
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "FolderExtension";
	private static final Color BACKGROUND = Color.decode("#004c40");

	public MainWindowJFrame(ActionListener controller) {
		setTitle(TITLE);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
		
		treeNode = new DefaultMutableTreeNode();
		folderTree = new JTree(treeNode);
		add(folderTree, BorderLayout.CENTER);
		
		ImageIcon fot = new ImageIcon(getClass().getResource("/img/folder.png"));
		Icon icon = new ImageIcon(fot.getImage().getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING));
		
		JButton btnSelectFolder = new JButton("Seleccione la carpeta");
		btnSelectFolder.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSelectFolder.addActionListener(controller);
		btnSelectFolder.setActionCommand("LOAD FOLDER");
		btnSelectFolder.setBackground(BACKGROUND);
		btnSelectFolder.setForeground(WHITE);
		btnSelectFolder.setIcon(icon);
		add(btnSelectFolder, BorderLayout.PAGE_END);
		folderRoute = null;
		
		setVisible(true);
	}

	public String getFolderRoute() {
		return folderRoute;
	}
	
	public int getTotalSize(){
		return Integer.parseInt(JOptionPane.showInputDialog("Introduza tamaño de archivos a calificar (KB)"));
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