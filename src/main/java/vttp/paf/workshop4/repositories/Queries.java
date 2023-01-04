package vttp.paf.workshop4.repositories;

public class Queries {
    
    public static final String SQL_INSERT_ORDER = "insert into orders(order_date, customer_name, ship_address, notes, tax) values (?, ?, ?, ?, ?)";

    public static final String SQL_INSERT_ORDER_DETAILS = "insert into order_details(product, unit_price, discount, quantity, order_id) values (?,?,?,?,?)";

    public static final String SQL_GET_ORDER = "select * from orders where order_date = ? and customer_name = ?";
}
