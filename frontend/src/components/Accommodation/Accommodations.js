import React, { useState, useEffect } from 'react';
import EMTLabService from "../../repository/EMTLabService";

const AccommodationList = ({updateAccommodations}) => {
    const [accommodations, setAccommodations] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [accommodationsPerPage] = useState(5);

    useEffect(() => {
        EMTLabService.fetchAccommodations()
            .then(resp => setAccommodations(resp.data))
            .catch(error => console.error("Error fetching accommodations:", error));
    }, []);

    // Pagination
    const indexOfLastAccommodation = currentPage * accommodationsPerPage;
    const indexOfFirstAccommodation = indexOfLastAccommodation - accommodationsPerPage;
    const currentAccommodations = accommodations.slice(indexOfFirstAccommodation, indexOfLastAccommodation);

    const paginate = pageNumber => setCurrentPage(pageNumber);

    const handleDelete = (id) => {
        EMTLabService.deleteById(id)
            .then(() => {
                console.log("Deleted successfully");
                setAccommodations(accommodations.filter(acc => acc.id !== id));
            })
            .catch(error => console.error("Error deleting accommodation:", error));
    }

    const handleRent = (id) => {
        EMTLabService.rentAccommodation(id)
            .then(() => {
                console.log("Rented successfully");
                EMTLabService.fetchAccommodations()
                    .then(resp => setAccommodations(resp.data))
                    .catch(error => console.error("Error fetching accommodations:", error));
            })
            .catch(error => console.error("Error renting accommodation:", error));
    }


    return (
        <div className="max-w-4xl mx-auto mt-8">
            <h2 className="text-2xl font-bold mb-4">Accommodations</h2>
            <table className="table-auto w-full">
                <thead>
                <tr>
                    <th className="px-4 py-2">Name</th>
                    <th className="px-4 py-2">Category</th>
                    <th className="px-4 py-2">Host</th>
                    <th className="px-4 py-2">Number of Rooms</th>
                    <th className="px-4 py-2">Actions</th>
                </tr>
                </thead>
                <tbody>
                {currentAccommodations.map(accommodation => (
                    <tr key={accommodation.id}>
                        <td className="border px-4 py-2">{accommodation.name}</td>
                        <td className="border px-4 py-2">{accommodation.category}</td>
                        <td className="border px-4 py-2">{accommodation.host.name}</td>
                        <td className="border px-4 py-2">{accommodation.numRooms}</td>
                        <td className="border px-4 py-2">
                            <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mr-2">
                                <a href={`/accommodations/edit/${accommodation.id}`}>Edit</a>
                            </button>
                            <button onClick={() => handleDelete(accommodation.id)} className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded mr-2">Delete</button>
                            {accommodation.rented ?
                                <button onClick={() => handleRent(accommodation.id)} className="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded">Check Out</button>
                                :
                                <button onClick={() => handleRent(accommodation.id)} className="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded">Rent</button>
                            }
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
            <ul className="flex justify-center mt-4">
                {Array.from({ length: Math.ceil(accommodations.length / accommodationsPerPage) }, (_, index) => (
                    <li key={index} className="mr-2">
                        <button className="bg-gray-200 hover:bg-gray-400 text-gray-800 font-bold py-2 px-4 rounded" onClick={() => paginate(index + 1)}>{index + 1}</button>
                    </li>
                ))}
            </ul>
            <button className="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded mt-4">
                <a href="/accommodations/add">Add</a>
            </button>
        </div>
    );
};

export default AccommodationList;
