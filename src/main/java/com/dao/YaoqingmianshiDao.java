package com.dao;

import com.entity.YaoqingmianshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YaoqingmianshiVO;
import com.entity.view.YaoqingmianshiView;


/**
 * 邀请面试
 * 
 * @author 
 * @email 
 * @date 2021-04-12 22:13:26
 */
public interface YaoqingmianshiDao extends BaseMapper<YaoqingmianshiEntity> {
	
	List<YaoqingmianshiVO> selectListVO(@Param("ew") Wrapper<YaoqingmianshiEntity> wrapper);
	
	YaoqingmianshiVO selectVO(@Param("ew") Wrapper<YaoqingmianshiEntity> wrapper);
	
	List<YaoqingmianshiView> selectListView(@Param("ew") Wrapper<YaoqingmianshiEntity> wrapper);

	List<YaoqingmianshiView> selectListView(Pagination page,@Param("ew") Wrapper<YaoqingmianshiEntity> wrapper);
	
	YaoqingmianshiView selectView(@Param("ew") Wrapper<YaoqingmianshiEntity> wrapper);
	
}
