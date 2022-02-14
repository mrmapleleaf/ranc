<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
          <link rel="stylesheet" type="text/css" href="/random_account_name_creater-0.0.1-SNAPSHOT/css/ranc.css">
        <title>アカウント名つけるくん</title>
    </head>
    <body>
        <div id="mainContent2">
            <p>あなたのアカウント名は今日から<span class="accountName">「<c:out value="${accountName}"/></span>」です。<br>
            良いSNSライフを！</p>
            <form action="./" method="post">
            <input type="submit" value="戻る">
            </form>

            <footer>
                by Mr.MapleLeaf
            </footer>
        </div>
    </body>
</html>