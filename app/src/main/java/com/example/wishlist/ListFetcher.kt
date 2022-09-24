package com.example.wishlist

class ListFetcher {
    companion object {
        var wishlist: MutableList<Item> = ArrayList()

        fun GetWishList(): MutableList<Item> {
            return wishlist
        }
        fun AddToWishlist(item: Item):MutableList<Item> {
            wishlist.add(item)
            return wishlist
        }
    }
}