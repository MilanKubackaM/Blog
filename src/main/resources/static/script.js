
async function getUsers(){
    let response = await fetch('http://localhost:8080/users');
    let data = await response.text();
    console.log(data);
}

function createUser(){




    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const username = document.getElementById('username').value;
    const surname = document.getElementById('surname').value;
    const password = document.getElementById('password').value;
    const checkPassword = document.getElementById('checkPassword').value;

    postUser(name, email, username, surname, password);

}


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

