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

<<<<<<< HEAD
getBeerByBreweryId(id){
    return axios.get(`/breweries/${id}`)
},
=======
    addBrewery(payload) {
        return axios.post('/breweries', payload)
    },
>>>>>>> main

    getBeerByBreweryId(id) {
        return axios.get(`/breweries/${id}`)
    },

    getBeer() {
        return axios.get('/beers')
    },

    // getBreweryById(id){
    //     return http.get('/breweries/${id}')
    // },

    deleteBrewery(id) {
        return axios.delete(`/breweries/${id}`)

    },


    addBeerReview(id) {
        return axios.post(`/beer/${id}reviews`)
    },

<<<<<<< HEAD
<<<<<<< HEAD
   
=======
=======
    addBeer(beer){
        return axios.post(`/beers`, beer)
    },

    searchBreweries(query){
        return axios.get(`breweries/search${query}`)
    },

    getBreweryById(id){
        return axios.get(`/breweries/${id}`)
    }
>>>>>>> main

>>>>>>> main




}