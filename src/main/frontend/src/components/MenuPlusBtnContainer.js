import React, {useEffect} from 'react';
import styles from '../styles/MenuPlusBtnContainer.module.css'



const MenuPlusBtnContainer = () => {
    const items = [
        {id: 1, name: "단품", count: 0}, {id: 2, name: "세트", count: 0}, {id: 3, name: "감자튀김", count: 0}, {id: 4, name: "음료", count: 0}
    ]
    const plusCnt = item => {
        console.log(item)
        item.count++;
    }
    const getCnt = item => {
        if (item === undefined) return;
        return item.count;
    }
    useEffect(() => {
        getCnt();
    }, [items])

    const minusCnt = item => {
        console.log(item)
        item.count <= 0 ? item.count = 0 : item.count--;
    }
    return (
        <ul className={styles.DivUl}>
            {items.map(item => {
                return <li key={item.id} className={styles.DivLi}>{item.name}<p>
                    <button className={styles.PlusBtn} onClick={() => plusCnt(item)}>+ </button>{getCnt(item)}<button className={styles.MinusBtn} onClick={() => minusCnt(item)}> -</button>
                </p></li>
            })}
        </ul>
    );
};

export default MenuPlusBtnContainer;