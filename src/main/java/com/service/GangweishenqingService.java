package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GangweishenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GangweishenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GangweishenqingView;


/**
 * 岗位申请
 *
 * @author 
 * @email 
 * @date 2021-04-12 22:13:25
 */
public interface GangweishenqingService extends IService<GangweishenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GangweishenqingVO> selectListVO(Wrapper<GangweishenqingEntity> wrapper);
   	
   	GangweishenqingVO selectVO(@Param("ew") Wrapper<GangweishenqingEntity> wrapper);
   	
   	List<GangweishenqingView> selectListView(Wrapper<GangweishenqingEntity> wrapper);
   	
   	GangweishenqingView selectView(@Param("ew") Wrapper<GangweishenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GangweishenqingEntity> wrapper);
   	
}

