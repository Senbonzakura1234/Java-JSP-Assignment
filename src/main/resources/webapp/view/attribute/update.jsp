<%--
  Created by IntelliJ IDEA.
  User: Senbonzakura
  Date: 6/12/2020
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Material Dash</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/demo/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon.png" />
</head>
<body>
<script src="${pageContext.request.contextPath}/assets/js/preloader.js"></script>
<div class="body-wrapper">
    <!-- partial:../../partials/_sidebar.jsp -->
    <jsp:include page="../partials/_sidebar.jsp"/>
    <!-- partial -->

    <div class="main-wrapper mdc-drawer-app-content">
        <!-- partial:../../partials/_navbar.jsp -->
        <jsp:include page="../partials/_navbar.jsp"/>
        <!-- partial -->
        <div class="page-wrapper mdc-toolbar-fixed-adjust">
            <main class="content-wrapper">
                <div class="mdc-layout-grid">
                    <div class="mdc-layout-grid__inner">
                        <div class="mdc-layout-grid__cell--span-4 mdc-layout-grid__cell--span-6-desktop stretch-card">
                            <form class="mdc-card" method="post" action="${pageContext.request.contextPath}/updateAttribute">
                                <h6 class="card-title">Update Category</h6>
                                <p class="card-sub-title text-danger">${message}</p>
                                <div class="template-demo">
                                    <input type="hidden" name="id" value="${id}">
                                    <div class="mdc-layout-grid__inner">
                                        <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                            <div class="mdc-text-field mdc-text-field--outlined">
                                                <input class="mdc-text-field__input" name="name" id="text-field-hero-input" value="${name}">
                                                <div class="mdc-notched-outline">
                                                    <div class="mdc-notched-outline__leading"></div>
                                                    <div class="mdc-notched-outline__notch">
                                                        <label for="text-field-hero-input" class="mdc-floating-label">Name</label>
                                                    </div>
                                                    <div class="mdc-notched-outline__trailing"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                            <div class="mdc-select demo-width-class mdc-layout-grid__cell--span-12" data-mdc-auto-init="MDCSelect">
                                                <input type="hidden" name="status" value="${status}">
                                                <i class="mdc-select__dropdown-icon"></i>
                                                <div class="mdc-select__selected-text"></div>
                                                <div class="mdc-select__menu mdc-menu-surface demo-width-class">
                                                    <ul class="mdc-list">
                                                        <%--@elvariable id="selectOptionList" type="java.util.List"--%>
                                                        <c:forEach items="${selectOptionList}" var="item">
                                                            <li class="mdc-list-item ${item.selected? " mdc-list-item--selected" : ""}"
                                                                data-value="${item.value}" aria-selected="${item.selected? "true" : "false"}">
                                                                    ${item.name}
                                                            </li>

                                                        </c:forEach>
                                                        <%--                                                        <li class="mdc-list-item mdc-list-item--selected" data-value="" aria-selected="true">--%>
                                                        <%--                                                        </li>--%>
                                                        <%--                                                        <li class="mdc-list-item" data-value="grains">--%>
                                                        <%--                                                            Bread, Cereal, Rice, and Pasta--%>
                                                        <%--                                                        </li>--%>
                                                        <%--                                                        <li class="mdc-list-item" data-value="vegetables">--%>
                                                        <%--                                                            Vegetables--%>
                                                        <%--                                                        </li>--%>
                                                        <%--                                                        <li class="mdc-list-item" data-value="fruit">--%>
                                                        <%--                                                            Fruit--%>
                                                        <%--                                                        </li>--%>
                                                    </ul>
                                                </div>
                                                <span class="mdc-floating-label">Pick a Food Group</span>
                                                <div class="mdc-line-ripple"></div>
                                            </div>
                                        </div>
                                        <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                                            <button type="submit"
                                                    class="mdc-button mdc-button--raised w-100 mdc-ripple-upgraded">
                                                Submit
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </main>
            <!-- partial:../../partials/_footer.jsp -->
            <jsp:include page="../partials/_footer.jsp"/>
            <!-- partial -->
        </div>
    </div>
</div>
<!-- plugins:js -->
<script src="${pageContext.request.contextPath}/assets/vendors/js/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page-->
<!-- End plugin js for this page-->
<!-- inject:js -->
<script src="${pageContext.request.contextPath}/assets/js/material.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/misc.js"></script>
<!-- endinject -->
<!-- Custom js for this page-->
<!-- End custom js for this page-->
</body>
</html>

