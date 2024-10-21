package com.entity.view;

import com.entity.QiuzhixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 求职信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-12 22:13:25
 */
@TableName("qiuzhixinxi")
public class QiuzhixinxiView  extends QiuzhixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QiuzhixinxiView(){
	}
 
 	public QiuzhixinxiView(QiuzhixinxiEntity qiuzhixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, qiuzhixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
