<template>

  <div id="app">
    <div id="nav" :class="{ sticky: active }">
      <link
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
        crossorigin="anonymous"
      />
      <link
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
      />

      <div id="dropdown">
        <button id="logonav" class="dropbtn" @click="toggle"></button>
        <div v-if="active"><a href="Home">Home</a>
      <a href="#">Link 2</a>
      <a href="#">Link 3</a></div>

        <!-- <div class="dropdown-content"> -->
      <!-- <a href="Home">Home</a>
      <a href="#">Link 2</a>
      <a href="#">Link 3</a> -->
    <!-- </div> -->
      </div>
      <!-- <router-link id="homenav" v-bind:to="{ name: 'home' }">Home |</router-link
      >&nbsp;|&nbsp;
      <div class="navbar">
        <router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link
        > -->
        

        <nav class="navbar">
      <ul class="nav links">
        <!-- <div id="nav"> -->

        <li>
          <router-link v-bind:to="{ name: 'home' }">Home</router-link>
        </li>
     <li>
          <router-link v-bind:to="{ name: 'breweries' }">Breweries</router-link>
        </li> 
       
        <li><router-link v-bind:to="{ name: 'login' }">Login</router-link></li>
        <li><router-link v-bind:to="{ name: 'register' }">Register</router-link></li>
                <li><router-link v-bind:to="{ name: 'maps' }">Locations</router-link></li>

                <li><router-link v-bind:to="{ name: 'brewer' }">Brewer</router-link></li>          <a id="about" href="#about">About</a> |
        <a id="contact" href="#contact">Contact</a>
        <input id="search" type="text" placeholder="Search.." />
        <i id="searchicon" class="fa fa-search icon"></i>


        <li>
          <router-link
            id="logout-link"
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            >Logout</router-link
          >
        </li>
      </ul>
    </nav>

      
        <!-- <router-link id="breweryinfo" :to="{name: 'brewery' }" v-if="$store.state.user.role == 'ROLE_BREWER'">Add/Update Brewery</router-link> -->
      <!-- </div> -->
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  name: "app",
  data() {
    return {
      scrolling: false,
      active: false,
      loggedIn: false
    };
  },

  methods: {
    toggle() {
      this.active = !this.active;
    },
    
    hasBrewerRole(){
      
    },

        toggleNavClass(){
            if(this.scrolling == false){
              return 'nav'
            } else {
              return 'sticky-nav'
            }

    }
      },
      mounted(){
      window.document.onscroll = () => {
          let navBar = document.getElementById('dropdown');
          if(window.scrollY > navBar.offsetTop){
            this.scrolling = true;
            } else {
            this.scrolling = false;
          }
        }
  },
};
</script>

<style>


/* Navbar container */
.navbar {
  overflow: hidden;
}

/* Links inside the navbar */
.navbar a {
  float: left;
  font-size: 16px;
  color: darkgoldenrod;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* The dropdown container */
.dropdown {
  float: left;
  overflow: hidden;
}

/* Dropdown button */
.dropdown .dropbtn {
  font-size: 16px;
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit; /* Important for vertical align on mobile phones */
  margin: 0; /* Important for vertical align on mobile phones */
}


/* Dropdown content (hidden by default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
  z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

/* Add a grey background color to dropdown links on hover */
.dropdown-content a:hover {
  background-color: #ddd;
}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
  display: block;
}

#nav {
  display: flex;
  align-items: center;
  background-color: black;
  width: 100%;
  position: fixed;
  top: 0;
  border-bottom: solid darkgray;
}


#logonav {
  margin-left: 10px;
  padding-right: 50px;
  width: 50px;
  height: 50px;
  background-image: url("/navlogo.png");
  background-repeat: no-repeat;
  background-size: cover;
  border-style: none;
}

/* #homenav {
  padding-left: 20px;
  color: darkgoldenrod;
  font-size: 3vh;
} */

.nav {
  transition: 100ms;
  padding: 25px;
}

.sticky-nav {
  transition: 100ms;
  padding: 20px;
}


#nav.sticky {
  transition: 150ms;
  box-shadow: 0px 15px 10px -15px #111;
  background-color: darkgray;
}


#searchicon{
 font-size: 1em;
transform: translate(-1.5vw, 1.9vh);
}

#search{
  height: 3vh;
  transform: translate(0, 1.5vh);
}

html{
  height: 100%;
}

</style>