package org.sakila.norbs.services.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.sakila.norbs.config.cache.RedisService;
import org.sakila.norbs.dto.ActorDTOV2;
import org.sakila.norbs.dto.ActorRecordRequest;
import org.sakila.norbs.mappers.ActorMapperV2;
import org.sakila.norbs.mappers.MapperActor;
import org.sakila.norbs.model.Actor;
import org.sakila.norbs.model.ModelActor;
import org.sakila.norbs.services.iface.SakilaServiceV2;
import org.sakila.norbs.utils.CollectionUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class SakilaServiceV2Impl implements SakilaServiceV2 {

    @Resource
    private ActorMapperV2 actorMapperV2;

    @Resource
    private MapperActor mapperActor;


    @Resource
    private RedisService redisService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;



    @Override
    public PageInfo<Actor> getListActors(ActorDTOV2 actorDTOV2) {
        PageHelper.startPage(actorDTOV2.getPageNum(),actorDTOV2.getPageSize());

        List<Actor> getListActors = actorMapperV2.getListActors(actorDTOV2);

        if(CollectionUtil.isNotEmpty(getListActors)) {
            PageInfo pageInfo = new PageInfo<>(getListActors);
            pageInfo.setTotal(((Page<Actor>)getListActors).getTotal());
           // pageInfo.setTotal(((Page)getListActors).getTotal());
            pageInfo.setSize(actorDTOV2.getPageSize());
            pageInfo.setPageNum(actorDTOV2.getPageNum());
            log.info("pageTotal:{}",pageInfo.getTotal());
            return pageInfo;
            /*return new PageInfo<>(getListActors);*/
        }

        return new PageInfo<>();
    }






    @Override
    public String insertActors(List<ActorDTOV2> dto) {

        List<ActorDTOV2> insertActorsDTO = new ArrayList<>();
        List<ActorDTOV2> existingActorsDTO = new ArrayList<>();
        List<String> existingNames = new ArrayList<>();
        List<String> insertNames = new ArrayList<>();
        StringBuffer msg = new StringBuffer();
        dto.forEach(item-> {
            List<Actor> verifyActors = verifyActors(item.getFirstName(), item.getLastName());
            log.info("verifyActors:{}",verifyActors);

            if(verifyActors.size() == 0) {
                insertNames.add(String.format("%s %s", item.getFirstName(),item.getLastName()));
                insertActorsDTO.add(item);
            } else {
                existingNames.add(String.format("%s %s", item.getFirstName(),item.getLastName()));
                existingActorsDTO.add(item);
            }
        });

        if(insertActorsDTO.size() > 0) {
            msg.append(String.format("Actors: %s has been added! ",insertNames));
            int i = actorMapperV2.insertActors(insertActorsDTO);
            log.info("insertActorsValue:{}",i);

        }
        if(existingActorsDTO.size() > 0){
            msg.append(String.format("Actors: %s already exist!",existingNames));
        }

        return msg.toString();
    }

    public List<Actor> verifyActors(String firstName, String lastName) {
        ActorDTOV2 dto = new ActorDTOV2();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setActorIds(Arrays.asList());

        List<Actor> actorList = actorMapperV2.getListActors(dto);

        if (CollectionUtil.isNotEmpty(actorList)) {
            return actorList;
        }
        return Collections.emptyList();
    }


    @Override
    public int deleteActor(ActorDTOV2 dto) {

        int i  = actorMapperV2.deleteActor(dto);
        if(i>0) return 1;
        return 0;
    }

    @Override
    public Integer updateActor(ActorDTOV2 dto) {

        Actor act = new Actor();
        act.setFirstName(dto.getFirstName());
        act.setLastName(dto.getLastName());
        act.setActorId(dto.getActorId());

        int i = actorMapperV2.updateActor(act);
        log.info("i:{}",i);
        if (i > 0) return 1;

        return 0;
    }

    @Override
    public Object differenceList(ActorDTOV2 dto) {
        List<String> list1 = Arrays.asList("norbs","herms","ludslec","Luslec");
        List<String> list2 = Arrays.asList("norbs","herms","luslec","boss");
        List<String> max = list1;
        List<String> min = list2;
        List<String> diff = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>(list1.size() + list2.size());
        boolean ignoreCase = dto.getIgnoreCase();

        if (list2.size() > list1.size()) {
            max = list2;
            min = list1;
        }

        for (String string : max) {
            map.put(ignoreCase ? string.toLowerCase() : string, 1);
        }

        for (String string : min) {
            String key = ignoreCase ? string.toLowerCase() : string;
            Integer cc = map.get(key);
            if (cc != null) {
                map.put(key,++cc);
                continue;
            }
            map.put(key,1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value.equals(1)) {
                diff.add(key);
            }
        }

        return diff;
    }

    @Override
    public List<Actor> getActorList(ActorRecordRequest request) {

       // request.setActorIds(Arrays.asList(1,2,3));
        QueryWrapper<ModelActor> queryWrapper=new QueryWrapper<>();

        if (CollectionUtil.isNotEmpty(request.getActorIds())) {
            queryWrapper.in("actor_id",request.getActorIds());
        }

        Long start = System.currentTimeMillis();
        List<Actor> actorList = mapperActor.actorListWrapper(queryWrapper);
        String redisKey = "actor:actorDetails";
        List<Actor> redisValue = redisService.get(redisKey);

        if (null == redisValue) {
            redisService.set(redisKey,actorList);
            Long end = System.currentTimeMillis();
            Long duration = end-start;
            System.out.println(TimeUnit.MILLISECONDS.toMillis(duration));
            return redisService.get(redisKey);

        }


        /**
         *
         * try redis
         * */
        Map<String, Object> map = new HashMap<>();
        map.put("status", Convert.toStr(1));
        map.put("permission", "sdsfs");

        redisTemplate.opsForHash().putAll("norbs", map);
        redisTemplate.expire("norbs",1,TimeUnit.MINUTES);


        String key = "hello";
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,true);
        redisTemplate.expire(key,1,TimeUnit.MINUTES);

        log.info("redisCache{}", redisTemplate.opsForValue().get("hello"));


        log.info("re{}", redisTemplate.opsForHash().entries("norbs"));


     //   System.out.println(redisTemplate.getClientList());


        Long start1 = System.currentTimeMillis();
        log.info("new:{}",actorList);
       /* Actor add = actorList.get(0);
        actorList.add(add);*/
        if (!actorList.equals(redisValue)) {
            System.out.println("alright! lets go");
            redisService.set(redisKey,actorList);
        }

        redisValue = redisService.get(redisKey);
        Long end1 = System.currentTimeMillis();
        Long duration1 = end1-start1;
        System.out.println(TimeUnit.MILLISECONDS.toMillis(duration1));
        log.info("redisValue: {}", redisValue);
        return redisValue;
    }

}
