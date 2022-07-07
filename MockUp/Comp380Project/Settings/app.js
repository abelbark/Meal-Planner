const tabs = document.querySelectorAll('[data-tab-target]');
const tabContents = document.querySelectorAll('[data-tab-content');

tabs.forEach(tab => {
    tab.addEventListener('click',() =>{
        const target = document.querySelector(tab.dataset.tabTarget)
        tabContents.forEach(tabContent => {
            tabContent.classList.remove('active')
        })
        tabs.forEach(tab => {
            tab.classList.remove('active')
        })
        tab.classList.add('active')
        target.classList.add('active')

    })
})

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

}

document.addEventListener('DOMContentLoaded', () => {
document.getElementById('btn').addEventListener('click', addUsers)
})
