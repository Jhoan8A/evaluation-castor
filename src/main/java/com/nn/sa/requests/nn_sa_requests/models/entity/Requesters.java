package com.nn.sa.requests.nn_sa_requests.models.entity;

import java.util.Date;

import org.hibernate.annotations.Collate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "requesters")
public class Requesters {

    @Id
    @Column(name = "requester_id")
    private Long requesterId;
    private String name;
    private String email;
    private String phone;
    private String address;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
}
