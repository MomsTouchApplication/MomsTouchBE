import React from 'react';
import styles from '../styles/SaleRatio.module.css';

const SaleRatio = () => {
    return (
        <form className={styles.FormTag}>
            <label className={styles.LabelTag}>조조 할인률</label><input className={styles.InputTag} type={"text"} placeholder={"원"} autoFocus={true}/><br />
            <label className={styles.LabelTag}>정율 할인률</label><input className={styles.InputTag} type={"text"} placeholder={"원"}/><br />
            <label className={styles.LabelTag}>정률 할인률</label><input className={styles.InputTag} type={"text"} placeholder={"원"}/><br />
            
            <button className={styles.BtnTag} type={"submit"}>수정하기</button>
        </form>
    );
};

export default SaleRatio;