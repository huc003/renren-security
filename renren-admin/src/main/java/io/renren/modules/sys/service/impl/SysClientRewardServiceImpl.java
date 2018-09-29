package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.NumberUtils;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.SysClientRewardDao;
import io.renren.modules.sys.entity.SysClientInfoEntity;
import io.renren.modules.sys.entity.SysClientRewardEntity;
import io.renren.modules.sys.service.SysClientInfoService;
import io.renren.modules.sys.service.SysClientRewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;


@Service("sysClientRewardService")
public class SysClientRewardServiceImpl extends ServiceImpl<SysClientRewardDao, SysClientRewardEntity> implements SysClientRewardService {

    @Autowired
    private SysClientInfoService sysClientInfoService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysClientRewardEntity> page = this.selectPage(
                new Query<SysClientRewardEntity>(params).getPage(),
                new EntityWrapper<SysClientRewardEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void save(SysClientRewardEntity sysClientReward) {
        addReward(sysClientReward);
    }

    /**
     * @Author: 胡成
     * @Date: 2018/9/27 13:36
     * @Description: 发送红包券
     **/
    public void addReward(SysClientRewardEntity sysClientReward) {
        SysClientInfoEntity sysClientInfoEntity = sysClientInfoService.queryClientInfoByUserName(sysClientReward.getUsername());
        sysClientReward.setUserId(sysClientInfoEntity.getUserId());
        sysClientReward.setAddtime(new Date());
        sysClientReward.setRewardNo(NumberUtils.rewardNo());
        super.insert(sysClientReward);
    }

}
