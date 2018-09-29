package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.SysClientPointEntity;
import io.renren.modules.sys.entity.vo.SysClientPointVo;

import java.util.Map;

/**
 * 用户积分
 *
 * @author ºú³É
 * @email hucheng003@gmail.com
 * @date 2018-09-28 09:15:13
 */
public interface SysClientPointService extends IService<SysClientPointEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R save(SysClientPointVo sysClientPointVo);

    SysClientPointEntity queryUserPoint(Integer userId);
}

