package com.app.views.paymenthistory;

import com.app.layouts.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.router.*;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("Make Payment")
@Route(value = "views/payments", layout = MainLayout.class)

public class Payments extends VerticalLayout implements BeforeEnterObserver {
     public Payments(){
         add(renderPaymentForm());
     }

    public void beforeEnter(BeforeEnterEvent event) {

    }

     VerticalLayout renderPaymentForm() {
         VerticalLayout layout = new VerticalLayout();

         Button button = new Button("payment");
         button.addClickListener(event -> {
             event.getSource().setText("Processing");
             UI.getCurrent().getPage().executeJs("makePayment()");
         });
         layout.add(button);
         return layout;
     }

}//end of class...
