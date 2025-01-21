import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Home = () => {
  const [productId, setProductId] = useState<number | undefined>(undefined);
  const [moduleId, setModuleId] = useState<number | undefined>(undefined);
  const navigate = useNavigate();

  // Handle Submit for Product ID
  const handleSubmitProduct = async () => {
    try {
      const token = "1";
      const response = await axios.get(`http://localhost:8080/search/Product/byId?productId=${productId}`, {
        headers: {
          'X-Auth-Token': token, // Include the token in the headers
        }
      });
      if (response.data.isError === false) {
        const fetchedData = response.data.data;
        navigate("/product", { state: { data: fetchedData } });
      } else {
        alert("Incorrect Product Id");
      }
    } catch (error) {
      console.error("Error fetching product data:", error);
    }
  };

  // Handle Submit for Module ID
  const handleSubmitModule = async () => {
    try {
      const token = "1";
      const response = await axios.get(`http://localhost:8080/search/module/byId?moduleId=${moduleId}`, {
        headers: {
          'X-Auth-Token': token, // Include the token in the headers
        }
      });
      if (response.data.isError === false) {
        const fetchedData = response.data.data;
        navigate("/module", { state: { data: fetchedData } });
      } else {
        alert("Incorrect Module Id");
      }
    } catch (error) {
      console.error("Error fetching module data:", error);
    }
  };

  // Handle Submit for Product ID to fetch Modules
  const handleSubmitProductModule = async () => {
    try {
      if (!productId) {
        console.error("Product ID is not set.");
        return;
      }

      console.log("Submitting Product ID for Modules:", productId);

      const token = "1";
      const response = await axios.get(`http://localhost:8080/search/Product/Module/byId?productId=${productId}`, {
        headers: {
          'X-Auth-Token': token, // Include the token in the headers
        }
      });
      if (response.data.isError === false) {
        console.log("Response data:", response.data.data);
        const fetchedData = response.data.data; // Assuming it's an array of modules

        // Navigate to the /productModule page with the fetched data
        navigate("/productModule", { state: { data: fetchedData } });
      } else {
        alert("There is no module data for this product Id");
      }
    } catch (error) {
      console.error("Error fetching module data:", error);
    }
  };

  return (
    <div className="p-8 bg-gray-100 min-h-screen flex flex-col items-center justify-center">
      {/* Product ID Input and Submit */}
      <div className="bg-white p-6 rounded-lg shadow-lg w-full max-w-md mb-6">
        <h2 className="text-2xl font-semibold mb-4 text-center">Search Product by ID</h2>
        <input
          type="text"
          value={productId || ""}
          onChange={(e) => setProductId(e.target.value ? parseInt(e.target.value) : undefined)}
          className="border border-gray-300 p-3 rounded-lg w-full mb-4"
          placeholder="Enter Product ID"
        />
        <button
          onClick={handleSubmitProduct}
          className="bg-blue-500 text-white p-3 rounded-lg w-full hover:bg-blue-600 transition duration-200 mb-4"
        >
          Fetch Product
        </button>
        <button
          onClick={handleSubmitProductModule}
          className="bg-green-500 text-white p-3 rounded-lg w-full hover:bg-green-600 transition duration-200"
        >
          Fetch Modules
        </button>
      </div>

      {/* Module ID Input and Submit */}
      <div className="bg-white p-6 rounded-lg shadow-lg w-full max-w-md">
        <h2 className="text-2xl font-semibold mb-4 text-center">Search Module by ID</h2>
        <input
          type="text"
          value={moduleId || ""}
          onChange={(e) => setModuleId(e.target.value ? parseInt(e.target.value) : undefined)}
          className="border border-gray-300 p-3 rounded-lg w-full mb-4"
          placeholder="Enter Module ID"
        />
        <button
          onClick={handleSubmitModule}
          className="bg-blue-500 text-white p-3 rounded-lg w-full hover:bg-blue-600 transition duration-200"
        >
          Fetch Module
        </button>
      </div>
    </div>
  );
};

export default Home;
