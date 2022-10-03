import axios from 'axios';


// const http = axios.create({
//     baseURL: "http://localhost:8080"
// });


export default{

getBreweries(){
    return axios.get('/breweries')
},

addBrewery(){
    return axios.post('/breweries')
},

getBeerByBrewery(id){
    return axios.get(`/brewery/${id}`)
},

// getBreweryById(id){
//     return http.get('/breweries/${id}')
// },

deleteBrewery(id){
return axios.delete(`/breweries/${id}`)

}







}