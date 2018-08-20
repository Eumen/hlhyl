package com.suke.czx.modules.hladmin.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;
import com.suke.czx.modules.hladmin.entity.HlRecuserHistoryEntity;
import com.suke.czx.modules.hladmin.service.HlRecuserHistoryService;




/**
 * 推荐人修改记录
 * 
 * @author czx
 * @email ${email}
 * @date 2018-08-18 15:46:56
 */
@RestController
@RequestMapping("/hladmin/hlrecuserhistory")
public class HlRecuserHistoryController {
    @Autowired
    private HlRecuserHistoryService hlRecuserHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<HlRecuserHistoryEntity> hlRecuserHistoryList = hlRecuserHistoryService.queryList(query);
        int total = hlRecuserHistoryService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(hlRecuserHistoryList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
			HlRecuserHistoryEntity hlRecuserHistory = hlRecuserHistoryService.queryObject(id);

        return R.ok().put("hlRecuserHistory", hlRecuserHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HlRecuserHistoryEntity hlRecuserHistory){
			hlRecuserHistoryService.save(hlRecuserHistory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HlRecuserHistoryEntity hlRecuserHistory){
			hlRecuserHistoryService.update(hlRecuserHistory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
			hlRecuserHistoryService.deleteBatch(ids);
        return R.ok();
    }
	
}
