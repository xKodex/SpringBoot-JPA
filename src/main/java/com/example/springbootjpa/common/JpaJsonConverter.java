package com.example.springbootjpa.common;

import com.google.gson.Gson;

import javax.persistence.AttributeConverter;
import java.lang.reflect.ParameterizedType;

public class JpaJsonConverter<X> implements AttributeConverter<X, String> {
    private Gson gson;

    public JpaJsonConverter() {
        this.gson = new Gson ();
    }

    @Override
    public String convertToDatabaseColumn(X attribute) {
        return this.gson.toJson (attribute);
    }

    @Override
    public X convertToEntityAttribute(String dbData) {
        if(dbData!=null){
            return this.gson.fromJson (dbData, ((ParameterizedType) this.getClass ().getGenericSuperclass ()).getActualTypeArguments ()[0]);
        }else{
            return null;
        }
    }
}
