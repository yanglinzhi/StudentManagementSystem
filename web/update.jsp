<%--
  Created by IntelliJ IDEA.
  @author: ylz
  @Date: 2022/7/16
  @Time: 8:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
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
        .Info{
            display: none;
        }
    </style>
</head>
<body onload="pswInfo()">
<div id="head_">
    <div id="personFile">
        名字:<span style="color: red">${user.getU_name()}</span><br>
        编号:<span style="color: red">${user.getU_id()}</span>
    </div>
</div>
学生id:${student.getU_id()}
学生名字:${student.getU_name()}
    <div id="update">
        <form action="/StudentManagementSystem/update" id="updatePsw" method="post" onsubmit="return psw()">
            <input class="Info" name="uId" type="text" value="${user.getU_id()}">
            <input class="Info" name="sName" type="text" value="${student.getU_name()}">
            <input class="Info" name="sId" type="text" value="${student.getU_id()}">
            <input class="Info"  id="message" name="message" type="text" value="${message}">
            旧密码:<input type="password" id="oldPsw" name="oldPsw">
            新密码:<input type="password" id="newPsw" name="newPsw">
            确认密码:<input type="password"  id="confirmPsw" name="confirmPsw"><span id="error" style="color: red"></span>
            <input type="submit" value="提交">
        </form>
    </div>
    <script>
        function psw() {
            let newPsw = document.getElementById("newPsw").value;
            let confirmPsw = document.getElementById("confirmPsw").value;
            if (newPsw == confirmPsw){
                return true;
            }else{
                document.getElementById("error").innerHTML="*与新密码不一致";
                return false;
            }
        }
        function pswInfo() {
            let message=document.getElementById("message").value;
            if(message!="none"){
                alert(message)
            }
        }
    </script>
</body>
</html>
