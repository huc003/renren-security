package io.renren.modules.sys.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/9/28
 * @Description: 类描述
 **/
@Data
public class SysClientPointVo  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;
    private Integer point;
    private Integer type;
}
