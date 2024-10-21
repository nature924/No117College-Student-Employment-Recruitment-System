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


import com.dao.QiuzhixinxiDao;
import com.entity.QiuzhixinxiEntity;
import com.service.QiuzhixinxiService;
import com.entity.vo.QiuzhixinxiVO;
import com.entity.view.QiuzhixinxiView;

@Service("qiuzhixinxiService")
public class QiuzhixinxiServiceImpl extends ServiceImpl<QiuzhixinxiDao, QiuzhixinxiEntity> implements QiuzhixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QiuzhixinxiEntity> page = this.selectPage(
                new Query<QiuzhixinxiEntity>(params).getPage(),
                new EntityWrapper<QiuzhixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QiuzhixinxiEntity> wrapper) {
		  Page<QiuzhixinxiView> page =new Query<QiuzhixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QiuzhixinxiVO> selectListVO(Wrapper<QiuzhixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QiuzhixinxiVO selectVO(Wrapper<QiuzhixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QiuzhixinxiView> selectListView(Wrapper<QiuzhixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QiuzhixinxiView selectView(Wrapper<QiuzhixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
