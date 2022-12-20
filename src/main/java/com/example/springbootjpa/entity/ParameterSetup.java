package com.example.springbootjpa.entity;

import com.example.springbootjpa.common.EntityBase;
import com.example.springbootjpa.entity.keys.ParameterSetupPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "GGL_GM_PMS_PARAMETER_SETUP")
@IdClass(ParameterSetupPK.class)
public class ParameterSetup extends EntityBase {//
    private String paramCode;
    private String paramDesc;
    private String value;
    private String parentCode;
    private String levelType;

    //private Collection<ParameterEntitySetup> setupList;

    @Column(name = "GPMS_PARAM_CODE", nullable = false, length = 70)
    @Id
    public String getParamCode() {
        return paramCode;
    }
    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    @Basic
    @Column(name = "GPMS_PARAM_DESC", length = 300, nullable = true)//, table = "GGL_GM_PMS_PARAMETER_SETUP_M"
    public String getParamDesc() {
        return paramDesc;
    }
    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }

    @Basic
    @Column(name = "GPMS_DEFAULT_VALUE", nullable = true, length = 10)
    public String getDefaultValue() {
        return value;
    }
    public void setDefaultValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "GPMS_PARENT_CODE", nullable = true, length = 70)
    public String getParentCode() {
        return parentCode;
    }
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    @Basic
    @Column(name = "GPMS_LEVELTYPE", nullable = true, length = 1)
    public String getLevelType() {
        return levelType;
    }
    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }
/*
    @JsonIgnore
    @OneToMany(mappedBy = "parameterSetup")
    public Collection<ParameterEntitySetup> getSetupList() {
        return setupList;
    }
    public void setSetupList(Collection<ParameterEntitySetup> setupList) {
        this.setupList = setupList;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParameterSetup that = (ParameterSetup) o;

        return paramCode.equals(that.paramCode);
    }

    @Override
    public int hashCode() {
        return paramCode.hashCode();
    }


}
