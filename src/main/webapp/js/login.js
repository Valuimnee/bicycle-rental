window.onload=function () {
    document.getElementById("login").oninput=function (ev) {
        ev.target.setCustomValidity("");
        if (!ev.target.validity.valid) {
            ev.target.setCustomValidity("Login must contain only letters and 0-9_.- and have length from 4 to 20");
        }
    };
    document.getElementById("password").oninput = function (ev) {
        ev.target.setCustomValidity("");
        if(!ev.target.validity.valid){
            ev.target.setCustomValidity("Password should be from 8 to 40 characters length and may not contain spaces");
        }
    };
};