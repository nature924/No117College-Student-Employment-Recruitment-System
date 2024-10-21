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


import com.dao.ZaixianliuyanDao;
import com.entity.ZaixianliuyanEntity;
import com.service.ZaixianliuyanService;
import com.entity.vo.ZaixianliuyanVO;
import com.entity.view.ZaixianliuyanView;

@Service("zaixianliuyanService")
public class ZaixianliuyanServiceImpl extends ServiceImpl<ZaixianliuyanDao, ZaixianliuyanEntity> implements ZaixianliuyanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZaixianliuyanEntity> page = this.selectPage(
                new Query<ZaixianliuyanEntity>(params).getPage(),
                new EntityWrapper<ZaixianliuyanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZaixianliuyanEntity> wrapper) {
		  Page<ZaixianliuyanView> page =new Query<ZaixianliuyanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZaixianliuyanVO> selectListVO(Wrapper<ZaixianliuyanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZaixianliuyanVO selectVO(Wrapper<ZaixianliuyanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZaixianliuyanView> selectListView(Wrapper<ZaixianliuyanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZaixianliuyanView selectView(Wrapper<ZaixianliuyanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
