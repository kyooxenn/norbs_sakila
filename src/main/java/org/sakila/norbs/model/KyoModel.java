package org.sakila.norbs.model;

import lombok.Data;

@Data
public class KyoModel {

    private String key;

    private String value;



    public KyoModel(String key, String value) {
        this.key= key;
        this.value = value;
    }

}
