package com.example.service;

import com.example.entity.Menu;
import com.example.entity.Restaurant;
import com.example.repository.MenuRepository;
import com.example.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuServiceImplementation implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public MenuServiceImplementation(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void addMenuItem(int restaurantId, Menu menu) {

        Menu item = new Menu();
        item.setAvailability(menu.getAvailability());
        item.setDescription(menu.getDescription());
        item.setDishName(menu.getDishName());
        item.setIngredients(menu.getIngredients());
        item.setPrice(menu.getPrice());
        item.setReview(menu.getReview());
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        item.setRestaurant(restaurant.get());

        menuRepository.save(item);
    }
}
