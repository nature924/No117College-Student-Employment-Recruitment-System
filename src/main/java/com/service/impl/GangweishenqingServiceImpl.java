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


import com.dao.GangweishenqingDao;
import com.entity.GangweishenqingEntity;
import com.service.GangweishenqingService;
import com.entity.vo.GangweishenqingVO;
import com.entity.view.GangweishenqingView;

@Service("gangweishenqingService")
public class GangweishenqingServiceImpl extends ServiceImpl<GangweishenqingDao, GangweishenqingEntity> implements GangweishenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GangweishenqingEntity> page = this.selectPage(
                new Query<GangweishenqingEntity>(params).getPage(),
                new EntityWrapper<GangweishenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GangweishenqingEntity> wrapper) {
		  Page<GangweishenqingView> page =new Query<GangweishenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GangweishenqingVO> selectListVO(Wrapper<GangweishenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GangweishenqingVO selectVO(Wrapper<GangweishenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GangweishenqingView> selectListView(Wrapper<GangweishenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GangweishenqingView selectView(Wrapper<GangweishenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
