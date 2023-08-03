package kr.hs.study.product.service;

import kr.hs.study.product.dto.productDTO;

import java.util.List;

public interface productService {
    public void insert(productDTO dto);
    public List<productDTO> listAll();
    public void del_Product(String id);
    public productDTO readOne(String id);
    public void update(productDTO dto);
}
