package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.SysClientRewardEntity;

import java.util.Map;

/**
 * 红包信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-27 09:17:57
 */
public interface SysClientRewardService extends IService<SysClientRewardEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void save(SysClientRewardEntity sysClientReward);
}

