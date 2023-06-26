package org.sakila.norbs.mappers;


import org.apache.ibatis.annotations.Mapper;
import org.sakila.norbs.dto.ActorDTOV2;
import org.sakila.norbs.model.Actor;
import org.sakila.norbs.utils.DataSourceMapper;

import java.util.List;

@Mapper
public interface ActorMapperV2  {

     @DataSourceMapper(dataSource = "slave")
     List<Actor> getListActors(ActorDTOV2 actorDTOV2);

     int insertActors(List<ActorDTOV2> insertActorsDTO);

     int deleteActor(ActorDTOV2 dto);

     int updateActor(Actor act);
}
