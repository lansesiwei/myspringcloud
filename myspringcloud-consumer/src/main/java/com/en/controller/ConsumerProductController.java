package com.en.controller;

import com.en.po.ProductPo;
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

    public static final String PRODUCT_GET_URL = "http://MYSPRINGCLOUD-PROVIDER-PRODUCT/product/getInfoById/";

    public static final String PRODUCT_LIST_URL = "http://MYSPRINGCLOUD-PROVIDER-PRODUCT/product/getAllInfo/";

    public static final String PRODUCT_ADD_URL = "http://MYSPRINGCLOUD-PROVIDER-PRODUCT/product/addInfo/";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders httpHeaders;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/product/getInfoById")
    public Object getProduct(long id) {
//        return restTemplate.getForObject(PRODUCT_GET_URL + id, ProductPo.class);
        return restTemplate.exchange(PRODUCT_GET_URL + id, HttpMethod.GET, new HttpEntity<>(httpHeaders), ProductPo.class).getBody();
    }

    @RequestMapping("/product/getAllInfo")
    public Object listProduct() {
//        return restTemplate.getForObject(PRODUCT_LIST_URL, List.class);
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("MYSPRINGCLOUD-PROVIDER-PRODUCT");
        System.out.println("【*** ServiceInstance ***】host = " + serviceInstance.getHost()
                + "、port = " + serviceInstance.getPort()
                + "、serviceId = " + serviceInstance.getServiceId());
        return restTemplate.exchange(PRODUCT_LIST_URL, HttpMethod.GET, new HttpEntity<>(httpHeaders), List.class).getBody();
    }

    @RequestMapping("/product/addInfo")
    public Object addProduct(ProductPo productPo) {
//        return restTemplate.postForObject(PRODUCT_ADD_URL, productPo, Boolean.class);
        return restTemplate.exchange(PRODUCT_ADD_URL, HttpMethod.POST, new HttpEntity<>(productPo, httpHeaders), Boolean.class).getBody();
    }

}
