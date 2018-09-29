package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.sys.entity.vo.SysClientPointVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.SysClientPointEntity;
import io.renren.modules.sys.service.SysClientPointService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;


/**
 * 用户积分
 *
 * @author ºú³É
 * @email hucheng003@gmail.com
 * @date 2018-09-28 09:15:13
 */
@RestController
@RequestMapping("sys/sysclientpoint")
public class SysClientPointController {
    @Autowired
    private SysClientPointService sysClientPointService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysclientpoint:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysClientPointService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("sys:sysclientpoint:info")
    public R info(@PathVariable("userId") Integer userId) {
        SysClientPointEntity sysClientPoint = sysClientPointService.selectById(userId);

        return R.ok().put("sysClientPoint", sysClientPoint);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysclientpoint:save")
    public R save(@RequestBody SysClientPointVo sysClientPointVo) {
        return sysClientPointService.save(sysClientPointVo);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysclientpoint:update")
    public R update(@RequestBody SysClientPointEntity sysClientPoint) {
        ValidatorUtils.validateEntity(sysClientPoint);
        //全部更新
        sysClientPointService.updateAllColumnById(sysClientPoint);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysclientpoint:delete")
    public R delete(@RequestBody Integer[] userIds) {
        sysClientPointService.deleteBatchIds(Arrays.asList(userIds));

        return R.ok();
    }

}
