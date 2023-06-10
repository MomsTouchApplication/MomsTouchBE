import React from 'react';
import styles from '../styles/OrderPrice.module.css'
const OrderPrice = ({list}) => {

    return (
        <>
            <p className={styles.SumOfPrice}>총 주문 금액: <p className={styles.Price}>{list.reduce((prev, cur) => prev + cur.price, 0)}</p>원</p>
        </>
    );
};

export default OrderPrice;