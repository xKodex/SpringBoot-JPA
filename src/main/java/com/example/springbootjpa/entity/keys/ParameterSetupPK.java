package com.example.springbootjpa.entity.keys;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ParameterSetupPK implements Serializable {
    private String paramCode;

    @Column(name = "GPMS_PARAM_CODE", nullable = false, length = 70)
    @Id
    public String getParamCode() {
        return paramCode;
    }
    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }
}
