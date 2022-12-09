// Get data 
const titleInput = document.querySelector("#title");
const description = document.querySelector("#description");
const success = document.querySelector("#success");
const errorNodes = document.querySelectorAll(".error");



function validateForm() {

    clearDescription();

    if(titleInput.value.length < 3) {
        errorNodes[0].innerText = "Title cannot be blank";
        titleInput.classList.add("error-border");
        
    }

    if(description.value.length < 1) {
        errorNodes[1].innerText = "Description cannot be blank";
        description.classList.add("error-border");
        
    }


    function clearDescription() {
        for(let i = 0; i < errorNodes.length; i++) {
            errorNodes[i].innerText = "";
        }
        titleInput.classList.remove("error-border");
        description.classList.remove("error-border");
    }

}