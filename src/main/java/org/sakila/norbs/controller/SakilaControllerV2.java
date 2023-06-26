package org.sakila.norbs.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.sakila.norbs.annotation.APIRole;
import org.sakila.norbs.annotation.Permission;
import org.sakila.norbs.dto.ActorDTOV2;
import org.sakila.norbs.dto.ActorRecordRequest;
import org.sakila.norbs.enums.AuthModule;
import org.sakila.norbs.enums.Privilege;
import org.sakila.norbs.enums.TraceOptId;
import org.sakila.norbs.enums.TraceType;
import org.sakila.norbs.model.Actor;
import org.sakila.norbs.utils.CommonDateUtil;
import org.sakila.norbs.vo.ResponseHelper;
import org.sakila.norbs.vo.ResponseVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sakila.norbs.annotation.TraceLog;
import org.sakila.norbs.services.iface.SakilaServiceV2;
import org.sakila.norbs.utils.CollectionUtil;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/api/sakila")
public class SakilaControllerV2 {


    @Resource
    SakilaServiceV2 sakilaServiceV2;

    @PostMapping("/list")
    @APIRole(APIRole.ADMIN)
    @Permission(privilege = Privilege.READ, modules = {AuthModule.SUBCONTROL_ABLINE_RECORD})
    @TraceLog(value = TraceType.SUBCONTROL_ABLINE_RECORD, optId = TraceOptId.AccountId)
    @ApiOperation(value = "sheeesh", tags ="bgc pareeh")
    public ResponseVO summary(ActorRecordRequest request) {
        List<Actor> pageInfo = new ArrayList<>();
        try {

           pageInfo = sakilaServiceV2.getActorList(request);
            log.info("pageInfo: {}", pageInfo);

        } catch (Exception e) {
            log.info("error: {}",e.getMessage());
        }

        return ResponseHelper.success(pageInfo);
    }




    /**
     * filter request body
     * {
     *    "actorIds" : [] or "actorIds" : [1,2,3]
     * }
     * {
     *    "actorIds" : [],
     *    "firstName":  "THORA",
     *    "lastName": ""
     * }
     * */
    @PostMapping("/v2/list/actor")
    public ResponseVO getListActors(@RequestBody @Validated ActorDTOV2 actorDTOV2) {
        return ResponseHelper.success(sakilaServiceV2.getListActors(actorDTOV2));
    }


    /**
     * request body
     * [
     *     {"firstName": "NorAbs","lastName": "SheeSsh"},
     *     {"firstName": "staAr","lastName": "bAoy"},
     *     {"firstName": "staASAAr","lastName": "bSAoy"}
     * ]
     * */
    @PostMapping("/v2/insertActor")
    public ResponseVO insertActor(@RequestBody @Validated List<ActorDTOV2> dto) {
        if (CollectionUtil.isEmpty(dto)) {
            return ResponseHelper.error("Parameters cannot be empty");
        }
        dto.stream().forEach(item-> {
            item.setLastUpdate(CommonDateUtil.now().toString());
        });
        log.info("dto:{}",dto);
        return ResponseHelper.success(sakilaServiceV2.insertActors(dto));
    }

    @PostMapping("v2/deleteActor")
    public ResponseVO deleteActor(@RequestBody ActorDTOV2 dto) {
        if(CollectionUtil.isEmpty(dto.getActorIds())) {
            return ResponseHelper.error("Please enter ids");
        }

        /*//check if ids exist
        PageInfo pageInfo = sakilaServiceV2.getListActors(dto);
        if (CollectionUtil.isEmpty(pageInfo.getList())){
            return ResponseHelper.error("No id exist");
        }*/

        int i = sakilaServiceV2.deleteActor(dto);
        log.info("i:{}",i);
        if (i > 0) return ResponseHelper.success();

      return ResponseHelper.errorNotExist("No id exist");
    }

    @PostMapping("v2/editActors")
    public ResponseVO editActors(@RequestBody ActorDTOV2 dto) {
        if (dto.getActorId()==null || dto.getFirstName()==null || dto.getLastName()==null) {
            return ResponseHelper.error("Please enter required parameters");
        }
        
        return ResponseHelper.success(sakilaServiceV2.updateActor(dto));
    }

    @PostMapping("v2/difference")
    public ResponseVO differenceList(@RequestBody ActorDTOV2 dto){
        return ResponseHelper.success(sakilaServiceV2.differenceList(dto));
    }



    @PostMapping("v2/tryContains")
    public ResponseVO contains(){

        Map<Integer ,String> map = new HashMap<>();
        map.put(1,"norbs");
        map.put(2,"luslec");
        map.put(3,"ll");
        map.put(4,"ldfl");
        map.put(5,"ll");

        List<Integer> categoryList = map.keySet().stream().map(Integer::new).collect(Collectors.toList());

      List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
      //  List<Integer> list = (Arrays.asList(1,2,3,4));
     log.info("listBefore{}",list);
        List<Integer> list2 = new ArrayList<>();

        if (categoryList.size() != list.size()) {
            list2 = list.stream().collect(Collectors.toList());
            List<Integer> finalList= list2;
            categoryList.forEach(item -> {
                if (!finalList.contains(item)){
                   list.add(item);
                }
            });
        }

        log.info("listAfter{}", list);

        return ResponseHelper.success();
    }


}
