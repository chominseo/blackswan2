<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Black Swan QnA reply input form</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
 <h1 class="hidden">BLACKSWAN</h1>
   <jsp:include page="../inc/header.jsp" />
	<table>
		<tr>
			<td>
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
					<tr
						style="background: url('img/table_mid.gif') repeat-x; text-align: center;">
						<td width="5"><img src="img/table_left.gif" width="5"
							height="30" /></td>
						<td>답글</td>
						<td width="5"><img src="img/table_right.gif" width="5"
							height="30" /></td>
					</tr>
				</table>
				<table>
					<tr>
						<td>&nbsp;</td>
						<td align="center">제목</td>
						<td><input name="subject" size="50" maxlength="100"></td>
						<td>&nbsp;</td>
					</tr>
					<tr height="1" bgcolor="#dddddd">
						<td colspan="4"></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="center">이름</td>
						<td><input name="name" size="50" maxlength="50"></td>
						<td>&nbsp;</td>
					</tr>
					<tr height="1" bgcolor="#dddddd">
						<td colspan="4"></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="center">비밀번호</td>
						<td><input name="name" size="50" maxlength="50"></td>
						<td>&nbsp;</td>
					</tr>
					<tr height="1" bgcolor="#dddddd">
						<td colspan="4"></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="center">내용</td>
						<td><textarea name="contents" cols="50" rows="13"></textarea></td>
						<td>&nbsp;</td>
					</tr>
					<tr height="1" bgcolor="#dddddd">
						<td colspan="4"></td>
					</tr>
					<tr height="1" bgcolor="#82B5DF">
						<td colspan="4"></td>
					</tr>
					<tr align="center">
						<td>&nbsp;</td>
						<td colspan="2"><input type=button value="등록"> <input
							type=button value="취소">
						<td>&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>


</body>
<jsp:include page="../inc/footer.jsp" />
</html>





