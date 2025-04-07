package com.nn.sa.requests.nn_sa_requests.models.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "service_request_detail")
public class ServiceRequestDetail {
    @Id
    @Column(name = "detail_id")
    private Long detailId;
    @Column(name = "request_id")
    private long requestId;
    @Column(name = "service_id")
    private long serviceId;
    private String observations;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

}
