package org.sakila.norbs.mappers;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sakila.norbs.dto.ActorDTO;
import org.sakila.norbs.model.Actor;

import java.util.List;

@Mapper
public interface ActorMapper {

     int updateActorLastName(String lastName, int actorId);

     Actor findActor(ActorDTO actorDTO);

     Boolean checkBothFirstLastNames(String firstname,String lastname);

     String checkFirstName(String firstname);

     String checkLastName(String lastname);

     List<Actor> getAllActors(ActorDTO actorDTO);

     List<Actor> pageGetAllActors();

     Integer countIds();

     List<Actor> verifyNames(@Param("fName") List<String> fName, @Param("lName")List<String> lName);

     List<Actor> verifyIds(@Param("ids") List<Integer> ids);



    // void setAllActorLastName(int actorId,String lastName);

     int batchInsert(@Param("list") List<ActorDTO> list);

     int insertSelective(ActorDTO actorDTO);

     int insertActor(ActorDTO actorDTO);

     int batchDeleteByIds(@Param("list") List<Integer> ids);

     int ifIdExist(Integer id);


     List<Actor> queryActors(@Param("list") List<Integer> ids);

     int lastNameBatchUpdate(@Param("list") List<Integer> ids , String lastName);

     Page<Actor> exportActor();

     List<Actor> queryActorModelList(ActorDTO dto);

     int insertActorFirstName(List<ActorDTO> insertList);

     int updateActorFirstName(List<ActorDTO> updateList);

     List<Actor> batchSelect(ActorDTO dto);

     int updateActorDetails(ActorDTO dto);
}
