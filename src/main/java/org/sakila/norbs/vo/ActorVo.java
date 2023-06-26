package org.sakila.norbs.vo;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class ActorVo extends PageInfo {

    private BigDecimal sheesh;

    private Integer exportPageSize;
}
