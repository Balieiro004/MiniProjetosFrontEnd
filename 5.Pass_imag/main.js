const images = [
    "images/image_1.jpg",
    "images/image_2.jpg",
    "images/image_3.jpg",
]

let currentIndex = 0

let imageElement = document.getElementById('image')
let buttonElement = document.getElementById('button')

buttonElement.addEventListener('click', function() {
    currentIndex++
    if(currentIndex >= images.length){
        currentIndex = 0
    }
    imageElement.src = images[currentIndex]

})