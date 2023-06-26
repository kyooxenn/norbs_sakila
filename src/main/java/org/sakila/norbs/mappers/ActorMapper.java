package org.sakila.norbs.mappers;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sakila.norbs.dto.ActorDTO;
import org.sakila.norbs.dto.v2ActorDTO;
import org.sakila.norbs.model.ActorModel;
import org.sakila.norbs.utils.DataSourceMapper;

import java.util.List;

@Mapper
public interface ActorMapper {

     int updateActorLastName(String lastName, int actorId);

     ActorModel findActor(ActorDTO actorDTO);

     Boolean checkBothFirstLastNames(String firstname,String lastname);

     String checkFirstName(String firstname);

     String checkLastName(String lastname);

     List<ActorModel> getAllActors(ActorDTO actorDTO);

     List<ActorModel> pageGetAllActors();

     Integer countIds();

     List<ActorDTO> verifyNames(@Param("fName") List<String> fName, @Param("lName")List<String> lName);

     List<ActorDTO> verifyIds(@Param("ids") List<Integer> ids);



    // void setAllActorLastName(int actorId,String lastName);

     int batchInsert(@Param("list") List<ActorDTO> list);

     int insertSelective(ActorDTO actorDTO);

     int insertActor(v2ActorDTO actorDTO);

     int batchDeleteByIds(@Param("list") List<Integer> ids);

     int ifIdExist(Integer id);


     List<ActorModel> queryActors(@Param("list") List<Integer> ids);

     int lastNameBatchUpdate(@Param("list") List<Integer> ids , String lastName);

     Page<ActorModel> exportActor();

     @DataSourceMapper(dataSource = "slave")
     List<ActorModel> queryActorModelList(ActorDTO dto);

     int insertActorFirstName(List<ActorDTO> insertList);

     int updateActorFirstName(List<ActorDTO> updateList);

     List<ActorModel> batchSelect(v2ActorDTO v2ActorDTO);

     int updateActorDetails(v2ActorDTO v2ActorDTO);
}
