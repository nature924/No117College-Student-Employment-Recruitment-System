package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YaoqingmianshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YaoqingmianshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YaoqingmianshiView;


/**
 * 邀请面试
 *
 * @author 
 * @email 
 * @date 2021-04-12 22:13:26
 */
public interface YaoqingmianshiService extends IService<YaoqingmianshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YaoqingmianshiVO> selectListVO(Wrapper<YaoqingmianshiEntity> wrapper);
   	
   	YaoqingmianshiVO selectVO(@Param("ew") Wrapper<YaoqingmianshiEntity> wrapper);
   	
   	List<YaoqingmianshiView> selectListView(Wrapper<YaoqingmianshiEntity> wrapper);
   	
   	YaoqingmianshiView selectView(@Param("ew") Wrapper<YaoqingmianshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YaoqingmianshiEntity> wrapper);
   	
}

