package com.app.views.settings;

import com.app.layouts.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Settings")
@Route(value = "views/settings", layout = MainLayout.class)
public class SettingsView extends Composite<VerticalLayout> {

    public SettingsView() {
        getContent().add(
                new H1("Welcome to settings page")
        );
    }
}
