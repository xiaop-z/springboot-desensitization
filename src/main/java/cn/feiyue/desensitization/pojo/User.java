package cn.feiyue.desensitization.pojo;

import cn.feiyue.desensitization.SensitiveTypeEnum;
import cn.feiyue.desensitization.annotation.Desensitization;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Date 2020-08-27 14:54
 * @Created by zfy
 */
@Data
@TableName("t_user")
public class User {

    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    private String username;

    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    @Desensitization(type= SensitiveTypeEnum.PLATE_NUM)
    private String plateNum;

    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    @Desensitization(type= SensitiveTypeEnum.PHONE)
    private String phone;

    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    @Desensitization(type= SensitiveTypeEnum.ID_CARD)
    private String idCard;

    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
