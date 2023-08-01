package kr.hs.study.product.dao;

import kr.hs.study.product.dto.productDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class productDAOImpl implements productDAO{
    @Autowired
    private JdbcTemplate jdbc;

    public void insert(productDTO dto) {
        String sql="insert into product values(?,?)";
        jdbc.update(sql,dto.getProductId(),dto.getProductName());

    }

    @Override
    public List<productDTO> listAll() {
        String sql="select * from product order by productId desc";
        List<productDTO> list=jdbc.query(sql,new BeanPropertyRowMapper<>(productDTO.class));
        return list;
    }

    @Override
    public void del_Product(String id) {
        String sql="delete from product where productId='"+id+"'";
        jdbc.update(sql);

    }

    @Override
    public productDTO readOne(String id) {
        String sql="select * from product where productId="+id;
  productDTO dto=jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(productDTO.class));
        return dto;
    }
}
