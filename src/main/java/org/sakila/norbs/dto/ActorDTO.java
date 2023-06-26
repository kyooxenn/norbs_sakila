package org.sakila.norbs.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.sakila.norbs.vo.PageVO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
public class ActorDTO extends PageVO implements Serializable {


    /**
     * Udemy Account
     * Username: rochanbert@yahoo.com
     * Password: Angmailissapatx10
     *
     *
     *
     * */




    private int actor_id;


    private String first_name;
    private String last_name;
    private String last_update;
    private LocalDateTime created_at;
    private List<Integer> actorIds;

    private String fullNameStr;

    public String getFullName() {
        return first_name+"/"+last_name;
        //return String.format("Full name is %s", String.join("/", first_name,last_name));

    }
}
