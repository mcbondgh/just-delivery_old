package com.app.layouts;

import com.app.views.checkoutform.CheckoutFormView;
import com.app.views.customers.CustomerProfileView;
import com.app.views.customers.CustomersView;
import com.app.views.dashboard.DashboardView;
import com.app.views.drivers.*;
import com.app.views.orders.OrdersView;
import com.app.views.paymenthistory.Payments;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;


/**
 * The main view is a top-level placeholder for other views.
 */


public class MainLayout extends AppLayout {

    private H1 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H1();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        Span appName = new Span("JUST DELIVERY");
        appName.addClassNames(LumoUtility.FontWeight.SEMIBOLD, LumoUtility.FontSize.LARGE);
        Header header = new Header(appName);
        header.addClassNames("sidebar-header-text");

        Scroller scroller = new Scroller(createNavigation());
        addToDrawer(header, scroller, createFooter());
    }

    private Component createNavigation() {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setPadding(false);

        Avatar icon = new Avatar("img", "icons/staff-100.png");
        icon.addClassNames("nav-icon");

        //SIDE NAVIGATION
        SideNav nav = new SideNav();
        SideNavItem dashboardNav = new SideNavItem("Dashboard", DashboardView.class, LineAwesomeIcon.CHART_PIE_SOLID.create());
        SideNavItem staffNav = new SideNavItem("Staff Members", "", icon);
        SideNavItem packagesNav = new SideNavItem("My Packages", "", LineAwesomeIcon.BOX_OPEN_SOLID.create());
        SideNavItem feedbackNav = new SideNavItem("Feedbacks", CheckoutFormView.class, LineAwesomeIcon.GRADUATION_CAP_SOLID.create());
        SideNavItem paymentsNav = new SideNavItem("My Payments" , Payments.class, LineAwesomeIcon.MONEY_BILL_SOLID.create());
        SideNavItem invoicesNav = new SideNavItem("Reports", "", LineAwesomeIcon.RECEIPT_SOLID.create());
        SideNavItem routesNav = new SideNavItem("Routes", "", LineAwesomeIcon.ROUTE_SOLID.create());

        nav.addItem(dashboardNav, paymentsNav, staffNav, packagesNav, feedbackNav, invoicesNav);

        //ADD NAVIGATION LINKS TO THE ORDERS SIDE NAV
        SideNav ordersNav = new SideNav("Order Manager");
        ordersNav.addItem(new SideNavItem("View Orders", OrdersView.class, LineAwesomeIcon.CHART_BAR.create()));
        ordersNav.addItem(new SideNavItem("Create Order"));
        ordersNav.addItem(new SideNavItem("Order History"));

        //ADD NAVIGATION LINKS TO DRIVER MANAGER
        SideNav driversNav = new SideNav("Driver Manager");
        SideNavItem addDriver = new SideNavItem("Drivers", DriversView.class, LineAwesomeIcon.CAR_SIDE_SOLID.create());
        SideNavItem driverProfile = new SideNavItem("Driver Profile", DriverProfileView.class, LineAwesomeIcon.CAR_ALT_SOLID.create());
        SideNavItem assignDriver = new SideNavItem("Assign Driver", AssignDriverView.class, LineAwesomeIcon.ASTERISK_SOLID.create());
        SideNavItem viewAssignedDrivers = new SideNavItem("Assigned Packages", AssignedPackagesView.class, LineAwesomeIcon.MOTORCYCLE_SOLID.create());
        SideNavItem ratingAndPerformance = new SideNavItem("Customer Rating", CustomerRatingView.class, LineAwesomeIcon.STAR_SOLID.create());
        driversNav.addItem(addDriver, assignDriver, viewAssignedDrivers, driverProfile, ratingAndPerformance);

        //ADD NAVIGATION LINK TO CUSTOMERS MANAGER
        SideNav customersNav = new SideNav("Customers Manager");
        SideNavItem addCustomer = new SideNavItem("Customers", CustomersView.class, VaadinIcon.ADD_DOCK.create());
        SideNavItem customerProfile = new SideNavItem("Customer Profile", CustomerProfileView.class, LineAwesomeIcon.USERS_SOLID.create());
        SideNav.SideNavI18n customers = new SideNav.SideNavI18n();
        customers.setToggle("toggle");
        customersNav.addItem(addCustomer, customerProfile);

        //ADD LINKS TO NOTIFICATION NAV
        SideNav notificationNav = new SideNav("Notifications");
        SideNavItem viewNotifications = new SideNavItem("My Notifications","", LineAwesomeIcon.BELL_SOLID.create());
        //CREATE A NOTIFICATION COUNTER LABEL
        Span notificationCounter = new Span("0");
        notificationCounter.addClassNames("circle-badge");
        viewNotifications.setSuffixComponent(notificationCounter);
        SideNavItem sendNotification = new SideNavItem("Send Notifications", "", LineAwesomeIcon.MAILCHIMP.create());
        SideNavItem notificationHistory = new SideNavItem("Notification History", "", LineAwesomeIcon.HISTORY_SOLID.create());
        notificationNav.addItem(viewNotifications, sendNotification, notificationHistory);

        //CREATE SETTINGS SIDE NAV
        SideNavItem settingsNav = new SideNavItem("Settings", "#", LineAwesomeIcon.SCREWDRIVER_SOLID.create());

        nav.setWidthFull();
        ordersNav.setCollapsible(true);
        ordersNav.setExpanded(false);
        ordersNav.setWidthFull();
        driversNav.setWidthFull();
        notificationNav.setWidthFull();
        notificationNav.setCollapsible(true);
        notificationNav.setExpanded(false);
        driversNav.setCollapsible(true);
        driversNav.setExpanded(false);
        customersNav.setCollapsible(true);
        customersNav.setExpanded(false);
        customersNav.setWidthFull();

        ordersNav.addClassNames("side-nav-item");
        customersNav.addClassNames("side-nav-item");
        driversNav.addClassNames("side-nav-item");
        notificationNav.addClassNames("side-nav-item");


        layout.add(
                nav,
                notificationNav, ordersNav, driversNav, customersNav,
                settingsNav);

        return layout;
    }

    private Footer createFooter() {
        Footer layout = new Footer();
        layout.addClassNames("main-layout-footer");
        MenuBar menuBar = new MenuBar();
        menuBar.addClassNames("footer-menu-bar");
        H5 USERNAME = new H5("JUST DELIVERY");

        USERNAME.addClassNames("footer-text");
        Avatar profilePicture = new Avatar("user", "images/user-100.png");
        profilePicture.addClassNames("picture-icon");
        menuBar.getStyle().setPadding("0 3px");
        menuBar.getElement().getStyle().set("background-color", "transparent");
        MenuItem signOutButton = menuBar.addItem(profilePicture);
        signOutButton.add(USERNAME);
        Anchor anchor = new Anchor("/", "Sing out");
        signOutButton.addClassNames("menu-item");
        signOutButton.getSubMenu().addItem(anchor, e-> {

        });

        layout.add(menuBar);
        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}