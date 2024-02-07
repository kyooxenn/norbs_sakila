package org.sakila.norbs.services.iface;

import com.github.pagehelper.PageInfo;
import org.sakila.norbs.dto.ActorDTO;
import org.sakila.norbs.model.Actor;
import org.sakila.norbs.vo.ResponseVO;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface SakilaService {

    PageInfo<Actor> getAllActors(ActorDTO actorDTO);


    Actor findActor(ActorDTO actorDTO);

    Actor updateActorLastName(ActorDTO actorDTO);

    ResponseVO batchInsertActor(ActorDTO actorDTO);

    HttpStatus insertActor(ActorDTO actorDTO);

    List<Actor> updateLastNameBatchUpdate(ActorDTO actorDTO);

    List<Actor> getActorNames(ActorDTO actorDTO);

    ResponseVO batchDeleteActor(ActorDTO actorDTO);


    int editActor(List<ActorDTO> dto);

    String editActors (ActorDTO actorDTO);

    List<Actor> batchSelectActor (ActorDTO actorDTO);

    List<Actor> sortRecords(ActorDTO actorDTO);
}
