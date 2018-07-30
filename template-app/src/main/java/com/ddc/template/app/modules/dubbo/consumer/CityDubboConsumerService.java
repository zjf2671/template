package com.ddc.template.app.modules.dubbo.consumer;

import org.springframework.stereotype.Component;

/**
 * 城市 Dubbo 服务消费者
 *
 */
@Component
public class CityDubboConsumerService {

   /* @Reference(version = "1.0.0")
    CityDubboService cityDubboService;

    public City printCity() {
        String cityName="温岭";
        City city = null;
		try {
			city = cityDubboService.findCityByName(cityName);
		} catch (Exception e) {
			throw new SOAException("--------调用dubbo服务findCityByName失败", e);
		}
        return city;
    }*/
}
