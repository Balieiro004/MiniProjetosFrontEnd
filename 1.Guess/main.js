let randomNumber = Math.floor(Math.random() * 100)
let tries = 0
console.log(randomNumber)

function checkGuess(){
    let guess = document.getElementById('guess').value
    let message = document.getElementById('message')
    tries++

    if(guess == randomNumber){
        message.innerHTML = 'Congratulations, you guesses the number in ' + tries + ' tries!'
    }
    else if(guess < randomNumber){
        message.innerHTML = 'To low. Try Again!'
    }else{
        message.innerHTML = 'Too hight. Try again!'
    }
}