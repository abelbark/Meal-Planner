
PROJECT TITLE: Calender
PURPOSE OF PROJECT: Salt N' Preper
VERSION or DATE: 1.0
AUTHORS: Adrian Gonzalez


MISSING: Save function, a method of keeping "Current date" updated depending
on real world day, A way to update Maximum Calories variables depending on User needs

Notes: 

POINTER: many of the functions in this program depend on the pointer. It can 
be moved using functions that move it up and down by week or month. It can also 
be moved directly to any desired date. 

CURRENT DAY: There is a second pointer, ment to represent the current real world 
day. As of right now, it is set to 6/10 and does not change yet.

PRINTING: The Calendar can print by week or month. It will always print the week 
or month that the pointer is in. Right now, the calendar return a String Array of 
either length 7 or the length of whatever month is currently being printed.

ENTERING MEALS: When entering a meal, The program takes a string representing the 
meal's name, an Int representing the calories, and a Double representing the time. 
There is a 4th parameter called Option. This Option determines the meal is placed in 
either the Breakfast, Lunch, Dinner, or snack slots. Removing meals uses the same variable. 

CHANGING MAXIMUM CALORIES: There is a function that will change the maximum calories for 
every day after the "current day pointer". The idea is that all of the previous day's will 
stay the exact same, only the future dates need to be changed.