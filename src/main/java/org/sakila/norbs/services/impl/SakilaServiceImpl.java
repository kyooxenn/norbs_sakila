package org.sakila.norbs.services.impl;

import com.github.pagehelper.PageInfo;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.sakila.norbs.dto.ActorDTO;
import org.sakila.norbs.dto.v2ActorDTO;
import org.sakila.norbs.mappers.ActorMapper;
import org.sakila.norbs.model.ActorModel;
import org.sakila.norbs.services.iface.SakilaService;
import org.sakila.norbs.utils.ListSplitUtil;
import org.sakila.norbs.vo.ParentCommonStatusCode;
import org.sakila.norbs.vo.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.sakila.norbs.utils.CollectionUtil;
import org.sakila.norbs.utils.ExportActorCsvHelper;
import org.sakila.norbs.vo.ResponseVO;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
public class SakilaServiceImpl implements SakilaService {

    @Autowired
    ActorMapper actorMapper;


    public List<ActorModel> getAllActors(ActorDTO actorDTO) {
        return actorMapper.getAllActors(actorDTO);
    }

    public PageInfo pageGetAllActors() {
      List<ActorModel> list =  actorMapper.pageGetAllActors();
      /*  if(CollectionUtil.isNotEmpty(pageInfo.getList())) {
            pageInfo.getList().forEach(item-> {
                item.setFirstName("norbs");
            });
        }*/


    /*    Map<Integer, ActorModel> map = pageInfo.getList().stream().collect(Collectors.toMap(ActorModel::getActorId, ActorModel-> ActorModel));
        for (ActorModel list: pageInfo.getList()) {
            ActorModel actorModel = map.get(list.getActorId());
            log.info("actorModel {}",actorModel);
        }*/



        // String name = pageInfo.getList().stream().map(ActorModel::getFirstName).filter(Objects::nonNull).reduce(String::join).get().toLowerCase();
        // log.info("name {}", name);

      /*  List<ActorModel> newList = pageInfo.getList().stream()
                .peek(f -> f.setFirstName("hermsss"))
                .collect(Collectors.toList());


        List<ActorModel> nwList = pageInfo.getList().stream()
                .peek(t->{

                    t.setFirstName("herms");
                    t.setLastName("norbs");
                })
                .collect(Collectors.toList());*/
        return new PageInfo<>(list);
    }

    public ActorModel findActor(ActorDTO actorDTO) {
        return actorMapper.findActor(actorDTO);
    }

    public ActorModel updateActorLastName(ActorDTO actorDTO) {
        int getActors = actorMapper.updateActorLastName(actorDTO.getLast_name(), actorDTO.getActor_id());
        ActorModel actorModels =actorMapper.findActor(actorDTO);

        return actorModels;

   /*     List<ActorModel> getActors = actorMapper.getAllActors();

        //initialization

        //alternate for each
       *//* getActors.forEach((v)->
                System.out.println("Hello"));
*//*

        int i = 0;
        for (ActorModel list : getActors) {

            list.setLastName("Coronado");
            System.out.println("Name: " + getActors.get(i).getLastName() + "  id: " + getActors.get(i).getActorId());
            actorMapper.setAllActorLastName(getActors.get(i).getActorId(), list.getLastName());

            i += 1;
        }*/

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
    public String insertActor(v2ActorDTO actorDTO){
      int a=  actorMapper.insertActor(actorDTO);
      log.info("insertActorInt:{}",a);
        return "Success!";
    }


   @Override
    public ResponseVO batchInsertActor(ActorDTO actorDTO){
        String firstName = actorDTO.getFirst_name();
        String lastName = actorDTO.getLast_name();
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
          // boolean isExist = actorMapper.checkBothFirstLastNames(arrNames1[i], arrNames2[i]);
          // if (!isExist) {
               ActorDTO acD = new ActorDTO();
               acD.setActor_id(actorMapper.countIds()+1);
               acD.setFirst_name(arrNames1[i]);
               acD.setLast_name(arrNames2[i]);
               acD.setCreated_at(LocalDateTime.now());
               acD.setLast_update("");
               actorDTOList.add(acD);
               actorMapper.insertSelective(acD);
        //   }
       }
       List<List<ActorDTO>> returnList = new ArrayList<>();
       returnList.add(actorDTOList);
       return ResponseHelper.success(returnList);
   }

    private String verifyNames(List<String> firstName, List<String> lastName) {
        List<ActorDTO> listNamesInfo = actorMapper.verifyNames(firstName, lastName);
        Map<String, List<ActorDTO>> mapFirstNamesInfo = listNamesInfo.stream().collect(Collectors.groupingBy(ActorDTO::getFirst_name));
        Map<String, List<ActorDTO>> mapLastNamesInfo = listNamesInfo.stream().collect(Collectors.groupingBy(ActorDTO::getLast_name));

        StringBuffer errorMsg = new StringBuffer();
        List<String> first = new ArrayList<>();
        List<String> last = new ArrayList<>();
        List<String> fullName = new ArrayList<>();
        for (String fName : firstName) {
            if (!CollectionUtil.isEmpty(mapFirstNamesInfo.get(fName))) {
                first.add(fName);
            }
        }
        for (String lName : lastName) {
            if (!CollectionUtil.isEmpty(mapLastNamesInfo.get(lName))) {
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
        List<ActorDTO> listIds = actorMapper.verifyIds(ids);
        Map<Integer, List<ActorDTO>> mapIds = listIds.stream().collect(Collectors.groupingBy(ActorDTO::getActor_id));
        StringBuffer errorMsg = new StringBuffer();
        List<Integer> idsList = new ArrayList<>();
        for (Integer id : ids) {
            if (CollectionUtil.isEmpty(mapIds.get(id))) {
                idsList.add(id);
            }
        }
        errorMsg.append(String.format("[%s]", idsList.stream().map(String::valueOf).collect(Collectors.joining(","))));
        return errorMsg.toString();
    }


    public List<ActorModel> updateLastNameBatchUpdate(ActorDTO actorDTO) {
        String lastName  = actorDTO.getLast_name();
        List<List<Integer>> splitIds = split(actorDTO.getActorIds(),20);
        for (List<Integer> list: splitIds) {
            actorMapper.lastNameBatchUpdate(list,lastName);
            log.info("actor Ids: {} lastName:{}", list,lastName);
        }
        return getActorNames(actorDTO);
    }

    public List<ActorModel> getActorNames(ActorDTO actorDTO){
        List<Integer> actorIds = actorDTO.getActorIds();
        List<List<Integer>> actors = ListSplitUtil.split(actorIds, 20);
        List<ActorModel> result = new ArrayList<>();
        for (List<Integer> list : actors) {
            List<ActorModel> ids = actorMapper.queryActors(list);
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

    public ByteArrayInputStream exportActor() {
        List<ActorModel> exportFile = actorMapper.exportActor();
        log.info("exportFile: {}",exportFile);
        ByteArrayInputStream download = ExportActorCsvHelper.exportHelperToCsv(exportFile);
        return download;
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
        List<ActorModel> actorModelList = actorMapper.queryActorModelList(dto);
        log.info("actorModelList:{}",actorModelList);
        Map<Integer,ActorModel> map =actorModelList.stream().collect(Collectors.toMap(ActorModel::getActorId, ActorModel->ActorModel));
        //compare list
        for (ActorDTO actorDTO: list) {
            actorDTO.setFirst_name(actorDTO.getFirst_name());
            //get actors
            ActorModel actorModel = map.get(actorDTO.getActor_id());
            log.info("actorDTO MEN {}",actorDTO);
            log.info("actorModel:{}",actorModel);
            if(actorModel==null) {
                //new actors
                actorDTO.setLast_update(LocalDateTime.now().toString());
                actorDTO.setActor_id(0);
                insertList.add(actorDTO);
                log.info("inserted {}", insertList);
            } else {
                //if first name is different , modify the firstname
                if(!actorModel.getFirstName().equals(actorDTO.getFirst_name())) {
                    actorDTO.setActor_id(actorDTO.getActor_id());
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
    public String editActors(v2ActorDTO v2ActorDTO) {

        List<ActorModel> recordList = actorMapper.batchSelect(v2ActorDTO);
        log.info("recordList:{}",recordList);
        StringBuffer msg = new StringBuffer();
        List<Integer> updatedActorIds = new ArrayList<>();
        List<Integer> notUpdatedActorIds = new ArrayList<>();

        recordList.forEach(item-> {
            v2ActorDTO dto = new v2ActorDTO();
            dto.setFirstName(!v2ActorDTO.getFirstName().equals(item.getFirstName()) ? v2ActorDTO.getFirstName() : "");
            dto.setLastName(!v2ActorDTO.getLastName().equals(item.getLastName()) ? v2ActorDTO.getLastName() : "");
            dto.setActorId(item.getActorId());
       //     v2ActorDTO.setLastUpdate(CommonDateUtil.now().toString());
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
    public List<ActorModel> batchSelectActor(v2ActorDTO dto) {
      return actorMapper.batchSelect(dto);
    }

    @Override
    public List<ActorModel> sortRecords(ActorDTO dto) {

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

        List<ActorModel> responseVO = actorMapper.getAllActors(dto);

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
        List<ActorModel> responseVO = actorMapper.getAllActors(dto);
        System.out.println("responseVO"+responseVO);
        Assert.isTrue(!responseVO.isEmpty(), "failed to call model"  );
        List<ActorModel> list = responseVO;
        Map<String , String> map = new LinkedHashMap<>();
        for (ActorModel v: list) {
            map.put(String.valueOf(v.getActorId()),v.getLastName());
        }
        return map;
    }



}
