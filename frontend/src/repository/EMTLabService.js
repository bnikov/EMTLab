import axios from "../custom-axios/axios";

const EMTLabService = {

    fetchAccommodations:() => {
      return axios.get("/accommodation/all")
    },
    addAccommodation:(name, category, hostId, numRooms) => {
        return axios.post("/accommodation/add", {
            "name": name,
            "category": category,
            "hostId": hostId,
            "numRooms": numRooms
        })
    },
    editAccommodation:(id, name, category, hostId, numRooms) => {
        return axios.post(`/accommodation/edit`, {
            "id": id,
            "name": name,
            "category": category,
            "hostId": hostId,
            "numRooms": numRooms
        })
    },
    getAccommodation:(id) => {
        return axios.get(`accommodation/${id}`)
    },
    deleteById: (id) => {
        return axios.post(`accommodation/delete/${id}`)
    },
    getCategories:() => {
        return axios.get("/accommodation/categoryValues")
    },
    rentAccommodation:(id) => {
        return axios.post(`/accommodation/rent/${id}`)
    }

}

export default EMTLabService;
