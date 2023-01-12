package com.en.controller;

import com.en.Service.IProductService;
import com.en.po.ProductPo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private IProductService iProductService;

    @RequestMapping(value="/getInfoById/{id}")
    @HystrixCommand(fallbackMethod = "getFallback")
    public Object get(@PathVariable("id") long id) {
        ProductPo productPo = iProductService.getInfoById(id);
        if (productPo == null) {
            throw new RuntimeException("该产品已下架！");
        }
        return productPo;
    }

    public Object getFallback(@PathVariable("id") long id){
        ProductPo productPo = new ProductPo();
        productPo.setProductName("HystrixName");
        productPo.setProductDesc("HystrixDesc");
        productPo.setProductId(0L);
        return productPo;

    }

    @RequestMapping(value="/addInfo")
    public Object add(@RequestBody ProductPo productPo) {
        return this.iProductService.addInfo(productPo);
    }

    @RequestMapping(value = "getAllInfo")
    public Object list() {
        return this.iProductService.getAllInfo();
    }

}
