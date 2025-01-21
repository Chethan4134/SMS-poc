import React, { lazy, Suspense } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
const Homepage = lazy(() => import("./pages/Home"));
const Product = lazy(() => import("./pages/product"));
const Module = lazy(() => import("./pages/module"));
const ProductModule = lazy(() => import("./pages/productModule"));

const Router = () => {
  return (
    <BrowserRouter>
      <Suspense fallback={<div>Loading........!</div>}>
        <Routes>
          <Route path="/" element={<Homepage />} />
          <Route path="/product" element={<Product />} />
          <Route path="/module" element={<Module />} />
          <Route path="/productModule" element={<ProductModule />} />
     

        </Routes>
      </Suspense>
    </BrowserRouter>
  );
};

export default Router;