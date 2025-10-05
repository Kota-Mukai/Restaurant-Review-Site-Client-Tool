package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Restaurant;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepository {
   
	private final JdbcTemplate jdbcTemplate;

	@Override
	public List<Restaurant> selectByNameWildCard(String restaurantName) {
		
		String sql = 
				"SELECT                                                " +
		        "res.restaurant_id,                                    " +
				"res.restaurant_name,                                  " +
		        "res.tagline,                                          " +
				"COALESCE(AVG(rev.rating), 0.0) average_rating         " +
		        "FROM                                                  " +
				"restaurants res                                       " +
		        "LEFT OUTER JOIN reviews rev                           " +
				"             ON res.restaurant_id = rev.restaurant_id " +
		        "WHERE                                                 " +
				" res.restaurant_name LIKE ?                           " +
		        "GROUP BY                                              " +
				"res.restaurant_id,                                    " +
		        "res.restaurant_name,                                  " +
				"res.tagline                                           " +
		        "ORDER BY                                              " +
				"res.restaurant_id                                     ";
		
		String p = "%" + restaurantName + "%";
		
		List<Map<String, Object>> list
		        = jdbcTemplate.queryForList(sql, p);
		
		List<Restaurant> result = new ArrayList<Restaurant>();
		for (Map<String, Object> one : list) {
			Restaurant restaurant = new Restaurant();
			restaurant.setRestaurantId((int)one.get("restaurant_id"));
			restaurant.setRestaurantName((String)one.get("restaurant_name"));
			restaurant.setTagline((String)one.get("tagline"));
			double d = ((BigDecimal)one.get("average_rating")).doubleValue();
			restaurant.setAverageRating(d);
			result.add(restaurant);
		}
		        
		return result;

	}

}