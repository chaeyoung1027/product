package kr.hs.study.product.dao;

import kr.hs.study.product.dto.productDTO;

import java.util.List;

public interface productDAO {
    public void insert(productDTO dto);
    public List<productDTO> listAll();
    public void del_Product(String id);
    void update(productDTO dto);
    public productDTO readOne(String id);
}
