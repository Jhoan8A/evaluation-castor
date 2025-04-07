package com.nn.sa.requests.nn_sa_requests.models.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "request_status")
public class RequestStatus {
    @Id
    private long status_id;
    private String name;
    private String description;
    private String color;
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAtDate;

}
