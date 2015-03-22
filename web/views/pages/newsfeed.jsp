<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="headerafterlogin.jsp">
    <c:param name="heading" value="NewsFeed"></c:param>
    <c:param name="title" value="NewsFeed Page"></c:param>
</c:import>
<!--=== Content Part ===-->
<div class="container content">
    <div class="row">
        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
            <c:if test="${!empty param.success}">
                <c:import url="successalert.jsp">
                    <c:param name="message" value="Posted successfully"></c:param>
                </c:import>
            </c:if>
            </br>
            <c:forEach var="posts" items="${postsandcomments}">
                <div class="detailBox">
                    <%@include file="statuspanel.jsp" %>
                    <div class="actionBox">
                        <ul class="commentList">
                            <c:forEach var="comments" items="${posts.comments}">
                                <%@include file="commentpanel.jsp" %>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <form action="/postcomment" method="post">
                    <input type="text" style="display:none" name="statusid" value="${posts.statusId}">
                    <input type="text" style="display: none" name="requestfrom" value="newsfeed">

                    <div class="input-group col-md-12 margin-bottom-0">
                        <input type="text" placeholder="Post A Comment" class="form-control" name="comment" required/>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <button class="btn-u pull-right" type="submit">Post</button>
                        </div>
                    </div>
                </form>
            </c:forEach>
        </div>
    </div>
    <!--/row-->
</div>
<!--/container-->
<!--=== End Content Part ===-->
<jsp:include page="footer.jsp"></jsp:include>