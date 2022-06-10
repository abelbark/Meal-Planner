var weight, height, measure, bmi, error;

function calc(){
    weight = document.getElementById("weight").value;
    height = document.getElementById("height").value;
    height *= height;
    bmi = weight/height;
    bmi *= 10000;
    bmi = bmi.toFixed(1);

    if(bmi <= 18.4){
        measure = "Your bmi is " + bmi + " which is Underweight.";
    }else if(bmi >= 18.5 && bmi <= 24.9){
        measure = "Your bmi is " + bmi + " which is Normal.";
    }else if(bmi >= 25.0 && bmi <= 29.9){
        measure = "Your bmi is " + bmi + " which is Overweight.";
    }else {
        measure = "Your bmi is " + bmi + " which is Obese.";
    }

    if(weight === 0){
        document.getElementById("results").innerHTML = error;
    }else if(height === 0){
        document.getElementById("results").innerHTML = error;
    }else{
        document.getElementById("results").innerHTML = measure;
    }

    if(weight < 0) {
        document.getElementById("results").innerHTML = "Not Allowed";
    }

}
