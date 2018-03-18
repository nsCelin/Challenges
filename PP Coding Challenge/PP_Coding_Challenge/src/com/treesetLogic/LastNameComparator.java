package com.treesetLogic;

import java.util.Comparator;

/*Last Name Comparator*/
public class LastNameComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getLastName().compareTo(o2.getLastName());
	}

	
}
