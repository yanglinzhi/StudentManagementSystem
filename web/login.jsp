<%--
  Created by IntelliJ IDEA.
  @author: ylz
  @Date: 2022/7/12
  @Time: 14:32
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
  <style>
    #frame{
      /*width: 200px;*/
      /*height: 140px;*/
      margin:0 auto;
      background-color: azure;
      border: black solid 2px;
    }
    #inner{
      margin:0 auto;

    }
  </style>
  <%--
      写入js代码 对数据进行验证
        用户id是否为空
          先校验标签里的值 判断是否为空
          为空，返回，提示用户id不能为空
        密码是否为空
          先校验标签里的值 判断是否为空
          为空返回用户密码不能为空
  --%>
  <script>
      function validation() {
        //1.获取id查看是否为空
          let id_str = document.getElementById("u_id").value;
          let pwd_str = document.getElementById("u_pwd").value;
          if(id_str==null||id_str==""){
            document.getElementById("error").innerHTML="*账户不能为空"
            return  false;
          }else if(pwd_str==null||pwd_str==""){
            document.getElementById("error01").innerHTML="*密码不能为空"
            return false;
          }else{
            return true;
          }
      }


  </script>
</head>
<body>
  <div id="frame">
    <div id="inner">
      <form action="/StudentManagementSystem/login" method="post" onsubmit="return validation()">
        用户id:<input type="text" id="u_id" name="u_id"><span id="error" style="color: red"></span><br>
        密码:<input type="password" id="u_pwd" name="u_pwd"><span id="error01" style="color: red"></span><br>
        <input type="submit" value="登录" id="btn01"><input type="reset" style="margin-left: 20px" id="btn02" value="重置">
        <span id="error02" style="color: red">${error}</span>
      </form>
    </div>
  </div>

</body>
</html>
