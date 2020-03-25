function fillcheck() {
    var check_first_table = false;
    var check_second_table = false;
    var check_multi_first = false;
    var check_multi_second = true;

    var radio_first = document.getElementsByName("leave");
    var radio_second = document.getElementsByName("touch");
    var checkbox_first = document.getElementsByName("situation");
    var checkbox_promise = document.getElementsByName("promise");

    for(var i = 0;i < radio_first.length;i++)
    {
        if(radio_first[i].checked == true)
        {
            check_first_table = true;
        }
    }

    for(var i = 0;i<radio_first.length;i++)
    {
        if(radio_second[i].checked == true)
        {
            check_second_table = true;
        }
    }

    for(var i = 0;i < checkbox_first.length;i++)
    {
        if(checkbox_first[i].checked == true)
        {
            check_multi_first = true;
        }
    }

    for(var i = 0;i < checkbox_promise.length;i++)
    {
        if(checkbox_promise[i].checked == false)
        {
            check_multi_second = false;
        }
    }

    if(!check_multi_second){
        alert("请承诺");
        return false;
    }

    if(!check_first_table){
        alert("问题一未选择");
        return false;
    }

    if(!check_second_table){
        alert("问题二未选择");
        return false;
    }
    if(!check_multi_first){
        alert("问题三未选择");
        return false;
    }


}