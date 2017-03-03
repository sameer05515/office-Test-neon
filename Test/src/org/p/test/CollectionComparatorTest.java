package org.p.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CollectionComparatorTest {

	// private static HashMap<String,Second> msgs;

	public static void main(String[] args) {

		List<String> ls = new ArrayList<String>();

		ls.add("fourth");
		ls.add("2");
		ls.add("second");
		ls.add("first");
		ls.add("third");
		ls.add("1");

		Iterator<String> it = ls.iterator();

		// before sorting
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}

		Collections.sort(ls, new Comparator<String>() {
			public int compare(String o1, String o2) {
				//return -1;
				// it can also return 0, and 1
				return o2.compareTo(o1);
			}
		});
		
		//Collections.sort(ls);

		System.out.println(" ");

		// after sorting
		System.out.println("after sorting");
		Iterator<String> iti = ls.iterator();
		while (iti.hasNext()) {
			String s = iti.next();

			System.out.println(s);
		}

	}

}