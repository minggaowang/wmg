
<div class="header header-affix" data-offset-top="80" data-nav-animation="slideInDown" id="header">
    <!-- 导航nav start -->
    <nav class="navbar navbar-main navbar-main-inverse navbar-shadow" style="height: 84px" role="navigation" id="slide-nav">
        <div class="container relative">
            <div class="navbar-header">
                <!-- LOGO -->
                <#--<a class="navbar-logo" href="<@spring.url '/gateway'/>">-->
                    <#--<img id="logoOne" src="<@spring.url '/public/static/assets/images/logo-2-a.png'/>">-->
                    <#--<img id="logoTwo" src="<@spring.url '/public/static/assets/images/logo-2-a.png'/>" class="hide">-->
                <#--</a>-->
                <!-- NAVBAR TOGGLE -->
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- 登录入口 -->
                <button type="button" class="navbar-icon-btn css-animate" data-target="#sctGlobalSearch">
                    <i class="fa fa-search"></i>
                </button>
            </div>
            <div id="slidemenu">
                <ul class="nav navbar-nav ml-20" data-hover="dropdown" data-animations="zoomIn fadeInDown fadeInRight fadeInLeft">
                    <!-- Navbar links -->
                    <li class="dropdown">
                        <#--<a href="<@spring.url '/userInfo/comeSoon'/>" class="dropdown-toggle" data-toggle="dropdown">-->
                            <#--<span>产品</span>-->
                        <#--</a>-->
                        <ul class="dropdown-menu">
                            <li class="">
                                <#--<a tabindex="-1" href="<@spring.url '/userInfo/emoniorDetail'/>">监控管家</a>-->
                            </li>
                        </ul>
                    </li>
                    <li>
                        <#--<a href="<@spring.url '/userInfo/toApplyTrial'/>">-->
                            <#--<span>申请使用</span>-->
                        <#--</a>-->
                    </li>
                    <li>
                        <#--<a href="<@spring.url '/userInfo/comeSoon'/>">-->
                            <#--<span>套餐介绍</span>-->
                        <#--</a>-->
                    </li>
                    <li class="dropdown">
                        <#--<a href="<@spring.url '/userInfo/comeSoon'/>" class="dropdown-toggle" data-toggle="dropdown">-->
                            <#--<span>资源</span>-->
                        <#--</a>-->
                        <#--<ul class="dropdown-menu">-->
                            <#--<li class="">-->
                                <#--<a tabindex="-1" href="<@spring.url '/userInfo/infoDownload'/>">资料下载</a>-->
                            <#--</li>-->
                            <#--<li class="">-->
                                <#--<a tabindex="-1"  href="<@spring.url '/userInfo/video'/>" >相关视频</a>-->
                            <#--</li>-->
                        <#--</ul>-->
                    </li>
                    <li class="dropdown">
                        <#--<a href="<@spring.url '/userInfo/comeSoon'/>" class="dropdown-toggle" data-toggle="dropdown">-->
                            <#--<span>关于我们</span>-->
                        <#--</a>-->
                        <#--<ul class="dropdown-menu">-->
                            <#--<li class="">-->
                                <#--<a tabindex="-1" href="javascript:;" class="official_wx">官方微信</a>-->
                            <#--</li>-->
                            <#--<li class="">-->
                                <#--<a tabindex="-1" href="http://www.weibo.com/p/1006066154278876/home?from=page_100606&mod=TAB&is_hot=1#place" target="_blank">官方微博</a>-->
                            <#--</li>-->
                        <#--</ul>-->
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                <#if LOGIN_USER ??>
                    <!-- 登录以后的状态 -->
                    <li class="user-profile dropdown">
                        <a href="#" class="clearfix dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                            <img src="<@spring.url '/public/static/assets/images/profile.jpg'/>" alt="" class="hidden-sm">
                            <div class="user-name" style="text-transform: none">${LOGIN_USER?if_exists}<span class="caret m-l-5"></span></div>
                        </a>
                        <ul class="dropdown-menu dropdown-animated pop-effect closed" role="menu">
                            <li><a href="<@spring.url '/userInfo/toInformation?agent=RXKJ001'/>">基本信息</a></li>
                            <li><a href="<@spring.url '/userInfo/toModifyPassword?agent=RXKJ001'/>">修改密码</a></li>
                            <li><a href="<@spring.url '/loginAccredit/index?agent=RXKJ001'/>">注册授权</a></li>
                            <li><a href="<@spring.url '/systemUpdate/index?agent=RXKJ001'/>">产品升级</a></li>
                            <li><a href="<@spring.url '/workorder/myQuestion?agent=RXKJ001'/>">我的问题</a></li>
                            <li><a href="<@spring.url '/workorder/submitQuestion?agent=RXKJ001'/>">提交问题</a></li>
                            <li><a href="<@spring.url '/knowledge/toMonitorList?agent=RXKJ001'/>">在线知识库</a></li>
                            <li><a href="javascript:saascommunity.userManage.doLogoutDls();">退出</a></li>
                        </ul>
                    </li>
                <#else>
                    <li class="dropdown-icon hidden-xs hidden-sm" id="login_other">
                    </li>
                </#if>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="nav_cntbox" id="navcntbox" style="height: 0px"></div>
<script type="text/javascript">
    $(function(){
        if (!window.saascommunity) {
            saascommunity = {}
        }
        saascommunity.App = {
            formatUrl: function (url) {
                return "<@spring.url '/' />" + url;
            }
        };
        if($(".user-name").text().length>1){
            $(".navbar-right").addClass("on");
            $("#mdlUserAccount").removeClass("in");
            $("body").removeClass("modal-open");
            $("body").css("padding-right","0px");
            $(".fade").css("display","none");
        }
        if(document.title=="门户"){
            $("#login_other").empty().append(" <a href='#' data-toggle='modal' data-target='#mdlUserAccount' class='login'><span><i class='fa fa-user'></i>登录</span></a>");
        }else{
            $("#login_other").empty().append(" <a id='loginButton' href='javascript:saascommunity.userManage.loginButtonDls();' class='login'><span><i class='fa fa-user'></i>登录</span></a>");
        }


    });
</script>




