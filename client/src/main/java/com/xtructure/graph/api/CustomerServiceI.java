package com.xtructure.graph.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.xtructure.graph.dto.CustomerAddCmd;
import com.xtructure.graph.dto.CustomerListByNameQry;
import com.xtructure.graph.dto.data.CustomerDTO;

public interface CustomerServiceI {

    Response addCustomer(CustomerAddCmd customerAddCmd);

    MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
