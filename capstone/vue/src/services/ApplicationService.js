import axios from 'axios';




export default {

    getBreweries() {
        return axios.get('/breweries')
    },
    getBeers() {
        return axios.get('/beers')
    },

    deleteBeer(id) {
        return axios.delete(`beers/${id}`)
    },

    addBrewery(payload) {
        return axios.post('/breweries', payload)
    },

    getBeerByBreweryId(id) {
        return axios.get(`/breweries/beers/${id}`)
    },

    getBeer() {
        return axios.get('/beers')
    },

    getAllReviewsById(id){
        return axios.get(`beer/${id}/reviews`)
    },

    // getBreweryById(id){
    //     return http.get('/breweries/${id}')
    // },

    deleteBrewery(id) {
        return axios.delete(`/breweries/${id}`)

    },


    addBeerReview(payload) {
        return axios.post(`/beer/reviews`, payload)
    },

    addBeer(beer){
        return axios.post(`/beers`, beer)
    },

    searchBreweries(query){
        return axios.get(`breweries/search${query}`)
    },

    getBreweryById(id){
        return axios.get(`/breweries/${id}`)
    },

    editBrewery(payload){
        return axios.put(`/breweries`, payload)
    },

    getBeerById(id){
        return axios.get(`/beers/${id}`)
    }



}