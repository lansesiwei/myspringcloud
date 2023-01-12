package com.en.controller;

import com.en.po.ProductPo;
import com.en.service.IProductClientService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ConsumerProductController
 * @Description some description
 * @Author Jason
 * @Date 2023/1/6 16:19
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {

    @Resource
    private IProductClientService iProductClientService;

    @RequestMapping("/product/getInfoById")
    public Object getProduct(long id) {
        return iProductClientService.getProduct(id);
    }

    @RequestMapping("/product/getAllInfo")
    public Object listProduct() {
        return iProductClientService.listProduct();
    }

    @RequestMapping("/product/addInfo")
    public Object addProduct(ProductPo productPo) {
        return iProductClientService.addProduct(productPo);
    }

}
