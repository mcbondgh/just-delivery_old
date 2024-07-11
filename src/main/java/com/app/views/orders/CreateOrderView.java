package com.app.views.orders;

import com.app.layouts.MainLayout;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Create Order")
@Route(value = "views/create-order", layout = MainLayout.class)
@Uses(Icon.class)
@JsModule("scripts.js")
public class CreateOrderView extends VerticalLayout {

    public CreateOrderView() {

    }
}
