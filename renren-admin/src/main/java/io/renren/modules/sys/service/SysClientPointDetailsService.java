package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.SysClientPointDetailsEntity;

import java.util.Map;

/**
 * 用户点细节
 *
 * @author ºú³É
 * @email hucheng003@gmail.com
 * @date 2018-09-28 14:09:43
 */
public interface SysClientPointDetailsService extends IService<SysClientPointDetailsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

