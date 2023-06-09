<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 정보</title>
</head>
<body>
    <table>
        <tr>
            <th>번호</th>
            <td>${board.bno}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>${board.title}</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><textarea rows="3" cols="2" style="width:100px;" readonly>${board.contents}</textarea></td>
        </tr>
        <tr>
            <th>내용</th>
            <td>${board.contents}</td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <!-- not empty = 객체의 값 체크 -->
            <c:choose>
            <c:when test="${not empty board.image}">
            <td><img src="<c:url value="/resources/image/${board.image}"/>"/></td>
        	</c:when>
        	<c:otherwise>
        	<td>파일없음</td>
        	</c:otherwise>
        	</c:choose>
        </tr>
            <!-- 경로를 자동으로 contextPath지정해준다. -->
        <tr>
            <th>작성일자</th>
            <td><fmt:formatDate value="${board.regdate}" pattern="yyyy/MM/dd" /></td>
        </tr>
    </table>
    <button type="button" 
    onclick="location.href='boardUpdate?bno=${board.bno}'">수정</button>
    <button type="button" 
    onclick="location.href='boardDelete?bno=${board.bno}'">삭제</button>
</body>
</html>