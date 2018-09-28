
<%@page import="com.chatf.review.dao.ReviewDAO"%>
<%@page import="com.chatf.review.dao.ReviewDAOImpl"%>
<%@page import="com.chatf.reply.text.dao.ReplyDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList,
            com.chatf.review.ReviewVO"  
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Gallery - Snapshot by TEMPLATED</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../assets/css/main.css" />
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	</head>

	<body>
	   	<%
		ArrayList<ReviewVO> list = (ArrayList<ReviewVO>) request.getAttribute("keylist");

%>   
   
	<div class="page-wrap">

						<jsp:include page="../common/navbar.jsp"></jsp:include>


			<!-- Main -->
				<section id="main">

					<!-- Header -->
						<header id="header">
							<div><li><a href="writepage.jsp" class="button">WRITE</a></li></div>
						</header>

					<!-- Gallery -->
						<section id="galleries">

							<!-- Photo Galleries -->
							
								<div class="gallery">

									<!-- Filters -->
										<header>
											<h1>REVIEW</h1>
											<ul class="tabs">
											    <li><a href="#" data-tag="ALL" class="button active" >ALL</a></li>
												<li><a href="#" data-tag="KANTO" class="button" value="101">KANTO</a></li>
												<li><a href="#" data-tag="KANSAI" class="button" value="102">KANSAI</a></li>
												<li><a href="#" data-tag="place" class="button" value="103">HOKKAIDO</a></li>
												<li><a href="#" data-tag="KYUSHU" class="button" value="104">KYUSHU</a></li>
												
						
						</ul>
										</header>

										<div class="content">
										
										
											 <table>
            <thead>
                <tr>
                    <th>REVIEWNo</th>
                    <th>LOCAL</th>
                    <th>TAG</th>
                    <th>TITLE</th>
                    <th>Created&nbsp;On</th>
                    <th>USER&nbsp;ID</th>
                    <th>LIKE</th>
                </tr>
            </thead>
            <tbody>
 
              <%for(int i=0;i<list.size();i++){ %>
             <tr>
             <td><%=list.get(i).getReviewNo() %></td>
             <td><%=list.get(i).getTagCode() %></td>
             <td><%=list.get(i).getUserId() %></td>
             <td><%=list.get(i).getWriteDate() %></td>
             <td><%=list.get(i).getReviewTitle() %></td>
             </tr>
             <%} %> 
            </tbody>
        </table>
								</div>


		<!-- Scripts -->
			<script src="../assets/js/jquery.min.js"></script>
			<script src="../assets/js/jquery.poptrox.min.js"></script>
			<script src="../assets/js/jquery.scrolly.min.js"></script>
			<script src="../assets/js/skel.min.js"></script>
			<script src="../assets/js/util.js"></script>
			<script src="../assets/js/main.js"></script>
</div>
</section>
</section>
</div>


	</body>
</html>