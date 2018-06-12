package com.ddc.template.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddc.template.common.utils.R;
import com.ddc.template.manage.shop.ShopManage;
import com.ddc.template.vo.ShopVO;


/**
 * 店铺
 * @author harry.zhang
 *
 */
@RestController
@RequestMapping("service/shop")
public class ShopServiceController {
    @Autowired
    private ShopManage shopManage;

    @RequestMapping("list")
    public R list(){
    	List<ShopVO> selectByMap = shopManage.findShopList();
    	return R.ok().put("shopList", selectByMap);
    }

}
