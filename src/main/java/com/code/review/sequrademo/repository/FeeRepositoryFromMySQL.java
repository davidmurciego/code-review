package com.code.review.sequrademo.repository;

import com.code.review.sequrademo.model.Fee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FeeRepositoryFromMySQL implements FeeRepository {


    private final NamedParameterJdbcTemplate npJdbcTemplate;

    public FeeRepositoryFromMySQL(NamedParameterJdbcTemplate npJdbcTemplate) {
        this.npJdbcTemplate = npJdbcTemplate;
    }

    @Override
    public Fee get(double orderAmount) {
        Fee fee = npJdbcTemplate.queryForObject("SELECT * FROM fees WHERE :orderAmount >= amount_base AND :orderAmount < amount_limit",
                new MapSqlParameterSource()
                        .addValue("orderAmount", orderAmount), BeanPropertyRowMapper.newInstance(Fee.class));
        return fee;
    }
}
