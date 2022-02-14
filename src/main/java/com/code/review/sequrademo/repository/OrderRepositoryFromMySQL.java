package com.code.review.sequrademo.repository;

import com.code.review.sequrademo.model.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryFromMySQL implements OrderRepository {

    private final NamedParameterJdbcTemplate npJdbcTemplate;

    public OrderRepositoryFromMySQL(NamedParameterJdbcTemplate npJdbcTemplate) {
        this.npJdbcTemplate = npJdbcTemplate;
    }

    @Override
    public Order get(Long orderId) {
        Order order = npJdbcTemplate.queryForObject("SELECT * FROM orders WHERE id = :orderId",
                new MapSqlParameterSource()
                        .addValue("orderId", orderId),BeanPropertyRowMapper.newInstance(Order.class));
        return order;
    }

    @Override
    /**
     * Returns the last 7 days, instead of the last week orders
     */
    public List<Order> getLastWeekCompleted() {
        List<Order> lastWeekOrders = npJdbcTemplate.query("SELECT * FROM orders WHERE completed_at is not null " +
                        "AND completed_at > current_date - interval 7 day " +
                        "AND id NOT IN ( SELECT order_id FROM disbursements )",
                new BeanPropertyRowMapper(Order.class));
        return lastWeekOrders;
    }

    @Override
    public void save(Order order) {
        // TODO: save all fields
       npJdbcTemplate.update ("UPDATE orders SET completed_at = :completed_at WHERE id = :orderId",
                new MapSqlParameterSource()
                        .addValue("completed_at", order.getCreateAt())
                        .addValue("orderId", order.getId()));
    }

}
