package org.sakila.norbs.controller;

import org.sakila.norbs.dto.ActorDTO;
import org.sakila.norbs.model.Actor;
import org.sakila.norbs.services.iface.SakilaService;
import org.sakila.norbs.vo.ResponseHelper;
import org.sakila.norbs.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping("/api/sakila/")
public class SakilaController {

    @Autowired
    SakilaService sakilaService;


    @GetMapping("list/actor")
    public ResponseVO getAllActors(@RequestBody ActorDTO actorDTO) {
        return ResponseHelper.success(sakilaService.getAllActors(actorDTO));
    }

    @PostMapping("find/actor")
    public ResponseVO findActor(@RequestBody ActorDTO actorDTO) {
        Actor actor = sakilaService.findActor(actorDTO);
        if (ObjectUtils.isEmpty(actor)) {
            return ResponseHelper.nullData(actor);
        }
        return ResponseHelper.success(actor);
    }

    @PostMapping("update/actorsLastName")
    public ResponseVO updateAllActorLastName(@RequestBody ActorDTO actorDTO) {
        Actor actor = sakilaService.updateActorLastName(actorDTO);
        if (ObjectUtils.isEmpty(actor)) {
            return ResponseHelper.nullData(actor);
        }
        return ResponseHelper.success(actor);
    }

    @PostMapping("batchInsert/actor")
    public ResponseVO batchInsertActor(@RequestBody ActorDTO actorDTO) {
        return sakilaService.batchInsertActor(actorDTO);
    }

    @PostMapping("Insert/actor")
    public ResponseVO insertActor(@RequestBody @Validated ActorDTO actorDTO) {
        return ResponseHelper.success(sakilaService.insertActor(actorDTO));
    }

    @PostMapping("batchDelete/actor")
    public ResponseVO batchDeleteActor(@RequestBody ActorDTO actorDTO) {
        if(CollectionUtils.isEmpty(actorDTO.getActorIds())) {
            return ResponseHelper.error("Please enter ids!");
        }
        return sakilaService.batchDeleteActor(actorDTO);
    }

    @PostMapping("batchSelect/actor")
    public ResponseVO getActorNames(@RequestBody ActorDTO actorDTO) {
        if(CollectionUtils.isEmpty(actorDTO.getActorIds())) {
            return ResponseHelper.error("Please enter ids!");
        }
        return ResponseHelper.success(sakilaService.getActorNames(actorDTO));
        //request body parameter
        //{
        //   "actorIds" :[]
        //}
    }

    @PostMapping("batchUpdateLastName/actor")
    public ResponseVO batchUpdateLastName(@RequestBody ActorDTO actorDTO) {
        if(CollectionUtils.isEmpty(actorDTO.getActorIds())) {
            return ResponseHelper.error("Please enter ids!");
        }
        if(ObjectUtils.isEmpty(actorDTO.getLastName())) {
            return ResponseHelper.error("Please enter last name!");
        }
        return ResponseHelper.success(sakilaService.updateLastNameBatchUpdate(actorDTO));
    }


    /**parameters should be something like this
     * [
     *     {
     *         "actor_id" : 4451,
     *         "first_name" : "awit",
     *         "last_name" : "World"
     *     },
     *      {
     *         "actor_id" : 4448,
     *         "first_name" : "Hellos",
     *         "last_name" : "World"
     *     }
     * ]
     *
     * */
    @PostMapping("v1/editActor")
    public ResponseVO editSelectedActor(@RequestBody @Validated List<ActorDTO> dto) {
        if (CollectionUtils.isEmpty(dto)){
            return ResponseHelper.error("parameters cannot be empty!");
        }
        return ResponseHelper.success(sakilaService.editActor(dto));
    }


}