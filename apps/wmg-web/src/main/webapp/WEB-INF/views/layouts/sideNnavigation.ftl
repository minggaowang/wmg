
<aside class="side-navigation-wrap sidebar-fixed">
    <div class="sidenav-inner">
        <ul class="side-nav magic-nav" >
            <li class="has-submenu" id="information">
                <a id="aInformation" href="<@spring.url '/userInfo/toInformation'/>" class="animsition-link"><i class="fa fa-gear"></i><span class="nav-text"> 基本信息</span></a>
            </li>
            <li class="has-submenu" id="modifyPassword">
                <a id="amodifyPassword" href="<@spring.url '/userInfo/toModifyPassword'/>" class="animsition-link"><i class="fa fa-lock"></i><span class="nav-text"> 修改密码</span></a>
            </li>
            <li class="has-submenu" id="loginAccredit">
                <a id="aloginAccredit" href="<@spring.url '/loginAccredit/index'/>" class="animsition-link"><i class="fa fa-unlock-alt"></i><span class="nav-text"> 注册授权</span></a>
            </li>
            <li class="has-submenu" id="systemUpdate">
                <a id="asystemUpdate" href="<@spring.url '/systemUpdate/index'/>" class="animsition-link"><i class="fa fa-external-link-square"></i><span class="nav-text"> 产品升级</span></a>
            </li>
            <li class="has-submenu" id="question">
                <a href="#submenu1" data-toggle="collapse" aria-expanded="false">
                    <i class="fa fa-question-circle"></i> <span class="nav-text">问题管理</span>
                </a>
                <div class="sub-menu collapse secondary list-style-circle" id="submenu1">
                    <ul>
                        <li id="myQuestion"><a id="myQuestionhref" href="<@spring.url '/workorder/myQuestion'/>" class="animsition-link">我的问题</a></li>
                        <li id="submitQuestion" class="active"><a id="submitQuestionhref" href="<@spring.url '/workorder/submitQuestion'/>" class="animsition-link">提交问题</a></li>
                    </ul>
                </div>
            </li>
            <li class="has-submenu" id="knowledge">
                <a href="#submenu2" data-toggle="collapse" aria-expanded="false">
                    <i class="fa fa-book"></i> <span class="nav-text">在线知识库</span>
                </a>
                <div class="sub-menu collapse secondary list-style-circle" id="submenu2">
                    <ul>
                        <li id="lmonitorList"><a id="amonitorList" href="<@spring.url '/knowledge/toMonitorList'/>" class="animsition-link">监控清单</a></li>
                        <li id="lconfiguration"><a id="aconfiguration" href="<@spring.url '/knowledge/toConfiguration'/>" class="animsition-link">配置手册</a></li>
                    </ul>
                </div>
            </li>
        </ul>
    </div>
</aside>
<!-- 左侧导航 end-->




