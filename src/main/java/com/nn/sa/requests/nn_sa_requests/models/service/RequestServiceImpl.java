package com.nn.sa.requests.nn_sa_requests.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nn.sa.requests.nn_sa_requests.models.dao.IRequestDao;
import com.nn.sa.requests.nn_sa_requests.models.entity.Request;

import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestServiceImpl implements IRequestService {

    @Autowired
    private IRequestDao requestDao;

    @Override
    @Transactional(readOnly = true)
    public List<Request> findAll() {
        return (List<Request>) requestDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Request findById(Long id) {
        return requestDao.findById(id).orElse(null);
    }

    @Override
    public Request save(Request request) {
        return requestDao.save(request);
    }

    @Override
    public void delete(Long id) {
        requestDao.deleteById(id);
    }

}
