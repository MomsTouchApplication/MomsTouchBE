import React from 'react';
import styles from '../styles/MenuDetailInfo.module.css';

const MenuDetailInfo = () => {
    return (
        <>
            <div className={styles.MenuInfoBox}>
                <h2>메뉴 이름: </h2>
                <p>메뉴 설명 ~~~ </p>
                <p>메뉴 설명 ~~~ </p>
                <p>메뉴 설명 ~~~ </p>
                <p>메뉴 설명 ~~~ </p>
                <p>메뉴 설명 ~~~ </p>
                <p>메뉴 가격: 0원</p>
            </div>
        </>
    );
};

export default MenuDetailInfo;