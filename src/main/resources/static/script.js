async function getUsers(){
    let response = await fetch('/users');
    let data = await response.text();
    console.log(data);
}

/*
 *  POST login data and wait for response (ok or badRequest)
 *  TODO: Postman receive response, but here getting 404
 */
let logedIn = false;
async function loginUser(){
    const username = document.getElementById('loginUsername').value;
    const password = document.getElementById('loginPassword').value;
    try {
        const response = await fetch('users/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({username, password})
        });

        const data = await response.json();
        if(response.ok)
            logedIn = true;
        console.log(data);
    } catch (error) {
        console.error(error);
    }

}

/*
 *  Creating new user
 *  TODO: password needs to be checked
 */
function createUser(){

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const username = document.getElementById('username').value;
    const surname = document.getElementById('surname').value;
    const password = document.getElementById('password').value;
    const checkPassword = document.getElementById('checkPassword').value;

    console.log("Som tu");
    postUser(name, email, username, surname, password);

}

/*
 *  Register user
 *  TODO: need to handle error in case of bad input
 */
async function postUser(name, email, username, surname, password){
    try {
        const response = await fetch('/users', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({name, email, username, surname, password})
        });

        const data = await response.json();
        console.log(data);
    } catch (error) {
        console.error(error);
    }
}