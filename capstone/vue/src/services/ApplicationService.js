import axios from 'axios';


// const http = axios.create({
//     baseURL: "http://localhost:8080"
// });


export default{

getBreweries(){
    return axios.get('/breweries')
},

addBrewery(payload){
    return axios.post('/breweries', payload)
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

deleteBeer(id){
    return axios.delete(`/beer/${id}`)
},

addReview(){
    return axios.post(`/beer/reviews`)
},







}