<#import "macros/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="robots" content="index, follow">
    <title>门户</title>
    <!-- BOOTSTRAP -->
    <link rel="stylesheet" href="<@spring.url '/public/static/components/bootstrap/css/bootstrap.min.css'/>" type="text/css">

    <!-- ANIMATE -->
    <link rel="stylesheet" href="<@spring.url '/public/static/components/animate/animate.min.css'/>" type="text/css">

    <!-- ICON FONTS -->
    <link rel="stylesheet" href="<@spring.url '/public/static/components/fonts/font-awesome/css/font-awesome.min.css'/>" type="text/css">
    <link rel="stylesheet" href="<@spring.url '/public/static/components/fonts/ionicons/css/ionicons.min.css'/>" type="text/css">

    <!-- GLOBAL STYLE -->
    <link id="stylesheetGlobal" type="text/css" href="<@spring.url '/public/static/components/bootstrap/css/global-style-blue.min.css'/>" rel="stylesheet" media="screen">
    <!-- banner -->
    <link href="<@spring.url '/public/static/components/flexslider/flexslider.css'/>" rel="stylesheet">
    <link href="<@spring.url '/public/static/components/owl-carousel/css/owl.theme.css'/>" rel="stylesheet">
    <link rel="stylesheet" href="<@spring.url '/public/static/components/cubeportfolio/css/cubeportfolio.min.css'/>">

    <!-- css -->
    <link rel="stylesheet" href="<@spring.url '/public/static/assets/css/page.css'/>" type="text/css">
    <link href="<@spring.url '/public/static/assets/images/favicon.png'/>" rel="icon" type="image/png">
    <link href="<@spring.url '/public/static/components/layer/skin/layer.css'/>" rel="stylesheet">
    <script src="<@spring.url '/public/static/assets/js/jquery.js' />"></script>
    <script src="<@spring.url '/public/static/assets/js/jquery-ui.min.js' />"></script>
    <script src="<@spring.url '/public/static/components/bootstrap/js/bootstrap.min.js' />"></script>
    <script src="<@spring.url '/public/static/components/bootstrap/js/tooltip.js' />"></script>
    <script src="<@spring.url '/public/static/components/js/bootstrap-extensions/bootstrap-dropdownhover.js' />"></script>
    <script src="<@spring.url '/public/static/components/js/bootstrap-extensions/bootstrap.slide-menu.js' />"></script>
    <script src="<@spring.url '/public/static/components/flexslider/jquery.flexslider.js' />"></script>
</head>
<body class="home_page">
welcome!!!
<!-- 登录/注册 -->
<#--<div class="modal fade" id="mdlUserAccount" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">-->
    <#--<div class="modal-dialog" role="document">-->
        <#--<div class="modal-content">-->
            <#--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">-->
                <#--×-->
            <#--</button>-->
            <#--<ul class="nav nav-pills style-2 nav-justified" role="tablist">-->
                <#--<li role="presentation" class="active"><a href="#tab-1" aria-controls="tab-1" role="tab" data-toggle="pill">登录</a></li>-->
            <#--</ul>-->
            <#--<div class="modal-body">-->
                <#--<div class="tab-content">-->
                    <#--<!-- Sign in - Tab 1 &ndash;&gt;-->
                    <#--<div role="tabpanel" class="tab-pane active" id="tab-1">-->
                        <#--<div class="form-body">-->
                            <#--<form data-toggle="validator" role="form" class="mt-20">-->
                                <#--<div class="form-group has-feedback"><!-- 有出错信息时加类名has_error &ndash;&gt;-->
                                    <#--<label class="control-label sr-only" for="">用户名</label>-->
                                    <#--<input type="text" maxlength="11" class="form-control input-lg" id="inputEmail" placeholder="请输入用户名">-->
                                    <#--<span class="glyphicon form-control-feedback" aria-hidden="true"></span>-->
                                    <#--<div class="help-block with-errors" id="mobilePhone_empty" style="display: none">用户名不能为空</div><!-- 出错提示 &ndash;&gt;-->
                                    <#--<div class="help-block with-errors" id="mobilePhone_validate" style="display: none">用户名错误</div><!-- 出错提示 &ndash;&gt;-->
                                <#--</div>-->
                                <#--<div class="form-group has-feedback">-->
                                    <#--<label class="control-label sr-only" for="inputPassword">密码</label>-->
                                    <#--<input type="password" maxlength="20" class="form-control input-lg" id="inputPassword" placeholder="请输入密码">-->
                                    <#--<span class="glyphicon form-control-feedback" aria-hidden="true"></span>-->
                                    <#--<div class="help-block with-errors" id="password_empty" style="display: none">密码不能为空</div><!-- 出错提示 &ndash;&gt;-->
                                    <#--<div class="help-block with-errors" id="password_validate" style="display: none">账号或密码输入错误，请重试</div><!-- 出错提示 &ndash;&gt;-->
                                <#--</div>-->
                                <#--<button type="button" class="btn btn-lg btn-block btn-base-1 mt-20 submit_login">登录</button>-->
                                <#--<div class="form-group mb0 mt-10">-->
                                    <#--<div class="clearfix">-->
                                        <#--<a href="<@spring.url '/userInfo/toPwdForgetFront'/>" class="fl">忘记密码?</a>-->
                                        <#--&lt;#&ndash;<a class="fr registerNow">立即注册</a>&ndash;&gt;-->
                                    <#--</div>-->
                                <#--</div>-->
                            <#--</form>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->
<#--</div>-->
<#--<div class="body-wrap">-->
<#--<div id="st-container" class="st-container">-->
<#--<div class="st-pusher">-->
<#--<div class="st-content">-->
<#--<div class="st-content-inner">-->
    <#--<#include "layouts/head.ftl">-->
    <#--<!-- banner start&ndash;&gt;-->
    <#--<div class="block_home_slider">-->
        <#--<div id="home_slider" class="flexslider">-->
            <#--<ul class="slides">-->
                <#--<li>-->
                    <#--<div class="slide">-->
                        <#--<img src="<@spring.url '/public/static/assets/images/banner/fullimage1.jpg'/>" alt="">-->
                    <#--</div>-->
                <#--</li>-->

                <#--<li>-->
                    <#--<div class="slide pr">-->
                        <#--<img src="<@spring.url '/public/static/assets/images/banner/fullimage2.jpg'/>" alt="">-->
                        <#--<a href="<@spring.url '/userInfo/emoniorDetail'/>" target="_blank" class="banner_btndetail">查看详情</a>-->
                    <#--</div>-->
                <#--</li>-->

                <#--<li>-->
                    <#--<div class="slide">-->
                        <#--<img src="<@spring.url '/public/static/assets/images/banner/fullimage3.jpg'/>" alt="">-->
                    <#--</div>-->
                <#--</li>-->

                <#--<li>-->
                    <#--<div class="slide pr">-->
                        <#--<img src="<@spring.url '/public/static/assets/images/banner/fullimage4.jpg'/>" alt="">-->
                        <#--<a href="<@spring.url '/userInfo/measuresDetail'/>" target="_blank" class="banner_btnqidai">查看详情</a>-->
                    <#--</div>-->
                <#--</li>-->
            <#--</ul>-->
        <#--</div>-->
    <#--</div>-->
    <#--<!-- banner end&ndash;&gt;-->
    <#--<!-- 云管家 EMonitor  增值服务 start &ndash;&gt;-->
        <#--<section class="slice sct-color-1 bb" id="section-1">-->
            <#--<div class="container">-->
                <#--<!-- BLOCKS - STYLE 6 &ndash;&gt;-->
                <#--<div class="row">-->
                    <#--<div class="col-md-4">-->
                        <#--<div class="block style-6 a-icon-effect-1 a-icon-effect-1a">-->
                            <#--<div class="block-icon circle">-->
                                <#--<i class="a-icon yun_icon"></i>-->
                            <#--</div>-->
                            <#--<div class="block-body text-center">-->
                                <#--<h3 class="block-title">监控管家</h3>-->
                                <#--<p class="block-cntp">-->
                                    <#--提供设备的物理连接图示、状态与性能全天自动检查与分析，同时预防故障发生，从而帮助中小企事业用户保障并提升IT环境稳定运行。-->
                                <#--</p>-->
                                <#--<a href="<@spring.url '/userInfo/toApplyTrial'/>" class="btn btn-base-2">申请使用</a>-->
                                <#--<a href="<@spring.url '/userInfo/emoniorDetail'/>" class="btn btn-base-2">查看详情</a>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="col-md-4">-->
                        <#--<div class="block style-6 a-icon-effect-1 a-icon-effect-1a">-->
                            <#--<div class="block-icon circle">-->
                                <#--<i class="a-icon emonitor_icon"></i>-->
                            <#--</div>-->
                            <#--<div class="block-body text-center">-->
                                <#--<h3 class="block-title">基础工具包</h3>-->
                                <#--<p class="block-cntp">-->
                                    <#--为IT日常维护工作提供一系列实用性工具，比如：IP地址管理，节能管理。-->
                                <#--</p>-->
                                <#--<a href="<@spring.url '/userInfo/comeSoon'/>" class="btn btn-base-2">查看详情</a>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="col-md-4">-->
                        <#--<div class="block style-6 a-icon-effect-1 a-icon-effect-1a">-->
                            <#--<div class="block-icon circle">-->
                                <#--<i class="a-icon server_icon"></i>-->
                            <#--</div>-->
                            <#--<div class="block-body text-center">-->
                                <#--<h3 class="block-title">高级智能包</h3>-->
                                <#--<p class="block-cntp">-->
                                    <#--通过大数据分析以及人工智能的大量学习，能为IT维护提供相关决策建议。-->
                                <#--</p>-->
                                <#--<a href="<@spring.url '/userInfo/comeSoon'/>" class="btn btn-base-2">查看详情</a>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        <#--</section>-->
    <#--<!-- 云管家 EMonitor  增值服务 end &ndash;&gt;-->
    <#--<!-- 典型应用 &ndash;&gt;-->
    <#--<#include "layouts/footer.ftl">-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--<div class="loading"></div>-->
<#--<div class="official_cnt">-->
    <#--<div class="official_close"></div>-->
    <#--<img src="<@spring.url '/public/static/assets/images/wx.jpg'/>" alt="">-->
<#--</div>-->
<#--<div class="qqmodule_cnt">-->
    <#--<div class="official_close"></div>-->
    <#--<img src="<@spring.url '/public/static/assets/images/qqcode.jpg'/>" alt="">-->
<#--</div>-->
<#--<a href="#" id="toTop">To Top</a>-->

<#--<script src="<@spring.url '/public/static/components/cubeportfolio/js/jquery.cubeportfolio.min.js' />"></script>-->
<#--<script src="<@spring.url '/public/static/components/cubeportfolio/js/jquery.cubeportfolio-4b.js' />"></script>-->
<#--<script src="<@spring.url '/public/static/components/js/classie.js' />"></script>-->
<#--<script src="<@spring.url '/public/static/components/js/scrollTop.js' />"></script>-->
<#--<script src="<@spring.url '/public/static/components/js/sidebar-transitions/sidebar-transitions.js' />"></script>-->
<#--<script src="<@spring.url '/public/static/components/layer/layer.js' />"></script>-->
<#--<script type="text/javascript" src="<@spring.url '/public/javascripts/plug.js' />"></script>-->
<#--<script type="text/javascript" src="<@spring.url '/public/javascripts/userManage/userManage.js'/>"></script>-->
<#--<script type="text/javascript" src="<@spring.url '/public/javascripts/md5.js' />"></script>-->
<#--<script type="text/javascript">-->
    <#--$(function(){-->
        <#--$('#home_slider').flexslider({-->
            <#--animation : 'slide',-->
            <#--controlNav : true,-->
            <#--directionNav : true,-->
            <#--animationLoop : true,-->
            <#--slideshow : true,-->
            <#--useCSS : false-->
        <#--});-->
        <#--//验证用户名-->
        <#--$("#inputEmail").blur(function(){-->
            <#--var value = $("#inputEmail").val();-->
            <#--$("#mobilePhone_empty").attr("style","display: none");-->
            <#--$("#mobilePhone_validate").attr("style","display: none");-->
            <#--var flag=saascommunity.userManage.isEmpty(value);-->
            <#--if(flag){-->
                <#--$("#inputEmail").parent().addClass("has_error");-->
                <#--$("#mobilePhone_empty").attr("style","display: block");-->
            <#--}-->
<#--//           else{-->
<#--//                $("#inputEmail").parent().removeClass("has_error");-->
<#--//                $("#mobilePhone_empty").attr("style","display: none");-->
<#--//                var formFlag=saascommunity.userManage.mobilePhone(value);-->
<#--//                if(!formFlag){-->
<#--//                    $("#inputEmail").parent().addClass("has_error");-->
<#--//                    $("#mobilePhone_validate").attr("style","display: block");-->
<#--//                }else{-->
<#--//                    $("#inputEmail").parent().removeClass("has_error");-->
<#--//                    $("#mobilePhone_validate").attr("style","display: none");-->
<#--//                }-->
<#--//            }-->
        <#--});-->
        <#--//验证密码-->
        <#--$("#inputPassword").blur(function(){-->
            <#--var value = $("#inputPassword").val();-->
            <#--$("#password_empty").attr("style","display: none");-->
            <#--$("#password_validate").attr("style","display: none");-->
            <#--var flag=saascommunity.userManage.isEmpty(value);-->
            <#--if(flag){-->
                <#--$("#inputPassword").parent().addClass("has_error");-->
                <#--$("#password_empty").attr("style","display: block");-->
            <#--}else{-->
                <#--$("#inputPassword").parent().removeClass("has_error");-->
                <#--$("#password_empty").attr("style","display: none");-->
            <#--}-->
        <#--});-->

        <#--$(".nav").on("click",".login",function(){//登录-->
            <#--$(".nav-justified li").removeClass("active");-->
            <#--$(".nav-justified li:first-child").addClass("active");-->
            <#--$(".tab-content .tab-pane").removeClass("active");-->
            <#--$(".tab-content .tab-pane:first-child").addClass("active");-->
        <#--});-->

        <#--$(".submit_login").on("click",function(){//登录成功后头部展示用户详细信息，这边只是看效果的列子-->
            <#--saascommunity.userManage.doLogin();-->
        <#--});-->
        <#--if(location.search.indexOf('auto')!=-1){-->
            <#--$(".login").click();-->
        <#--}-->
        <#--if(window.location.pathname.indexOf('gateway') == -1){-->
            <#--location.href=saascommunity.App.formatUrl("gateway");-->
        <#--}-->

        <#--$("#mobilePhone").focus(function(){-->
            <#--saascommunity.userManage.mobilePhoneFocus();-->
        <#--});-->

            <#--$(window).keydown(function (event) {-->
                <#--if($(".user-name").text().length <1 && (!saascommunity.userManage.isEmpty($("#mdlUserAccount").attr("style")) || $("#mdlUserAccount").attr("style")=="display: none;")) {-->
                    <#--saascommunity.userManage.onkeydownSubmit(event.keyCode, "login");-->
                <#--}-->
            <#--});-->
        <#--$(".official_wx").on("click",function(){//加载微信详情页-->
            <#--$("body").addClass("weixin_load");-->
        <#--});-->

        <#--$(".official_cnt").on("click",".official_close",function(){//关闭微信详情页-->
            <#--$("body").removeClass("weixin_load");-->
        <#--});-->
        <#--$(".official_qq").on("click",function(){//加载qq详情页-->
            <#--$("body").addClass("qq_load");-->
        <#--});-->

        <#--$(".qqmodule_cnt").on("click",".official_close",function(){//关闭微信详情页-->
            <#--$("body").removeClass("qq_load");-->
        <#--});-->
    <#--});-->
<#--</script>-->
</body>
</html>