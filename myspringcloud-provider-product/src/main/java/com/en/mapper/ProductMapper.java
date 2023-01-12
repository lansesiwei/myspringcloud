package com.en.mapper;

import com.en.po.ProductPo;

import java.util.List;

public interface ProductMapper {

    /**
     * @Description 添加数据
     * @param productPo
     * @return boolean
     * @throws
     */
    boolean addInfo(ProductPo productPo);

    /**
     * @Description 根据ID获取信息
     * @param id
     * @return ProductPo
     * @throws
     */
    ProductPo getInfoById(Long id);

    /**
     * @Description 查询数据库所有信息
     * @return List<ProductPo>
     * @throws
     */
    List<ProductPo> getAllInfo();
}
