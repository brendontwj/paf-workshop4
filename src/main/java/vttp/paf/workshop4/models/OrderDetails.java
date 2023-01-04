package vttp.paf.workshop4.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class OrderDetails {
    
    private String product;
    private Double unit_price;
    private Double discount;
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public Double getUnit_price() {
        return unit_price;
    }
    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }
    public Double getDiscount() {
        return discount;
    }
    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public OrderDetails create(SqlRowSet rs) {
        OrderDetails od = new OrderDetails();
        od.setProduct(rs.getString("product"));
        od.setUnit_price(rs.getDouble("unit_price"));
        od.setDiscount(rs.getDouble("discount"));
        return od;
    }
}
