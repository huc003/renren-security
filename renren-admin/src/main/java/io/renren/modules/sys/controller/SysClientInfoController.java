package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.SysClientInfoEntity;
import io.renren.modules.sys.service.SysClientInfoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;


/**
 * @author hucheng
 * @email hucheng003@gmail.com
 * @date 2018-09-25 13:32:18
 */
@RestController
@RequestMapping("sys/sysclientinfo")
public class SysClientInfoController {
    @Autowired
    private SysClientInfoService sysClientInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysclientinfo:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysClientInfoService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("sys:sysclientinfo:info")
    public R info(@PathVariable("userId") Integer userId) {
        SysClientInfoEntity sysClientInfo = sysClientInfoService.selectById(userId);
        return R.ok().put("sysClientInfo", sysClientInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysclientinfo:save")
    public R save(@RequestBody SysClientInfoEntity sysClientInfo) {
        sysClientInfoService.save(sysClientInfo);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysclientinfo:update")
    public R update(@RequestBody SysClientInfoEntity sysClientInfo) {
        ValidatorUtils.validateEntity(sysClientInfo);
        //全部更新
        sysClientInfoService.updateAllColumnById(sysClientInfo);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysclientinfo:delete")
    public R delete(@RequestBody Integer[] userIds) {
        sysClientInfoService.deleteBatchIds(Arrays.asList(userIds));
        return R.ok();
    }

}
