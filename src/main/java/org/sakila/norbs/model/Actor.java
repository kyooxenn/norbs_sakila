package org.sakila.norbs.model;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Actor {
    private int actorId;
    private String firstName;
    private String lastName;
    private String lastUpdate;
}
