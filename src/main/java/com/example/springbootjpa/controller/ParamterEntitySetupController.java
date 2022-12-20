package com.example.springbootjpa.controller;

import com.example.springbootjpa.common.RestControllerBase;
import com.example.springbootjpa.common.ServiceBase;
import com.example.springbootjpa.entity.ParameterEntitySetup;
import com.example.springbootjpa.entity.ParameterSetup;
import com.example.springbootjpa.entity.keys.ParameterEntitySetupPK;
import com.example.springbootjpa.entity.keys.ParameterSetupPK;
import com.example.springbootjpa.service.ParameterEntitySetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.*;


@RestController
@RequestMapping(value = "/api/param-setup")
public class ParamterEntitySetupController extends RestControllerBase<ParameterSetup, ParameterSetupPK> {

    @Autowired
    private ParameterEntitySetupService setupService;

    /*public ParamterEntitySetupController(ServiceBase<ParameterEntitySetup, ParameterEntitySetupPK> service) {
        super(service);
        this.setupService = (ParameterEntitySetupService) service;
    }*/

    /*@GetMapping(value = {"/get-entity/{gMapCode}/{codeField}/{paramCode}/{entityType}", "/get-entity/{gMapCode}/{codeField}/{paramCode}/{entityType}/{routeGMapCode}/{routeCodeField}"})
    public Map<String, Object> getParameterSetupByEntity(@PathVariable(value = "gMapCode") String gMapCode,
                                                         @PathVariable(value = "codeField") String codeField,
                                                         @PathVariable(value = "paramCode") String paramCode,
                                                         @PathVariable(value = "entityType") Character entityType,
                                                         @PathVariable(value = "routeGMapCode") Optional<String> routeGMapCode,
                                                         @PathVariable(value = "routeCodeField") Optional<String> routeCodeField,
                                                         @RequestParam(value = "workingDate", required = false)
                                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date workingDate) {
        return setupService.getParamDataByEntity(routeGMapCode, routeCodeField, gMapCode, codeField, workingDate, paramCode, entityType);
    }*/

//@PathVariable(value = "gMapCode") String gMapCode, @PathVariable(value = "codeField") String codeField
    @GetMapping(value = {"/get-entity/{gMapCode}/{codeField}"})//{gMapCode}/{codeField}
    public Map<String, Object> getParameterSetupByEntity(@PathVariable(value = "gMapCode") String gMapCode, @PathVariable(value = "codeField") String codeField) {

        String routeGMapCode ="";
        String routeCodeField = "";
        String paramCode = "01";
        gMapCode = "02003";
        Date workingDate = Date.from(Instant.now());
        Character entityType='E';

        return setupService.getParamDataByEntity(routeGMapCode, routeCodeField, gMapCode, codeField, workingDate, paramCode, entityType);
     //   return setupService.getParamDataByEntity();
    }
}

