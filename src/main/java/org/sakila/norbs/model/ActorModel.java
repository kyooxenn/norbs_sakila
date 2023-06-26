package org.sakila.norbs.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActorModel {
    private int actorId;
    private String firstName;
    private String lastName;
    private String lastUpdate;
    private BigDecimal depositBase;

}
