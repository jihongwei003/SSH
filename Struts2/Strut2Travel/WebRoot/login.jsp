<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head><title>登录界面</title></head>
  <body>
  
  <script type="text/javascript">
	function register(){
		var form = document.forms[0];
		form.action = "registerAction"
		form.submit();
	}
  </script>
  
    <form method="post" action="loginAction">
       用户名：<input name="username"><br>
       密    码：<input type="password" name="userpass"><br>
      <input type="submit" name="button" id="button" value="提 交">
      <input type="submit" name="button2" id="button2" value="注 册" onclick=register();>
      <input type="reset"  name="password" name="password" value="取 消">
    </form>
    
  </body>
</html>