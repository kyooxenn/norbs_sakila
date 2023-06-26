package org.sakila.norbs.services.iface;

import com.github.pagehelper.PageInfo;
import org.sakila.norbs.dto.ActorDTO;
import org.sakila.norbs.dto.v2ActorDTO;
import org.sakila.norbs.model.ActorModel;
import org.sakila.norbs.vo.ResponseVO;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface SakilaService {

    List<ActorModel> getAllActors(ActorDTO actorDTO);

    PageInfo pageGetAllActors();

    ActorModel findActor(ActorDTO actorDTO);

    ActorModel updateActorLastName(ActorDTO actorDTO);

    ResponseVO batchInsertActor(ActorDTO actorDTO);

    String insertActor(v2ActorDTO actorDTO);

    List<ActorModel> updateLastNameBatchUpdate(ActorDTO actorDTO);

    List<ActorModel> getActorNames(ActorDTO actorDTO);

    ResponseVO batchDeleteActor(ActorDTO actorDTO);

    ByteArrayInputStream exportActor();

    int editActor(List<ActorDTO> dto);

    String editActors (v2ActorDTO v2ActorDTO);

    List<ActorModel> batchSelectActor (v2ActorDTO dto);

    List<ActorModel> sortRecords(ActorDTO dto);
}
