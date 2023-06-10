import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import React from "react";
import OwnerPage from "./pages/OwnerPage";
import CustomerPage from "./pages/CustomerPage";
const App = () => {
  return (
    <BrowserRouter>
      <Routes>
          <Route exact path={"/owner"} element={<OwnerPage />}></Route>
          <Route path={"/*"} element={<CustomerPage />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
