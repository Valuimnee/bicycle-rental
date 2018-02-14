$.ajax({
    complete: function (e) {

    }
})

window.onload=function (ev) {
    document.querySelector("form").addEventListener("submit", function (ev2) {
        alert("hi1");
    });
    $('form').on('submit', function (e) {
        alert('hi2');
    });
    $('.no-resubmit').on('submit', function (ev2) {
        alert("hi3");
        ev2.preventDefault();
        $("input[name=submit]").value=true;
        return true;
    });
    /*document.getElementsByClassName("no-resubmit").addEventListener("submit", function (ev) {
        ev.preventDefault();
        /!*if(document["submit"].value==true){
            ev.preventDefault();
        }else{
            if(!ev.target.validity.valid){
                ev.preventDefault();
            }else{
                document["submit"].value=true;
            }
        }*!/
    })*/
};

