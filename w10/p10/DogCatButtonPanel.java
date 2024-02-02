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

	public DogCatButtonPanel() { // ������

		final ImageIcon dogIcon = createImageIcon("/images/dog-icon.png", "cute dog image");
		final ImageIcon catIcon = createImageIcon("/images/cat-icon.png", "pretty cat image");

		// �׸��� �׷��� ���� �����Ѵ�.
		// �׸� �������� ���� ���Ϳ� ��ġ�ϵ���.
		final JLabel label = new JLabel(dogIcon, JLabel.CENTER);

		// ������ ���콺�� �� ���� �÷��� �� ��Ÿ���� ��ǳ��
		label.setToolTipText("������ Ȥ�� �����");

		final JButton dog_button = new JButton("������");
		final JButton cat_button = new JButton("�����");

		class ClickListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == dog_button) {
					label.setIcon(dogIcon); 	// �󺧿� �������� ��Ÿ���� ��.
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
	 * �̹��� ������ �о� ImageIcon ���·� ��ȯ�ϴ� �޼ҵ�. 
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