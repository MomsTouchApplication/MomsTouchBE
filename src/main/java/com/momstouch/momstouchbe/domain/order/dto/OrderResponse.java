package com.momstouch.momstouchbe.domain.order.dto;

import com.momstouch.momstouchbe.domain.discountpolicy.dto.DiscountResponse;
import com.momstouch.momstouchbe.domain.member.model.Member;
import com.momstouch.momstouchbe.domain.order.model.*;
import com.momstouch.momstouchbe.domain.shop.dto.ShopResponse;
import com.momstouch.momstouchbe.domain.shop.model.Menu;
import com.momstouch.momstouchbe.domain.shop.model.Shop;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.momstouch.momstouchbe.domain.discountpolicy.dto.DiscountResponse.*;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class OrderResponse {

    private Long orderId;
    private String address;
    private String phoneNumber;
    private BigDecimal totalPrice;
    private BigDecimal discountPrice;

    private OrderStatus status;

    private OrderShopResponse shop;

    private OrderMemberResponse customer;

    private List<OrderMenuResponse> orderMenus;

    public static OrderResponse of(Order order) {
        return builder()
                .orderId(order.getId())
                .address(order.getAddress())
                .phoneNumber(order.getPhoneNumber())
                .totalPrice(order.getTotalPrice().getAmount())
                .discountPrice(order.getDiscountPrice().getAmount())
                .status(order.getOrderStatus())
                .shop(new OrderShopResponse(order.getShop()))
                .customer(new OrderMemberResponse(order.getMember()))
                .orderMenus(order.getOrderMenuList().stream()
                        .map(OrderMenuResponse::new).collect(Collectors.toList()))
                .build();
    }


    @Getter
    private static class OrderMemberResponse {

        private Long id;
        private String name;

        public OrderMemberResponse(Member member) {
            this.id = member.getId();
            this.name = member.getAccount().getName();
        }
    }

    @Getter
    private static class OrderShopResponse {
        private Long shopId;
        private String shopName;

        public OrderShopResponse(Shop shop) {
            this.shopId = shop.getId();
            this.shopName = shop.getName();
        }
    }

    @Getter
    private static class OrderMenuResponse {
        private Long orderMenuId;
        private Integer count;
        private String menuName;
        private BigDecimal menuPrice;
        private DiscountPolicyResponse discountPolicy;
        private List<OrderMenuOptionGroupResponse> orderMenuOptionGroups;

        public OrderMenuResponse(OrderMenu orderMenu) {
            Menu menu = orderMenu.getMenu();
            this.orderMenuId = orderMenu.getId();
            this.count = orderMenu.getCount();
            this.menuName = menu.getName();
            this.menuPrice = menu.getPrice().getAmount();
            this.discountPolicy = DiscountPolicyResponse.of(menu.getDiscountPolicy());
            this.orderMenuOptionGroups = orderMenu.getOrderOptionGroupList().stream()
                    .map(OrderMenuOptionGroupResponse::new)
                    .collect(Collectors.toList());
        }
    }



    @Getter
    private static class OrderMenuOptionGroupResponse {
        private List<OrderMenuOptionResponse> orderOptions;
        private String name;
        private BigDecimal totalPrice;

        public OrderMenuOptionGroupResponse(OrderOptionGroup orderOptionGroup) {
            this.name = orderOptionGroup.getName();
            this.totalPrice = orderOptionGroup.totalPrice().getAmount();
            this.orderOptions = orderOptionGroup.getOrderOptionList().stream()
                    .map(OrderMenuOptionResponse::new)
                    .collect(Collectors.toList());
        }
    }

    @Getter
    private static class OrderMenuOptionResponse {
        private String name;
        private BigDecimal price;

        public OrderMenuOptionResponse(OrderOption orderOption) {
            this.name = orderOption.getName();
            this.price = orderOption.getPrice().getAmount();
        }
    }

    @Getter
    @Builder
    public static class OrderListResponse {

        private List<OrderResponse> orders;



        public static OrderListResponse of(List<Order> orders) {
            return builder()
                    .orders(orders.stream()
                            .map(OrderResponse::of).collect(Collectors.toList()))
                    .build();
        }
    }

}
