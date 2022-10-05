import java.util.Scanner;

enum Week {
	MON, TUE, WED, THU, FRI, SAT, SUN
}

public class Main {
	public static void main(String[] args) {
		Week week = Week.MON;

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("요일을 입력하세요: ");
			String input = sc.nextLine();
			week = Week.valueOf(input);
			// 잘못 입력했을 때
			// XXX 입력했을 때
			if(input == "XXX") {
				System.out.println("프로그램을 종료합니다. \n");
				break;
			}

			switch (week) {
			case MON:
				System.out.println("주간회의가 있습니다. \n");
				break;
			case TUE:
				System.out.println("프로젝트 기획 회의가 있습니다. \n");
				break;
			case WED:
				System.out.println("진행사항 보고하는 날입니다. \n");
				break;
			case THU:
				System.out.println("사내 축구시합이 있는 날입니다. \n");
				break;
			case FRI:
				System.out.println("프로젝트 마감일입니다. \n");
				break;
			case SAT:
				System.out.println("가족과 함께 즐거운 시간을 보내세요. \n");
				break;
			case SUN:
				System.out.println("오늘은 휴일입니다. n");
				break;
			}
		}
	}
}
