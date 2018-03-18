package com.boxplacement.arm;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class RobotArmLogic {
	
	/*This map is used to save the details of
	 * Columns as Keys and the loads that is passed to those columns as arrays (values to Column Keys).
	 * Using LinkedHashMap - this map can store keys and values in the order of insertion.*/
	Map<String,List<String>> expectedColumns = new LinkedHashMap<String,List<String>>();
	
	/*Initializing the arrays that will store values
	 * which will be mapped to the LinkedHashMap*/
	List<String> loadA = null;
	List<String> loadB = null;
	List<String> loadC = null;
	List<String> loadD = null;
	List<String> loadE = null;
	
	public static void main(String[] args) {
		
		//String input = "FD{foo}FFD{bar}RFFD{Foo}RFFD{World}"; In Question
		System.out.println("Enter the string input");  
		Scanner scan=new Scanner(System.in);  		
		String input = scan.nextLine();
		scan.close();  
		new RobotArmLogic().simulateArm(input);
		
	}
	
	public void simulateArm(String input)
	{
		
		int column = 0;
		createLists();
		
		/*So we can get a single cycle. Ex : FD{foo*/
		String[] sets = input.split("}");
		
		for(String s : sets)
		{
			/*So we can get the different positions in a single cycle. Ex: F,D*/
			String[] positions = s.substring(0, s.indexOf("{")).split("");
			
			/*This is to get the load value for a single cycle. Ex :foo*/
			String loadValue = s.substring(s.indexOf("{")).replace("{", "");
			
			for(String pos : positions)
			{					
				if(pos.equals("R"))
					column = 0;
				
				/*The arm cannot move ahead of the last column and 
				 * will stay there if it receives a forward command.*/
				if(pos.equals("F") && column < 5)
					column = column +1;
				
				/*Dropping the load at this column*/
				if(pos.equals("D") && column <= 5)
				{
					StoreValues(column, loadValue);
					
					/*Once a load is successfully dropped the arm moves forward 
					 * one position except when in the last column */
					if(column<5)
					 column +=column;
				}
			}
								
		}
		
		String output = printOutput();
		System.out.println(output);
	}
	
	/*This is where the arraylists are created and are
	 * mapped to columns of the map*/
	public void createLists()
	{
		if(loadA == null)
		{
			loadA = GenericListCreation.createList();
			expectedColumns.put("A", loadA);
		}			  
		if(loadB == null)
		{
			loadB = GenericListCreation.createList();
			expectedColumns.put("B", loadB);
		}			  
		if(loadC == null)
		{
			loadC = GenericListCreation.createList();
			expectedColumns.put("C", loadC);
		}			  
		if(loadD == null)
		{
			loadD = GenericListCreation.createList();
			expectedColumns.put("D", loadD);
		}			  
		if(loadE == null)
		{
			loadE = GenericListCreation.createList();
		    expectedColumns.put("E", loadE);
		}			  		
	}
	
	/*Storing the values into arraylists.The height of column is height of 10 boxes*/
	public  void StoreValues(int pos, String columnValue)
	{		
		switch(pos)
		{
		  case 1:
		  {
			  if(loadA.size()<=10)
			    loadA.add(columnValue);			  
			  break;
		  }
			  
		  case 2:
		  {		
			  if(loadB.size()<=10)
				 loadB.add(columnValue);		   
			  break;
		  }
		  case 3:
		  {
			  if(loadC.size()<=10)
			     loadC.add(columnValue);
			  break;
		  }
		  case 4:
		  {
			  if(loadD.size()<=10)
				  loadD.add(columnValue);
			  break;
		  }
		  case 5:
		  {
			  if(loadE.size()<=10)
				  loadE.add(columnValue);
			  break;
		  }
	      default :
	       	  
		}
	}
	
	/*printing the output into console*/
	public String printOutput()
	{
		StringBuilder sb=new StringBuilder("Output : ");  
		sb.append("{");
		for(Entry<String, List<String>> entry :expectedColumns.entrySet())
		{
			sb.append(entry.getKey());
			sb.append("-->");
			sb.append(entry.getValue());
			sb.append(",");
		}
		
		String output = sb.toString();		
		output = output.substring(0, output.length()-1);
		output = output +"}";
		
		return output;
	}

}
