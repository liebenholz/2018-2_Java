package w10.p10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DogCatButtonPanel extends JPanel {

	public DogCatButtonPanel() { // 구성자

		final ImageIcon dogIcon = createImageIcon("/images/dog-icon.png", "cute dog image");
		final ImageIcon catIcon = createImageIcon("/images/cat-icon.png", "pretty cat image");

		// 그림이 그려진 라벨을 구성한다.
		// 그림 아이콘이 라벨의 센터에 위치하도록.
		final JLabel label = new JLabel(dogIcon, JLabel.CENTER);

		// 툴팁은 마우스를 라벨 위로 올렸을 때 나타나는 말풍선
		label.setToolTipText("강아지 혹은 고양이");

		final JButton dog_button = new JButton("강아지");
		final JButton cat_button = new JButton("고양이");

		class ClickListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == dog_button) {
					label.setIcon(dogIcon); 	// 라벨에 아이콘이 나타나게 함.
				} else if (e.getSource() == cat_button) {
					label.setIcon(catIcon);
				}
			}
		}

		ActionListener listener = new ClickListener();
		dog_button.addActionListener(listener);
		cat_button.addActionListener(listener);

		add(label);
		add(dog_button);
		add(cat_button);
	}

	/**
	 * 이미자 파일을 읽어 ImageIcon 형태로 반환하는 메소드. 
	 * Returns an ImageIcon, or null if the path was invalid.
	 */
	protected static ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = DogCatButtonPanel.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	public static void main(String[] args) {
		// Create and set up the window.
		JFrame frame = new JFrame("Buttons for Image Switch");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add content to the window.
		frame.add(new DogCatButtonPanel());

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
}