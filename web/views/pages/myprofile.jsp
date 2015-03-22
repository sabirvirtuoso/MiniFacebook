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
                <h3>Profile of ${sessionScope.user.firstName} ${sessionScope.user.lastName}</h3>
                <div class="profile-body">
                    <div class="profile-bio">
                        <div class="row">
                            <div class="col-md-5">
                                <img class="img-responsive md-margin-bottom-10"
                                     src="uploads/${sessionScope.user.profilePictureName}" alt="">
                            </div>
                            <div class="col-md-7">
                                <span><strong>Email:</strong> ${sessionScope.user.email}</span>
                                <span><strong>Date Of Birth:</strong> ${sessionScope.user.dob}</span>
                                <span><strong>Occupation:</strong> ${sessionScope.user.occupation}</span>
                                <span><strong>Address:</strong> ${sessionScope.user.address}</span>
                            </div>
                        </div>
                        <hr>
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