let firstName;
let lastName;
let address;
let email;
let pswd;
let cpswd;
let agree;
var letters = /^[A-Za-z]+$/;
var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[!@#$%^&*_.])(?=.*[A-Z]).{6,12}$/;

let flag1, flag2, flag3,flag4,flag5,flag6 = false;


function setValue(){
    firstName = document.getElementById('fName').value;

    lastName = document.getElementById('lName').value;
    address = document.getElementById('address').value;
    email = document.getElementById('email').value;
    pswd = document.getElementById('pswd').value;
    agree = document.getElementById('agree').checked;
    cpswd = document.getElementById('cpswd').value;
}
function enable(){
    setValue();
    if(firstName==""){
        alert("First Name is missing");
    }else if(!firstName.match(letters)){
        alert("name contains alphabets only");
    }else{
        flag1 = true;
    }
    if(lastName==""){
        alert("Last Name is missing");
    }else if(!lastName.match(letters)){
        alert("last name contains alphabets only");
    }else{
        flag2 = true;
    }
    if(address==""){
        alert("Address is missing");
    }else{
        flag3 = true;
    }   
    if(email==""){
        alert("Email is missing");
    }else if(!validateEmail(email)){
        alert("You have entered an invalid email address!")
    }else flag4 =true;
    
    if(cpswd!=pswd){
        alert("Password does not match");
    }else if(pswd =="" ){
        alert("password is missing")
    }else if(!validatePassword(pswd)){
        alert("Password should contain following\n1 Uppercase character\n1 Lowercase character\n1 numember\n1 special character");
    }else{
        flag5 = true;
    }
    if(!agree){
        alert("Make sure you check, terms and conditions");
    }else{
        flag6 = true;
    }
    if(((flag1 && flag2) && flag3) && ((flag4 && flag5) && flag6)){
        document.forms['reg'].submit();
    }
}


function validateEmail(email) 
{
 if (/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(email))
  {
    return 1;
  }
    return 0;
}

function validatePassword(pswd){
    if(pswd.match(passw)){
        return 1
    }else{
        return 0;
    }
}