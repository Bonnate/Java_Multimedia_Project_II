package _1103A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static Scanner Keyboard = new Scanner(System.in);
	public static Vector<Person> PersonData = new Vector<Person>();
	private static String FileName = "PersonData.txt";

	public static void main(String[] args) {

		LoadTextData();

		while (true) {
			DisplayMenu();

			switch (Keyboard.nextInt()) {
			case 1: {
				InputData();
				System.out.println();
				break;
			}
			case 2: {
				DisplayAllData();
				System.out.println();
				break;
			}
			case 3: {
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			case 4: {
				RemoveFile();
				System.out.println();
				break;
			}
			}
		}
	}

	public static void RemoveFile() {
		File file = new File(FileName);
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("파일삭제 성공");
				PersonData.clear();
			} else {
				System.out.println("파일삭제 실패");
			}
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}

	public static void LoadTextData() {
		BufferedReader in = null;
		StringBuilder str = new StringBuilder();
		try {
			in = new BufferedReader(new FileReader(FileName));
			String line;
			while (true) {
				line = in.readLine();
				if (line == null)
					break;
				str.append(line);
			}
			InputDataFromFileStream(str);
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void InputDataFromFileStream(StringBuilder fileStream) {

		StringBuilder strName = new StringBuilder();
		StringBuilder strAge = new StringBuilder();

		for (int i = 0; i < fileStream.length(); ++i) {
			if (fileStream.charAt(i) == '{') {
				++i;

				strName.setLength(0);
				strAge.setLength(0);

				for (int j = i; j < fileStream.length(); ++j, ++i) {
					if (fileStream.charAt(i) == ',') {
						++j;
						++i;
						break;
					}
					strName.append(fileStream.charAt(i));
				}
				for (int j = i; j < fileStream.length(); ++j, ++i) {
					if (fileStream.charAt(i) == '}') {
						break;
					}
					strAge.append(fileStream.charAt(i));
				}

				PersonData.add(new Person(strName.toString(), Integer.parseInt(strAge.toString())));
			}
		}
	}

	public static void InputData() {

		Keyboard.nextLine();

		BufferedWriter out = null;

		String nameInput;
		int ageInput;

		try {
			out = new BufferedWriter(new FileWriter(FileName, true));

			System.out.print("이름: ");
			nameInput = Keyboard.nextLine();

			System.out.print("나이: ");
			ageInput = Keyboard.nextInt();

			PersonData.add(new Person(nameInput, ageInput));
			out.write('{' + nameInput + ',' + ageInput + "}, ");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void DisplayAllData() {

		if (PersonData.size() == 0) {
			System.out.println("데이터가 없습니다.");
			return;
		}
		else
		{
			System.out.println("총 " + PersonData.size() + "명을 출력합니다.");
		}

		for (Person person : PersonData) {
			person.DisplayInfo();
		}
	}

	public static void DisplayMenu() {
		System.out.println("== 메뉴 ==");
		System.out.println("1. 입력");
		System.out.println("2. 출력");
		System.out.println("3. 종료");
		System.out.println("4. 파일 제거");
		System.out.print("무엇을 하시겠습니까? ");
	}
}