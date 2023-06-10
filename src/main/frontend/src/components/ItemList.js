import React from 'react';
import styles from '../styles/Item.module.css';
import {Link} from "react-router-dom";

const items = [
    {id: 1, name: '햄'}, {id: 2, name: '버'}, {id: 3, name: '거'}, {id: 4, name: '먹'},
    {id: 5, name: '고'}, {id: 6, name: '고'}, {id: 7, name: '싶'}, {id: 8, name: '다'}
]

const ItemList = () => {
    return (
        <ul className={styles.DivUl}>
            {items.map(item => {
                return <Link to={`/detail/${item.id}`} className={styles.LinkTag}><li key={item.id} className={styles.DivLi}>{item.name}</li></Link>
            })}
        </ul>
    );
};

export default ItemList;