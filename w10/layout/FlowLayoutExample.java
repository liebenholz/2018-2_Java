package w10.layout;

import java.awt.*;
import javax.swing.*;

/**
 * Illustrate the layout style of a FlowLayout.
 * 
 */
public class FlowLayoutExample
{
	private JFrame frame;

	/**
	 * Constructor for objects of class FlowLayoutExample
	 */
	public FlowLayoutExample()
	{
		makeFrame();
	}

	/**
	 * Place five components within a container managed by
	 * a FlowLayout.
	 */
	private void makeFrame()
	{
		frame = new JFrame("FlowLayout Example");

		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JButton("first"));
		contentPane.add(new JButton("second"));
		contentPane.add(new JButton("third"));
		//      contentPane.add(new JButton("the third string is very long"));
		//        contentPane.add(new JButton("fourth"));
		//        contentPane.add(new JButton("fifth"));

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args){
		new FlowLayoutExample();
	}

}
