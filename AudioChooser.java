
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import sun.audio.*;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AudioChooser extends JFrame implements ActionListener {
	JButton loadImage;
	Border line, margin, compound;

	AudioChooser() {

		loadImage = new JButton("Select Image");
		// Setting Button's position, width and height.
		loadImage.setBounds(10, 10, 225, 225);
		loadImage.setIcon(new ImageIcon("play.png"));

		validate();

		// Registering component to event handler.
		loadImage.addActionListener(this);

		// Adding lable and button to frame.
		add(loadImage);

		// Properties of Jframe.
		setLayout(null);
		setTitle("Image Chooser");
		setSize(250, 270);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		setVisible(true);
	}

	public static void main(String[] args) {
		AudioChooser audioChooser = new AudioChooser();
		System.out.println("why is this not working");
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
			try {
				FileInputStream fis = new FileInputStream(path);
				BufferedInputStream bis = new BufferedInputStream(fis);
				Player player;
				try {
					player = new Player(bis);
					player.play();
				} catch (JavaLayerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (result == JFileChooser.CANCEL_OPTION) {
			System.out.println("No File Select");
		}
	}
}