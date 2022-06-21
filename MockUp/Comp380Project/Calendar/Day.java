import java.util.ArrayList;
/**
 * An object that represents a single day. Stores Meal objects and tracks daily calories
 */
public class Day
{
    //keeping track of place in callender
    int month;
    int date;
    
    //the actual meals being stored
    MealPlan breakfast;
    MealPlan lunch;
    MealPlan dinner;
    ArrayList<MealPlan> snacks = new ArrayList<MealPlan>(); 
    
    //calorie info
    int maxCal;
    int totalCal;
    
    //day of the week
    int dayOfTheWeek;
    
    public Day(int month, int date, int identify, int maxCal)
    {
        this.month = month;
        this.date = date;
        dayOfTheWeek = identify;
        this.maxCal = maxCal;
        update();
    }

    /**
     * Insert meal plans. 
     * retrieve individual meal plans
     * Replace meal plans
     * Remove meal plans
     * 
     * keep track of calories
     * 
     * print all of the day's information easy
     */
    
    //This handles both incertion and replacement;
    public void insertMeal(double time, String meal, int cal, int option)
    {
        if (option == 0){
            breakfast = new MealPlan (month,  date,  time,  meal,  cal);
        } else if (option == 1) {
            lunch = new MealPlan (month,  date,  time,  meal,  cal);
        } else if (option == 2) {
            dinner = new MealPlan (month,  date,  time,  meal,  cal);
        }else if (option == 3) {
            snacks.add(new MealPlan (month,  date,  time,  meal,  cal));
        } else {
            System.out.println("INVALID - option for creating Meal invalid");
        }
        update();
    }
    
    
    //Remove meals
    public void removeSnack(int option){
        if (snacks.size() > option){
            snacks.remove(option);
        }
    }
    
    public void removeBreakfast (){
        breakfast = null;
        update();
    }
    
    public void removeLunch (){
        lunch = null;
        update();
    }
    
    public void removeDinner (){
        dinner = null;
        update();
    }
    
    public void newMax(int newVal){
        maxCal = newVal;
        update();
    }
    
    
    //recalculates calories after every action
    public void update(){
        totalCal = 0;
        if (breakfast != null){
            totalCal += breakfast.getCal();
        }
        if (lunch != null){
            totalCal += lunch.getCal();
        }
        if (dinner != null){
            totalCal += dinner.getCal();
        }
        if (snacks.size() != 0){
            for (int i = 0; i < snacks.size(); i ++){
                totalCal += snacks.get(i).getCal();
            }
        }
        
    }
    
    //these handle getting individual meals
    public MealPlan getSnack (int option){
        if (snacks.size() > option){
            return snacks.get(option);
        }
        return null;
    }
    
    public MealPlan getBreakfast (){
        return breakfast;
    }
    
    public MealPlan getLunch (){
        return lunch;
    }
    
    public MealPlan getDinner (){
        return dinner;
    }
    
    public int getDOTW(){
        return dayOfTheWeek;
    }
    
    //this prints all the important information for the GUI to display
    //NEEDS FMORE INFO RIGHT NOW IT ONLY PRINTS MEALS
    public String printDay(){
        String fin;
        fin = "Date: "+(month+1)+"/"+(date+1)+"\t Calories : "+totalCal+" / "+maxCal+"\n";
        
        fin += "0 Breakfast: ";
        if (breakfast == null){
            fin += "Null \n";
        } else {
            fin += breakfast.printMeal() + " \n";
        }
        
        fin += "1 Lunch: ";
        if (lunch == null){
            fin += "Null \n";
        } else {
            fin += lunch.printMeal() + " \n";
        }
        
        fin += "2 Dinner: ";
        if (dinner == null){
            fin += "Null \n";
        } else {
            fin += dinner.printMeal() + " \n";
        }
        
        if (snacks.size() == 0){
            //System.out.println(fin);
            return fin;
        } else {
            for (int i = 0; i < snacks.size(); i ++){
                fin += (3 + i)+ " Snacks: " + snacks.get(i).printMeal()+ " \n";
            }
        }
        //System.out.println(fin);
        return fin;
    }
}
