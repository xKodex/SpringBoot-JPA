package com.example.springbootjpa.service;

//import com.example.springbootjpa.repository.ParameterEntitySetupRepository;

import com.example.springbootjpa.repository.ParameterEntitySetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ParameterEntitySetupService {

    @Autowired
    private ParameterEntitySetupRepository setupRepository;

    public Map<String, Object> getParamDataByEntity(String routeGMapCode, String routeCodeField, String gMapCode, String codeField, Date workingDate, String paramCode, Character entityType) {

        // public Map<String, Object> getParamDataByEntity(Optional<String> routeGMapCode, Optional<String> routeCodeField, String gMapCode, String codeField, Date workingDate, String paramCode, Character entityType) {
        Map<String, Object> tableResult = new HashMap<>();
        Map<String, Object> finalMap = new HashMap<>();

        paramCode = "01";
        gMapCode = "02003";
        String organizationCode = "0108";//this.session.getUser().getOrganizationCode();
        List<Map<String, Object>> paramData = setupRepository.getParamDataByEntity(organizationCode, gMapCode, paramCode.concat("%"));
        // List<Map<String, Object>> paramListMap = new ArrayList<>(paramData.size());

        paramData.forEach(param ->{

            System.out.println(param.get("source"));
            Map<String, Object> sourceMap = (Map<String, Object>) param.get("source");



        });

        // finalMap.put("data", paramListMap);
        finalMap.put("dictionary", tableResult);
        //paramListMap.remove(0);
        return finalMap;
    }


}
