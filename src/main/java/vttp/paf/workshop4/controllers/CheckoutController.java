package vttp.paf.workshop4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import vttp.paf.workshop4.models.Order;
import vttp.paf.workshop4.models.OrderDetails;
import vttp.paf.workshop4.services.OrderService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
    
    @Autowired
    private OrderService oService;

    @PostMapping
    public String postCheckout(Model model, HttpSession session) {
        System.out.println(session.getId());

        List<OrderDetails> detailsList = (List<OrderDetails>) session.getAttribute("details");
        Order o = (Order) session.getAttribute("order");

        System.out.println(o.getCustomer_name());

        for(OrderDetails od : detailsList) {
            System.out.println(od.getProduct());
        }

        boolean inserted = oService.insertOrder(detailsList, o);

        model.addAttribute("inserted", inserted);

        session.invalidate();

        return "checkout";
    }
}
