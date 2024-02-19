package com.xindus.wishlist.Service;


import com.xindus.wishlist.Exception.UserNotFoundException;
import com.xindus.wishlist.Exception.WishlistItemNotFoundException;
import com.xindus.wishlist.Models.Dto.WishList;
import com.xindus.wishlist.Models.User;
import com.xindus.wishlist.Models.WishlistItems;
import com.xindus.wishlist.Repository.UserRepository;
import com.xindus.wishlist.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WishlistRepository wishlistRepository;


    public List<WishList> getUserWishlist(String username) {
        Optional<User> optionalUsers = userRepository.findByUsername(username);
        if (optionalUsers.isPresent()) {

            User users = optionalUsers.get();
            List<WishList> wishList = new ArrayList<>();
            for(WishlistItems item: users.getWishlistItemsList()){
                wishList.add(WishList.builder().name(item.getName()).price(item.getPrice()).build());
            }
            return wishList;
        } else {
            throw new UserNotFoundException("wrong username");
        }
    }

    public String addItems(WishlistItems wishlistItem, String username) {
        Optional<User> optionalUsers = userRepository.findByUsername(username);
        if (optionalUsers.isPresent()) {
            User users = optionalUsers.get();
            users.getWishlistItemsList().add(wishlistItem);
            wishlistItem.setUser(users);
            userRepository.save(users);
            return "Item added to wishlist";
        } else {
            throw new UserNotFoundException("Wrong username"); // Handle case where user is not found
        }
    }

    public String removeItems(String username,Integer productId) throws Exception {
        Optional<User> optionalUsers = userRepository.findByUsername(username);
        if (optionalUsers.isPresent()) {
            User users = optionalUsers.get();
            Optional<WishlistItems> optionalWishlistItems = wishlistRepository.findById(productId);
            if (optionalWishlistItems.isPresent()) {
                wishlistRepository.deleteById(productId);
                return "Item removed from wishlist";
            } else {
                throw new WishlistItemNotFoundException("Item not found");
            }
        } else {
            throw new UserNotFoundException("Wrong username");
        }
    }
}
