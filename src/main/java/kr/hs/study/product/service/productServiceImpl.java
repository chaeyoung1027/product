package kr.hs.study.product.service;

import kr.hs.study.product.dao.productDAO;
import kr.hs.study.product.dto.productDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productServiceImpl implements productService{
    @Autowired
    private productDAO dao;

    @Override
    public void insert(productDTO dto) {
        dao.insert(dto);

    }

    @Override
    public List<productDTO> listAll() {
        return dao.listAll();
    }

    @Override
    public void del_Product(String id) {
        dao.del_Product(id);
    }

    @Override
    public productDTO readOne(String id) {
        return dao.readOne(id);
    }
}
