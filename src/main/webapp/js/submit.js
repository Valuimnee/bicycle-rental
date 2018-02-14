$(document).ready(function () {
    $('form.no-resubmit').on('submit', function (ev) {
        var $form=$(this);
        if(!$form[0].checkValidity()){
            console.log("form invalid");
            ev.preventDefault();
            return false;
        }
        var $flag=$('input[name="submitted"]');
        if($flag.attr('value')=='false'){
            $flag.attr('value','true');
            return true;
        }else{
            ev.preventDefault();
            return false;
        }
    });
});
