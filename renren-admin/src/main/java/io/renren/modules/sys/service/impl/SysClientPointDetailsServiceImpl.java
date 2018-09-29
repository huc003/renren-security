package io.renren.modules.sys.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.SysClientPointDetailsDao;
import io.renren.modules.sys.entity.SysClientPointDetailsEntity;
import io.renren.modules.sys.service.SysClientPointDetailsService;


@Service("sysClientPointDetailsService")
public class SysClientPointDetailsServiceImpl extends ServiceImpl<SysClientPointDetailsDao, SysClientPointDetailsEntity> implements SysClientPointDetailsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        String userId = (String)params.get("userId");

        if(userId==null){
            return new PageUtils(new Page<SysClientPointDetailsEntity>());
        }

        Page<SysClientPointDetailsEntity> page = this.selectPage(
                new Query<SysClientPointDetailsEntity>(params).getPage(),
                new EntityWrapper<SysClientPointDetailsEntity>().like(StringUtils.isNotBlank(userId),"user_id",userId)
        );

        return new PageUtils(page);
    }

}
