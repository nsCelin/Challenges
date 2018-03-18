package com.treesetLogic;

import java.util.Comparator;

/*Age Comparator*/
public class AgeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getAge() > o2.getAge()) {
			return 1;
    	} 
		else {
			return -1;
		}
	}

}
