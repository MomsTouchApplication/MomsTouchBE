package com.momstouch.momstouchbe.domain.order.service;

import com.momstouch.momstouchbe.domain.member.model.Member;
import com.momstouch.momstouchbe.domain.order.application.OrderInfo;
import com.momstouch.momstouchbe.domain.order.model.Order;
import com.momstouch.momstouchbe.domain.order.model.OrderMenu;
import com.momstouch.momstouchbe.domain.order.model.OrderOption;
import com.momstouch.momstouchbe.domain.order.model.OrderOptionGroup;
import com.momstouch.momstouchbe.domain.order.model.repository.OrderRepository;
import com.momstouch.momstouchbe.domain.shop.model.Menu;
import com.momstouch.momstouchbe.domain.shop.model.Shop;
import com.momstouch.momstouchbe.global.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;


    @Transactional
    public Long createOrder(OrderInfo orderInfo) {
        List<MenuInfo> orderMenuList = orderInfo.getOrderMenuList();
        Money totalPrice = Money.ZERO;

        for (MenuInfo menuInfo : orderMenuList) {
            Money menuPrice = menuInfo.getTotalPrice();
            totalPrice = totalPrice.plus(menuPrice);
        }

        Member member = orderInfo.getMember();
        Shop shop = orderInfo.getShop();

        Order order = Order.builder()
                .member(member)
                .shop(shop)
                .address(orderInfo.getAddress())
                .totalPrice(totalPrice)
                .build();

        for (MenuInfo menuInfo : orderMenuList) {
            Menu menu = menuInfo.getMenu();
            List<OptionGroupSelectInfo> optionGroupSelectInfoList = menuInfo.getOptionGroupSelectInfoList();

            OrderMenu orderMenu = OrderMenu.builder()
                    .count(menuInfo.getCount())
                    .menu(menu)
                    .order(order)
                    .build();

            for (OptionGroupSelectInfo optionGroupSelectInfo : optionGroupSelectInfoList) {
                OrderOptionGroup orderOptionGroup = OrderOptionGroup
                        .builder()
                        .name(optionGroupSelectInfo.getName())
                        .build();

                List<OptionSelectInfo> optionSelectInfoList = optionGroupSelectInfo.getOptionSelectInfoList();
                for (OptionSelectInfo optionSelectInfo : optionSelectInfoList) {
                    OrderOption orderOption = new OrderOption(optionSelectInfo.getName(), optionSelectInfo.getPrice());
                    orderOptionGroup.addOrderOption(orderOption);
                }

                orderMenu.order(order);
            }

        }

        orderRepository.save(order);


        return order.getId();
    }

}
