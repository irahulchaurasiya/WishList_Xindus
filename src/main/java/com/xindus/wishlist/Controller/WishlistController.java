package com.xindus.wishlist.Controller;


import com.xindus.wishlist.Models.Dto.WishList;
import com.xindus.wishlist.Models.WishlistItems;
import com.xindus.wishlist.Service.UserService;
import com.xindus.wishlist.Service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {
    @Autowired
    private WishlistService wishlistService;
    
    @Autowired 
    private UserService userService;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WishList>> getUserWishlist(Authentication authentication) {
        var username = authentication.getName();
        List<WishList> wishlistItemsList = wishlistService.getUserWishlist(username);
        return new ResponseEntity(wishlistItemsList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addItemToWishlist(Authentication authentication, @RequestBody WishlistItems wishlistItem) {
        String username = authentication.getName();
        String result = wishlistService.addItems(wishlistItem, username);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> removeItemFromWishlist(Authentication authentication, @PathVariable Integer productId) throws Exception {
        String username = authentication.getName();
        String result = wishlistService.removeItems(username, productId);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
