const counter = document.getElementById('counter');
const incrementButton = document.getElementById('increment');
const decrementButton = document.getElementById('decrement');
const resetButton = document.getElementById('reset');


let count = 0

function updateCounter(){
    counter.textContent = count
}

incrementButton.addEventListener('click', function(){
    count++
    updateCounter()
})

decrementButton.addEventListener('click', function(){
    if(count > 0){
        count--
        updateCounter()
    }
})

resetButton.addEventListener('click', function(){
    count = 0
    updateCounter()
})