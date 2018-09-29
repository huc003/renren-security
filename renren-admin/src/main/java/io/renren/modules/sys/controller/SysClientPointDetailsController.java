package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.SysClientPointDetailsEntity;
import io.renren.modules.sys.service.SysClientPointDetailsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 用户点细节
 *
 * @author ºú³É
 * @email hucheng003@gmail.com
 * @date 2018-09-28 14:09:43
 */
@RestController
@RequestMapping("sys/sysclientpointdetails")
public class SysClientPointDetailsController {
    @Autowired
    private SysClientPointDetailsService sysClientPointDetailsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysclientpointdetails:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysClientPointDetailsService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:sysclientpointdetails:info")
    public R info(@PathVariable("id") Integer id){
        SysClientPointDetailsEntity sysClientPointDetails = sysClientPointDetailsService.selectById(id);
        return R.ok().put("sysClientPointDetails", sysClientPointDetails);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysclientpointdetails:save")
    public R save(@RequestBody SysClientPointDetailsEntity sysClientPointDetails){
        sysClientPointDetailsService.insert(sysClientPointDetails);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysclientpointdetails:update")
    public R update(@RequestBody SysClientPointDetailsEntity sysClientPointDetails){
        ValidatorUtils.validateEntity(sysClientPointDetails);
        //全部更新
        sysClientPointDetailsService.updateAllColumnById(sysClientPointDetails);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysclientpointdetails:delete")
    public R delete(@RequestBody Integer[] ids){
        sysClientPointDetailsService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
