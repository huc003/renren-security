package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.SysClientPointEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户积分
 * 
 * @author ºú³É
 * @email hucheng003@gmail.com
 * @date 2018-09-28 09:15:13
 */
public interface SysClientPointDao extends BaseMapper<SysClientPointEntity> {
	Integer insertPoint(@Param("cond") SysClientPointEntity sysClientPointEntity);
}
