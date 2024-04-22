import React, { useState, useEffect } from 'react';
import { useHistory, useParams } from "react-router-dom";
import EMTLabService from "../../repository/EMTLabService";

const EditAccommodation = () => {
    const { id } = useParams();
    const [name, setName] = useState('');
    const [category, setCategory] = useState('');
    const [hostId, setHostId] = useState('');
    const [numRooms, setNumRooms] = useState('');
    const history = useHistory();

    useEffect(() => {
        const fetchAccommodation = async () => {
            try {
                const response = await EMTLabService.getAccommodation(id);
                const data = response.data;
                setName(data.name);
                setCategory(data.category);
                setHostId(data.host.id);
                setNumRooms(data.numRooms);
            } catch (error) {
                console.error("Error fetching accommodation:", error);
            }
        };
        fetchAccommodation();
    }, [id]);

    const handleSubmit = async () => {
        try {
            await EMTLabService.editAccommodation(id, name, category, hostId, numRooms);
            history.push('/accommodations');
        } catch (error) {
            console.error("Error updating accommodation:", error);
        }
    };

    return (
        <div className="max-w-md mx-auto p-6 bg-white shadow-md rounded-md">
            <h2 className="text-lg font-semibold mb-4">Edit Accommodation</h2>
            <div className="mb-4">
                <label htmlFor="name" className="block text-sm font-medium text-gray-700 capitalize">Name</label>
                <input
                    type="text"
                    id="name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    className="mt-1 p-2 border border-gray-300 rounded-md w-full"
                    required
                />
            </div>
            <div className="mb-4">
                <label htmlFor="category" className="block text-sm font-medium text-gray-700 capitalize">Category</label>
                <input
                    type="text"
                    id="category"
                    value={category}
                    onChange={(e) => setCategory(e.target.value)}
                    className="mt-1 p-2 border border-gray-300 rounded-md w-full"
                    required
                />
            </div>
            <div className="mb-4">
                <label htmlFor="hostId" className="block text-sm font-medium text-gray-700 capitalize">Host ID</label>
                <input
                    type="text"
                    id="hostId"
                    value={hostId}
                    onChange={(e) => setHostId(e.target.value)}
                    className="mt-1 p-2 border border-gray-300 rounded-md w-full"
                    required
                />
            </div>
            <div className="mb-4">
                <label htmlFor="numRooms" className="block text-sm font-medium text-gray-700 capitalize">Number of Rooms</label>
                <input
                    type="number"
                    id="numRooms"
                    value={numRooms}
                    onChange={(e) => setNumRooms(e.target.value)}
                    className="mt-1 p-2 border border-gray-300 rounded-md w-full"
                    required
                />
            </div>
            <button onClick={handleSubmit} className="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-600">Save Changes</button>
        </div>
    );
};

export default EditAccommodation;
