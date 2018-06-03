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
import com.suke.czx.modules.hladmin.entity.HlHylPriceEntity;
import com.suke.czx.modules.hladmin.service.HlHylPriceService;




/**
 * 
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-06-02 10:04:01
 */
@RestController
@RequestMapping("/hladmin")
public class HlHylPriceController {
    @Autowired
    private HlHylPriceService hlHylPriceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<HlHylPriceEntity> hlHylPriceList = hlHylPriceService.queryList(query);
        int total = hlHylPriceService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(hlHylPriceList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 保存
     */
    @RequestMapping("/price")
    @RequiresPermissions("hladmin:price")
    public R save(@RequestBody HlHylPriceEntity hlHylPrice){
			hlHylPriceService.save(hlHylPrice);
        return R.ok();
    }
}
