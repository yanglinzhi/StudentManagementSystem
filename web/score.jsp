<%--
  Created by IntelliJ IDEA.
  @author: ylz
  @Date: 2022/7/15
  @Time: 20:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分数</title>
    <style>
        #head_{
            height: 100px;
            width: 100%;
            background-color: slategray;
        }
        #personFile{
            width: 120px;
            height: 50px;
            padding-top: 25px;
            margin-left: 90%;
        }
        #table{
            margin-left: 25%;
            margin-top: 30px;
        }
        td {
            text-align: center;
            height: 20px;
            width: 150px;
            border: black 1px solid;
            padding: 1px;
        }
    </style>
    <script>
        function goBack(id) {
            window.location.href="goBack?id="+id;
        }
    </script>
</head>
<body>
<div id="head_">
    <div id="personFile">
        名字:<span style="color: red">${user.getU_name()}</span><br>
        编号:<span style="color: red">${user.getU_id()}</span>
    </div>
</div>
学生id:${student.getU_id()}
学生名字:${student.getU_name()}
<div>
    <table id="table" style="height: 30px;width: 700px;border: black 1px solid;border-collapse:collapse;">

        <tr >
            <td>课程id</td>
            <td>课程名字</td>
            <td>课程教师</td>
            <td>成绩</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${arrStudent}" var="item">
            <tr>
                <td>${item.getCourseId()}</td>
                <td>${item.getCourseName()}</td>
                <td>${item.getCourseTeacherName()}</td>
                <td>${item.getCourseScore()}</td>
                <td><button>修改成绩</button></td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="goBack(${user.getU_id()})">返回</button>
</div>
</body>
</html>
