package com.nn.sa.requests.nn_sa_requests.models.dao;
import org.springframework.data.repository.CrudRepository;

import com.nn.sa.requests.nn_sa_requests.models.entity.Request;

public interface IRequestDao extends CrudRepository<Request,Long> {

}
