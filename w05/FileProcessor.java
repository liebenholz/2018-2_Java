package w5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class FileProcessor {

	/**
	 * 파일로부터 단어들을 읽어 이들을 ArrayList에 넣은 후
	 * ArrayList를 반환한다.
	 * @param fileName 파일 이름
	 * @return 단어들이 들어있는 리스트
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
	 * 주어진 리스트에 들어있는 단어들의 순서를 바꿔
	 * 새 ArrayList에 저장한다.
	 * @param list 단어들이 들어있는 리스트.
	 * @return 순서가 바뀐 단어들이 들어있는 새 ArrayList.
	 */
	public List<String> backwards(List<String> list) {
		List<String> backList = new ArrayList<String>();

		// Iterator를 사용
		ListIterator<String> it = list.listIterator(list.size());
		while(it.hasPrevious()) {
			String word = it.previous();
			backList.add(word);
		}

		return backList;
	}

	/**
	 * 리스트에 들어있는 단어들 중
	 * 주어진 문자열로 끝나는 단어들을 삭제한다.
	 * @param list 단어들로 들어있는 리스트
	 * @param s 문자열
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
	 * 리스트에 들어있는 단어들 중
	 * 주어진 문자열로 끝나는 단어들을 삭제한다.(Iterator 사용하지 않음)
	 * @param list 단어들로 들어있는 리스트
	 * @param s 문자열
	 */
	public void discardWords2(List<String> list, String s) {
		// Iterator를 이용하지 않는다.
		List<String> list2 = new ArrayList<>(list);
		for (int i = list2.size() - 1; i >= 0; i--)
			if(list2.get(i).endsWith(s))
				list2.remove(i);
		System.out.println(list2);
	}

	public static void main(String[] args) throws FileNotFoundException {

		// FileProcessor 인스턴스를 하나 구성한다.
		FileProcessor fileProcessor = new FileProcessor();

		// 'words.txt' 파일의 단어들이 저장된 리스트틀 얻는다.
		// 이 때 FileProcessor의 readFiles 메소드를 이용한다.
		// 리스트를 출력한다.
		List<String> list = new ArrayList<>(fileProcessor.readFile("words.txt"));
		System.out.println(list.toString());

		// 리스트에 있는 단어들의 순서를 바꾼 새 리스트를 얻는다.
		// 이 때 FileProcessor의 backwards 메소드를 사용한다.
		// 새 리스트를 출력한다.
		List<String> list2 = new ArrayList<>(fileProcessor.backwards(list));
		System.out.println(list2.toString());

		// 원래의 리스트의 단어들 중 "치"로 끝나는 단어들을 삭제한다.
		// 이 때 discardWords1 메소드를 사용한다.
		// 리스트를 출력한다.
		fileProcessor.discardWords1(list, "치");

		// 새 리스트의 단어들 중 "치"로 끝나는 단어들을 삭제한다.
		// 새 리스트를 출력한다.
		// 이 때 discardWords2 메소드를 사용한다.
		fileProcessor.discardWords2(list2, "치");

	}

}
