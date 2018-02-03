window.onload = function () {
    document.getElementById("address").oninput = function (ev) {
        ev.target.setCustomValidity("");
        if (!ev.target.validity.valid) {
            ev.target.setCustomValidity("Please enter correct address");
        }
    };
    document.getElementById("passport").oninput = function (ev) {
        ev.target.setCustomValidity("");
        if (!ev.target.validity.valid) {
            ev.target.setCustomValidity("Passport number should consist of two upper case letters following by seven digits");
        }
    };
    document.getElementById("phone").oninput = function (ev) {
        ev.target.setCustomValidity("");
        if (!ev.target.validity.valid) {
            ev.target.setCustomValidity("Please enter phone number with length 12 without delimeters");
        }
    };
};