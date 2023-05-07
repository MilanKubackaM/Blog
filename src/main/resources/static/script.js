/**
 *  Logged user
 */
let loggedUsername = '';
let loggedUserId = 0;


async function getUsers(){
    let response = await fetch('/users');
    let data = await response.text();
    console.log(data);
}


async function getUserByUsername(username){
    try {
        const response = await fetch(`/users/${username}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({username})
        });

        const data = await response.json();
        console.log("get by username:" + data);
        return data;
    } catch (error) {
        console.error(error);
    }
}


async function getUserById(id) {
    try {
        const response = await fetch(`/users/${id}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });
        return await response.json();

    } catch (error) {
        console.error(error);
    }
}




/**
 *  POST login data and wait for response (ok or badRequest)
 *  TODO: Postman receive response, but here getting 404
 */
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
        if(response.ok){
             handleLogin(username);
        }
        console.log(data);
    } catch (error) {
        console.error(error);
    }
}

/**
 *  Override 'log in' with username and set actual user as Logged
 */
function handleLogin(username){
    let id = getUserByUsername(username);
    console.log("User: " + id);
    loggedUsername = username;
    loggedUserId = id;

    const signInLink = document.querySelector('.nav-item a');
    signInLink.innerHTML = loggedUsername;
}


/**
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
    postUser(name, email, username, surname, password).then(() =>
        handleLogin(username)
    );

    console.log("LoggedUserId: " + loggedUserId + "\n");

}

/**
 *  Register user
 *  TODO: need to handle error in case of bad input & hash password
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

/**
 *  Updating Account settings
 *  TODO: works in postman, needs to connect to JS
 */


async function updateUser(){
/*
 * Assigned just for testing case,
 * because I am still getting 0, don't know why
 */
    loggedUserId = 1;
    console.log("LoggedUserId: " + loggedUserId + "\n");
    if(loggedUserId === null || loggedUserId === 0)
        return;


/** 1. Get user by ID or Username   */
    let existingUser = await getUserById(loggedUserId);
    console.log("Existing user ID: " + existingUser.id);
    console.log("Existing user name: " + existingUser.name);


/** 2. Make a new record with updated properties */

    const name = document.getElementById('updateName').value;
    const email = document.getElementById('updateEmail').value;
    const username = document.getElementById('updateUsername').value;
    const surname = document.getElementById('updatSurname').value;
    const password = document.getElementById('updatePassword').value;
    const checkPassword = document.getElementById('updateCheckPassword').value;

    const updatedUser = {
        name,
        email,
        username,
        surname,
        password,
    };

    const newUser = {
        ...existingUser, // Merge the attributes of existingUser into the newUser object
        ...updatedUser // Override any existing attributes with the updatedUser attributes
    };

    /**  3. Put new User */



    try {
        const response = await fetch(`/users/${loggedUserId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newUser)
        });
        await response.json();
        if(response.ok){
            console.log("Changes success!")
        }
    } catch (error) {
        console.error(error);
    }
}