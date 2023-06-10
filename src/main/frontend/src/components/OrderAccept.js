import React from 'react';
import styles from '../styles/OrderAccept.module.css'

const items = [
    {id: 1, status: "Order", address: "대구시 북구 관음동로 41"},
    {id: 2, status: "Ready", address: "구미시 대학로 17-14"}
]
const OrderAccept = () => {

    const statusNum = status => {
        return status.padStart(5, " ");
    }

    const addressNum = address => {
        return address.padStart(15, " ");
    }
    return (
        <ul className={styles.DivUl}>
            {items.map(item => {
                return <li key={item.id} className={styles.DivLi}><p className={styles.PTag}>{item.id}</p><p className={styles.PTag}>{statusNum(item.status)}</p><p className={styles.PTag}>{addressNum(item.address)}</p><button className={styles.BtnTag}>승인</button><button className={styles.BtnTag}>거절</button></li>
            })}
        </ul>
    );
};

export default OrderAccept;