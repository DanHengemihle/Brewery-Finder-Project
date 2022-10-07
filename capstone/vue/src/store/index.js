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
favorites: [],
beers: [],
reviews:[],
breweries: [],
avg: [],
activeBrewery: {
  id: "",
  brewerId: "",
        name: "",
        street: "",
        city: "",
        state: "",
        phone: "",
        websiteUrl: "",
        hoursOfOperation: "",
},

beer: {
  beerId: "",
  breweryId: "",
    beerName: "",
    beerDescription: "",
    image: "",
    beerType: "",
    abv: "",
    
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
      state.activeBrewery=data;
    },
    SET_BREWERY(state, data){
      state.breweries=data;
    },

    SET_BEERS(state, data){
      state.beers=data;
    },

    SET_REVIEWS(state, review) {
      state.reviews.push(review);
    },

  SET_ACTIVE_BEER(state, data){
    state.beer=data;
  },

  SET_FAVORITES(state, data){
    state.favorites.unshift(data);
  },

  DELETE_BEER(state, id){
    state.beers = state.beers.filter((beer) => {
      return beer.id !== id;
    });
  },

  DELETE_BREWERY(state, breweryIdToDelete) {
    state.breweries = state.breweries.filter((brewery) => {
      return brewery.id !== breweryIdToDelete;
    });
  },
  }
})
