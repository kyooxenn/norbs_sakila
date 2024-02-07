package org.sakila.norbs.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseDto implements Serializable {
    public static final long serialVersionUID = 6572240406576656734L;

    private int pageNum = 1;

    private int pageSize = 10;

}
