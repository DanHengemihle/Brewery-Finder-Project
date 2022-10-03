import axios from 'axios';


const http = axios.create({
    baseURL: "http://localhost:8080"
});


export default{

getBreweries(){
    return http.get('/breweries')
},


getBeer(){
    return http.get('/beer')
},

// getBreweryById(id){
//     return http.get('/breweries/${id}')
// },








}