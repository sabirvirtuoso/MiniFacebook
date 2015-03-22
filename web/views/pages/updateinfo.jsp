<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="headerafterlogin.jsp">
    <c:param name="heading" value="Update Your Info"></c:param>
    <c:param name="title" value="Update Page"></c:param>
</c:import>
<!--=== Content Part ===-->
<div class="container content">
    <div class="row">
        <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <c:if test="${!empty param.success}">
                <c:import url="successalert.jsp">
                    <c:param name="message" value="Profile updated successfully"></c:param>
                </c:import>
            </c:if>
            <form class="reg-page" action="/updateprofile" method="post">
                <div class="reg-header">
                    <h2>Update Info</h2>
                </div>
                <label>First Name</label>
                <input type="text" class="form-control margin-bottom-20" name="firstname"
                       value="${sessionScope.user.firstName}">
                <label>Last Name</label>
                <input type="text" class="form-control margin-bottom-20" name="lastname"
                       value="${sessionScope.user.lastName}">
                <label>Email Address</label>
                <input type="text" class="form-control margin-bottom-20" name="email"
                       value="${sessionScope.user.email}">

                <div class="row">
                    <div class="col-sm-12">
                        <label>Password</label>
                        <input type="password" class="form-control margin-bottom-20" name="password"
                               value="${sessionScope.user.password}">
                    </div>
                </div>
                <label>Date Of Birth</label>
                <input type="date" class="form-control margin-bottom-20 controls input-append" name="dob"
                       value="${sessionScope.user.dob}">
                <label>Address</label>
                <input type="text" class="form-control margin-bottom-20" name="address"
                       value="${sessionScope.user.address}">
                <label>Occupation</label>
                <input type="text" class="form-control margin-bottom-20" name="occupation"
                       value="${sessionScope.user.occupation}">
                <hr>
                <div class="row">
                    <div class="col-lg-12 text-right">
                        <button class="btn-u" type="submit">Update</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!--/container-->
<!--=== End Content Part ===-->
<%@include file="footer.jsp" %>