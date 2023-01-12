package com.en.Service;

import com.en.po.ProductPo;

import java.util.List;

public interface IProductService {

    /**
     * @Description 根据ID获取信息
     * @param id
     * @return ProductPo
     * @throws
     */
    ProductPo getInfoById(long id);

    /**
     * @Description 添加数据
     * @param productPo
     * @return boolean
     * @throws
     */
    boolean addInfo(ProductPo productPo);

    /**
     * @Description 查询数据库所有信息
     * @return List<ProductPo>
     * @throws
     */
    List<ProductPo> getAllInfo();
}
