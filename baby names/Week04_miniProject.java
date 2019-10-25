import java.io.File;

import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class Week04_miniProject {

		
	/************
	 * main()
	 * @param args
	 */
	public static void main(String[] args){
		
		Week04_miniProject miniP = new Week04_miniProject();
		
		
		//1st Modify the method totalBirths, print out number of girls/boys and total
		System.out.println("\n Part 1: printout number of girls/boys, and total" );
		
		System.out.println("Q#1: Select year 1900: ");
		miniP.totalBirths();
		
		System.out.println("Q#2: Select year 1905: ");
		miniP.totalBirths();		
		
		//2nd method named getRank that has three parameters: 
		//an integer named year, a string named name, and a string named gender 
		//(F for female and M for male). 
		//This method returns the rank of the name in the file for the given gender
		
		System.out.println("\n Part 2: get rank by name");

		int year = 1960;
		String name = "Emily";
		String gender = "F";
		System.out.println("Q#3: Select year " + year +". ");
		int rank = miniP.getRank(year, name, gender);
		System.out.println("The name " + name + " gender " + gender + " ranks " + rank + " at year " + year);
		
		year = 1971;
		name = "Frank";
		gender = "M";
		System.out.println("Q#4: Select year " + year +". ");
		rank = miniP.getRank(year, name, gender);
		System.out.println("The name " + name + " gender " + gender + " ranks " + rank + " at year " + year);
		
		//3rd Write the method named getName that has three parameters: 
		//an integer named year, an integer named rank, and a string named gender 
		//(F for female and M for male). 
		//This method returns the name of the person in the file at this rank, for the given gender.
		System.out.println("\n Problem 3: getName by rank");
		
		year = 1980;
		rank = 350;
		gender = "F";
		System.out.println("Q#5: Select year " + year +". ");
		String rankName = miniP.getName(year, rank, gender);
		System.out.println("The " + gender + " name ranked " + rank + " is: " + rankName +". " );

		year = 1982;
		rank = 450;
		gender = "M";
		System.out.println("Q#6: Select year " + year +". ");
		rankName = miniP.getName(year, rank, gender);
		System.out.println("The " + gender + " name ranked " + rank + " is: " + rankName +". " );

		//4th What would your name be if you were born in a different year? 
		//Write the void method named whatIsNameInYear that has four parameters: 
		//a string name, an integer named year representing the year that name was born, 
		//an integer named newYear and a string named gender (F for female and M for male).
		//This method determines what name would have been named if they were born in a different year, 
		//based on the same popularity.
		System.out.println("\n Problem 4: whatIsNameInYear" );
		
		int year1 = 1972;
		int year2 = 2014;
		gender = "F";
		name = "Susan";
		System.out.println("Q#7: Select year " + year1 +"; And year " + year2 +". ");
		miniP.whatIsNameInYear(name, year1, year2, gender);

		year1 = 1974;
		year2 = 2014;
		gender = "M";
		name = "Owen";
		System.out.println("Q#8: Select year " + year1 +"; And year " + year2 +". ");
		miniP.whatIsNameInYear(name, year1, year2, gender);

		//5th method yearOfHighestRank that has two parameters: 
		//a string name, and a string named gender (F for female and M for male). 
		//This method selects a range of files to process and returns an integer, 
		//the year with the highest rank for the name and gender.
		System.out.println("\n Part 5: yearOfHighestRank");
		
		name = "Genevieve"; 
		gender = "F";
		System.out.println("Q#9: select all years:");
		int highestRank = miniP.yearOfHighestRank(name, gender);
		System.out.println("The highest rank for the name " + name + " gender " + gender + " is at year " + highestRank );

		name = "Mich"; 
		gender = "M";
		System.out.println("Q10: select all years:");
		highestRank = miniP.yearOfHighestRank(name, gender);
		System.out.println("The highest rank for the name " + name + " gender " + gender + " is at year " + highestRank );

		//6th method getAverageRank that has two parameters: a string name, and a string named gender (F for female and M for male). 
		//This method selects a range of files to process and returns a double representing the average rank 
		//of the name and gender over the selected files.
		System.out.println("\n question 6: averageRank");
				
		name = "Susan";
		gender = "F";
		System.out.println("Q#11: select all years:");
		double aveRank = miniP.getAverageRank(name, gender);
		System.out.println("The average rank of " + name + " gender " + gender + " is " + aveRank);

		name = "Robert";
		gender = "M";
		System.out.println("Q#12: select all years:");
		aveRank = miniP.getAverageRank(name, gender);
		System.out.println("The average rank of " + name + " gender " + gender + " is " + aveRank);

		//7th  method getTotalBirthsRankedHigher that has three parameters: 
		//an integer named year, a string named name, and a string named gender (F for female and M for male). 
		//This method returns an integer, the total number of births of those names with the same gender and same year 
		//who are ranked higher than name
		System.out.println("Q13: select year 2012: ");
		year = 2012;
		name = "Ethan";
		gender = "M";
				
		int totalBirthHigher = getTotalBirthsRankedHigher(year, name, gender);
		System.out.println("The total " + gender + " births at year " + year + " ranks higher than " + name + " is: " + totalBirthHigher);

		System.out.println("Q14: select year 2012: ");
		year = 2012;
		name = "Ethan";
		gender = "M";
				
		totalBirthHigher = getTotalBirthsRankedHigher(year, name, gender);
		System.out.println("The total " + gender + " births at year " + year + " ranks higher than " + name + " is: " + totalBirthHigher);

	}//end of main();

	
	
	private static int getTotalBirthsRankedHigher(int year, String name, String gender) {
		// TODO Auto-generated method stub
		FileResource fr = new FileResource();
		
		int sum = 0;
		for(CSVRecord record : fr.getCSVParser(false)){
			
			if(record.get(1).equals(gender)){
				
				if(record.get(0).equals(name)) return sum;
				
				sum += Integer.parseInt(record.get(2));
								
			}//end if record euqals gender condition;
			
		}//end for CSV record record;
		
		return sum;
	}//end getTotalBirthsRankedHigher() method;

	
	private double getAverageRank(String name, String gender) {
		// TODO Auto-generated method stub
		
		//get director
		DirectoryResource dr = new DirectoryResource();
		int fileNum = 0;
		int totalRank = 0;
		
		for(File fi : dr.selectedFiles()){
			fileNum++;
			
			//get the file resource
			FileResource fr = new FileResource(fi);
			
			int pivot = 0;
			int currRank = 0;
			for(CSVRecord record : fr.getCSVParser(false) ){
				
				if(record.get(1).equals(gender)) {pivot++;
				
					if(record.get(0).equals(name)) {
					
						currRank = pivot;
						break;
					
					} //end if record.equals name condition;
				}
				
			}//end for Record loop;
			
			totalRank += currRank;
			
		}//end for file loop;
		
		if(totalRank == 0) return -1;
		else return (double)(totalRank)/fileNum;
	
	}//end getAverageRank() method;

	
	private int yearOfHighestRank(String name, String gender) {
		// TODO Auto-generated method stub
		
		//initial year and rank;
		int rank = 1000000;
		int yearHigh = 0;
		
		//get the directory:
		DirectoryResource dr = new DirectoryResource();
		
		//get the files
		for(File fi : dr.selectedFiles()){
			
			//get the name of the file, which contains the year
			String fileName = fi.getName();
			
			//get the year integer from the name of the file
			int year = Integer.parseInt(fileName.replaceAll("[\\D]", ""));
			
			//get the FileResource
			FileResource fr = new FileResource(fi);
			int currRank = -1;
			int pivot = 0;
			for(CSVRecord record : fr.getCSVParser(false)){
				
				if(record.get(1).equals(gender)) {
					
					pivot++;
								
					if(record.get(0).equals(name)) {
						currRank = pivot;
						break;
					}
					
				}
				
			}//end for loop;
			
			//int currRank = getRank(year, name, gender);
		//	System.out.println("  At year " + year + " name " + name + " gender " + gender + " ranks " + currRank + ". ");
			
			if(currRank != -1 && currRank < rank){
				rank = currRank;
				yearHigh = year;
			}//end if condition;
		
		}//end for File fi loop;
		
		return yearHigh;
	}

	
	private void whatIsNameInYear(String name, int year1, int year2, String gender) {
		// TODO Auto-generated method stub

		
		int rank = getRank(year1, name, gender);
		//System.out.println(name + " ranks " + rank + " at year " + year1);
		String equalName = getName(year2, rank, gender);
		
		//Isabella born in 2012 would be Sophia if she was born in 2014.
		System.out.println( name + " born in " + year1 + " would be " + equalName + " if she was born in " + year2);
		
	}//end whatIsNameInYear() method;

	
	private String getName(int year, int rank, String gender) {
		// TODO Auto-generated method stub
		
		//get the file
		FileResource fr = new FileResource();
		
		int pivot = 0;
		//get the CSV file
		for(CSVRecord record : fr.getCSVParser(false)){
			
			if(record.get(1).equals(gender)){ 
				
				pivot ++;
				if(pivot == rank) return record.get(0);
			}//
			
		}//end for CSV record loop;
		
		System.out.println("the rank: " + rank + "... The last one rank " + pivot + ".");
		return "NO NMAE";
		
	}//end getName() method;


	private int getRank(int year, String name, String gender) {
		// TODO Auto-generated method stub

		//get the file
		FileResource fr = new FileResource();
				
		int pivot = 0;
		
		for(CSVRecord record : fr.getCSVParser(false)){
			
			//for female records
			if(record.get(1).equals(gender)) {
				
				//the pivot of equal gender ++
				pivot++;
				if(record.get(0).equals(name)) return pivot;
			
			}
			
		}//end for CSV record loop;
			
		return -1;
			
	}//end getRank() method;


	private void totalBirths() {
		// TODO Auto-generated method stub

		//get the file, 
		FileResource fr = new FileResource();
		
		//get the CSV, parser the CSV
		int numGirl = 0;
		int numBoy = 0;
		int sum = 0;
		for(CSVRecord record : fr.getCSVParser(false)){
			String gender = record.get(1);
			int num = Integer.parseInt(record.get(2));
			
			if(gender.equals("F")) numGirl ++;
			else numBoy ++;
			
			sum ++;
			
		}//end for csvrecord loop;
		
		
		//printout num of girls, boys, and total
		System.out.println("Girls: " + numGirl +", Boys: " + numBoy +", Total: " + sum);
		
	}//end of totalBirths() method;
	
	
}
