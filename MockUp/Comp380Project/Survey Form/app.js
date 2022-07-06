  let users = [];

    const addUsers = (ev)=>{
        ev.preventDefault();
        let user = {
            weight: document.getElementById('userInput1').value,
            height: document.getElementById('userInput2').value,
            goal: document.querySelector('input[name="diet"]:checked').value,
            activity: document.querySelector('input[name="exercise"]:checked').value,
            lifestyle: document.querySelector('input[name="lifestyle"]:checked').value,
        }
        users.push(user);
        document.forms[0].reset();
        console.warn('added', {users} );

    }

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('btn').addEventListener('click', addUsers)
})
