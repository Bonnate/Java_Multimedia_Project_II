package _1027_B;

import java.util.HashSet;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Person> hSet = new HashSet<Person>();
		hSet.add(new Person("Lee", 24));
		hSet.add(new Person("Hong", 29));
		hSet.add(new Person("Choi", 21));
		hSet.add(new Person("Hong", 28));
		printCollection(hSet.iterator());

		System.out.println();

		deleteCollectionByHash(hSet, "Hong");
		printCollection(hSet.iterator());
	}

	public static void printCollection(Iterator<Person> itr) {
		while (itr.hasNext())
			itr.next().ShowData();
	}

	/**
	 * 해쉬 값을 이용하여 해당 오브젝트를 제거 O(1)
	 */
	public static void deleteCollectionByHash(HashSet<Person> hSet, String name) {
		hSet.remove(new Person(name));
	}

	/**
	 * 평범한 방식인 순차탐색을 이용하여 해당 오브젝트를 제거 O(n)
	 */
	public static void deleteCollectionBySearch(HashSet<Person> hSet, String name) {
		Iterator<Person> itr = hSet.iterator();

		while (itr.hasNext()) {
			if (itr.next().GetName().equals(name)) {
				itr.remove();
			}
		}
	}
}
