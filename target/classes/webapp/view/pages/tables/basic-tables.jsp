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
    <!-- partial:../../partials/_sidebar.html -->
    <aside class="mdc-drawer mdc-drawer--dismissible mdc-drawer--open">
      <div class="mdc-drawer__header">
        <a href="${pageContext.request.contextPath}/view/index.jsp" class="brand-logo">
          <img src="${pageContext.request.contextPath}/assets/images/logo.svg" alt="logo">
        </a>
      </div>
      <div class="mdc-drawer__content">
        <div class="user-info">
          <p class="name">Clyde Miles</p>
          <p class="email">clydemiles@elenor.us</p>
        </div>
        <div class="mdc-list-group">
          <nav class="mdc-list mdc-drawer-menu">
            <div class="mdc-list-item mdc-drawer-item">
              <a class="mdc-drawer-link" href="${pageContext.request.contextPath}/view/index.jsp">
                <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon" aria-hidden="true">home</i>
                Dashboard
              </a>
            </div>
            <div class="mdc-list-item mdc-drawer-item">
              <a class="mdc-drawer-link" href="../forms/basic-forms.jsp">
                <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon" aria-hidden="true">track_changes</i>
                Forms
              </a>
            </div>
            <div class="mdc-list-item mdc-drawer-item">
              <a class="mdc-expansion-panel-link" href="#/" data-toggle="expansionPanel" data-target="ui-sub-menu">
                <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon" aria-hidden="true">dashboard</i>
                UI Features
                <i class="mdc-drawer-arrow material-icons">chevron_right</i>
              </a>
              <div class="mdc-expansion-panel" id="ui-sub-menu">
                <nav class="mdc-list mdc-drawer-submenu">
                  <div class="mdc-list-item mdc-drawer-item">
                    <a class="mdc-drawer-link" href="../ui-features/buttons.jsp">
                      Buttons
                    </a>
                  </div>
                  <div class="mdc-list-item mdc-drawer-item">
                    <a class="mdc-drawer-link" href="../ui-features/typography.jsp">
                      Typography
                    </a>
                  </div>
                </nav>
              </div>
            </div>
            <div class="mdc-list-item mdc-drawer-item">
              <a class="mdc-drawer-link" href="basic-tables.jsp">
                <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon" aria-hidden="true">grid_on</i>
                Tables
              </a>
            </div>
            <div class="mdc-list-item mdc-drawer-item">
              <a class="mdc-drawer-link" href="../charts/chartjs.jsp">
                <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon" aria-hidden="true">pie_chart_outlined</i>
                Charts
              </a>
            </div>
            <div class="mdc-list-item mdc-drawer-item">
              <a class="mdc-expansion-panel-link" href="#/" data-toggle="expansionPanel" data-target="sample-page-submenu">
                <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon" aria-hidden="true">pages</i>
                Sample Pages
                <i class="mdc-drawer-arrow material-icons">chevron_right</i>
              </a>
              <div class="mdc-expansion-panel" id="sample-page-submenu">
                <nav class="mdc-list mdc-drawer-submenu">
                  <div class="mdc-list-item mdc-drawer-item">
                    <a class="mdc-drawer-link" href="../samples/blank-page.jsp">
                      Blank Page
                    </a>
                  </div>
                  <div class="mdc-list-item mdc-drawer-item">
                    <a class="mdc-drawer-link" href="../samples/403.jsp">
                      403
                    </a>
                  </div>
                  <div class="mdc-list-item mdc-drawer-item">
                    <a class="mdc-drawer-link" href="../samples/404.jsp">
                      404
                    </a>
                  </div>
                  <div class="mdc-list-item mdc-drawer-item">
                    <a class="mdc-drawer-link" href="../samples/500.jsp">
                      500
                    </a>
                  </div>
                  <div class="mdc-list-item mdc-drawer-item">
                    <a class="mdc-drawer-link" href="../samples/505.jsp">
                      505
                    </a>
                  </div>
                  <div class="mdc-list-item mdc-drawer-item">
                    <a class="mdc-drawer-link" href="../samples/login.jsp">
                      Login
                    </a>
                  </div>
                  <div class="mdc-list-item mdc-drawer-item">
                    <a class="mdc-drawer-link" href="../samples/register.jsp">
                      Register
                    </a>
                  </div>
                </nav>
              </div>
            </div>
            <div class="mdc-list-item mdc-drawer-item">
              <a class="mdc-drawer-link" href="https://www.bootstrapdash.com/demo/material-admin-free/jquery/documentation/documentation.html" target="_blank">
                <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon" aria-hidden="true">description</i>
                Documentation
              </a>
            </div>
          </nav>
        </div>
        <div class="profile-actions">
          <a href="javascript:;">Settings</a>
          <span class="divider"></span>
          <a href="javascript:;">Logout</a>
        </div>
        <div class="mdc-card premium-card">
          <div class="d-flex align-items-center">
            <div class="mdc-card icon-card box-shadow-0">
              <i class="mdi mdi-shield-outline"></i>
            </div>
            <div>
              <p class="mt-0 mb-1 ml-2 font-weight-bold tx-12">Material Dash</p>
              <p class="mt-0 mb-0 ml-2 tx-10">Pro available</p>
            </div>
          </div>
          <p class="tx-8 mt-3 mb-1">More elements. More Pages.</p>
          <p class="tx-8 mb-3">Starting from $25.</p>
          <a href="https://www.bootstrapdash.com/product/material-design-admin-template/" target="_blank">
						<span class="mdc-button mdc-button--raised mdc-button--white">Upgrade to Pro</span>
					</a>
        </div>
      </div>
    </aside>
    <!-- partial -->
    <div class="main-wrapper mdc-drawer-app-content">
      <!-- partial:../../partials/_navbar.html -->
      <header class="mdc-top-app-bar">
        <div class="mdc-top-app-bar__row">
          <div class="mdc-top-app-bar__section mdc-top-app-bar__section--align-start">
            <button class="material-icons mdc-top-app-bar__navigation-icon mdc-icon-button sidebar-toggler">menu</button>
            <span class="mdc-top-app-bar__title">Greetings Clyde!</span>
            <div class="mdc-text-field mdc-text-field--outlined mdc-text-field--with-leading-icon search-text-field d-none d-md-flex">
              <i class="material-icons mdc-text-field__icon">search</i>
              <input class="mdc-text-field__input" id="text-field-hero-input">
              <div class="mdc-notched-outline">
                <div class="mdc-notched-outline__leading"></div>
                <div class="mdc-notched-outline__notch">
                  <label for="text-field-hero-input" class="mdc-floating-label">Search..</label>
                </div>
                <div class="mdc-notched-outline__trailing"></div>
              </div>
            </div>
          </div>
          <div class="mdc-top-app-bar__section mdc-top-app-bar__section--align-end mdc-top-app-bar__section-right">
            <div class="menu-button-container menu-profile d-none d-md-block">
              <button class="mdc-button mdc-menu-button">
                <span class="d-flex align-items-center">
                  <span class="figure">
                    <img src="${pageContext.request.contextPath}/assets/images/faces/face1.jpg" alt="user" class="user">
                  </span>
                  <span class="user-name">Clyde Miles</span>
                </span>
              </button>
              <div class="mdc-menu mdc-menu-surface" tabindex="-1">
                <ul class="mdc-list" role="menu" aria-hidden="true" aria-orientation="vertical">
                  <li class="mdc-list-item" role="menuitem">
                    <div class="item-thumbnail item-thumbnail-icon-only">
                      <i class="mdi mdi-account-edit-outline text-primary"></i>
                    </div>
                    <div class="item-content d-flex align-items-start flex-column justify-content-center">
                      <h6 class="item-subject font-weight-normal">Edit profile</h6>
                    </div>
                  </li>
                  <li class="mdc-list-item" role="menuitem">
                    <div class="item-thumbnail item-thumbnail-icon-only">
                      <i class="mdi mdi-settings-outline text-primary"></i>                      
                    </div>
                    <div class="item-content d-flex align-items-start flex-column justify-content-center">
                      <h6 class="item-subject font-weight-normal">Logout</h6>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
            <div class="divider d-none d-md-block"></div>
            <div class="menu-button-container d-none d-md-block">
              <button class="mdc-button mdc-menu-button">
                <i class="mdi mdi-settings"></i>
              </button>
              <div class="mdc-menu mdc-menu-surface" tabindex="-1">
                <ul class="mdc-list" role="menu" aria-hidden="true" aria-orientation="vertical">
                  <li class="mdc-list-item" role="menuitem">
                    <div class="item-thumbnail item-thumbnail-icon-only">
                      <i class="mdi mdi-alert-circle-outline text-primary"></i>
                    </div>
                    <div class="item-content d-flex align-items-start flex-column justify-content-center">
                      <h6 class="item-subject font-weight-normal">Settings</h6>
                    </div>
                  </li>
                  <li class="mdc-list-item" role="menuitem">
                    <div class="item-thumbnail item-thumbnail-icon-only">
                      <i class="mdi mdi-progress-download text-primary"></i>                      
                    </div>
                    <div class="item-content d-flex align-items-start flex-column justify-content-center">
                      <h6 class="item-subject font-weight-normal">Update</h6>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
            <div class="menu-button-container">
              <button class="mdc-button mdc-menu-button">
                <i class="mdi mdi-bell"></i>
              </button>
              <div class="mdc-menu mdc-menu-surface" tabindex="-1">
                <h6 class="title"> <i class="mdi mdi-bell-outline mr-2 tx-16"></i> Notifications</h6>
                <ul class="mdc-list" role="menu" aria-hidden="true" aria-orientation="vertical">
                  <li class="mdc-list-item" role="menuitem">
                    <div class="item-thumbnail item-thumbnail-icon">
                      <i class="mdi mdi-email-outline"></i>
                    </div>
                    <div class="item-content d-flex align-items-start flex-column justify-content-center">
                      <h6 class="item-subject font-weight-normal">You received a new message</h6>
                      <small class="text-muted"> 6 min ago </small>
                    </div>
                  </li>
                  <li class="mdc-list-item" role="menuitem">
                    <div class="item-thumbnail item-thumbnail-icon">
                      <i class="mdi mdi-account-outline"></i>                      
                    </div>
                    <div class="item-content d-flex align-items-start flex-column justify-content-center">
                      <h6 class="item-subject font-weight-normal">New user registered</h6>
                      <small class="text-muted"> 15 min ago </small>
                    </div>
                  </li>
                  <li class="mdc-list-item" role="menuitem">
                    <div class="item-thumbnail item-thumbnail-icon">
                      <i class="mdi mdi-alert-circle-outline"></i>
                    </div>
                    <div class="item-content d-flex align-items-start flex-column justify-content-center">
                      <h6 class="item-subject font-weight-normal">System Alert</h6>
                      <small class="text-muted"> 2 days ago </small>
                    </div>
                  </li> 
                  <li class="mdc-list-item" role="menuitem">
                    <div class="item-thumbnail item-thumbnail-icon">
                      <i class="mdi mdi-update"></i>
                    </div>
                    <div class="item-content d-flex align-items-start flex-column justify-content-center">
                      <h6 class="item-subject font-weight-normal">You have a new update</h6>
                      <small class="text-muted"> 3 days ago </small>
                    </div>
                  </li> 
                </ul>
              </div>
            </div>
            <div class="menu-button-container">
              <button class="mdc-button mdc-menu-button">
                <i class="mdi mdi-email"></i>
                <span class="count-indicator">
                  <span class="count">3</span>
                </span>
              </button>
              <div class="mdc-menu mdc-menu-surface" tabindex="-1">
                <h6 class="title"><i class="mdi mdi-email-outline mr-2 tx-16"></i> Messages</h6>
                <ul class="mdc-list" role="menu" aria-hidden="true" aria-orientation="vertical">
                  <li class="mdc-list-item" role="menuitem">
                    <div class="item-thumbnail">
                      <img src="${pageContext.request.contextPath}/assets/images/faces/face4.jpg" alt="user">
                    </div>
                    <div class="item-content d-flex align-items-start flex-column justify-content-center">
                      <h6 class="item-subject font-weight-normal">Mark send you a message</h6>
                      <small class="text-muted"> 1 Minutes ago </small>
                    </div>
                  </li>
                  <li class="mdc-list-item" role="menuitem">
                    <div class="item-thumbnail">
                      <img src="${pageContext.request.contextPath}/assets/images/faces/face2.jpg" alt="user">
                    </div>
                    <div class="item-content d-flex align-items-start flex-column justify-content-center">
                      <h6 class="item-subject font-weight-normal">Cregh send you a message</h6>
                      <small class="text-muted"> 15 Minutes ago </small>
                    </div>
                  </li>
                  <li class="mdc-list-item" role="menuitem">
                    <div class="item-thumbnail">
                      <img src="${pageContext.request.contextPath}/assets/images/faces/face3.jpg" alt="user">
                    </div>
                    <div class="item-content d-flex align-items-start flex-column justify-content-center">
                      <h6 class="item-subject font-weight-normal">Profile picture updated</h6>
                      <small class="text-muted"> 18 Minutes ago </small>
                    </div>
                  </li>                
                </ul>
              </div>
            </div>
            <div class="menu-button-container d-none d-md-block">
              <button class="mdc-button mdc-menu-button">
                <i class="mdi mdi-arrow-down-bold-box"></i>
              </button>
              <div class="mdc-menu mdc-menu-surface" tabindex="-1">
                <ul class="mdc-list" role="menu" aria-hidden="true" aria-orientation="vertical">
                  <li class="mdc-list-item" role="menuitem">
                    <div class="item-thumbnail item-thumbnail-icon-only">
                      <i class="mdi mdi-lock-outline text-primary"></i>
                    </div>
                    <div class="item-content d-flex align-items-start flex-column justify-content-center">
                      <h6 class="item-subject font-weight-normal">Lock screen</h6>
                    </div>
                  </li>
                  <li class="mdc-list-item" role="menuitem">
                    <div class="item-thumbnail item-thumbnail-icon-only">
                      <i class="mdi mdi-logout-variant text-primary"></i>                      
                    </div>
                    <div class="item-content d-flex align-items-start flex-column justify-content-center">
                      <h6 class="item-subject font-weight-normal">Logout</h6>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </header>
      <!-- partial -->
      <div class="page-wrapper mdc-toolbar-fixed-adjust">
        <main class="content-wrapper">
          <div class="mdc-layout-grid">
            <div class="mdc-layout-grid__inner">
              <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                <div class="mdc-card p-0">
                  <h6 class="card-title card-padding pb-0">Basic Table</h6>
                  <div class="table-responsive">
                    <table class="table">
                      <thead>
                        <tr>
                          <th class="text-left">Dessert (100g serving)</th>
                          <th>Calories</th>
                          <th>Fat (g)</th>
                          <th>Link</th>
                          <th>Carbs</th>
                          <th>Protein (g)</th>
                          <th>Sodium (mg)</th>
                          <th>Calcium (%)</th>
                          <th>Iron (%)</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td class="text-left">Frozen yogurt</td>
                          <td>1.59</td>
                          <td>6.0</td>
                          <td>50</td>
                          <td>4.0</td>
                          <td>87</td>
                          <td>20%</td>
                          <td>4%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Frozen yogurt</td>
                          <td>1.59</td>
                          <td>2.5</td>
                          <td>35</td>
                          <td>2.0</td>
                          <td>97</td>
                          <td>17%</td>
                          <td>2%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Ice crean sandwich</td>
                          <td>1.4</td>
                          <td>4.0</td>
                          <td>40</td>
                          <td>8.0</td>
                          <td>83</td>
                          <td>14%</td>
                          <td>7%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Eclair</td>
                          <td>1.7</td>
                          <td>3.0</td>
                          <td>34</td>
                          <td>6.0</td>
                          <td>67</td>
                          <td>17%</td>
                          <td>3%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Cupcake</td>
                          <td>2.49</td>
                          <td>4.0</td>
                          <td>45</td>
                          <td>3.05</td>
                          <td>83</td>
                          <td>20%</td>
                          <td>9%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Jellybean</td>
                          <td>0.78</td>
                          <td>5.2</td>
                          <td>35</td>
                          <td>2.0</td>
                          <td>27</td>
                          <td>18%</td>
                          <td>37%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Gingerbread</td>
                          <td>1.59</td>
                          <td>6.0</td>
                          <td>50</td>
                          <td>4.0</td>
                          <td>87</td>
                          <td>20%</td>
                          <td>4%</td>
                          <td>5.7%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Lollipop</td>
                          <td>1.59</td>
                          <td>6.0</td>
                          <td>50</td>
                          <td>4.0</td>
                          <td>87</td>
                          <td>20%</td>
                          <td>4%</td>
                          <td>6.5%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Honeycomb</td>
                          <td>0.45</td>
                          <td>5.0</td>
                          <td>45</td>
                          <td>3.5</td>
                          <td>45</td>
                          <td>19%</td>
                          <td>26%</td>
                          <td>9%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Donut</td>
                          <td>0.67</td>
                          <td>5.0</td>
                          <td>56</td>
                          <td>3.34</td>
                          <td>67</td>
                          <td>23%</td>
                          <td>4%</td>
                          <td>1.8%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Kitkat</td>
                          <td>0.59</td>
                          <td>8.34</td>
                          <td>43</td>
                          <td>1.97</td>
                          <td>34</td>
                          <td>18%</td>
                          <td>13%</td>
                          <td>1.5%</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
              <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                <div class="mdc-card p-0">
                  <h6 class="card-title card-padding pb-0">Hoverable Table</h6>
                  <div class="table-responsive">
                    <table class="table table-hoverable">
                      <thead>
                        <tr>
                          <th class="text-left">Dessert (100g serving)</th>
                          <th>Calories</th>
                          <th>Fat (g)</th>
                          <th>Link</th>
                          <th>Carbs</th>
                          <th>Protein (g)</th>
                          <th>Sodium (mg)</th>
                          <th>Calcium (%)</th>
                          <th>Iron (%)</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td class="text-left">Frozen yogurt</td>
                          <td>1.59</td>
                          <td>6.0</td>
                          <td>50</td>
                          <td>4.0</td>
                          <td>87</td>
                          <td>20%</td>
                          <td>4%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Frozen yogurt</td>
                          <td>1.59</td>
                          <td>2.5</td>
                          <td>35</td>
                          <td>2.0</td>
                          <td>97</td>
                          <td>17%</td>
                          <td>2%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Ice crean sandwich</td>
                          <td>1.4</td>
                          <td>4.0</td>
                          <td>40</td>
                          <td>8.0</td>
                          <td>83</td>
                          <td>14%</td>
                          <td>7%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Eclair</td>
                          <td>1.7</td>
                          <td>3.0</td>
                          <td>34</td>
                          <td>6.0</td>
                          <td>67</td>
                          <td>17%</td>
                          <td>3%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Cupcake</td>
                          <td>2.49</td>
                          <td>4.0</td>
                          <td>45</td>
                          <td>3.05</td>
                          <td>83</td>
                          <td>20%</td>
                          <td>9%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Jellybean</td>
                          <td>0.78</td>
                          <td>5.2</td>
                          <td>35</td>
                          <td>2.0</td>
                          <td>27</td>
                          <td>18%</td>
                          <td>37%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Gingerbread</td>
                          <td>1.59</td>
                          <td>6.0</td>
                          <td>50</td>
                          <td>4.0</td>
                          <td>87</td>
                          <td>20%</td>
                          <td>4%</td>
                          <td>5.7%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Lollipop</td>
                          <td>1.59</td>
                          <td>6.0</td>
                          <td>50</td>
                          <td>4.0</td>
                          <td>87</td>
                          <td>20%</td>
                          <td>4%</td>
                          <td>6.5%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Honeycomb</td>
                          <td>0.45</td>
                          <td>5.0</td>
                          <td>45</td>
                          <td>3.5</td>
                          <td>45</td>
                          <td>19%</td>
                          <td>26%</td>
                          <td>9%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Donut</td>
                          <td>0.67</td>
                          <td>5.0</td>
                          <td>56</td>
                          <td>3.34</td>
                          <td>67</td>
                          <td>23%</td>
                          <td>4%</td>
                          <td>1.8%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Kitkat</td>
                          <td>0.59</td>
                          <td>8.34</td>
                          <td>43</td>
                          <td>1.97</td>
                          <td>34</td>
                          <td>18%</td>
                          <td>13%</td>
                          <td>1.5%</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
              <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                <div class="mdc-card p-0">
                  <h6 class="card-title card-padding pb-0">Striped Table</h6>
                  <div class="table-responsive">
                    <table class="table table-striped">
                      <thead>
                        <tr>
                          <th class="text-left">Dessert (100g serving)</th>
                          <th>Calories</th>
                          <th>Fat (g)</th>
                          <th>Link</th>
                          <th>Carbs</th>
                          <th>Protein (g)</th>
                          <th>Sodium (mg)</th>
                          <th>Calcium (%)</th>
                          <th>Iron (%)</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td class="text-left">Frozen yogurt</td>
                          <td>1.59</td>
                          <td>6.0</td>
                          <td>50</td>
                          <td>4.0</td>
                          <td>87</td>
                          <td>20%</td>
                          <td>4%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Frozen yogurt</td>
                          <td>1.59</td>
                          <td>2.5</td>
                          <td>35</td>
                          <td>2.0</td>
                          <td>97</td>
                          <td>17%</td>
                          <td>2%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Ice crean sandwich</td>
                          <td>1.4</td>
                          <td>4.0</td>
                          <td>40</td>
                          <td>8.0</td>
                          <td>83</td>
                          <td>14%</td>
                          <td>7%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Eclair</td>
                          <td>1.7</td>
                          <td>3.0</td>
                          <td>34</td>
                          <td>6.0</td>
                          <td>67</td>
                          <td>17%</td>
                          <td>3%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Cupcake</td>
                          <td>2.49</td>
                          <td>4.0</td>
                          <td>45</td>
                          <td>3.05</td>
                          <td>83</td>
                          <td>20%</td>
                          <td>9%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Jellybean</td>
                          <td>0.78</td>
                          <td>5.2</td>
                          <td>35</td>
                          <td>2.0</td>
                          <td>27</td>
                          <td>18%</td>
                          <td>37%</td>
                          <td>6%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Gingerbread</td>
                          <td>1.59</td>
                          <td>6.0</td>
                          <td>50</td>
                          <td>4.0</td>
                          <td>87</td>
                          <td>20%</td>
                          <td>4%</td>
                          <td>5.7%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Lollipop</td>
                          <td>1.59</td>
                          <td>6.0</td>
                          <td>50</td>
                          <td>4.0</td>
                          <td>87</td>
                          <td>20%</td>
                          <td>4%</td>
                          <td>6.5%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Honeycomb</td>
                          <td>0.45</td>
                          <td>5.0</td>
                          <td>45</td>
                          <td>3.5</td>
                          <td>45</td>
                          <td>19%</td>
                          <td>26%</td>
                          <td>9%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Donut</td>
                          <td>0.67</td>
                          <td>5.0</td>
                          <td>56</td>
                          <td>3.34</td>
                          <td>67</td>
                          <td>23%</td>
                          <td>4%</td>
                          <td>1.8%</td>
                        </tr>
                        <tr>
                          <td class="text-left">Kitkat</td>
                          <td>0.59</td>
                          <td>8.34</td>
                          <td>43</td>
                          <td>1.97</td>
                          <td>34</td>
                          <td>18%</td>
                          <td>13%</td>
                          <td>1.5%</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </main>
        <!-- partial:../../partials/_footer.html -->
        <footer>
          <div class="mdc-layout-grid">
            <div class="mdc-layout-grid__inner">
              <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-6-desktop">
                <span class="tx-14">Copyright © 2019 <a href="https://www.bootstrapdash.com/" target="_blank">BootstrapDash</a>. All rights reserved.</span>
              </div>
              <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-6-desktop d-flex justify-content-end">
                <div class="d-flex align-items-center">
                  <a href="">Documentation</a>
                  <span class="vertical-divider"></span>
                  <a href="">FAQ</a>
                </div>
              </div>
            </div>
          </div>
        </footer>
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
