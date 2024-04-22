import React, { useState, useEffect } from 'react';
import EMTLabService from "../../repository/EMTLabService";

const CategoryList = () => {
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        EMTLabService.getCategories()
            .then(resp => setCategories(resp.data))
            .catch(error => console.error("Error fetching categories:", error));
    }, []);

    return (
        <div>
            <h2 className="text-lg font-semibold ml-4 mb-4">Categories</h2>
            <ul className={"ml-4"}>
                {categories.map((category, index) => (
                    <li key={index}>{category}</li>
                ))}
            </ul>
        </div>
    );
};

export default CategoryList;
