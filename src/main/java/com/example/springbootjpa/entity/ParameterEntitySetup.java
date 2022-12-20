package com.example.springbootjpa.entity;


import com.example.springbootjpa.common.EntityBase;
import com.example.springbootjpa.common.Json2MapConverter;
import com.example.springbootjpa.entity.keys.ParameterEntitySetupPK;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "GGL_GM_PES_PARAM_ENT_SETUP")
@IdClass(ParameterEntitySetupPK.class)
public class ParameterEntitySetup extends EntityBase {

    private String organizationCode;
    private String gMapCode;
    private String paramCode;
    private String parentCode;
    /*private String value;*/
    private String active;
    private Double entityOrder;


    @Basic
    @Column(name = "GPES_PARENT_CODE", nullable = true, length = 12,precision = 10)
    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    private Map<String, Object> source;
    private String valueType;

    private ParameterSetup parameterSetup;

    @Id
    @Column(name = "PORG_ORGACODE", nullable = false, insertable = false, updatable = false, length = 70)
    public String getOrganizationCode() {
        return organizationCode;
    }
    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    @Id
    @Column(name = "GGES_GMAPCODE", nullable = false, insertable = false, updatable = false, length = 70)
    public String getgMapCode() {
        return gMapCode;
    }
    public void setgMapCode(String gMapCode) {
        this.gMapCode = gMapCode;
    }

    @Id
    @Column(name = "GPMS_PARAM_CODE", nullable = false, insertable = false, updatable = false, length = 70)
    public String getParamCode() {
        return paramCode;
    }
    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }



    @Basic
    @Column(name = "GPES_ORDER", nullable = true, length = 12,precision = 10)
    public Double getEntityOrder() {
        return entityOrder;
    }
    public void setEntityOrder(Double entityOrder) {
        this.entityOrder = entityOrder;
    }

    @Basic
    @Column(name = "GPES_ACTIVE", nullable = true, length = 1)
    public String getActive() {
        return active;
    }
    public void setActive(String active) {
        this.active = active;
    }

    @Basic
   // @Column(name = "GPES_SOURCE", nullable = true,length = 2147483647)
    @Column(name = "GPES_SOURCE", nullable = true,length = 1000000)
    @Convert(converter = Json2MapConverter.class)
    public Map<String, Object> getSource() {
        return source;
    }
    public void setSource(Map<String, Object> source) {
        this.source = source;
    }

    @Basic
    @Column(name = "GPES_VALUE_TYPE", nullable = false, length = 1)
    public String getValueType() {
        return valueType;
    }
    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "GPMS_PARAM_CODE", referencedColumnName = "GPMS_PARAM_CODE", insertable = false, updatable = false)
    })
    public ParameterSetup getParameterSetup() {
        return parameterSetup;
    }
    public void setParameterSetup(ParameterSetup parameterSetup) {
        this.parameterSetup = parameterSetup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParameterEntitySetup that = (ParameterEntitySetup) o;

        if (!organizationCode.equals(that.organizationCode)) return false;
        if (!gMapCode.equals(that.gMapCode)) return false;
        return paramCode.equals(that.paramCode);
    }

    @Override
    public int hashCode() {
        int result = organizationCode.hashCode();
        result = 31 * result + gMapCode.hashCode();
        result = 31 * result + paramCode.hashCode();
        return result;
    }


}
