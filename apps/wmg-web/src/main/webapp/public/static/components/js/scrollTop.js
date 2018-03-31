$(window).scroll(function(){
    var sc=$(window).scrollTop();
    var rwidth=$(window).width()+$(document).scrollLeft();
    var rheight=$(window).height()+$(document).scrollTop();
    if(sc>0){
        $("#toTop").css("display","block");;
    }else{
        $("#toTop").css("display","none");
    }
});
$("#toTop").click(function(){
    $('body,html').animate({scrollTop:0},500);
});