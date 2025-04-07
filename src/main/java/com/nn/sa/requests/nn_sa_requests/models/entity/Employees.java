package com.nn.sa.requests.nn_sa_requests.models.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "employees")
public class Employees {

    @Id
    private Long id;
    @Column(name = "identificador_number")
    private Long identificadorNumber;
    private String name;
    @Column(name = "hire_date")
    private Date hireDate;
    @Column(name = "podition_id")
    private Long positionId;
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAtDate;

}
