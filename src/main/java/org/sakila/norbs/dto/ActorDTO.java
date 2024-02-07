package org.sakila.norbs.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
public class ActorDTO extends BaseDto implements Serializable {


    /**
     * Udemy Account
     * Username: rochanbert@yahoo.com
     * Password: Angmailissapatx10
     *
     *
     *
     * */

    private int actorId;
    private String firstName;
    private String lastName;
    private String lastUpdate;
    private LocalDateTime createAt;
    private List<Integer> actorIds;
    private String fullNameStr;

    public String getFullName() {
        return new StringBuilder(firstName+"/"+lastName).toString();
    }
}
