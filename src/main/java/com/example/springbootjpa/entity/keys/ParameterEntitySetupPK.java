package com.example.springbootjpa.entity.keys;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ParameterEntitySetupPK implements Serializable {

    private String organizationCode;
    private String gMapCode;
    private String paramCode;

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

}
