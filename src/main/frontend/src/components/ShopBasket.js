import React from 'react';
import styles from '../styles/ShopBasket.module.css';
import {Link} from "react-router-dom";
const ShopBasket = () => {
    return (
        <>
            <button className={styles.ShopBtn}><Link to={"/"} className={styles.LinkTag}>장바구니 담기</Link></button>
        </>
    );
};

export default ShopBasket;