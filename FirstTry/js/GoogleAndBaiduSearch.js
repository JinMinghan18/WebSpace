function google() {
    var inputs = document.getElementsByTagName('input');
    var act = "https://www.google.com/search?q="+inputs[0].value;
    // document.search.action = act;

    // document.search.submit();
    window.location.href = act;
}


function baidu() {

    document.search.action="https://www.baidu.com/s?wd=";
    document.search.submit();
}
