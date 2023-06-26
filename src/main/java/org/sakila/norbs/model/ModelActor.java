package org.sakila.norbs.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("actor")
public class ModelActor extends Model<ModelActor> {

    private static final long serialVersionUID = 1L;


    @TableId(value = "actor_id", type = IdType.AUTO)
    private int actorId;

    @TableField("first_name")
    private String firstName;

    @TableField("last_name")
    private String lastName;

    @TableField("last_update")
    private String lastUpdate;


    @Override
    protected Serializable pkVal() {
        return this.actorId;
    }
}
