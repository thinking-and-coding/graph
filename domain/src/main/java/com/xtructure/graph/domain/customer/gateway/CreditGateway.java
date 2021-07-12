package com.xtructure.graph.domain.customer.gateway;

import com.xtructure.graph.domain.customer.Credit;

//Assume that the credit info is in antoher distributed Service
public interface CreditGateway {

    Credit getCredit(String customerId);

}
