package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.sys.entity.SysClientRewardEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.service.SysClientRewardService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 红包信息表
 *
 * @author 胡成
 * @email hucheng003@gmail.com
 * @date 2018-09-27 09:17:57
 */
@RestController
@RequestMapping("sys/sysclientreward")
public class SysClientRewardController {
    @Autowired
    private SysClientRewardService sysClientRewardService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysclientreward:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysClientRewardService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:sysclientreward:info")
    public R info(@PathVariable("id") Integer id){
        SysClientRewardEntity sysClientReward = sysClientRewardService.selectById(id);
        return R.ok().put("sysClientReward", sysClientReward);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysclientreward:save")
    public R save(@RequestBody SysClientRewardEntity sysClientReward){
        sysClientRewardService.save(sysClientReward);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysclientreward:update")
    public R update(@RequestBody SysClientRewardEntity sysClientReward){
        ValidatorUtils.validateEntity(sysClientReward);
        //全部更新
        sysClientRewardService.updateAllColumnById(sysClientReward);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysclientreward:delete")
    public R delete(@RequestBody Integer[] ids){
        sysClientRewardService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
