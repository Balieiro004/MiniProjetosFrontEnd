let checkButton = document.getElementById('check-button')
let ageInput = document.getElementById('age-input')

checkButton.addEventListener('click', function(){
    let age = ageInput.value
    let message = (age >= 18) ? 'Your are adult' : 'Your are not and adult'
    alert(message)
    ageInput.value = ''
})