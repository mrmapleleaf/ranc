<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="/target/random_account_name_creater-0.0.1-SNAPSHOT/css/ranc.css">
        <title>アカウント名つけるくん</title>
    </head>
    <body>
    <div id="header">
        <img class="logo" alt="ロゴ" src="./target/random_account_name_creater-0.0.1-SNAPSHOT/images/titleLogo.png">
        <h1>アカウント名つけるくん</h1>
        <span id="beta">β版</span>
    </div>
    <div id="mainContent1">
        <p>こんにちは！このサービスは入力された内容からSNSなどで使うアカウント名をテキトーに作ってくれるサービスです。<br>
        下記の内容を入力してください。全ての項目は必須入力となります。</p>

        <c:if test="${errorList != null}">
            <div class="errorMsg">
                <span class="errorTitle">入力内容エラー</span>
                <c:forEach var="error" items="${errorList}">
                   ● <c:out value="${error}"></c:out><br>
                </c:forEach>
            </div>
        </c:if>

        <div class="form">
        <form action="./Result" method="post">
            <h3>入力内容</h3>
            <div class="lastName">
                姓<span class="annotation">※ローマ字で入力</span><br><input type="text" name="lastName" size="40" value="${AccountInfo.firstName}"/><br>
            </div>
            <div class="firstName">
                名<span class="annotation">※ローマ字で入力</span><br><input type="text" name="firstName" size="40" value="${AccountInfo.lastName}"/><br>
            </div>
            <div class="birthDate">
                生年月日<br><input type="date" name="birthDate" value="${AccountInfo.birthDate}"/><br>
            </div>
            <div class="button">
                <button type="submit">アカウント名作成！</button>
            </div>
        </form>
        </div>
    </div>
    <footer>
        by Mr.MapleLeaf
    </footer>
    </body>
</html>