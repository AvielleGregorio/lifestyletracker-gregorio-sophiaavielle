//@author Sophia Avielle D. Gregorio (223019)
//@version December 4, 2022
/*@description: This program is a lifestyle tracker that can 
calculate your caloric consumption for the goal of weight lost, gain or maintenance.
This program has all 3 add ons and can be commanded as such:
-Add On 1: Command: Edit <Food/Activity>
Nextln: Command: <Index> <Hour/Servings>

-Add On 2: Command: Delete <Food/Activity>
Nextln: Command: <Index>

-Add On 3: When executing the Perform/Eat command and the name of the specified does not exist.
Nextln: Command: Yes/No
Nextln: Command: <Insert Calories>

-Mystery Add On: TDEE Calculator so that the user can efficiently use the tracker for their goals
Command: TDEE
Nextln: Sex(M/F) | Weight in KG | Height in cm | Age | Exercise Frequency | Goal

*/
/*
I have not discussed the Java language code in my program 
with anyone other than my instructor or the teaching assistants 
assigned to this course.
I have not used Java language code obtained from another student, 
or any other unauthorized source, either modified or unmodified.
If any Java language code or documentation used in my program 
was obtained from another source, such as a textbook or website, 
that has been clearly noted with a proper citation in the comments 
of my program.
*/

public class Activity{
	
	private String activity;
	private double caloriesburned;
	
	public Activity(String n, double c){
		
		activity = n;
		caloriesburned = c;
		
	}
	
	public String getActivityName(){
		return activity;
	}
	
	public double getActivityCalories(){
		return caloriesburned;
	}
	
	public void updateCalories(double c){
		caloriesburned = c;
	}
	
}