import React from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

const ProductModule: React.FC = () => {
  const location = useLocation();
  const data = location.state?.data;
  const navigate = useNavigate();

  return (
    <div className="p-6 max-w-4xl mx-auto bg-white shadow-lg rounded-lg">
      <h1 className="text-2xl font-semibold text-gray-800 mb-6">Module Details</h1>

      {data && Array.isArray(data) && data.length > 0 ? (
        <table className="min-w-full table-auto border-separate border-spacing-2">
          <thead>
            <tr className="bg-gray-100">
              <th className="px-4 py-2 text-left text-sm font-semibold text-gray-600">Module ID</th>
              <th className="px-4 py-2 text-left text-sm font-semibold text-gray-600">Module Description</th>
              <th className="px-4 py-2 text-left text-sm font-semibold text-gray-600">Start Date</th>
              <th className="px-4 py-2 text-left text-sm font-semibold text-gray-600">End Date</th>
            </tr>
          </thead>
          <tbody>
            {data.map((module: any) => (
              <tr key={module.moduleId} className="hover:bg-gray-50">
                <td className="px-4 py-2 text-sm text-gray-700">{module.moduleId}</td>
                <td className="px-4 py-2 text-sm text-gray-700">{module.moduleDescription}</td>
                <td className="px-4 py-2 text-sm text-gray-700">{module.startDate}</td>
                <td className="px-4 py-2 text-sm text-gray-700">{module.endDate}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p className="text-gray-600 text-sm mt-4">No data available</p>
      )}

      <div className="mt-6 text-center">
        <button
          className="bg-blue-500 text-white py-2 px-6 rounded-lg text-sm font-semibold shadow-md hover:bg-blue-600 transition"
          onClick={() => navigate('/')}
        >
          Back to Home
        </button>
      </div>
    </div>
  );
};

export default ProductModule;
