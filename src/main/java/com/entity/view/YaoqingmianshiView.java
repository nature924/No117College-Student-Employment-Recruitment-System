package com.entity.view;

import com.entity.YaoqingmianshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 邀请面试
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-12 22:13:26
 */
@TableName("yaoqingmianshi")
public class YaoqingmianshiView  extends YaoqingmianshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YaoqingmianshiView(){
	}
 
 	public YaoqingmianshiView(YaoqingmianshiEntity yaoqingmianshiEntity){
 	try {
			BeanUtils.copyProperties(this, yaoqingmianshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
