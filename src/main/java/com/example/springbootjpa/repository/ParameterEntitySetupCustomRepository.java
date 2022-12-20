package com.example.springbootjpa.repository;

import javax.persistence.Tuple;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ParameterEntitySetupCustomRepository {

    Tuple getNonAggregatedValueEntity(String orgaCode, String gMapCode, String codeField, Optional<Tuple> deviceLatlng, String gMapCodeRef, String codeFieldRef, Date workingDate, List<Map<String, Object>> selectColumns);

    Tuple getAggregatedValueEntity(String orgCode, Optional<Tuple> deviceLatlngOptional, String gMapCodeRef, String codeFieldRef, List<Map<String, Object>> selectColumns, boolean isRoute);

}
