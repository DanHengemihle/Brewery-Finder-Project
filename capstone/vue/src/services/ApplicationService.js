import axios from 'axios';


// const http = axios.create({
//     baseURL: "http://localhost:8080"
// });


export default {

    getBreweries() {
        return axios.get('/breweries')
    },
    getBeers() {
        return axios.get('/beers')
    },

    deleteBeer(id){
        return axios.delete(`beers/${id}`)
    },

    addBrewery(payload) {
        return axios.post('/breweries', payload)
    },

    getBeerByBrewery(id) {
        return axios.get(`/breweries/${id}/beers`)
    },

    getBreweryById(id) {
        return axios.get(`/breweries/${id}`)
    },

    deleteBrewery(id) {
        return axios.delete(`/breweries/${id}`)

    },

    addReview(review) {
        return axios.post('/reviews', review)
    },

    addNewBeer(beer) {
        return axios.post(`/beers`, beer)
    },

    updateBrewery(brewery) {
        return axios.put(`/breweries`, brewery)
    }
}
