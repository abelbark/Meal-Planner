
/**
 * An object that holds individual meal planns
 */
public class MealPlan
{
    private int month;
    private int date;
    private double time;
    private String meal;
    private int cal;
    
    

    //creating a meal
    public MealPlan(int month, int date, double time, String meal, int cal)
    {
        this.month = month;
        this.date = date;
        this.time = time;
        this.meal = meal;
        this.cal = cal;
    }
    
    //return the calories for recalculations
    public int getCal(){
        return cal;
    }

    //print everything for the GUI
    public String printMeal()
    {
        return ("You have scedualed "+meal+" at "+time);
    }
}
