import React from 'react';
import styles from '../styles/OrderList.module.css';


const OrderList = ({list}) => {
    return (
        <ul className={styles.DivUl}>
            {list.map(item => {
                return <li key={item.id} className={styles.DivLi}><p className={styles.ItemName}>{item.name}</p> <p className={styles.ItemPrice}>{item.price}원</p></li>
            })}
        </ul>
    );
};

export default OrderList;