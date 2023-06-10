import React from 'react';
import MenuDetailInfo from "../components/MenuDetailInfo";
import MenuPlusBtnContainer from "../components/MenuPlusBtnContainer";
import ShopBasket from "../components/ShopBasket";

const MenuDetailPage = () => {
    return (
        <>
            <MenuDetailInfo/>
            <MenuPlusBtnContainer />
            <ShopBasket />
        </>
    );
};

export default MenuDetailPage;