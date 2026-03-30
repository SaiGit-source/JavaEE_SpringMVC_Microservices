package com.microservices.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.ecommerce.model.OrderDTO;
import com.microservices.ecommerce.model.User;
import com.microservices.ecommerce.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long userId) {
        var user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        var url = "http://order-service:8080/orders/user/" + userId;
        var orders = restTemplate.getForObject(url, OrderDTO[].class);
        if (orders!=null){
            user.setOrders(List.of(orders));
        }
        return user;
    }

    public User getUserByName(String name) {
        return userRepository.findAll().stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found with name: " + name));
    }
}
