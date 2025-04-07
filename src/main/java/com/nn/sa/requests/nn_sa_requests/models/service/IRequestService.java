package com.nn.sa.requests.nn_sa_requests.models.service;

import java.util.List;

import com.nn.sa.requests.nn_sa_requests.models.entity.Request;

public interface IRequestService {

    public List<Request> findAll();

    public Request findById(Long id);

    public Request save(Request client);

    public void delete(Long id);
}
