package com.example.springbootjpa.common;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})//, MultiLingualListener.class, EntityBaseAuditListener.class,
        //ParaLevelValidation.class, IsDefaultValidation.class, SequenceNumberGenerator.class, ReferenceNumberGenerator.class,ParaLevelNumberGeneration.class})
public class EntityBase implements Serializable {

    private String createdBy;

    private Date createdDate;

    private String modifiedBy;

    private Date modifiedDate;

    @CreatedBy
    //@Sequence(value = 1001)
    @Column(name = "CREATED_BY", nullable = false, length = 50)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @CreatedDate
   //@Sequence(value = 1002)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @LastModifiedBy
    //@Sequence(value = 1003)
    @Column(name = "MODIFIED_BY", nullable = false, length = 50)
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Version
    @LastModifiedDate
    //@Sequence(value = 1004)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_DATE", nullable = false)
    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
