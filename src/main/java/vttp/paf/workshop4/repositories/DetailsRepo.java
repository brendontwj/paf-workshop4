package vttp.paf.workshop4.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp.paf.workshop4.models.OrderDetails;
import static vttp.paf.workshop4.repositories.Queries.*;

import java.util.List;

@Repository
public class DetailsRepo {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer insertDetails(OrderDetails od, Integer order_id) {
        return jdbcTemplate.update(SQL_INSERT_ORDER_DETAILS, od.getProduct(), od.getUnit_price(), od.getDiscount(), od.getQuantity(), order_id);
    }

    public Integer insertDetails(List<OrderDetails> detailsList, Integer order_id) {
        List<Object[]> data = detailsList.stream()
            .map(od -> {
                Object[] l = new Object[5];
                l[0] = od.getProduct();
                l[1] = od.getUnit_price();
                l[2] = od.getDiscount();
                l[3] = od.getQuantity();
                l[4] = order_id;
                return l;
            }).toList();

        return jdbcTemplate.batchUpdate(SQL_INSERT_ORDER_DETAILS, data).length;
    }
}
