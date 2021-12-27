function google() {
    document.getElementById('in1').name='q';
    var inputs = document.getElementsByTagName('input');
    document.search.action = "https://www.google.com/search";
    document.search.submit();
}


function baidu() {

    document.search.action="https://www.baidu.com/s";
    document.search.submit();
}