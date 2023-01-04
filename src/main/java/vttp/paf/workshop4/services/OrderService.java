package vttp.paf.workshop4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vttp.paf.workshop4.models.Order;
import vttp.paf.workshop4.models.OrderDetails;
import vttp.paf.workshop4.repositories.DetailsRepo;
import vttp.paf.workshop4.repositories.OrderRepo;

@Service
public class OrderService {
    
    @Autowired
    private DetailsRepo dRepo;

    @Autowired
    private OrderRepo oRepo;

    @Transactional(rollbackFor = OrderException.class)
    public boolean insertOrder(List<OrderDetails> detailList, Order o) {
        Integer order = oRepo.insertOrder(o);
        Integer details = dRepo.insertDetails(detailList, oRepo.getOrderId(o));

        if (order > 0 && details > 0) {
            return true;
        } else {
            return false;
        }
    }

    // public boolean insertOrder(Order o) {
    //     return oRepo.insertOrder(o) > 0;
    // }

    // public boolean insertDetails(List<OrderDetails> detailsList, Order o) {
    //     return dRepo.insertDetails(detailsList, oRepo.getOrderId(o)) > 0;
    // }
}
