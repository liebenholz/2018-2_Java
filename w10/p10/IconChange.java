package w10.p10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class IconChange extends JPanel{
	/**
	 * ImageIcon을 반환, 단, path가 유효하지 않은 경우에는 null을 반환.
	 *
	 * @param path 그림 파일 경로명 (가령, "C:/images/smile.jpg").
	 * @param description 그림에 대한 설명.
	 * @return 그림파일로부터 만들어진 ImageIcon (path가 유효한 경우), null (path가 유효하지 않은 경우).
	 */

	static final int IMAGES = 16; // 이미지 파일 수
	ImageIcon[] icon = new ImageIcon[IMAGES]; // 이미지 아이콘들 (이미지 아이콘들은 일련번호를 가짐)
	private int n;
	
	public IconChange() {
		getImages();
		final JButton button = new JButton(icon[0]);
		
		class ClickListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (n >= IMAGES - 1) n = -1;
				n++;
				button.setIcon(icon[n]);
			}
		}
		ActionListener listener = new ClickListener();
		button.addActionListener(listener);
		add(button);
	}
	
	private void getImages() {
		// 16개의 이미지가 있는 경우
		icon[0] = createImageIcon("/images/dog-icon.png", "cute dog image");
		icon[1] = createImageIcon("/images/cat-icon.png", "pretty cat image");
		icon[2] = createImageIcon("/images/angry-bird-icon.png", "cute dog image");
		icon[3] = createImageIcon("/images/bird-icon.png", "pretty cat image");
		icon[4] = createImageIcon("/images/clown-fish-icon.png", "cute dog image");
		icon[5] = createImageIcon("/images/cow-icon.png", "pretty cat image");
		icon[6] = createImageIcon("/images/eagles-icon.png", "cute dog image");
		icon[7] = createImageIcon("/images/elephant-icon.png", "pretty cat image");
		icon[8] = createImageIcon("/images/fish-icon.png", "cute dog image");
		icon[9] = createImageIcon("/images/jelly-fish-icon.png", "pretty cat image");
		icon[10] = createImageIcon("/images/lion-icon.png", "cute dog image");
		icon[11] = createImageIcon("/images/owl-icon.png", "pretty cat image");
		icon[12] = createImageIcon("/images/red-fish-icon.png", "cute dog image");
		icon[13] = createImageIcon("/images/snake-icon.png", "pretty cat image");
		icon[14] = createImageIcon("/images/tiger-icon.png", "cute dog image");
		icon[15] = createImageIcon("/images/bee-icon.png", "pretty cat image");
	}

	/**
	 * ImageIcon을 반환, 단, path가 유효하지 않은 경우에는 null을 반환.
	 *
	 * @param path 그림 파일 경로명 (가령, "C:/images/smile.jpg").
	 * @param description 그림에 대한 설명.
	 * @return 그림파일로부터 만들어진 ImageIcon (path가 유효한 경우), null (path가 유효하지 않은 경우).
	 */
	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = IconChange.class.getResource(path);
		if (imgURL != null)
			return new ImageIcon(imgURL, description);
		else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	
	public static void main (String[] args) {
		JFrame frame = new JFrame("Button for Image Switch");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new IconChange());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
