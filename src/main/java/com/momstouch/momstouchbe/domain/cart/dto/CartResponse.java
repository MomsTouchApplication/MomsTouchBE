package com.momstouch.momstouchbe.domain.cart.dto;

import com.momstouch.momstouchbe.domain.cart.model.Cart;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class CartResponse {

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor
    @Getter
    @Setter
    public static class CartSearchResponse {

        List<CartMenuResponse> cartMenuList = new ArrayList<>();

        public static CartSearchResponse of(Cart cart) {
            CartSearchResponse cartSearchResponse = new CartSearchResponse();
            cart.getCartMenuList().forEach(cartMenu -> {
                CartMenuResponse cartMenuResponse = CartMenuResponse.builder()
                        .menuId(cartMenu.getMenuId())
                        .discountPolicyId(cartMenu.getDiscountPolicy().getId())
                        .quantity(cartMenu.getQuantity())
                        .price(cartMenu.getPrice().getAmount().intValueExact())
                        .build();
                cartMenu.getCartMenuOptionGroupList().forEach(cartMenuOptionGroup -> {
                    CartMenuOptionGroupResponse cartMenuOptionGroupResponse = CartMenuOptionGroupResponse.builder()
                            .menuOptionGroupId(cartMenuOptionGroup.getMenuOptionGroupId())
                            .build();
                    cartMenuOptionGroup.getCartMenuOptionList().forEach(cartMenuOption -> {
                        CartMenuOptionResponse cartMenuOptionResponse = CartMenuOptionResponse.builder()
                                .menuOptionId(cartMenuOption.getMenuOptionId())
                                .price(cartMenuOption.getPrice().getAmount().intValueExact())
                                .build();
                        cartMenuOptionGroupResponse.getCartMenuOptionList().add(cartMenuOptionResponse);
                    });
                    cartMenuResponse.getCartMenuOptionGroupList().add(cartMenuOptionGroupResponse);
                });
                cartSearchResponse.getCartMenuList().add(cartMenuResponse);
            });
            return cartSearchResponse;
        }
    }

    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor
    @Getter @Setter
    public static class CartMenuResponse {

        private Long menuId;
        private Long discountPolicyId;
        private Integer quantity;
        private Integer price;

        @Builder.Default
        private List<CartMenuOptionGroupResponse> cartMenuOptionGroupList = new ArrayList<>();


    }

    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter @Setter
    public static class CartMenuOptionGroupResponse {
        private Long menuOptionGroupId;

        @Builder.Default
        private List<CartMenuOptionResponse> cartMenuOptionList = new ArrayList<>();
    }

    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter @Setter
    public static class CartMenuOptionResponse {
        private Long menuOptionId;
        private Integer price;
    }
}
