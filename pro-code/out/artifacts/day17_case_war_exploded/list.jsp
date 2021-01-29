<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 导入jstl标签库-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script >

        function deleteUser() {
            alert(132);

/*            if (confirm("您确定要删除吗？")) {
                location.href = "${pageContext.request.contextPath}/deleteUserServlet?id=" + id
            }*/

        }

        window.onload = function () {
            var elementById = document.getElementById("selectdeid");
            var c = document.getElementsByName("uid");
            elementById.onclick = function () {
                var flag = false;
                for (var i = 0; i < c.length; i++) {
                    if (c[i].checked) {
                        if (confirm("是否删除选中用户？")) {
                            //有一个条目选中了
                            flag = true;
                            break;
                        }
                        if (flag) {
                            document.getElementById("form").submit();
                        }
                    }
                }
            }
        }
        var elementById1 = document.getElementById("firstCb");
        elementById1.onclick = function () {
            for (var i = 0; i < c.length; i++) {
                c[i].checked = this.checked;
            }
        }
        }

    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left;margin: 5px">
        <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text"  name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" name="address" value="${condition.address[0]}" class="form-control" id="exampleInputName3">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" name="email" value="${condition.email[0]}" class="form-control" id="exampleInputEmail2">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="margin:5px;float: right">
<%--        <a class="btn btn-primary" href="${pageContext.request.contextPath}/" id="selectdeid">删除选中</a>--%>
        <a class="btn btn-primary" href="javascript:void(0)" id="selectdeid">删除选中</a>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
    </div>
    <form id="form" action="${pageContext.request.contextPath}/delSelecteIdServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pageBean.list}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="uid" value="${user.id}"></td>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" <%--href="javascript:;" onclick="deleteUser()"--%>
                           href="javascript:if (confirm('您确定要删除吗？')) {
                        location.href = '${pageContext.request.contextPath}/deleteUserServlet?id=${user.id}'
                        };"
                          >删除</a>
                    </td>
                </tr>
            </c:forEach>
<%--            <c:forEach items="${users}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="uid" value="${user.id}"></td>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id})">删除</a></td>
                </tr>
            </c:forEach>--%>
        </table>
    </form>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                <li class="disabled">
                    <c:if test="${pageBean.currentPage<=1}">
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                </li>
                <li>
                    <c:if test="${pageBean.currentPage>1}">
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?rows=${pageBean.rows}&currentPage=${pageBean.currentPage-1}&name=${condition.name[0]}&address=${condition.address[0]}&eamil=${condition.eamil[0]}"
                           aria-label="Previous">
                                <%--                            <a href="#" aria-label="Previous">--%>
                            <span aria-hidden="true">&laquo;</span>
                        </a>

                    </c:if>
                </li>
                </li>
                <li>
                    <c:forEach begin="1" step="1" end="${requestScope.pageBean.totalPage}" varStatus="s">
                    <c:if test="${s.count==pageBean.currentPage}">
                <li class="active">
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?rows=${pageBean.rows}&currentPage=${s.count}&name=${condition.name[0]}&address=${condition.address[0]}&eamil=${condition.eamil[0]}">${s.count}</a>
                </li>
                </c:if>
                <c:if test="${s.count!=pageBean.currentPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?rows=${pageBean.rows}&currentPage=${s.count}&name=${condition.name[0]}&address=${condition.address[0]}&eamil=${condition.eamil[0]}">${s.count}</a>
                    </li>
                </c:if>
                </c:forEach>
                </li>
                <li class="disabled">
                    <c:if test="${pageBean.currentPage>=pageBean.totalPage}">

                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                </li>
                <li>
                    <c:if test="${pageBean.currentPage<pageBean.totalPage}">
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?rows=${pageBean.rows}&currentPage=${pageBean.currentPage+1}&name=${condition.name[0]}&address=${condition.address[0]}&eamil=${condition.eamil[0]}"
                           aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                </li>
                <span style="margin: 5px;font-size:25px">
                    共${pageBean.totalCounts}条记录，共${pageBean.totalPage}页
                </span>
            </ul>
        </nav>

    </div>
</div>
</body>
</html>