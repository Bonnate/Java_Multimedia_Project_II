interface PersonalNumberStorage {
	void addPersonalInfo(String name, int age);

	String searchName(int age);
}

class Test {
	public static void main(String[] args) {
		PersonalNumberStorage storage = new PersonalNumberStorageImpl(100);
		storage.addPersonalInfo("Jack", 22);
		storage.addPersonalInfo("King", 33);
		System.out.println(storage.searchName(22));
		System.out.println(storage.searchName(33));
		System.out.println(storage.searchName(44));
	}
}

class PersonalNumberStorageImpl implements PersonalNumberStorage {
	PersonalNumInfo[] perArr;
	int numOfPerInfo;

	PersonalNumberStorageImpl(int sz) {
		perArr = new PersonalNumInfo[sz];
		numOfPerInfo = 0;
	}

	public void addPersonalInfo(String name, int perNum) {
		perArr[numOfPerInfo] = new PersonalNumInfo(name, perNum);
		numOfPerInfo++;
	}

	public String searchName(int perNum) {
		for (int i = 0; i < numOfPerInfo; i++) {
			if (perNum == perArr[i].getNumber())	// 숫자끼리 비교!
				return perArr[i].getName();
		}
		return "no one";
	}
}

class PersonalNumInfo {
	String name;
	int number;

	PersonalNumInfo(String name, int number) {
		this.name = name;
		this.number = number;
	}

	String getName() {
		return name;
	}

	int getNumber() {
		return number;
	}
}