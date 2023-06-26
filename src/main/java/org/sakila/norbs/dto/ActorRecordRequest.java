package org.sakila.norbs.dto;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class ActorRecordRequest {

    @ApiParam(name = "actorId", value = "actorId")
    private Integer actorId;

    @NotBlank(message = "firstname must be not empty")
    @ApiParam(name = "firstName", value = "actorFirstName")
    private String firstName;

    @ApiParam(name = "lastName", value = "actorLastName")
    private String lastName;

    @ApiParam(name = "lastUpdate", value = "actorLastUpdate")
    private String lastUpdate;

    @ApiParam(name = "actorIds", value = "actorIdsList")
    private List<Integer> actorIds;

    @ApiParam(name = "ignoreCase", value = "ignoreCaseLetters")
    private Boolean ignoreCase;


    @ApiParam(name="page",value = "Current page")
    private Integer page = 1;

    @ApiParam(name="pagesize",value = "Number of bars per page", required = true)
    private Integer pagesize=10;
}
