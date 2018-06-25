package com.ddc.template.modules.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ddc.template.common.utils.PageUtils;
import com.ddc.template.common.utils.Query;
import com.ddc.template.modules.sys.dao.GoodsDao;
import com.ddc.template.modules.sys.entity.GoodsEntity;
import com.ddc.template.modules.sys.service.GoodsService;


@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, GoodsEntity> implements GoodsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsEntity> page = this.selectPage(
                new Query<GoodsEntity>(params).getPage(),
                new EntityWrapper<GoodsEntity>()
        );

        return new PageUtils(page);
    }

    
    
	@Override
	@Transactional
	public void testUpateTraction(Integer num1, Integer num2) {
		List<GoodsEntity> geList = this.selectList(null);
		geList.forEach(c->{
			if(c.getGoodsId().equals(3L)){
				c.setNum(num1);
			}
			if(c.getGoodsId().equals(4L)){
				c.setNum(num2);
			}
			updateById(c);
		});
		//updateByBatchId(geList) //此中方式更新会有问题，同事务相同商品只会更最开始那一个商品，后面都不会更新
	}
	
	@Override
	@Transactional
	public void testUpdateListTraction(){
		for(int i=1;i<3;i++){
			testUpateTraction(i,i+1);
		}
	}
	

}
