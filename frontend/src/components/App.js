import logo from '../logo.svg';
import '../App.css';
import {BrowserRouter, BrowserRouter as Router, Redirect, Route, Routes} from "react-router-dom"
import Header from "./Header";
import Accommodations from "./Accommodation/Accommodations";
import AccommodationAdd from "./Accommodation/AccommodationAdd";
import AccommodationEdit from "./Accommodation/AccommodationEdit";
import Categories from "./Categories/Categories";
import {useEffect} from "react";
import EMTLabService from "../repository/EMTLabService";

function App() {

    return (
        <div>
            <Header/>
            <BrowserRouter>
                <Route>
                    <Route path={"/accommodations"} exact render={() =>
                        <Accommodations/>}/>
                    <Route path={"/accommodations/add"} exact render={() =>
                        <AccommodationAdd/>}/>
                    <Route path={`/accommodations/edit/:id`} exact render={() =>
                        <AccommodationEdit/>}/>
                    <Route path={`/categories`} exact render={() =>
                        <Categories/>}/>
                    <Route path={"/"} exact render={() =>
                        <Accommodations/>}/>
                </Route>
            </BrowserRouter>
        </div>
    );
}

export default App;
