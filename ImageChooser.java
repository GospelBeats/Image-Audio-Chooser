
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;

public class ImageChooser extends JFrame implements ActionListener {
	JButton loadImage;
	JLabel imageLabel;
	Border line, margin, compound;

	ImageChooser() {
		
		imageLabel = new JLabel();
		// Setting Label's position, width and height.
		imageLabel.setBounds(50, 10, 700, 400); 

		loadImage = new JButton("Select Image");
		// Setting Button's position, width and height.
		loadImage.setBounds(325, 500, 150, 40); 

		// Styling the Button's appearance
		loadImage.setForeground(Color.WHITE);
		loadImage.setBackground(Color.BLUE);
		line = new LineBorder(Color.BLACK);
		margin = new EmptyBorder(5, 15, 5, 15);
		compound = new CompoundBorder(line, margin);
		loadImage.setBorder(compound);
		
		// Registering component to event handler. 
		loadImage.addActionListener(this);

		// Adding lable and button to frame.
		add(imageLabel);
		add(loadImage);

		// Properties of Jframe.
		setLayout(null);
		setTitle("Image Chooser");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		setVisible(true);
	}

	public static void main(String[] args) {
		ImageChooser imageChooser = new ImageChooser();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setCurrentDirectory(new File("C:\\Users"));

		FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "png");
		jFileChooser.addChoosableFileFilter(filter);
		int result = jFileChooser.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jFileChooser.getSelectedFile();
			String path = selectedFile.getAbsolutePath();
			ImageIcon imageIcon1 = new ImageIcon(path);
			Image image1 = imageIcon1.getImage();
			Image imageIcon2 = image1.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(),
					Image.SCALE_SMOOTH);
			ImageIcon image2 = new ImageIcon(imageIcon2);
			imageLabel.setIcon(image2);
		} else if (result == JFileChooser.CANCEL_OPTION) {
			System.out.println("No File Select");
		}
	}
}