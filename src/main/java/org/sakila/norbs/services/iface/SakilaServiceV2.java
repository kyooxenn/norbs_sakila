package org.sakila.norbs.services.iface;

import com.github.pagehelper.PageInfo;
import org.sakila.norbs.dto.ActorDTOV2;
import org.sakila.norbs.dto.ActorRecordRequest;
import org.sakila.norbs.model.Actor;

import java.util.List;


public interface SakilaServiceV2 {

    PageInfo<Actor> getListActors (ActorDTOV2 actorDTOV2);


    String insertActors(List<ActorDTOV2> dto);

    int deleteActor(ActorDTOV2 dto);

    Integer updateActor(ActorDTOV2 dto);

    Object differenceList(ActorDTOV2 dto);

    List<Actor> getActorList(ActorRecordRequest request);
}
