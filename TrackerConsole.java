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

import java.util.Scanner;

public class TrackerConsole{
	
	public static void main(String[] args){
		System.out.println("Welcome to "+args[0]+"'s Lifestyle Tracker!");
		Scanner input = new Scanner(System.in);
		LifestyleTracker lifestyletracker = new LifestyleTracker();
		String inputters = "hello";
		
		while (!inputters.equals("Report")){
			inputters = input.next();
			if(inputters.equals("Food")){
				String food = input.next();
				double foodcals = input.nextDouble();
					System.out.println(lifestyletracker.addFood(food, foodcals));
				
			}else if(inputters.equals("Activity")){
				String activity = input.next();
				double activitycals = input.nextDouble();
					System.out.println(lifestyletracker.addActivity(activity, activitycals));
				
			}else if(inputters.equals("Perform")){
				String activitydone = input.next();
				double hours = input.nextDouble();
				if(lifestyletracker.checker(inputters, activitydone, hours) == true){
					System.out.println(lifestyletracker.perform(activitydone, hours));
				}else{
					String yesno = input.next();
					if(yesno.equals("Yes")){
						System.out.println("Add Calories:");
						double cals = input.nextDouble();
						System.out.println(lifestyletracker.addActivity(activitydone, cals));
						System.out.println(lifestyletracker.perform(activitydone, hours));
					}else{
						continue;
					}
				}
			}else if(inputters.equals("Eat")){
				String foodeaten = input.next();
				double servings = input.nextDouble();
				if(lifestyletracker.checker(inputters, foodeaten, servings) == true){
					System.out.println(lifestyletracker.eat(foodeaten, servings));
				}else{
					String yesno = input.next();
					if(yesno.equals("Yes")){
						System.out.println("Add Calories:");
						double cals = input.nextDouble();
						System.out.println(lifestyletracker.addFood(foodeaten, cals));
						System.out.println(lifestyletracker.eat(foodeaten, servings));
					}else{
						continue;
					}
				}
			}else if(inputters.equals("Delete")){
				String decision = input.next();
				lifestyletracker.printRecords(decision);
				System.out.println("Which one would you like to delete?");
				int index = input.nextInt();
				lifestyletracker.deleteRecords(index);
				
			}else if(inputters.equals("Edit")){
				String decision = input.next();
				lifestyletracker.printRecords(decision);
				System.out.println("Which one would you like to edit?");
				
				int index = input.nextInt();
				double num = input.nextDouble();
				
				lifestyletracker.editRecords(index, num);
				
			}else if(inputters.equals("TDEE")){
				System.out.println("TDEE Calculator (Total Daily Energy Expenditure)");
				System.out.println("an estimation of how many calories you burn per day when exercise is taken into account.");
				System.out.println("Please provide the following in order: Sex(M/F) | Weight in KG | Height in cm | Age | Exercise Frequency | Goal");
				System.out.println("Exercise Frequency Chart:");
				System.out.println("None (Desk Job + Little to no exercise)");
				System.out.println("Light (light exercise 1-3 days / week)");
				System.out.println("Moderate (moderate exercise 3-5 days / week)");
				System.out.println("Heavy (heavy exercise 6-7 days / week)");
				System.out.println("What is your goal? To lose or gain weight?");
				
				String sex = input.next();
				double kg = input.nextDouble();
				double cm = input.nextDouble();
				int age = input.nextInt();
				String moderation = input.next();
				String goal = input.next();
				
				lifestyletracker.TDEE(sex, kg, cm, age, moderation, goal);
				
			}
		
		}
		
		System.out.println(lifestyletracker.report());
		
	}
}