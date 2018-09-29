package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.SysClientInfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author hucheng
 * @email hucheng003@gmail.com
 * @date 2018-09-25 13:32:18
 */
public interface SysClientInfoService extends IService<SysClientInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void save(SysClientInfoEntity sysClientInfo);

    SysClientInfoEntity queryClientInfoByUserName(String userName);
}

