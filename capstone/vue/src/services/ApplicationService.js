import axios from 'axios';


// const http = axios.create({
//     baseURL: "http://localhost:8080"
// });


export default{

getBreweries(){
    return axios.get('/breweries')
},


// getBeer(){
//     return axios.get('/beer')
// },

// getBreweryById(id){
//     return http.get('/breweries/${id}')
// },

deleteBrewery(id){
return axios.delete(`/breweries/${id}`)

}







}