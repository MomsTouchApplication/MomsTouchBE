import React from 'react';
import styles from '../styles/Header.module.css';
import {Link} from "react-router-dom";
const Header = () => {
    return (
        <div className={styles.HeaderBox}>
            <div className={styles.Box}>
                <h2 className={styles.Logo}><Link to={"/"} className={styles.LinkTag}>MomsTouch</Link></h2>
            </div>
            <div className={styles.Box}>
                <h4 className={styles.Login}>Login</h4>
                <h4 className={styles.Order}><Link to={"/order"} className={styles.LinkTag}>Order</Link></h4>
            </div>
        </div>
    );
};

export default Header;