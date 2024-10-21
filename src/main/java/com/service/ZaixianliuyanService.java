package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZaixianliuyanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZaixianliuyanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZaixianliuyanView;


/**
 * 在线留言
 *
 * @author 
 * @email 
 * @date 2021-04-12 22:13:25
 */
public interface ZaixianliuyanService extends IService<ZaixianliuyanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZaixianliuyanVO> selectListVO(Wrapper<ZaixianliuyanEntity> wrapper);
   	
   	ZaixianliuyanVO selectVO(@Param("ew") Wrapper<ZaixianliuyanEntity> wrapper);
   	
   	List<ZaixianliuyanView> selectListView(Wrapper<ZaixianliuyanEntity> wrapper);
   	
   	ZaixianliuyanView selectView(@Param("ew") Wrapper<ZaixianliuyanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZaixianliuyanEntity> wrapper);
   	
}

