<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <title>社区医院居民健康监测管理系统设计与实现</title>
    <script type="text/javascript" src="assets/js/jquery-1.6.js"></script>
    <script type="text/javascript">
$(function(){ 
    var xx=$('#relname').text();
     if (xx=="") {
		alert("您当前未登录，请登录!");
		window.location.href="http://localhost:8080/his";
	} 
});
</script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="assets/js/bui.js"></script>
<script type="text/javascript" src="assets/js/common/main-min.js"></script>
<script type="text/javascript" src="assets/js/config-min.js"></script>

</head>

<body>

<div class="header" style="height:60px;">

    <div class="dl-title" >
        <img src="./assets/img/logo.png">
    </div>
	
    <div class="dl-log">欢迎您，<span class="dl-log-user" id="relname">${rname}</span>
	
	<a href="http://localhost:8080/his" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected">
            <div class="nav-item-inner nav-home">welcome</div></li>

		</ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">
    </ul>
</div>

<script>
    BUI.use('common/main',function(){
        var config = [
			{id:'1',menu:[
				
		{text:'功能列表',items:[
		
		{id:'2',text:'挂号信息管理',href:'RegisterAction?action=FindRegPage&uid=${userid}'},
		{id:'3',text:'门诊医生管理',href:'DoctorAction?action=FindDoctorPage&uid=${userid}'},
		{id:'4',text:'药品管理',href:'DrugAction?action=FindDrugPage&uid=${userid}'},
		{id:'5',text:'住院办理',href:'HospitalAction?action=FindHosPage&uid=${userid}'},
		{id:'6',text:'收费项目登记',href:'FeeAction?action=FindFeePage&uid=${userid}'},
		{id:'7',text:'在院发药',href:'DispAction?action=FindDispPage&uid=${userid}'},
		{id:'8',text:'住院结算',href:'hospital/account.html'},
		//{id:'9',text:'月营业额统计',href:''},
		//{id:'10',text:'年营业额统计',href:''},	
		{id:'11',text:'用户管理',href:'UserAction?action=FindUserPage&uid=${userid}'},
		{id:'12',text:'角色管理',href:'RoleAction?action=FindRolePage&uid=${userid}'},
		//{id:'13',text:'资源管理',href:'ResourcesAction?action=FindResPage&uid=${userid}'},
		//{id:'14',text:'密码设置',href:'Resource/index.html'},
		{id:'15',text:'血氧信息统计',href:'bloodpressure/index.html'},
		{id:'16',text:'血压信息统计',href:'oxygen/index.html'},
		//{id:'17',text:'脉搏信息统计',href:'pulse/index.html'},
		
		{id:'18',text:'血氧血压监测数据',href:'sensor/index.html'},
		{id:'19',text:'脉搏监测数据',href:'pulse/index.html'},
		{id:'20',text:'健康状况统计',href:'tongji/index.html'},
		{id:'21',text:'公告栏',href:'notice/index.html'},
		{id:'22',text:'交流沟通',href:'bbs/bbs.html'},
		]}
		]}
		
		];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>

</body>
</html>
