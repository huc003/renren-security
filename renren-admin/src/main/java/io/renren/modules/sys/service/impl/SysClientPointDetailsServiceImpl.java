package io.renren.modules.sys.service.impl;

import io.renren.common.utils.DateUtils;
import io.renren.modules.sys.entity.SysClientInfoEntity;
import io.renren.modules.sys.entity.SysClientPointEntity;
import io.renren.modules.sys.entity.vo.SysClientPointVo;
import io.renren.modules.sys.service.SysClientInfoService;
import io.renren.modules.sys.service.SysClientPointService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private SysClientInfoService sysClientInfoService;

    @Autowired
    private SysClientPointService sysClientPointService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        String userId = (String) params.get("userId");

        if (userId == null) {
            return new PageUtils(new Page<SysClientPointDetailsEntity>());
        }

        Page<SysClientPointDetailsEntity> page = this.selectPage(
                new Query<SysClientPointDetailsEntity>(params).getPage(),
                new EntityWrapper<SysClientPointDetailsEntity>().like(StringUtils.isNotBlank(userId), "user_id", userId)
        );

        return new PageUtils(page);
    }

    @Override
    public void save(SysClientPointVo sysClientPointVo) {

        SysClientInfoEntity sysClientInfoEntity = sysClientInfoService.queryClientInfoByUserName(sysClientPointVo.getUserName());

        if (sysClientInfoEntity == null) {
            return;
        }

        SysClientPointEntity sysClientPointEntity = sysClientPointService.queryUserPoint(sysClientInfoEntity.getUserId());

        SysClientPointDetailsEntity sysClientPointDetailsEntity = new SysClientPointDetailsEntity();
        sysClientPointDetailsEntity.setPoint(sysClientPointVo.getPoint());
        sysClientPointDetailsEntity.setExpiredTime(DateUtils.addDateDays(new Date(),30));
        sysClientPointDetailsEntity.setOverage(sysClientPointEntity.getPoint());
        sysClientPointDetailsEntity.setPointType(sysClientPointVo.getType());
        sysClientPointDetailsEntity.setPointUsed(sysClientPointEntity.getPointUsed());
        sysClientPointDetailsEntity.setSource("测试积分");
        sysClientPointDetailsEntity.setSourceType(1);
        sysClientPointDetailsEntity.setUserId(sysClientInfoEntity.getUserId());
        sysClientPointDetailsEntity.setAddtime(new Date());

        baseMapper.insert(sysClientPointDetailsEntity);
    }

}
