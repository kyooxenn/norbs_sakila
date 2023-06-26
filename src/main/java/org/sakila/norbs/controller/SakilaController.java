package org.sakila.norbs.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.sakila.norbs.dto.ActorDTO;
import org.sakila.norbs.dto.v2ActorDTO;
import org.sakila.norbs.model.ActorModel;
import org.sakila.norbs.services.iface.SakilaService;
import org.sakila.norbs.vo.ActorVo;
import org.sakila.norbs.vo.ResponseHelper;
import org.sakila.norbs.vo.ResponseVO;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.sakila.norbs.model.KyoModel;
import org.sakila.norbs.utils.CollectionUtil;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/api/sakila/")
public class SakilaController {

    @Resource
    SakilaService sakilaService;

    @Resource
    Environment env;

    @GetMapping("list/actor")
    public ResponseVO getAllActors(@RequestBody ActorDTO actorDTO) {
        return ResponseHelper.success(sakilaService.getAllActors(actorDTO));
    }

    @PostMapping("find/actor")
    public ResponseVO findActor(@RequestBody ActorDTO actorDTO) {
        ActorModel actorModels = sakilaService.findActor(actorDTO);
        if (actorModels == null) {
            return ResponseHelper.nullData(actorModels);
        }
        return ResponseHelper.success(actorModels);
    }

    @PostMapping("update/actorsLastName")
    public ResponseVO updateAllActorLastName(@RequestBody ActorDTO actorDTO) {
        ActorModel actor = sakilaService.updateActorLastName(actorDTO);
        if (actor == null) {
            return ResponseHelper.nullData(actor);
        }
        return ResponseHelper.success(actor);
    }

    @PostMapping("batchInsert/actor")
    public ResponseVO batchInsertActor(@RequestBody ActorDTO actorDTO) {
        return sakilaService.batchInsertActor(actorDTO);
    }

    @PostMapping("Insert/actor")
    public ResponseVO insertActor(@RequestBody @Validated v2ActorDTO actorDTO) {
        return ResponseHelper.success(sakilaService.insertActor(actorDTO));
    }

    @PostMapping("batchDelete/actor")
    public ResponseVO batchDeleteActor(@RequestBody ActorDTO actorDTO) {
        if(actorDTO.getActorIds().isEmpty()) {
            return ResponseHelper.error("Please enter ids!");
        }
        return sakilaService.batchDeleteActor(actorDTO);
    }

    @PostMapping("batchSelect/actor")
    public ResponseVO getActorNames(@RequestBody ActorDTO actorDTO) {
        if(actorDTO.getActorIds().isEmpty()) {
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
        if(actorDTO.getActorIds().isEmpty()) {
            return ResponseHelper.error("Please enter ids!");
        }
        if(actorDTO.getLast_name()==null || actorDTO.getLast_name().isEmpty()) {
            return ResponseHelper.error("Please enter last name!");
        }
        return ResponseHelper.success(sakilaService.updateLastNameBatchUpdate(actorDTO));
    }

    @PostMapping("exportActor")
    public ResponseEntity<Object> exportActor() {
        InputStreamResource file = new InputStreamResource(sakilaService.exportActor());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + LocalDate.now() + "Export_Report.csv")
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }

    @PostMapping("v1/listActors")
    public ResponseVO queryActorList(){





        List<KyoModel> kyoModelList = Arrays.asList(new KyoModel("Sheesh","sss"),new KyoModel("Sheesh1","sWERss"));

        Map<String,String> map = kyoModelList.stream().collect(Collectors.toMap(KyoModel::getKey,KyoModel::getValue));

        System.out.println(kyoModelList);
        System.out.println(map);

      // String pageSize = env.getProperty("100");
        String pageSize = "100";
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setPageNum(1);
        actorDTO.setPageSize(10);

        actorDTO.setFirst_name("sheesh");
        actorDTO.setLast_name("herms");

        actorDTO.setFullNameStr(actorDTO.getFirst_name());
        actorDTO.setFullNameStr("sas");

        Integer num =1;


        System.out.println("bgi" + BigDecimal.ZERO);

        if(num.equals(1))
        System.out.println("set"+actorDTO.getFullNameStr());



        actorDTO.setActorIds(Arrays.asList(1,2,3));
        if(CollectionUtils.isEmpty(actorDTO.getActorIds())){
            return ResponseHelper.error("No actor ids");
        }

        BigDecimal rate = BigDecimal.valueOf((-100) + (200.76));
        BigDecimal money = BigDecimal.valueOf((-750) + 750 + 750);

        String total = money.divide(rate,2, BigDecimal.ROUND_DOWN).toString();
        System.out.println(StrUtil.format("This is money added rate {} ",money.add(rate).setScale(2,BigDecimal.ROUND_DOWN).toString()));
        System.out.println(StrUtil.format("This is total {}", total));


        List<Integer> list =  actorDTO.getActorIds().stream().map(x-> {
            x= x==1 ? 0 : 1;

            actorDTO.setActor_id(x==1? 0: 1);

            return x;
        }).collect(Collectors.toList());


        System.out.println(list);


      /*  Integer[][] categories = {
                {0,1},
                {1,1},
                {0,2},
                {1,2}
        };


List<Integer> model = Arrays.stream(categories).map(c->{
   Integer norbs = 0;
   norbs = c[0];
   return norbs;

}).collect(Collectors.toList());

        System.out.println(model);
*/








       /* BigDecimal nn = BigDecimal.valueOf(Long.parseLong("0.00"));
        if (nn.equals(0.0)) {
            System.out.println("norbs" + nn);
        }*/




      //  PageHelper.startPage(actorDTO.getPageNum(),actorDTO.getPageSize());

        List<BigDecimal> decimalsList = Arrays.asList(BigDecimal.valueOf(0.99), BigDecimal.valueOf(0.98),BigDecimal.valueOf(0.97));

        PageInfo<ActorModel> pageInfo = sakilaService.pageGetAllActors();

        pageInfo.getList().stream().peek(item-> {
            item.setDepositBase(decimalsList.stream().filter(Objects::nonNull).reduce(BigDecimal::add).get());
        }).collect(Collectors.toList());



        BigDecimal withdrawalFee = pageInfo.getList().stream().map(ActorModel::getDepositBase).filter(Objects::nonNull).reduce(BigDecimal::add).get();
        log.info("withdrawalFee: {}",withdrawalFee);
        log.info(String.format("This is %s ",withdrawalFee.toString()));
        log.info(StrUtil.format("This is {} ",withdrawalFee.toString()));

        ActorVo result = new ActorVo();
        BeanUtil.copyProperties(pageInfo,result);
        //chain accessors vo
        result.setSheesh(BigDecimal.ZERO).setSheesh(BigDecimal.ZERO);
        //adding big decimals
       // result.setValidBetAmount(tempList.stream().map(ActorVo::getSheesh).reduce(BigDecimal.ZERO,BigDecimal::add));


        log.info("pageSize:{}",pageSize);
        result.setExportPageSize(!StringUtils.isNullOrEmpty(pageSize) ? Integer.valueOf(pageSize) : 0);
        log.info("result{}",result.getExportPageSize());
        log.info("totalData: {}",result.getTotal());
        if(result.getTotal()>10000) {
            PageHelper.startPage(actorDTO.getPageNum(),actorDTO.getPageSize());
        }

        PageInfo<ActorModel> pageInfo1 = new PageInfo<>(result.getList());
        pageInfo1.setTotal(result.getTotal());
        pageInfo1.setPageNum(actorDTO.getPageNum());
        pageInfo1.setPageSize(actorDTO.getPageSize());

        return ResponseHelper.success(pageInfo1);

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
        if (CollectionUtil.isEmpty(dto)){
            return ResponseHelper.error("parameters cannot be empty!");
        }
        /*dto.stream().forEach(item->{
            item.setLast_name("SHEESH!");
        });*/
        return ResponseHelper.success(sakilaService.editActor(dto));
    }


    @PostMapping("v2/editActor")
    public ResponseVO editActors(@RequestBody v2ActorDTO v2ActorDTO) {
        if(CollectionUtil.isEmpty(v2ActorDTO.getActorIds())) {
            return ResponseHelper.error("parameters cannot be empty!");
        }
        if(v2ActorDTO.getFirstName()==null && v2ActorDTO.getLastName()==null) {
            return ResponseHelper.error("parameters cannot be empty!");
        }
        return ResponseHelper.success(sakilaService.editActors(v2ActorDTO));
    }


    @PostMapping("v2/batchSelectActor")
    public ResponseVO batchSelectActor(@RequestBody v2ActorDTO dto){
        if(CollectionUtil.isEmpty(dto.getActorIds())) {
            return ResponseHelper.error("Empty actorIds");
        }
       return ResponseHelper.success(sakilaService.batchSelectActor(dto));
    }

    @PostMapping("v2/sortRecords")
    public ResponseVO sortRecords(@RequestBody ActorDTO dto) {
        if(dto==null) {
            return ResponseHelper.error("Enter parameter");
        }

        return ResponseHelper.success(sakilaService.sortRecords(dto));

    }




}