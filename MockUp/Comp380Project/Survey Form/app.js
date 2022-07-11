let users = [];

const addUsers = (ev)=>{
    ev.preventDefault();
    let user = {
        weight: document.getElementById('userInput1').value,
        height: document.getElementById('userInput2').value,
        gender: document.querySelector('input[name="gender"]:checked').value,
        age: document.getElementById('userInput4').value,
        goal: document.querySelector('input[name="diet"]:checked').value,
        activity: document.querySelector('input[name="exercise"]:checked').value,
        lifestyle: document.querySelector('input[name="lifestyle"]:checked').value,
    }
    users.push(user);
    document.forms[0].reset();
    console.warn('added', {users} );

    
    if(user.lifestyle == 'Vegetarian'){
        alert('Check out our Vegetarian Meal Plan');
        return false;
    }
    else if(user.lifestyle == 'Vegan'){
        alert('Check out our Vegan Meal Plan');
        return false;
    }
    else if(user.lifestyle == 'Pescatarian'){
        alert('Check out our Pescatarian Meal Plan');
        return false;
    }
    else{
        alert('Check out our Variety of Meals');
        return false;
    }
    


    localStorage.setItem('HealthInfo', JSON.stringify(users) );
    var retrievedObject = localStorage.getItem('HealthInfo');
    console.log('retrievedObject: ', JSON.parse(retrievedObject));

}
 

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btn').addEventListener('click', addUsers)
})
