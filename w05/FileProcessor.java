package w5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class FileProcessor {

	/**
	 * ���Ϸκ��� �ܾ���� �о� �̵��� ArrayList�� ���� ��
	 * ArrayList�� ��ȯ�Ѵ�.
	 * @param fileName ���� �̸�
	 * @return �ܾ���� ����ִ� ����Ʈ
	 * @throws FileNotFoundEXception
	 */
	public static List<String> readFile(String fileName) throws FileNotFoundException {
		List<String> list = new ArrayList<>();
		
		Scanner in = new Scanner(new File(fileName));
		while (in.hasNext()) {
			list.add(in.next());
		}
		in.close();
		
		return list;
	}

	/**
	 * �־��� ����Ʈ�� ����ִ� �ܾ���� ������ �ٲ�
	 * �� ArrayList�� �����Ѵ�.
	 * @param list �ܾ���� ����ִ� ����Ʈ.
	 * @return ������ �ٲ� �ܾ���� ����ִ� �� ArrayList.
	 */
	public List<String> backwards(List<String> list) {
		List<String> backList = new ArrayList<String>();

		// Iterator�� ���
		ListIterator<String> it = list.listIterator(list.size());
		while(it.hasPrevious()) {
			String word = it.previous();
			backList.add(word);
		}

		return backList;
	}

	/**
	 * ����Ʈ�� ����ִ� �ܾ�� ��
	 * �־��� ���ڿ��� ������ �ܾ���� �����Ѵ�.
	 * @param list �ܾ��� ����ִ� ����Ʈ
	 * @param s ���ڿ�
	 */
	public void discardWords1(List<String> list, String s) {
		ListIterator<String> it = list.listIterator();
		while(it.hasNext()) {
			if(it.next().endsWith(s))
				it.remove();
		}
		System.out.println(list);
	}

	/**
	 * ����Ʈ�� ����ִ� �ܾ�� ��
	 * �־��� ���ڿ��� ������ �ܾ���� �����Ѵ�.(Iterator ������� ����)
	 * @param list �ܾ��� ����ִ� ����Ʈ
	 * @param s ���ڿ�
	 */
	public void discardWords2(List<String> list, String s) {
		// Iterator�� �̿����� �ʴ´�.
		List<String> list2 = new ArrayList<>(list);
		for (int i = list2.size() - 1; i >= 0; i--)
			if(list2.get(i).endsWith(s))
				list2.remove(i);
		System.out.println(list2);
	}

	public static void main(String[] args) throws FileNotFoundException {

		// FileProcessor �ν��Ͻ��� �ϳ� �����Ѵ�.
		FileProcessor fileProcessor = new FileProcessor();

		// 'words.txt' ������ �ܾ���� ����� ����ƮƲ ��´�.
		// �� �� FileProcessor�� readFiles �޼ҵ带 �̿��Ѵ�.
		// ����Ʈ�� ����Ѵ�.
		List<String> list = new ArrayList<>(fileProcessor.readFile("words.txt"));
		System.out.println(list.toString());

		// ����Ʈ�� �ִ� �ܾ���� ������ �ٲ� �� ����Ʈ�� ��´�.
		// �� �� FileProcessor�� backwards �޼ҵ带 ����Ѵ�.
		// �� ����Ʈ�� ����Ѵ�.
		List<String> list2 = new ArrayList<>(fileProcessor.backwards(list));
		System.out.println(list2.toString());

		// ������ ����Ʈ�� �ܾ�� �� "ġ"�� ������ �ܾ���� �����Ѵ�.
		// �� �� discardWords1 �޼ҵ带 ����Ѵ�.
		// ����Ʈ�� ����Ѵ�.
		fileProcessor.discardWords1(list, "ġ");

		// �� ����Ʈ�� �ܾ�� �� "ġ"�� ������ �ܾ���� �����Ѵ�.
		// �� ����Ʈ�� ����Ѵ�.
		// �� �� discardWords2 �޼ҵ带 ����Ѵ�.
		fileProcessor.discardWords2(list2, "ġ");

	}

}
