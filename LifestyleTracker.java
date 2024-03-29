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

import java.util.ArrayList;

public class LifestyleTracker{
	
	ArrayList<Food> listoffood = new ArrayList<Food>();
	ArrayList<Activity> listofactivities = new ArrayList<Activity>();
	ArrayList<String> eaten = new ArrayList<String>();
	ArrayList<Double> servingsu = new ArrayList<Double>();
	ArrayList<String> done = new ArrayList<String>();
	ArrayList<Double> hour = new ArrayList<Double>();
	ArrayList<Double> foodcallist = new ArrayList<Double>();
	ArrayList<Double> activitycallist = new ArrayList<Double>();
	Food temp = new Food("fakefood", 123);
	Activity temporary = new Activity("fakename", 123);
	private double servingsforfood; 
	private double foodcal;
	private double activitycal;
	private double totalcalorieseaten;
	private double totalcaloriesburned;
	private double totaltotalcalories;
	private double calorieconversion;
	private double activityhours;
	private double tdee;
	private double multiplier;
	private String namefood;
	private String thenameofactivity;
	private String string;
	private String ultimatefood;
	private String ultimateactivity;
	private String decision;
	private int j;
	private boolean check;
	
	
	public LifestyleTracker(){
		listoffood.add(temp);
		listofactivities.add(temporary);
		string = "";
		ultimateactivity = "";
		ultimatefood = "";
	}
	
	public String addFood(String n, double c){

		Food ulam = new Food(n, c);
		ulam = new Food(n, c);
		
		for(Food x : listoffood){
			namefood = x.getFoodName();
				if(namefood.equals(n)){
					x.updateCalories(c);
					string = "Updated Food "+n+" with "+String.format("%.2f", c)+" kcal";
					return string;
				}else{
					continue;
				}
			}
		foodcal = c;
		listoffood.add(ulam);
		string = "Added Food "+n+" with "+String.format("%.2f", c)+" kcal";
		
		return string;
	
	}

		
	public String addActivity(String n, double c){
		
		Activity actibidad = new Activity(n, c);
		actibidad = new Activity(n, c);
		
		for(Activity x : listofactivities){
			thenameofactivity = x.getActivityName();
				if(thenameofactivity.equals(n)){
					x.updateCalories(c);
					string = "Updated Activity "+n+" with "+String.format("%.2f", c)+" kcal";
					return string;
				}else{
					continue;
				}
			}
		activitycal = c;
		listofactivities.add(actibidad);
		string = "Added Activity "+n+" with "+String.format("%.2f", c)+" kcal";
		
		return string;
		
	}
	
	public void editRecords(int index, double num){
		
		
		if(decision.equals("Food")){
			servingsu.set(index, num);
			namefood = eaten.get(index);
			for(Food x : listoffood){
				String thenameoffood = x.getFoodName();
				foodcal = x.getFoodCalories();
				if(thenameoffood.equals(namefood)){
					foodcal = foodcal * num;
					System.out.println("Successfully Edited");
					foodcallist.set(index, foodcal);
					System.out.printf("The record is now: %.2f serving(s) of "+eaten.get(index)+", %.2f kcal", servingsu.get(index), foodcal);
					System.out.println();
					break;
			}
			}
		
		}else{
			hour.set(index, num);
			thenameofactivity = done.get(index);
			for(Activity x : listofactivities){
				namefood = x.getActivityName();
				activitycal = x.getActivityCalories();
				if(namefood.equals(thenameofactivity)){
					activitycal = activitycal * num;
					System.out.println("Successfully Edited");
					activitycallist.set(index, activitycal);
					System.out.printf("The record is now: %.2f serving(s) of "+done.get(index)+", %.2f kcal", hour.get(index), activitycal);
					System.out.println();
					break;
				}
			}
			
			
			
			
		}
		
		
		
	}


	public void deleteRecords(int index){
		
		
		if(decision.equals("Food")){
			servingsu.remove(index);
			eaten.remove(index);
			
		}else{
			hour.remove(index);
			done.remove(index);
			
		}
		
		System.out.println("Successfully deleted");

}

	public boolean checker(String t, String n, double c){	
			
		if(t.equals("Eat")){
			for(Food x : listoffood){
			namefood = x.getFoodName();	
			foodcal = x.getFoodCalories();
			if(namefood.equals(n)){
					check = true;
					break;
				}else{
					check = false;
				}
			}
			if(check == false){
				System.out.println("The specified food does not exist");
				System.out.println("Would you like to create it?");
			}
			
		}else if(t.equals("Perform")){
			for(Activity x : listofactivities){
			thenameofactivity = x.getActivityName();
			activitycal = x.getActivityCalories();
			if(thenameofactivity.equals(n)){
					check = true;
					break;
				}else{
					check = false;
				}
			}
			if(check == false){
				System.out.println("The specified activity does not exist");
				System.out.println("Would you like to create it?");
			}
		}
		return check;
}

	public String eat(String foodName, double servings){
			
		if(servings > 0){
			eaten.add(foodName);
			servingsu.add(servings);
			foodcal = foodcal * servings;
			foodcallist.add(foodcal);
			string = "Ate "+String.format("%.2f", servings)+" serving(s) of "+foodName+", "+String.format("%.2f", foodcal)+" kcal";
			return string;
		}else if(servings <0){
			string = "Number of servings cannot be negative";
			return string;
		}		
	return string;
	}

	public String perform(String actName, double hours){

		if(hours>0){
			done.add(actName);
			hour.add(hours);
			activitycal = activitycal * hours;
			activitycallist.add(activitycal);
			string = "Performed "+String.format("%.2f", hours)+" hour(s) of "+actName+", "+String.format("%.2f", activitycal)+" kcal";	
			return string;
		}else if(hours<0){
			string = "Number of hours cannot be negative";
			return string;
		}
	return string;
	}

	public void printRecords(String t){
		decision = t;
		if(t.equals("Activity")){
			j = 0;
			System.out.println("So far, you have done:");
			for(String y : done){
				for(Activity x : listofactivities){
					thenameofactivity = x.getActivityName();
					activitycal = x.getActivityCalories();
						if(thenameofactivity.equals(y)){
							activityhours = hour.get(j);
							foodcal =  activitycal * activityhours;
							activitycallist.add(foodcal);
							System.out.printf(j + ". %.2f hour(s) of "+thenameofactivity+", %.2f kcal", activityhours, foodcal);
							System.out.println();
						}
			
				}
					j += 1;
			}
		
		}

		if(t.equals("Food")){
			j = 0;
			System.out.println("So far, you have done:");
				for(String y : eaten){
					for(Food x : listoffood){
						namefood = x.getFoodName();
						foodcal = x.getFoodCalories();	
							if(namefood.equals(y)){
								servingsforfood = servingsu.get(j);
								foodcal =  foodcal * servingsforfood;
								foodcallist.add(foodcal);
								System.out.printf(j + ". %.2f servings(s) of "+namefood+", %.2f kcal", servingsforfood, foodcal);
								System.out.println();
							}
			
					}
					j += 1;
				}
		
			}
	}
	
	public void TDEE(String sex, double kg, double cm, int age, String moderation, String goal){
		
		if(moderation.equals("None")){
			multiplier = 1.2;
		}else if(moderation.equals("Light")){
			multiplier = 1.375;
		}else if(moderation.equals("Moderate")){
			multiplier = 1.55;
		}else if(moderation.equals("Heavy")){
			multiplier = 1.725;
		}
		
		if(sex.equals("M")){
			double totalweight = 13.7 * kg;
			double totalheight = 5 * cm;
			double totalage = 6.8 * age;
			tdee = 66 + totalweight + totalheight - totalage;
			tdee = tdee * multiplier;
			
		}else if(sex.equals("F")){
			double totalweight = 9.6 * kg;
			double totalheight = 1.8 * cm;
			double totalage = 4.7 * age;
			tdee = 655 + totalweight + totalheight - totalage;
			tdee = tdee * multiplier;
			
		}
		
		System.out.println("Your maintenance calories are "+tdee+" kcal.");
		
		if(goal.equals("Gain")){
			System.out.println("If you would like to gain weight, please subtract 500 from your maintenance calories");
		}else if(goal.equals("Lose")){
			System.out.println("If you would like to lose weight, please subtract 500 from your maintenance calories");
		}
	
	}

	public String report(){
		
		listoffood.remove(temp);
		listofactivities.remove(temporary);
		
		
		String line1 = "----------------";
		String line2 = "LIFESTYLE REPORT";
		String line3 = "Food Consumed:";
		
		j = 0;
		for(String x : eaten){
			for(Food y : listoffood){
				namefood = y.getFoodName();
				foodcal = y.getFoodCalories();
				
				if(namefood.equals(x)){
					servingsforfood = servingsu.get(j);
					foodcal =  foodcallist.get(j);
					String line4 = String.format("%.2f", servingsforfood) + " serving(s) of "+namefood+", "+String.format("%.2f", foodcal)+" kcal";
					ultimatefood =  ultimatefood + "\n" +line4;
					totalcalorieseaten += foodcal;
				}
			
			}
			
			j += 1;
			
		}
		

		String line5 = "Total Calories Consumed: "+String.format("%.2f", totalcalorieseaten)+ " kcal";
		String linesinget = "Activities Performed:";
		
		j = 0;
		for(String x : done){
			for(Activity y : listofactivities){
				namefood = y.getActivityName();
				
				if(namefood.equals(x)){
					activityhours = hour.get(j);
					activitycal = activitycallist.get(j);
					String line6 = String.format("%.2f", activityhours) + " hour(s) of "+namefood+", "+String.format("%.2f", activitycal)+" kcal";
					ultimateactivity = ultimateactivity+"\n" +line6;
					totalcaloriesburned += activitycal;
				}
			
			}
			
			j += 1;
			
		}
		
		totaltotalcalories = totalcalorieseaten -= totalcaloriesburned;
		calorieconversion = totaltotalcalories * .00012959782;
		double inaweek = Math.abs(calorieconversion * 7);
		double inamonth = Math.abs(calorieconversion * 30);
		double inthreemonth = Math.abs(calorieconversion * 90);
		double insixmonth = Math.abs(calorieconversion * 180);
		
		String line7 = "Total Calories Burned: "+String.format("%.2f", totalcaloriesburned)+ " kcal";
		String line8 = "Net Calories for the Day: "+String.format("%.2f", totaltotalcalories)+ " kcal";
		String line9 = "If you keep up this lifestyle...";
		if(totaltotalcalories > 0){
			decision = "gain ";
		}else{
			decision = "lose ";
		}
		String line10 = "In a week, you will "+decision+String.format("%.2f", inaweek)+" kilograms.";
		String line11 = "In a month, you will "+decision+String.format("%.2f", inamonth)+" kilograms.";
		String line12 = "In a 3 months, you will "+decision+String.format("%.2f", inthreemonth)+" kilograms.";
		String line13 = "In a 6 months, you will "+decision+String.format("%.2f", insixmonth)+" kilograms.";
		
		String reportline = line1 + "\n" + line2 + "\n" + line1 + "\n" +line3+ "\r" +ultimatefood+ "\n" +line1+"\n"+line5+ "\n" +line1+ "\n" +linesinget+ "\r"+ultimateactivity+ "\n" +line1+ "\n" +line7+ "\n" +line1+ "\n" +line8+ "\n" +line9+ "\n" +line10+ "\n" +line11+ "\n" +line12+ "\n" +line13+ "\n" +line1;
		
		return reportline;
		
		}
		
}
	
