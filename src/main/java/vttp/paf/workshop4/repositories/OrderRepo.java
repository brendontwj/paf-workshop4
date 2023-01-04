package vttp.paf.workshop4.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.paf.workshop4.models.Order;
import static vttp.paf.workshop4.repositories.Queries.*;

@Repository
public class OrderRepo {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer insertOrder(Order o) {
        return jdbcTemplate.update(SQL_INSERT_ORDER, o.getOrder_date(), o.getCustomer_name(), o.getShip_address(), o.getNotes(), o.getTax());
    }

    public Integer getOrderId(Order o) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_ORDER, o.getOrder_date(), o.getCustomer_name());
        Integer id = 0;
        while (rs.next()) {
            id = rs.getInt("order_id");
        }
        return id;
    }
}
