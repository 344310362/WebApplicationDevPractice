package com.springPractice.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.springPractice.domain.Product;

public class JdbcProductDao extends SimpleJdbcDaoSupport implements ProdcutDao {

	public List<Product> getProductList() {
		List<Product> products = getSimpleJdbcTemplate().query(
				"select id,  description, price from products", 
				new ProductMapper());
		return products;
	}

	public void saveProduct(Product product) {
		int count = getSimpleJdbcTemplate().update(
				"update products set description = :description, price = :price where id = :id",
				new MapSqlParameterSource().addValue("description", product.getDescription())
				                           .addValue("price", product.getPrice())
				                           .addValue("id", product.getId())
				);

	}
	
	private static class ProductMapper implements ParameterizedRowMapper<Product>{

		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setDescription(rs.getString("description"));
			product.setPrice(rs.getDouble("price"));
			return product;
		}}
}
