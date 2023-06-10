import React from 'react';
import styles from '../styles/OrderButton.module.css';

const OrderButton = () => {
    return (
        <>
            <button className={styles.Button}><p className={styles.Letter}>주문!</p></button>
        </>
    );
};

export default OrderButton;