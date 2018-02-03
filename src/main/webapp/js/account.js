window.onload = function () {
    document.getElementById("login").oninput = function (ev) {
        ev.target.setCustomValidity("");
        if(!ev.target.validity.valid){
            ev.target.setCustomValidity("Login must contain only letters and 0-9_.- and have length from 4 to 20");
        }
    };
    document.getElementById("password").oninput = function (ev) {
        ev.target.setCustomValidity("");
        if(!ev.target.validity.valid){
            ev.target.setCustomValidity("Password should be from 8 to 40 characters length and may not contain spaces");
        }
    };
    document.getElementById("password").onfocus = function (ev) {
        if(ev.target.validity.valid){
            ev.target.setCustomValiduty("");
        }
    };
    document.getElementById("new-password").oninput = function (ev) {
        ev.target.setCustomValidity("");
        if(!ev.target.validity.valid){
            ev.target.setCustomValidity("Password should be from 8 to 40 characters length and may not contain spaces");
        }
    };
    document.getElementById("new-password").onfocus = function (ev) {
        if(!ev.target.validity.valid&&!ev.target.validity.validationMessage=="New passwords must match!"){
            ev.target.setCustomValidity("New passwords must match!");
        }
    };
    document.getElementById("new-password2").oninput = function (ev) {
        ev.target.setCustomValidity("");
        if (!ev.target.validity.valid) {
            ev.target.setCustomValidity("Password should be from 8 to 40 characters length and may not contain spaces");
        }
    };
    document.forms["account"].addEventListener('submit', function (e) {
        if (!(document.getElementById("new-password").value == document.getElementById("new-password2").value)){
            document.getElementById("new-password").setCustomValidity("New passwords must match!");
            document.getElementById("new-password").validity=false;
            document.getElementById("new-password").focus();
            e.preventDefault();
        }
    }, false);

};