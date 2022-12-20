package com.example.springbootjpa.common;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class ServiceBase<T, ID extends Serializable> {


    /*
    @Autowired
    public ServiceBase(final RepositoryBase<T, ID> repository, final ISession session) {
        this.session = session;
        this.repository = repository;
        this.entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }*/
}
