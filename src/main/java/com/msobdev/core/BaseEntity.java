package com.msobdev.core;


import javax.persistence.*;

/**
 * Created by sob1 on 21.07.2017.
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    @Version
    private Long version;

    protected BaseEntity() {
        id = null;
    }
}
