import java.util.Scanner;

enum Week {
	MON, TUE, WED, THU, FRI, SAT, SUN
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Week[] values = Week.values();
		boolean flag;

		while (true) {
			System.out.print("요일을 입력하세요: ");
			String input = sc.nextLine();
			flag = false;

			// case 1. 'XXX'를 입력하면, 종료시킨다.
			if (input.equals("XXX")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			// case 2. 'XXX'가 아니면, 값들을 Week Enum과 비교해본다.
			for (Week week : values) {
				if (week.name().equals(input)) {
					DisplayInfo(week);
					flag = true;
				}
			}

			// default, 위 과정이 모두 아닌경우엔 예외 입력이다.
			if (flag) {
				System.out.println("");
			} else {
				System.out.println("잘못 입력하셨습니다.\n");
			}
		}
	}

	public static void DisplayInfo(Week week) {
		switch (week) {
		case MON:
			System.out.println("주간회의가 있습니다.");
			break;
		case TUE:
			System.out.println("프로젝트 기획 회의가 있습니다.");
			break;
		case WED:
			System.out.println("진행사항 보고하는 날입니다.");
			break;
		case THU:
			System.out.println("사내 축구시합이 있는 날입니다.");
			break;
		case FRI:
			System.out.println("프로젝트 마감일입니다.");
			break;
		case SAT:
			System.out.println("가족과 함께 즐거운 시간을 보내세요.");
			break;
		case SUN:
			System.out.println("오늘은 휴일입니다.");
			break;
		}
	}
}
