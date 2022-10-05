import axios from 'axios';




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

getBeerByBreweryId(id){
    return axios.get(`/breweries/${id}`)
},

getBeer(){
    return axios.get('/beers')
},

// getBreweryById(id){
//     return http.get('/breweries/${id}')
// },

deleteBrewery(id){
return axios.delete(`/breweries/${id}`)

},


addBeerReview(){
    return axios.post(`/beer/reviews`)
},


   




}