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

    getBreweryById(id) {
        return axios.get(`/breweries/${id}`)
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
