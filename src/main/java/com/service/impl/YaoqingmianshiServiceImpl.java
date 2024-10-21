package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YaoqingmianshiDao;
import com.entity.YaoqingmianshiEntity;
import com.service.YaoqingmianshiService;
import com.entity.vo.YaoqingmianshiVO;
import com.entity.view.YaoqingmianshiView;

@Service("yaoqingmianshiService")
public class YaoqingmianshiServiceImpl extends ServiceImpl<YaoqingmianshiDao, YaoqingmianshiEntity> implements YaoqingmianshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YaoqingmianshiEntity> page = this.selectPage(
                new Query<YaoqingmianshiEntity>(params).getPage(),
                new EntityWrapper<YaoqingmianshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YaoqingmianshiEntity> wrapper) {
		  Page<YaoqingmianshiView> page =new Query<YaoqingmianshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YaoqingmianshiVO> selectListVO(Wrapper<YaoqingmianshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YaoqingmianshiVO selectVO(Wrapper<YaoqingmianshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YaoqingmianshiView> selectListView(Wrapper<YaoqingmianshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YaoqingmianshiView selectView(Wrapper<YaoqingmianshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
