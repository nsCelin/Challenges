package com.boxplacement.arm;

import java.util.ArrayList;
import java.util.List;

/*Generic class for creating an Arraylist*/
public class GenericListCreation<T> {
	
	public GenericListCreation()
	{ }
	
	public static <T>List<T> createList()
	{
		return new ArrayList<T>();
	}

}
