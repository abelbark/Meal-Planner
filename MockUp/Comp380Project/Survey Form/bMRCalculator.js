
//These are test variables, b=please delete the test ones and input the ones from the survey/settings object
//let weight , hieght, gOrL, phyActLvl, sexID, age, finalResult;
let weight = 113.398;
let height = 180;
let phyActLvl = 2;
let sexID = true;
let age = 20;
let finalResult = 0;

//end of variables. start of computation.

if (sexID){
  //male
  finalResult = 10*weight + 6.25*height - 5*age + 5
  
} else{
  //Female
  finalResult = 10*weight + 6.25*height - 5*age - 161
}

// these are multipliers used based on how active the user is
//1 1.2
//2 1.375
//3 1.465
//4 1.55
//5 1.725
//6 1.9

switch (phyActLvl){
  case 1:
    finalResult *= 1.2
  break;
  case 2:
    finalResult *= 1.375
  break;
  case 3:
    finalResult *= 1.465
  break;
  case 4:
    finalResult *= 1.55
  break;
  case 5:
    finalResult *= 1.725
  break;
  case 6:
    finalResult *= 1.9
  break;
}


//This is the output. im not sure how you use this in HTML
console.log(finalResult);
