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
	public void testUpateTransaction(Integer num1, Integer num2) {
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
//		updateBatchById(geList); //此种方式更新会有问题，同事务相同商品只会更新列表第一个商品，version只会+1，后面都不会更新
	}
	
	@Override
	@Transactional
	public void testUpdateListTransaction(){
		for(int i=1;i<3;i++){
			testUpateTransaction(i,i+1);
		}
	}
	

}
