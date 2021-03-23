package com.xtructure.graph.domain.customer.gateway;

import com.xtructure.graph.domain.customer.Customer;

public interface CustomerGateway {
    public Customer getByById(String customerId);
}
