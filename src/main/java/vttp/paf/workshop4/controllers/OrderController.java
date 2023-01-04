package vttp.paf.workshop4.controllers;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import vttp.paf.workshop4.models.Order;
import vttp.paf.workshop4.models.OrderDetails;

@Controller
@RequestMapping("/order")
public class OrderController {
    
    @PostMapping
    public String postUser(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession session) {
        
        String sessionId = session.getId();
        System.out.println(sessionId);
        
        Order o = new Order();
        o.setCustomer_name(form.getFirst("customer_name"));
        o.setNotes(form.getFirst("notes"));
        o.setOrder_date(Date.valueOf(form.getFirst("order_date")));
        o.setShip_address(form.getFirst("ship_address"));
        o.setTax(Double.parseDouble(form.getFirst("tax")));

        session.setAttribute("order", o);
        model.addAttribute("order", session.getAttribute("order"));

        return "details";
    }

    @PostMapping("/details")
    public String postDetails(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession session) {

        String sessionId = session.getId();
        System.out.println(sessionId);
        model.addAttribute("order", session.getAttribute("order"));

        List<OrderDetails> detailsList = (List<OrderDetails>) session.getAttribute("details");

        if (detailsList == null) {
            detailsList = new LinkedList<>();
        }

        OrderDetails od = new OrderDetails();
        od.setDiscount(Double.parseDouble(form.getFirst("discount")));
        od.setProduct(form.getFirst("product"));
        od.setQuantity(Integer.parseInt(form.getFirst("quantity")));
        od.setUnit_price(Double.parseDouble(form.getFirst("unit_price")));
        detailsList.add(od);

        session.setAttribute("details", detailsList);
        model.addAttribute("details", session.getAttribute("details"));

        return "details";
    }
}
