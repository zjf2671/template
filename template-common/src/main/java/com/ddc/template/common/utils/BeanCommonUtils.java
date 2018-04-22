package com.ddc.template.common.utils;

import java.util.List;

import org.springframework.beans.BeanUtils;



/**
 * 对象转换工具类
 * 
 * @author harry.zhang
 */
public class BeanCommonUtils {

	/**
	 * 
	 * @param source 源
	 * @param target 目标
	 */
	public static void copyProperties(Object source, Object target) {
		BeanUtils.copyProperties(source, target);
	}
	
	/**
	 * @param source 源
	 * @param targetBean 目标对象
	 * @return List<T> 结果对象
	 */
//	public static <F, T> List<T> copyListProperties(List<F> source, Class<T> targetBean){
//		List<T> target = Lists.transform(source, input -> {
//			try {
//				T newInstance = targetBean.newInstance();
//				BeanUtils.copyProperties(input, newInstance);
//				return newInstance;
//			} catch (InstantiationException | IllegalAccessException e) {
//				e.printStackTrace();
//			}
//			return null;
//		});
//		return target;
//	}
	
	
	/**
	 * @param source 源
	 * @param target 目标
	 * @param targetBean 目标对象
	 */
	public static <F, T> void copyListProperties(List<F> source, List<T> target, Class<T> targetBean) {
		source.stream().forEach(c -> {
			T newInstance;
			try {
				newInstance = targetBean.newInstance();
				BeanUtils.copyProperties(c, newInstance);
				target.add(newInstance);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		});
	}
	
//	public static void main(String[] args) {
//		List<A> list = new ArrayList<A>();
//		for(int i=0;i<50;i++){
//			list.add(new A(i+"name",i+"title"));
//		}
//		System.out.println(JSON.toJSONString(list));
//		List<B> listb = new ArrayList<B>();
//		BeanCommonUtils.copyListProperties(list,listb, B.class);
//		System.out.println(JSON.toJSONString(listb));
//	}
	

}

//class A{
//	String name;
//	String title;
//	
//	public A(){};
//	public A(String name,String title){
//		this.name = name;
//		this.title = title;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	
//}
//
//class B{
//	String name;
//	String title;
//	
//	public B(){};
//	public B(String name,String title){
//		this.name = name;
//		this.title = title;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
	
//}
