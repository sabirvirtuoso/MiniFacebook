<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="headerafterlogin.jsp">
    <c:param name="heading" value="Users"></c:param>
    <c:param name="title" value="View Users"></c:param>
</c:import>
<!--=== Profile ===-->
<div class="profile">
    <div class="container content">
        <div class="row">
            <div class="col-md-9 col-md-offset-1">
                <c:if test="${!empty param.message}">
                    <c:import url="successalert.jsp">
                        <c:param name="message" value="${param.message}"></c:param>
                    </c:import>
                </c:if>

                <h3>Friend Suggestions</h3>

                <div class="profile-body">
                    <div class="profile-bio">
                        <c:forEach var="users" items="${requestScope.nonfriends}">
                            <div class="row">
                                <div class="col-md-5">
                                    <img class="img-responsive md-margin-bottom-10"
                                         src="uploads/${users.profilePictureName}" alt="">
                                </div>
                                <div class="col-md-7">
                                    <%@include file="profilebody.jsp" %>
                                    <form action="/addfriend" method="post">
                                        <input type="text" style="display:none" name="userid" value="${users.userId}">

                                        <div class="row">
                                            <div class="col-md-12">
                                                <button class="btn-u pull-right" type="submit">Add Friend</button>
                                            </div>
                                        </div>
                                    </form>
                                    <br/>
                                    <%@include file="sendmessage.jsp" %>
                                </div>
                            </div>
                            <hr>
                        </c:forEach>
                    </div>
                    <!--/end row-->
                    <hr>
                </div>
                <h3>Current Friends</h3>

                <div class="profile-body">
                    <div class="profile-bio">
                        <c:forEach var="users" items="${requestScope.friends}">
                            <div class="row">
                                <div class="col-md-5">
                                    <img class="img-responsive md-margin-bottom-10"
                                         src="uploads/${users.profilePictureName}" alt="">
                                </div>
                                <div class="col-md-7">
                                    <%@include file="profilebody.jsp" %>
                                    <form action="deletefriend" method="post">
                                        <input type="text" style="display:none" name="userid" value="${users.userId}">

                                        <div class="row">
                                            <div class="col-md-12">
                                                <button class="btn-u pull-right" type="submit">Delete Friend</button>
                                            </div>
                                        </div>
                                    </form>
                                    <br/>
                                    <%@include file="sendmessage.jsp" %>
                                </div>
                            </div>
                            <hr>
                        </c:forEach>
                    </div>
                    <!--/end row-->
                    <hr>
                </div>
            </div>
        </div>
        <!--/end row-->
    </div>
    <!--/container-->
</div>
<!--=== End Profile ===-->
<%@include file="footer.jsp" %>