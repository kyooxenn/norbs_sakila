package org.sakila.norbs.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class v2ActorDTO {

        private Integer actorId;
        @NotBlank(message = "firstname must be not empty")
        private String firstName;
        private String lastName;
        private String lastUpdate;
        private List<Integer> actorIds;

}
