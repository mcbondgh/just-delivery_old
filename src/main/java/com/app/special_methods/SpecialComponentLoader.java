package com.app.special_methods;

import com.vaadin.flow.component.combobox.ComboBox;

public class SpecialComponentLoader {

    public static void setGender(ComboBox<String> comboBox) {
        String [] items = {"Female", "Male", "Other"};
        comboBox.setItems(items);
    }
}
