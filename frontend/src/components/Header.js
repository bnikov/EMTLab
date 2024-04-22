import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {
    return (
        <header className="bg-gray-800 text-white py-4 pl-8 pr-8">
            <div className="container mx-auto flex justify-between items-center">
                <h1 className="text-2xl font-bold">EMT Lab</h1>
                <nav>
                    <ul className="flex space-x-4">
                        <li>
                            <a href="/accommodations" className="hover:text-gray-300">Accommodations</a>
                        </li>
                        <li>
                            <a href="/categories" className="hover:text-gray-300">Categories</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </header>
    );
}

export default Header;
