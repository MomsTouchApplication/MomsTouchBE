import React from "react";
import styles from '../styles/MainPage.module.css';
import ItemList from "../components/ItemList";

const MainPage = () => {
    return (
        <>
            <ItemList className={styles.ItemList}></ItemList>
        </>
    )
}

export default MainPage;