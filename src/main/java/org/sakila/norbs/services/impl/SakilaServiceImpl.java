package org.sakila.norbs.services.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.sakila.norbs.dto.ActorDTO;
import org.sakila.norbs.mappers.ActorMapper;
import org.sakila.norbs.model.Actor;
import org.sakila.norbs.services.iface.SakilaService;
import org.sakila.norbs.utils.ListSplitUtil;
import org.sakila.norbs.vo.ParentCommonStatusCode;
import org.sakila.norbs.vo.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.sakila.norbs.vo.ResponseVO;
import org.springframework.util.CollectionUtils;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
public class SakilaServiceImpl implements SakilaService {

    @Autowired
    ActorMapper actorMapper;


    public PageInfo<Actor> getAllActors(ActorDTO actorDTO) {
        PageHelper.startPage(actorDTO.getPageNum(),actorDTO.getPageSize());
        List<Actor> actorList= actorMapper.getAllActors(actorDTO);
        return new PageInfo<>(actorList);
    }

    public Actor findActor(ActorDTO actorDTO) {
        return actorMapper.findActor(actorDTO);
    }

    @Override
    public Actor updateActorLastName(ActorDTO actorDTO) {
        return null;
    }


    @Override
    public ResponseVO batchDeleteActor(ActorDTO actorDTO) {
    /*   String[] actorIds = String.valueOf(actorDTO.getActor_id()).split(",");
       List<Integer> Ids = Stream.of(actorIds).map(Integer::valueOf).collect(Collectors.toList());*/

        List<Integer> splitIds = actorDTO.getActorIds();
        //check if id exist
        String errorMsg=verifyIds(actorDTO.getActorIds());
        if(!StringUtils.isNullOrEmpty(errorMsg) && errorMsg.length()>2){
            errorMsg ="The following ids "+ errorMsg + " does not exist!";
            return new ResponseVO(ParentCommonStatusCode.FAILURE.getCode(),errorMsg,errorMsg);
        }
        actorMapper.batchDeleteByIds(splitIds);
       return ResponseHelper.success("Successfully deleted Ids " + actorDTO.getActorIds());
    }



    @Override
    public HttpStatus insertActor(ActorDTO actorDTO){
      int a=  actorMapper.insertActor(actorDTO);
      log.info("insertActorInt:{}",a);
      return HttpStatus.OK;
    }


   @Override
    public ResponseVO batchInsertActor(ActorDTO actorDTO){
        String firstName = actorDTO.getFirstName();
        String lastName = actorDTO.getLastName();
        String [] arrNames1 = firstName.split(",");
        String [] arrNames2 = lastName.split(",");

       //check if firstname and last name does not exist
        String errorMsg=verifyNames(Arrays.stream(arrNames1).collect(Collectors.toList()), Arrays.stream(arrNames2).collect(Collectors.toList()));
        if(!StringUtils.isNullOrEmpty(errorMsg) && errorMsg.length()>2){
            errorMsg ="The following names "+ errorMsg + " already exist!";
            return new ResponseVO(ParentCommonStatusCode.FAILURE.getCode(),errorMsg,errorMsg);
        }

       List<ActorDTO> actorDTOList = new ArrayList<>();
       for (int i = 0; i < arrNames1.length; i++) {
           ActorDTO acD = new ActorDTO();
           acD.setActorId(actorMapper.countIds()+1);
           acD.setFirstName(arrNames1[i]);
           acD.setLastName(arrNames2[i]);
           acD.setCreateAt(LocalDateTime.now());
           acD.setLastUpdate(LocalDateTime.now().toString());
           actorDTOList.add(acD);
           actorMapper.insertSelective(acD);
       }
       List<List<ActorDTO>> returnList = new ArrayList<>();
       returnList.add(actorDTOList);
       return ResponseHelper.success(returnList);
   }

    private String verifyNames(List<String> firstName, List<String> lastName) {
        List<Actor> listNamesInfo = actorMapper.verifyNames(firstName, lastName);
        Map<String, List<Actor>> mapFirstNamesInfo = listNamesInfo.stream().collect(Collectors.groupingBy(Actor::getFirstName));
        Map<String, List<Actor>> mapLastNamesInfo = listNamesInfo.stream().collect(Collectors.groupingBy(Actor::getLastName));

        StringBuffer errorMsg = new StringBuffer();
        List<String> first = new ArrayList<>();
        List<String> last = new ArrayList<>();
        List<String> fullName = new ArrayList<>();
        for (String fName : firstName) {
            if (!CollectionUtils.isEmpty(mapFirstNamesInfo.get(fName))) {
                first.add(fName);
            }
        }
        for (String lName : lastName) {
            if (!CollectionUtils.isEmpty(mapLastNamesInfo.get(lName))) {
                last.add(lName);
            }
        }

        for (int i = 0; i < first.size(); i++) {
            fullName.add(first.get(i) + " " + last.get(i));
        }

       // errorMsg.append("The following accounts " +fullName + " already exist!");
      //  errorMsg.append(StrUtil.format("The following accounts {} already exist!", fullName.stream().collect(Collectors.joining(","))));
        errorMsg.append(String.format("[%s]", fullName.stream().collect(Collectors.joining(","))));


        return errorMsg.toString();
    }


    public String verifyIds(List<Integer> ids) {
        List<Actor> listIds = actorMapper.verifyIds(ids);
        Map<Integer, List<Actor>> mapIds = listIds.stream().collect(Collectors.groupingBy(Actor::getActorId));
        StringBuffer errorMsg = new StringBuffer();
        List<Integer> idsList = new ArrayList<>();
        for (Integer id : ids) {
            if (CollectionUtils.isEmpty(mapIds.get(id))) {
                idsList.add(id);
            }
        }
        errorMsg.append(String.format("[%s]", idsList.stream().map(String::valueOf).collect(Collectors.joining(","))));
        return errorMsg.toString();
    }


    public List<Actor> updateLastNameBatchUpdate(ActorDTO actorDTO) {
        String lastName  = actorDTO.getLastName();
        List<List<Integer>> splitIds = split(actorDTO.getActorIds(),20);
        for (List<Integer> list: splitIds) {
            actorMapper.lastNameBatchUpdate(list,lastName);
            log.info("actor Ids: {} lastName:{}", list,lastName);
        }
        return getActorNames(actorDTO);
    }

    public List<Actor> getActorNames(ActorDTO actorDTO){
        List<Integer> actorIds = actorDTO.getActorIds();
        List<List<Integer>> actors = ListSplitUtil.split(actorIds, 20);
        List<Actor> result = new ArrayList<>();
        for (List<Integer> list : actors) {
            List<Actor> ids = actorMapper.queryActors(list);
                result.addAll(ids);
        }
        return result;
    }


    public static <T> List<List<T>> split (Collection<T> collection, int size) {
        List<List<T>> result = new ArrayList<>();
        ArrayList<T> subList = new ArrayList(size);

        Object t;
        for(Iterator var4 = collection.iterator(); var4.hasNext(); subList.add((T) t)){
            t= var4.next();
            if(subList.size()>=size) {
                result.add(subList);
                subList = new ArrayList(size);
            }
        }
        result.add(subList);
        return result;
    }

    @Override
    public int editActor(List<ActorDTO> list) {
        List<ActorDTO> insertList = new ArrayList<>();
        List<ActorDTO> updateList =new ArrayList<>();

        ActorDTO dto = new ActorDTO();
        for (ActorDTO act : list){
            dto = act;
        }
        //check actor models
        List<Actor> actorModelList = actorMapper.queryActorModelList(dto);
        log.info("actorModelList:{}",actorModelList);
        Map<Integer,Actor> map =actorModelList.stream().collect(Collectors.toMap(Actor::getActorId, ActorModel->ActorModel));
        //compare list
        for (ActorDTO actorDTO: list) {
            actorDTO.setFirstName(actorDTO.getFirstName());
            //get actors
            Actor actorModel = map.get(actorDTO.getActorId());
            log.info("actorDTO MEN {}",actorDTO);
            log.info("actorModel:{}",actorModel);
            if(actorModel==null) {
                //new actors
                actorDTO.setLastUpdate(LocalDateTime.now().toString());
                actorDTO.setActorId(0);
                insertList.add(actorDTO);
                log.info("inserted {}", insertList);
            } else {
                //if first name is different , modify the firstname
                if(!actorModel.getFirstName().equals(actorDTO.getFirstName())) {
                    actorDTO.setActorId(actorDTO.getActorId());
                    updateList.add(actorDTO);
                    log.info("update success! {}", updateList);
                }
            }
        }
        if (insertList.size() > 0) {
            actorMapper.insertActorFirstName(insertList);
        }
        if (updateList.size() > 0) {
            actorMapper.updateActorFirstName(updateList);
        }
        return 0;
    }

    @Override
    public String editActors(ActorDTO actorDTO) {

        List<Actor> recordList = actorMapper.batchSelect(actorDTO);
        log.info("recordList:{}",recordList);
        StringBuffer msg = new StringBuffer();
        List<Integer> updatedActorIds = new ArrayList<>();
        List<Integer> notUpdatedActorIds = new ArrayList<>();

        recordList.forEach(item-> {
            ActorDTO dto = new ActorDTO();
            dto.setFirstName(!actorDTO.getFirstName().equals(item.getFirstName()) ? actorDTO.getFirstName() : "");
            dto.setLastName(!actorDTO.getLastName().equals(item.getLastName()) ? actorDTO.getLastName() : "");
            dto.setActorId(item.getActorId());
            if (!"".equals(dto.getFirstName()) && !"".equals(dto.getLastName())) {
                int updateActorDetails = actorMapper.updateActorDetails(dto);
                log.info("updateActorDetails:{}",updateActorDetails);
                updatedActorIds.add(updateActorDetails==1 ? dto.getActorId() : null);
            } else {
                notUpdatedActorIds.add(dto.getActorId());
            }
        });

        if (updatedActorIds.size() > 0) msg.append(String.format("The following actorIds %s has been updated!",updatedActorIds.toString()));
        if (notUpdatedActorIds.size() > 0) msg.append(String.format("This actorIds %s has not been updated!", notUpdatedActorIds.toString()));

        return msg.toString();
    }

    @Override
    public List<Actor> batchSelectActor(ActorDTO dto) {
      return actorMapper.batchSelect(dto);
    }

    @Override
    public List<Actor> sortRecords(ActorDTO dto) {

        Map<String, String> map = new HashMap<>();
        map.put("24", "Sheesh");
        map.put("1","SWANK");
        map.put("9","JOHANSSON");
        map.put("8","STREEP");

        System.out.println(String.format("unsorted map: %s",map));

        Map<String, String> map1 = getValueSort("String");
        System.out.println(String.format("sorted map: %s",map1));

        List<String> cat = Arrays.asList("1","8","24","9");


        cat.sort((o1,o2)-> {

            if (getSort(o1,map1) < getSort(o2,map1)) {
                return -1;
            } else {
                return 1;
            }
        });


    /*    dto.setActorIds(cat.stream().map(item-> {
                return Integer.parseInt(item);
                }).collect(Collectors.toList()));*/

        dto.setActorIds(cat.stream().map(Integer::parseInt).collect(Collectors.toList()));
        List<Actor> responseVO = actorMapper.getAllActors(dto);
        return responseVO;
    }


    public int getSort(String key, Map<String, String> dict) {
        int sort=0;
        for (String s: dict.keySet()) {
            if(s.equals(key)) {
                break;
            }
            sort++;
        }
        return  sort;
    }

    public Map<String , String> getValueSort(String code) {

        ActorDTO dto = new ActorDTO();
        dto.setActorIds(Arrays.asList(24,1, 8, 9));
        System.out.println(dto.getActorIds());
        List<Actor> responseVO = actorMapper.getAllActors(dto);
        System.out.println("responseVO"+responseVO);
        Assert.isTrue(!responseVO.isEmpty(), "failed to call model"  );
        List<Actor> list = responseVO;
        Map<String , String> map = new LinkedHashMap<>();
        for (Actor v: list) {
            map.put(String.valueOf(v.getActorId()),v.getLastName());
        }
        return map;
    }



}
