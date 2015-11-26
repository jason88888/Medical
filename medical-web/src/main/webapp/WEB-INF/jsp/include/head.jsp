<link href="${basePath}assets/js/lib/dwz-ria/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${basePath}assets/js/lib/dwz-ria/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${basePath}assets/js/lib/dwz-ria/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="${basePath}assets/js/lib/dwz-ria/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>

<script src="${basePath}assets/js/lib/dwz-ria/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="${basePath}assets/js/lib/dwz-ria/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${basePath}assets/js/lib/dwz-ria/js/jquery.validate.js" type="text/javascript"></script>
<script src="${basePath}assets/js/lib/dwz-ria/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${basePath}assets/js/lib/dwz-ria/xheditor/xheditor-1.1.14-zh-cn.min.js" type="text/javascript"></script>
<script src="${basePath}assets/js/lib/dwz-ria/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

<script src="${basePath}assets/js/lib/dwz-ria/bin/dwz.min.js" type="text/javascript"></script>
<script src="${basePath}assets/js/lib/dwz-ria/js/dwz.regional.zh.js" type="text/javascript"></script>


<script type="text/javascript">
    $(function(){
        DWZ.init("${basePath}assets/js/lib/dwz-ria/dwz.frag.xml", {
            <%--loginUrl:"${basePath}assets/js/lib/dwz-ria/login_dialog.html", loginTitle:"登录",  // 弹出登录对话框--%>
            loginUrl:"login",
            statusCode:{ok:200, error:300, timeout:301}, //【可选】
            pageInfo:{pageNum:"currentPage", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
            debug:true, // 调试模式 【true|false】
            callback:function(){
                initEnv();
                $("#themeList").theme({themeBase:"${basePath}assets/js/lib/dwz-ria/themes"}); // themeBase 相对于index页面的主题base路径
            }
        });
    });

</script>