package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class MainWindowJFrame extends JFrame{

	private static final String TITLE = "FolderExtension";
	private static final long serialVersionUID = 1L;

	public MainWindowJFrame() {
		setTitle(TITLE);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel lbImg = new JLabel("IMAGE");
		lbImg.setSize(500,200);
		lbImg.setBorder(BorderFactory.createTitledBorder("Image:"));
		add(new JScrollPane(lbImg));
		
		JButton btnSelectImage = new JButton("Select image");
		btnSelectImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSelectImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jf = new JFileChooser();
				int option = jf.showOpenDialog(getContentPane());
				if (option == JFileChooser.APPROVE_OPTION) {
					lbImg.setIcon(new ImageIcon(jf.getSelectedFile().getPath()));
				}
			}
		});
		add(btnSelectImage, BorderLayout.PAGE_END);
		
		setVisible(true);
	}
}