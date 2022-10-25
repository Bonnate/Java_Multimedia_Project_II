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

		deleteCollection(hSet, "Hong");
		printCollection(hSet.iterator());
	}

	public static void printCollection(Iterator<Person> itr) {
		while (itr.hasNext())
			itr.next().ShowData();
	}

	public static void deleteCollection(HashSet<Person> hSet, String name) {
		hSet.remove(new Person(name));
	}

	public static void deleteCollectionSearch(HashSet<Person> hSet, String name) {
		Iterator<Person> itr = hSet.iterator();

		while (itr.hasNext()) {
			if (itr.next().GetName().equals(name)) {
				itr.remove();
			}
		}
	}
}
