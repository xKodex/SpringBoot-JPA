package com.example.springbootjpa.repository;

import com.example.springbootjpa.common.RepositoryBase;
import com.example.springbootjpa.entity.ParameterEntitySetup;
import com.example.springbootjpa.entity.keys.ParameterEntitySetupPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface ParameterEntitySetupRepository extends RepositoryBase<ParameterEntitySetup, ParameterEntitySetupPK>//,ParameterEntitySetupCustomRepository
{
    @Query(value = "select p.paramCode as code, t.paramDesc as desc , p.valueType as valueType, p.source as source, t.levelType as levelType, t.parentCode as parentCode from ParameterEntitySetup p inner join p.parameterSetup t where p.organizationCode = ?1 and p.gMapCode = ?2 and p.paramCode like ?3 order by p.entityOrder")
    List<Map<String, Object>> getParamDataByEntity(String orgCode, String gMapCode, String paramCode);
}


