import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {

reviews: [],
beers: [],
breweries: [],
activeBreweries: {
  id: null, 
  name: '',
  phone_number: '',
  website_url: '',
  street: '',
  city: '',
  zipcode: '',
  state: '',
  hours: ''
},
    
    token: currentToken || '',
    user: currentUser || {},
    
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    
    SET_USER(state, user) {
      console.log(user);
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_ACTIVE_BREWERY(state, data){
      state.activeBreweries=data;
    },
    SET_BREWERY(state, data){
      state.breweries=data;
    },

    SET_BEERS(state, data){
      state.beers=data;
    },

    SET_REVIEWS(state, data){
      state.reviews=data;
    },
    SET_REVIEWS_DATA(state, reviews) {
      state.reviews = reviews;
    },
  },
  DELETE_BREWERY(state, breweryIdToDelete) {
    state.brewery = state.brewery.filter((brewery) => {
      return brewery.id !== breweryIdToDelete;
    });
  }
})
