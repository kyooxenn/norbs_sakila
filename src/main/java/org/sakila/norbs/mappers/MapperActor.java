package org.sakila.norbs.mappers;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sakila.norbs.model.Actor;
import org.sakila.norbs.model.ModelActor;

import java.util.List;

@Mapper
public interface MapperActor extends BaseMapper<ModelActor> {


    @Select("SELECT actor_id actorId, first_name firstName, last_name lastName, last_update lastUpdate " +
            "FROM actor " +
            "${ew.customSqlSegment} ")
    List<Actor> actorListWrapper(@Param(Constants.WRAPPER) QueryWrapper queryWrapper);
}
