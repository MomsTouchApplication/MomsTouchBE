import React from 'react';
import OrderList from "../components/OrderList";
import OrderPrice from "../components/OrderPrice";
import OrderButton from "../components/OrderButton";

const items = [
    {id: 1, name: '햄', price: 10000}, {id: 2, name: '거', price: 5000}
]
const OrderListPage = () => {
    return (
        <>
            <OrderList list = {items}/>
            <OrderPrice list = {items}/>

            <OrderButton />
        </>
    );
};

export default OrderListPage;