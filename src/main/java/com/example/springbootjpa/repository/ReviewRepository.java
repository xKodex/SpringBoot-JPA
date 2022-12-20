package com.example.springbootjpa.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ReviewRepository {

    @Autowired
    EntityManager em;
    private Logger logger= LoggerFactory.getLogger(this.getClass());


}
