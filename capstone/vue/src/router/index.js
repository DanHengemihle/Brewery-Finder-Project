import Vue from 'vue'
import Router from 'vue-router'
// import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import store from '../store/index'
import Register from '../components/Register.vue'
// import Brewer from '../components/Brewer.vue'
import BeerLover from '../components/BeerLover.vue'
import Admin from '../components/Admin.vue'
import Breweries from '../components/Breweries.vue'
import BreweryForm from '../components/BreweryForm.vue'
import Locations from '../components/Locations.vue'
// import Beers from '../components/Beers.vue'
import Beers from '../components/Beers.vue'
import BeerForm from '../components/BeerForm.vue'
import CSSBEER from '../views/CSSBEER.vue'
import ReviewsForm from '../components/ReviewsForm.vue'
import BreweryCard from '../components/BreweryCard.vue'
import UpdateBrewery from '../components/UpdateBrewery.vue'
import Favorites from '../components/Favorites.vue'


import AboutPage from '../components/AboutPage'
import ContactUs from '../components/ContactUs'
Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'intro',
      component: CSSBEER,
      meta: {
        requiresAuth: false
      }
    },
    
    {
      path: '/home',
      name: 'home',
      component: Breweries,
      meta: {
        requiresAuth: false
      }
    },

    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
      },
      {
        path: "/breweries",
        name: "breweries",
        component: Breweries,
        meta: {
          requiresAuth: false
        }
      },
     
    { path: "/brewer",
    name: "brewer",
    component: BreweryForm,
    meta: {
      requiresAuth: true,
    }
  },

{
path: "/beerlover",
name: "beerlover",
component: BeerLover,
meta: {
  requiresAuth: true,
}
},

{
  path: "/admin",
  name: "admin",
  component: Admin,
  meta: {
    requiresAuth: true,
  }
  },
  {
    path: "/maps",
    name: "maps",
    component: Locations,
    meta: {
      requiresAuth: true,
    }
  


},
// {
//   path: "/brewery/:id",
//   name: "brewery-page",
//   component: Beer,
//   meta: {
//     requiresAuth: true,
//   }
// },

{
  path: "/beers",
  name: "beers",
  component: Beers,
  meta: {
    requiresAuth: false,
  }
}, 
{
  path: "/about",
  name: "about",
  component: AboutPage,
  meta: {
    requiresAuth: false,
  }
},
{
  path: "/contact",
  name: "contact",
  component: ContactUs,
  meta: {
    requiresAuth: false,
  }
},
// {
//   path: "/beers/:id/reviews",
//   name: "beer-reviews",
//   component: BeerReviews,
//   props:true,
//   meta: {
//     requiresAuth: false
//   }
// }





    



    // {
    //   path: "/admin",
    //   name: "admin",
    //   component: Admin,
    //   meta: {
    //     requiresAuth: false
    //   }
    // },

    {
      path: "/beer",
      name: "beerform",
      component: BeerForm,
      meta: {
        requiresAuth: true
      }
    },

    {
      path: "/beer/reviews",
      name: "reviewform",
      component: ReviewsForm,
      meta: {
        requiresAuth: true
      }
    },

    {
      path: "/brewery",
      name: "brewery",
      component: BreweryCard,

    },
    {
      path: "/brewery/update",
      name: "updatebrewery",
      component: UpdateBrewery,
      meta: {
        requiresAuth: true
      }
    },

    {
      path: "/beers/favorites",
      name: "favorites",
      component: Favorites
    }
    
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
