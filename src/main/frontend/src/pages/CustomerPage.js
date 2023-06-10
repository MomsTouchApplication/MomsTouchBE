import React from 'react';
import {Route, Routes} from "react-router-dom";
import MainPage from "./MainPage";
import MenuDetailPage from "./MenuDetailPage";
import OrderListPage from "./OrderListPage";
import Header from "../components/Header";

const CustomerPage = () => {
    return (
        <>
            <Header />
            <Routes>
                <Route path={"/"} element={<MainPage />}></Route>
                <Route path={"/detail/:itemId"} element={<MenuDetailPage />}></Route>
                <Route path={"/order"} element={<OrderListPage />}></Route>
            </Routes>
        </>
    );
};

export default CustomerPage;