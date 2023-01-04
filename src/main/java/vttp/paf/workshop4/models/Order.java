package vttp.paf.workshop4.models;

import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Order {
    
    private Date order_date;
    private String customer_name;
    private String ship_address;
    private String notes;
    private double tax;

    public Date getOrder_date() {
        return order_date;
    }
    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }
    public String getCustomer_name() {
        return customer_name;
    }
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
    public String getShip_address() {
        return ship_address;
    }
    public void setShip_address(String ship_address) {
        this.ship_address = ship_address;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public double getTax() {
        return tax;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }

    public Order create(SqlRowSet rs) {
        Order o = new Order();
        o.setOrder_date(rs.getDate("order_date"));
        o.setCustomer_name(rs.getString("customer_name"));
        o.setShip_address(rs.getString("ship_address"));
        o.setNotes(rs.getString("notes"));
        o.setTax(rs.getDouble("tax"));

        return o;
    }
}
