package com.xindus.wishlist.Repository;

import com.xindus.wishlist.Models.WishlistItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WishlistRepository extends JpaRepository<WishlistItems,Integer> {
}
