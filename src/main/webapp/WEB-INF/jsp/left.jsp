<%--
  Created by IntelliJ IDEA.
  User: ckzippo
  Date: 9/5/16
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>left</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/matrix/bootstrap.min.css" />
    <link rel="stylesheet" href="css/matrix/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="css/matrix/matrix-style.css" />
    <link rel="stylesheet" href="css/matrix/matrix-media.css" />
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>
<!--sidebar-menu-->
<div id="sidebar"> <a href="#" class="visible-phone"><i class="icon icon-fullscreen"></i>Full width</a>
    <ul>
        <li class="submenu"> <a href="#"><i class="icon icon-user"></i> <span>个人管理</span></a>
            <ul>
                <li><a href="qryUser">查找用户</a></li>
                <li><a href="qryDept.jsp">增加用户</a></li>
                <li><a href="#">删除用户</a></li>
            </ul>
        </li>

        <li class="submenu"> <a href="#"><i class="icon icon-group"></i><span>群管理</span></a>
            <ul>
                <li><a href="#">查找群</a></li>
                <li><a href="#">修改群</a></li>
                <li><a href="#">增加群</a></li>
                <li><a href="#">删除群</a></li>
                <li><a href="#">查看群成员</a></li>
                <li><a href="#">修改群成员</a></li>
                <li><a href="#">增加群成员</a></li>
                <li><a href="#">删除群成员</a></li>
            </ul>
        </li>

        <li class="submenu"> <a href="#"><i class="icon icon-group"></i><span>讨论组管理</span></a>
            <ul>
                <li><a href="#">查找讨论组</a></li>
                <li><a href="#">修改讨论组</a></li>
                <li><a href="#">增加讨论组</a></li>
                <li><a href="#">删除讨论组</a></li>
                <li><a href="#">查看讨论组成员</a></li>
                <li><a href="#">修改讨论组成员</a></li>
                <li><a href="#">增加讨论组成员</a></li>
                <li><a href="#">删除讨论组成员</a></li>
            </ul>
        </li>

        <li class="submenu"> <a href="#"><i class="icon icon-bell"></i><span>组织架构管理</span></a>
            <ul>
                <li><a href="#">查找组织架构</a></li>
                <li><a href="#">修改组织架构</a></li>
                <li><a href="#">增加组织架构</a></li>
                <li><a href="#">删除组织架构</a></li>
                <li><a href="#">查看组织架构成员</a></li>
                <li><a href="#">增加组织架构成员</a></li>
                <li><a href="#">删除组织架构成员</a></li>
                <li><a href="#">调整组织架构成员</a></li>
            </ul>
        </li>
    </ul>
</div>
<!--sidebar-menu-->


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/matrix.js"></script>
<script src="js/jquery.uniform.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/matrix.tables.js"></script>

<ul class="typeahead dropdown-menu"></ul>

</body>
</html>
