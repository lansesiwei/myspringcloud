package com.en.service.fallback;

import com.en.po.ProductPo;
import com.en.service.IProductClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName IProductClientServiceFallbackFactory
 * @Description some description
 * @Author Jason
 * @Date 2023/1/11 10:53
 */
@Component
public class IProductClientServiceFallbackFactory implements FallbackFactory<IProductClientService> {
    @Override
    public IProductClientService create(Throwable throwable) {
        return new IProductClientService() {
            @Override
            public ProductPo getProduct(long id) {
                ProductPo productPo = new ProductPo();
                productPo.setProductId(999999L);
                productPo.setProductName("feign-hystrixName");
                productPo.setProductDesc("feign-hyStrixDesc");
                return productPo;
            }

            @Override
            public List<ProductPo> listProduct() {
                return null;
            }

            @Override
            public boolean addProduct(ProductPo productPo) {
                return false;
            }
        };
    }
}
