<%@ page import="model.ActionEnum" %>
<%@ page import="model.User" %>
<%@ page import="java.util.ArrayList" %>

<%--
  Created by IntelliJ IDEA.
  User: ckzippo
  Date: 9/5/16
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询用户</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/matrix/bootstrap.min.css" />
    <link rel="stylesheet" href="css/matrix/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="css/matrix/matrix-style.css" />
    <link rel="stylesheet" href="css/matrix/matrix-media.css" />
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>

    <%--修改用户、重置密码、增加建群权限的JS代码--%>
    <script language="JavaScript" type="text/javascript">

        // 修改用户
        function modifyUser() {
            var x = document.getElementsByName("id");
            var t = 0;
            for (var i = 0; i < x.length; i++) {
                if (x[i].checked == true) {
                    t = 1;
                    break;
                }
            }

            if (t == 1) {
                showUser.action = "/modUser?flag=show";
                showUser.submit();
            } else {
                alert("请选择一个用户");
            }
        }

        // 增加建群权限
        function addCreateGroupAutority() {
            var x = document.getElementsByName("id");
            var t = 0;
            for (var i = 0; i < x.length; i++) {
                if (x[i].checked == true) {
                    t = 1;
                    break;
                }
            }

            if (t == 1) {
                showUser.action = "/addCreateGroupAuthority";
                showUser.submit();
            } else {
                alert("请选择一个用户");
            }
        }

        /**
         * 重置密码
         */
        function resetPassword() {
            var x = document.getElementsByName("id");
            var t = 0;
            for (var i = 0; i < x.length; i++) {
                if (x[i].checked == true) {
                    t = 1;
                    break;
                }
            }

            if (t == 1) {
                showUser.action = "/resetPassword";
                showUser.submit();
            } else {
                alert("请选择一个用户");
            }
        }


    </script>
</head>
<body>
<%--header--%>
<%@include file="header.jsp"%>

<%--left subbar--%>
<%@include file="left.jsp"%>

<%--main content--%>
<div id="content" >
    <div id="content-header">
        <div id="breadcrumb">
            <a class="tip-bottom" data-original-title="主页" href="#">
                <i class="icon-home"></i>
                主页
            </a>
            <a class="current">
                查询用户
            </a>
        </div>
        <h1>查询用户</h1>
    </div>

    <hr>

    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span4">
                <form action="qryUser">
                    <input type="text" style="height: 30px" name="keyword"><br>
                    <button class="btn btn-success">查询用户</button>
                </form>
                <br>
                <hr>
                <p>
                <ol>
                    <li>输入用户名、账号、手机号、邮箱关键字进行搜索</li>
                    <li>关键字尽量输入长一点,以免结果太多,反应慢</li>
                    <li>增加建群权限将使得选中的用户具有建群权限</li>
                    <li>重置密码功能只能对非OA用户使用。<br>密码重置后,密码跟账号一致</li>
                </ol>
                </p>
            </div>

            <jsp:useBean id="qryresult" class="model.User" scope="page"/>
            <%
               ArrayList<User> resultList =
                       (ArrayList<User>) request.getSession().getAttribute(ActionEnum.QRYUSER.getActionName());
                if (resultList != null) {
            %>
            <form id="showUser" name="showUser" method="post">
                <div class="span8">
                    <%--<table class="table table-bordered table-striped with-check">--%>
                    <table class="table table-bordered table-hover data-table">
                        <thead>
                        <tr>
                            <th><i class="icon-resize-vertical"></i></th>
                            <th>用户姓名</th>
                            <th>登录账号</th>
                            <th>用户ID</th>
                            <th>手机号</th>
                            <th>部门</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (User user : resultList) {
                        %>
                        <tr>
                            <td><input type="radio" id="id" name="id" value="<%=user.getUserid()%>"></td>
                            <td><%=user.getUsername()%></td>
                            <td><%=user.getUseracc()%></td>
                            <td><%=user.getUserid()%></td>
                            <td><%=user.getMobilephone()%></td>
                            <td><%=user.getDeptname()%></td>
                            <td style="display: none"><input type="hidden" name="acc" value="<%=user.getUseracc()%>"></td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                    <div align="right">
                        <a href="#" onclick="modifyUser()">
                            <button class="btn btn-success">修改用户</button>
                        </a>
                        <a href="#" onclick="addCreateGroupAutority()">
                            <button class="btn btn-info">增加建群权限</button>
                        </a>
                        <a href="#" onclick="resetPassword()">
                            <button class="btn btn-warning">重置密码</button>
                        </a>
                        <%--TODO:删除用户需谨慎,特定权限的管理员才能删除用户--%>
                        <a href="#" onclick="">
                            <button class="btn btn-danger">删除用户</button>
                        </a>
                    </div>
                </div>
            </form>
            <%
                }
            %>
        </div>

    </div>
</div>

<%@include file="footer.jsp"%>

<%--去除session--%>
<%--<%--%>
<%--request.getSession().removeAttribute(ActionEnum.QRYUSER.toString());--%>
<%--%>--%>
</body>
</html>
