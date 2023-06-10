import React from 'react';
import styles from '../styles/Enrollment.module.css';

const Enrollment = () => {
    const submit = () => {
        console.log('hello');
    }

    return (
        <form className={styles.FormBox}>
            <label className={styles.LabelTag}>이름</label>
            <input className={styles.InputTag} type={"text"} /><br />
            <label className={styles.LabelTag}>단품 가격</label>
            <input className={styles.InputTag} type={"text"} /><br />
            <label className={styles.LabelTag}>세트 가격</label>
            <input className={styles.InputTag} type={"text"} /><br />
            <label className={styles.LabelTag}>이미지</label>
            <input className={styles.InputTag} type={"file"} accept={'image/*'}/><br />
            <label className={styles.LabelTag}>옵션</label>
            <input className={styles.InputTag} type={"text"} />
            <button className={styles.ButtonTag} onClick={() => submit()}>메뉴 등록</button>
        </form>
    );
};

export default Enrollment;