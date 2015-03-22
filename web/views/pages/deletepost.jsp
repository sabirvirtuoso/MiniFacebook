<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="headerafterlogin.jsp">
    <c:param name="heading" value="Delete Post"></c:param>
    <c:param name="title" value="Post Delete"></c:param>
</c:import>
<!--=== Content Part ===-->
<div class="container content">
    <div class="row">
        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
            <c:if test="${!empty param.success}">
                <c:import url="successalert.jsp">
                    <c:param name="message" value="Post deleted successfully"></c:param>
                </c:import>
            </c:if>
            <c:forEach var="posts" items="${sessionScope.user.posts}">
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
                <form action="/deletepost" method="post">
                    <input type="text" style="display:none" name="statusid" value="${posts.statusId}">

                    <div class="row">
                        <div class="col-md-12">
                            <button class="btn-u pull-right" type="submit">Delete Post</button>
                        </div>
                    </div>
                </form>
            </c:forEach>
            <br/>
        </div>
    </div>
    <!--/row-->
</div>
<!--/container-->
<!--=== End Content Part ===-->
<%@include file="footer.jsp" %>