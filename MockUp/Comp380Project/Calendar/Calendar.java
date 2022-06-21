
/**
 * An object that contains all the information for the calendar
 */
public class Calendar
{
    //NOTE: Because of the way arrays work, [month+1] [Day+1] Is what we will have to use.
    Day[][] calendar = new Day[12][31];
    int[] pointer = new int[2];
    int[] currentDay = new int[2];
    int maxCal;
    
    
    
    public Calendar()
    {
        // Create each month, give it the proper number of days. Keep track of the current day
        // Using a jagged arrray to keep track of month lengths.
        // This gets a bit confusing, so i filled in a lot of the blanks to help visualize it
        
        
        //calendar[0] = new Day[31];   Jan
          calendar[1] = new Day[28]; //Feb
        //calendar[2] = new Day[31];   Mar
          calendar[3] = new Day[30]; //Apr
        //calendar[4] = new Day[31];   May
          calendar[5] = new Day[30]; //Jun
        //calendar[6] = new Day[31];   Jul
        //calendar[7] = new Day[31];   Aug
          calendar[8] = new Day[30]; //Sep
        //calendar[9] = new Day[31];   Oct
          calendar[10] = new Day[30];//Nov
        //calendar[11] = new Day[31];  Dec
        
        
        // Id is the day of the week. 0 is monday, 6 is sunday. Usefull for identifying weeks
        int id = 5;
        
        //I need the actual value once we know how to calculate it. for now it's just 100
        maxCal = 100;
        
        for (int i = 0; i < 12; i++){
            for (int j = 0; j < calendar[i].length; j++){
                calendar[i][j] = new Day(i, j, id, maxCal);
                id ++;
                id = id % 7;
            }
        }
        
        //I need the program to update this daily. 
        //This translate to June 10th (6/10) thanks to how arrays work
        currentDay[0] = 5;
        currentDay[1] = 9;
        
        // "pointer" is how I'm going to keep track of what sections of the calendar the user is looking at
        //The idea is that watever day the user taps/clicks becomes the cordinits stored in "pointer"
        pointer[0] = 5;
        pointer[1] = 9;
        
        // at some point, i need to figure out how to save the entire calender. I could wright all of it's data to a text file.
        //then make a new constructor that recreates the calander from the text file. 
    }

    /**
     * Functions: 
     * Add a meal plan to a day
     * Get a meal plan from a sepecific day
     * Make sure all of them are easily printable
     * 
     * Make changes easy
     * 
     */
    
    
    // This function adds a meal at the location of the cursor
    public void addMeal( double time, String meal, int cal, int option)
    {
        calendar[ pointer[0] ][ pointer[1] ].insertMeal(time, meal, cal, option);
    }
    
    public MealPlan getMeal(int option){
        if (option == 0){
            return calendar[ pointer[0] ][ pointer[1] ].getBreakfast();
        } else if (option == 1) {
            return calendar[ pointer[0] ][ pointer[1] ].getLunch();
        } else if (option == 2) {
            return calendar[ pointer[0] ][ pointer[1] ].getDinner();
        }else if (option == 3) { // expect an error with this one, fix it in testing
            return calendar[ pointer[0] ][ pointer[1] ].getSnack(option - 3);
        }else {
            return null;
        }
    }
    
    public void removeMeal(int option){
        if (option == 0){
            calendar[ pointer[0] ][ pointer[1] ].removeBreakfast();
        } else if (option == 1) {
            calendar[ pointer[0] ][ pointer[1] ].removeLunch();
        } else if (option == 2) {
            calendar[ pointer[0] +1][ pointer[1] ].removeDinner();
        }else if (option == 3) { // expect an error with this one, fix it in testing
            calendar[ pointer[0] ][ pointer[1] ].removeSnack(option - 3);
        }
    }
    
    public void updateCals(int newVal){
        for (int i = currentDay[0] ; i < 12; i++){
            if (i == currentDay[0]){
                for (int j = currentDay[1]; j < calendar[i].length; j++){
                    calendar[i][j].newMax(newVal);
                }
            } else {
                for (int j = 0; j < calendar[i].length; j++){
                    calendar[i][j].newMax(newVal);
                }
            }
        }
    }
    
    //NOTE: INTACES ACTUAL DATE, COVERTS INTO ARRAY DATE
    
    public void movePoint(int month, int day){
        
        pointer[0] = month - 1;
        pointer[1] = day - 1;
    }
    
    public void moveUpWeek(){
        if (pointer[1] - 7 < 0){
                if (pointer[0] - 1 < 0){
                    //if both the day and month cannot be reduced, we are on january first and the rest need to be null.
                    pointer[0] = 0;
                    pointer[1] = 0;
                } else{
                    // if the day is not reducable, go to the last month and continue from there
                    
                    int dotw = calendar[pointer[0]][pointer[1]].getDOTW();
                    pointer[0] --;
                    pointer[1] = calendar[pointer[0]].length - 1;
                    while (calendar[pointer[0]][pointer[1]].getDOTW() != dotw){
                        pointer[1] --;
                    }
                }
            } else {
                //if the day is reducable, simply reduce it.
                pointer[1] -= 7;
            }
        
    }
    
    public void moveDownWeek(){
        if (pointer[1] + 7 > calendar[pointer[0]].length - 1){
                if (pointer[0] + 1 > 11){
                    //if both the day and month cannot be reduced, we are on january first and the rest need to be null.
                    pointer[0] = 11;
                    pointer[1] = 30;
                } else{
                    // if the day is not reducable, go to the last month and continue from there
                    int dotw = calendar[pointer[0]][pointer[1]].getDOTW();
                    pointer[0] ++;
                    pointer[1] = 0;
                    while (calendar[pointer[0]][pointer[1]].getDOTW() != dotw){
                        pointer[1] ++;
                    }
                }
            } else {
                //if the day is reducable, simply reduce it.
                pointer[1] += 7;
            }
    }
    
    public void moveUpMonth(){
        if (pointer[0] + 1 > 11){
            
        } else {
            pointer[0] --;
        }
    }
    
    public void moveDownMonth(){
        if (pointer[0] - 1 < 0){
            
        } else {
            pointer[0] ++;
        }
    }
    
    //Printing the meals. Notice that they return String[]. The hope is we would be able to plug that sstring into the display window. 
    
    public String[] printMonth(){
        String[] fin = new String[calendar[pointer[0]].length];
        for (int j = 0; j < calendar[pointer[0]].length; j++){
            fin[j] = calendar[pointer[0]][j].printDay();
        }
        return fin;
    }
    
    
    //this one is a bit weird and verry complicated :D
    public String[] printWeek(){
        String[] fin = new String[7];
        
        
        
        // we want to print a week, starting from monday and ending at sunday
        int counter = calendar[pointer[0]][pointer[1]].getDOTW();
        
        int month = pointer[0];
        int day = pointer[1];
        //we start by going down the week from the current pointer. We plan to go down to monday
        while(counter >= 0){
            //add current day to the array
            fin[calendar[month][day].getDOTW()] = calendar[month][day].printDay();
            
            if (day - 1 < 0){
                if (month - 1 < 0){
                    //if both the day and month cannot be decreased, we are on january first and the rest need to be null.
                    while(counter >= 0){
                        fin[counter] = "null";
                        counter --;
                    }
                } else{
                    // if the day cannot be decreased, go to the last month and continue from there
                    month --;
                    day = calendar[month].length - 1;
                }
            } else {
                //if the day can be decreased, simply reduce it.
                day --;
            }
            counter --;
        }
        
        //Now we check if we can go up from the pointer
        counter = calendar[pointer[0]][pointer[1]].getDOTW();
        
        month = pointer[0];
        day = pointer[1];
        
        while(counter <= 6){
            //System.out.println(month + ", " + day);
            fin[calendar[month][day].getDOTW()] = calendar[month][day].printDay();
            //the pointer is currently pointing at the day with "^^(*)^^" Under it
            if (pointer[0] == month && pointer[1] == day){
                fin[calendar[month][day].getDOTW()] += "^^(*)^^";
            }
            
            if (day + 1 > calendar[month].length - 1){
                if (month + 1 > 11){
                    //if both the day and month cannot be increased, we are on December 31st and the rest need to be null.
                    while(counter <= 6){
                        fin[counter] = "null";
                        counter ++;
                    }
                    fin[calendar[month][day].getDOTW()] = calendar[month][day].printDay();
                } else{
                    // if the day cannot be increased, go to the next month and continue from there
                    month ++;
                    day = 0;
                }
            } else {
                //if the day cannot be increased, simply increase it.
                day ++;
            }
            counter ++;
        }
        
        return fin;
    }
}
