package com.xindus.wishlist.Wishlist;

import com.xindus.wishlist.Controller.WishlistController;
import com.xindus.wishlist.Exception.UserNotFoundException;
import com.xindus.wishlist.Models.User;
import com.xindus.wishlist.Models.WishlistItems;
import com.xindus.wishlist.Repository.UserRepository;
import com.xindus.wishlist.Repository.WishlistRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class WishlistTest {

    @Autowired
    private WishlistController wishlistController;
    @Mock
    private Authentication authentication;
    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        Mockito.when(authentication.getName()).thenReturn("john");
    }

    @Test
    public void UserNotFound_WishList() throws Exception {

        var runtimeException = Assertions.assertThrows(UserNotFoundException.class, () -> wishlistController.getUserWishlist(authentication));

        Assertions.assertEquals("please enter the correct username", runtimeException.getMessage());
    }

    @Test
    public void EmptyWishlist() {

        Mockito.when(userRepository.findByUsername(Mockito.anyString())).thenReturn(Optional.of(getTestUsers()));

        var response = wishlistController.getUserWishlist(authentication);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(getTestWishList().getName(), response.getBody().get(0).getName());

    }


    @Test
    public void AddWishList() {

        Mockito.when(userRepository.findByUsername(Mockito.anyString())).thenReturn(Optional.ofNullable(getTestUsers()));

        var response = wishlistController.addItemToWishlist(authentication, getTestWishList());

        Assertions.assertEquals("Wishlist item has been added to your wishlist", response.getBody().toString());
    }

    private User getTestUsers() {
        List<WishlistItems> wishList = new ArrayList<>();
        wishList.add(getTestWishList());
        User users = User.builder().username("john").email("john@mail.com").wishlistItemsList(wishList).build();
        return users;
    }

    private WishlistItems getTestWishList() {
        return WishlistItems.builder().name("colgate").price(200).build();
    }
}
