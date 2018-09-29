package io.renren.modules.sys.service.impl;

import io.renren.common.utils.R;
import io.renren.modules.sys.entity.SysClientInfoEntity;
import io.renren.modules.sys.entity.vo.SysClientPointVo;
import io.renren.modules.sys.service.SysClientInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.SysClientPointDao;
import io.renren.modules.sys.entity.SysClientPointEntity;
import io.renren.modules.sys.service.SysClientPointService;


@Service("sysClientPointService")
public class SysClientPointServiceImpl extends ServiceImpl<SysClientPointDao, SysClientPointEntity> implements SysClientPointService {

    @Autowired
    private SysClientInfoService sysClientInfoService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        String userId = (String)params.get("userId");

        Page<SysClientPointEntity> page = this.selectPage(
                new Query<SysClientPointEntity>(params).getPage(),
                new EntityWrapper<SysClientPointEntity>().like(StringUtils.isNotBlank(userId),"user_id",userId)
        );

        return new PageUtils(page);
    }

    @Override
    public R save(SysClientPointVo sysClientPointVo) {
        SysClientInfoEntity sysClientInfoEntity = sysClientInfoService.queryClientInfoByUserName(sysClientPointVo.getUserName());
        if(sysClientInfoEntity==null){
            return R.error(100001,"用户不存在");
        }
        SysClientPointEntity sysClientPointEntity = selectById(sysClientInfoEntity.getUserId());
        if (sysClientPointEntity != null) {
            SysClientPointEntity pointEntity = new SysClientPointEntity();
            pointEntity.setUserId(sysClientPointEntity.getUserId());
            int point = sysClientPointVo.getPoint() + sysClientPointEntity.getPoint();
            if(sysClientPointVo.getType()==1){
                point = sysClientPointEntity.getPoint() - sysClientPointVo.getPoint();
            }
            if(point<0){
                point = 0;
            }
            pointEntity.setPoint(point);
            baseMapper.updateById(pointEntity);
            return R.ok();
        }
        sysClientPointEntity = new SysClientPointEntity();
        sysClientPointEntity.setUserId(sysClientInfoEntity.getUserId());
        sysClientPointEntity.setPoint(sysClientPointVo.getPoint());
        baseMapper.insertPoint(sysClientPointEntity);
        return R.ok();
    }

}
