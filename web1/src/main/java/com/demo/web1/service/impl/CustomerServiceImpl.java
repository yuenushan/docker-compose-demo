package com.demo.web1.service.impl;

import com.demo.web1.domain.CustomerDomain;
import com.demo.web1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CustomerDomain> gets() {
        return jdbcTemplate.query("SELECT * FROM customers", BeanPropertyRowMapper.newInstance(CustomerDomain.class));
    }
}
