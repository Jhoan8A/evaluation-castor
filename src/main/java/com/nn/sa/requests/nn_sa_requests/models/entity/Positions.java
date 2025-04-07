package com.nn.sa.requests.nn_sa_requests.models.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "positions")
public class Positions {

    @Id
    @Column(name = "position_id")
    private Long positionId;
    private String name;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
}
