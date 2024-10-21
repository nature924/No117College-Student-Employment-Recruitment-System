package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.GangweishenqingEntity;
import com.entity.view.GangweishenqingView;

import com.service.GangweishenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 岗位申请
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-12 22:13:25
 */
@RestController
@RequestMapping("/gangweishenqing")
public class GangweishenqingController {
    @Autowired
    private GangweishenqingService gangweishenqingService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GangweishenqingEntity gangweishenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			gangweishenqing.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			gangweishenqing.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GangweishenqingEntity> ew = new EntityWrapper<GangweishenqingEntity>();
		PageUtils page = gangweishenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweishenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GangweishenqingEntity gangweishenqing, HttpServletRequest request){
        EntityWrapper<GangweishenqingEntity> ew = new EntityWrapper<GangweishenqingEntity>();
		PageUtils page = gangweishenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweishenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GangweishenqingEntity gangweishenqing){
       	EntityWrapper<GangweishenqingEntity> ew = new EntityWrapper<GangweishenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gangweishenqing, "gangweishenqing")); 
        return R.ok().put("data", gangweishenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GangweishenqingEntity gangweishenqing){
        EntityWrapper< GangweishenqingEntity> ew = new EntityWrapper< GangweishenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gangweishenqing, "gangweishenqing")); 
		GangweishenqingView gangweishenqingView =  gangweishenqingService.selectView(ew);
		return R.ok("查询岗位申请成功").put("data", gangweishenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GangweishenqingEntity gangweishenqing = gangweishenqingService.selectById(id);
        return R.ok().put("data", gangweishenqing);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GangweishenqingEntity gangweishenqing = gangweishenqingService.selectById(id);
        return R.ok().put("data", gangweishenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GangweishenqingEntity gangweishenqing, HttpServletRequest request){
    	gangweishenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gangweishenqing);
        gangweishenqingService.insert(gangweishenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GangweishenqingEntity gangweishenqing, HttpServletRequest request){
    	gangweishenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gangweishenqing);
        gangweishenqingService.insert(gangweishenqing);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GangweishenqingEntity gangweishenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gangweishenqing);
        gangweishenqingService.updateById(gangweishenqing);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gangweishenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<GangweishenqingEntity> wrapper = new EntityWrapper<GangweishenqingEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			wrapper.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = gangweishenqingService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
