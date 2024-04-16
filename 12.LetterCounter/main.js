const textInput = document.getElementById('text-input')
const countButton = document.getElementById('count-button')
const result = document.getElementById('result')

function countLetters(){
    const text = textInput.value
    const count = text.length
    result.textContent = `The text contains ${count} letters.`
}

countButton.addEventListener('click', countLetters)