package io.renren.modules.sys.service.impl;

import io.renren.common.utils.DesUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.SysClientInfoDao;
import io.renren.modules.sys.entity.SysClientInfoEntity;
import io.renren.modules.sys.service.SysClientInfoService;


@Service("sysClientInfoService")
public class SysClientInfoServiceImpl extends ServiceImpl<SysClientInfoDao, SysClientInfoEntity> implements SysClientInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysClientInfoEntity> page = this.selectPage(
                new Query<SysClientInfoEntity>(params).getPage(),
                new EntityWrapper<SysClientInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void save(SysClientInfoEntity sysClientInfo) {
        sysClientInfo.setAddTime(new Date());
        sysClientInfo.setPassWord(DesUtils.encrypt(sysClientInfo.getPassWord()));
        super.insert(sysClientInfo);
    }

    @Override
    public SysClientInfoEntity queryClientInfoByUserName(String userName) {
        return baseMapper.queryClientInfoByUserName(userName);
    }

}
