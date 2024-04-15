let starNumber = document.getElementById('star')
let endNumber = document.getElementById('end')
let result = document.getElementById('result')

function showEventNumbers() {
    let start = Number(starNumber.value) 
    let end = Number(endNumber.value)

    let i = start
    let output = 0

    while(i <= end){
        if(i % 2 == 0){
            output = output + i + ' '
            result.innerHTML = output
        }
        i++
    }
}