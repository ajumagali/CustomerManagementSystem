package com.zuhkle;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.router.Route;
import com.zuhkle.models.Customer;
import com.zuhkle.models.CustomerService;

import java.util.List;

/**
 * The main view contains a button and a click listener.
 */
@Route
@PWA(name = "My Application", shortName = "My Application")
public class MainView extends VerticalLayout {
    private CustomerService service = CustomerService.getInstance();
    private Grid<Customer> grid = new Grid<>(Customer.class);

    public MainView() {
        final VerticalLayout layout = new VerticalLayout();
        layout.addComponentAsFirst(grid);

        updateList();

        add(layout);
    }

    public void updateList() {
        List<Customer> customers = service.findAll();
        grid.setItems(customers);
    }
}
