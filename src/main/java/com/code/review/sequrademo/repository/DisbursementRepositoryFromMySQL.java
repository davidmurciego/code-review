package com.code.review.sequrademo.repository;

import com.code.review.sequrademo.model.Disbursement;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DisbursementRepositoryFromMySQL implements DisbursementRepository {

    private final NamedParameterJdbcTemplate npJdbcTemplate;

    public DisbursementRepositoryFromMySQL(NamedParameterJdbcTemplate npJdbcTemplate) {
        this.npJdbcTemplate = npJdbcTemplate;
    }

    @Override
    public List<Disbursement> getAllByWeek(String week) {
        List<Disbursement> disbursements = npJdbcTemplate.query("SELECT * FROM disbursements WHERE week = :week",
                new MapSqlParameterSource()
                        .addValue("week", week), new BeanPropertyRowMapper(Disbursement.class));
        return disbursements;
    }

    @Override
    public List<Disbursement> getAllByWeekAndMerchantId(String week, Long merchantId) {
        List<Disbursement> disbursements = npJdbcTemplate.query("SELECT * FROM disbursements d LEFT JOIN orders o " +
                        "ON o.id = d.order_id AND o.merchant_id = :merchantId AND d.week = :week",
                new MapSqlParameterSource()
                        .addValue("week", week)
                        .addValue("merchantId", merchantId),
                BeanPropertyRowMapper.newInstance(Disbursement.class));
        return disbursements;
    }

    @Override
    public void save(Disbursement disbursement) {
        npJdbcTemplate.update( "INSERT INTO disbursements (order_id, merchant_id, week, disbur_amount, percentage, state) " +
                        "VALUES (:order_id, :merchant_id, :week, :disbur_amount, :percentage, :state)",
                new MapSqlParameterSource()
                        .addValue("order_id", disbursement.getOrder_id())
                        .addValue("merchant_id", disbursement.getMerchant_id())
                        .addValue("week", disbursement.getWeek())
                        .addValue("disbur_amount", disbursement.getDisburAmount())
                        .addValue("percentage", disbursement.getPercentage())
                        .addValue("state", disbursement.getState()));
    }
}
