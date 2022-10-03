<template>

<div id="app">
    <router-link id="logo" v-bind:to="{ name: 'home' }"
      ><img id="logo" src="../public/logo.png"
    /></router-link>

    <nav class="navbar">
      <ul class="nav links">
        <!-- <div id="nav"> -->

        <li>
          <router-link v-bind:to="{ name: 'home' }">Home</router-link>
        </li>
     <li>
          <router-link v-bind:to="{ name: 'home' }">Breweries</router-link>
        </li> 
        <li>
          <router-link v-bind:to="{ name: 'home' }">About Us</router-link>
        </li>
        <li><router-link v-bind:to="{ name: 'login' }">Login</router-link></li>
        <li><router-link v-bind:to="{ name: 'register' }">Register</router-link></li>
        <li><router-link v-bind:to="{ name: 'brewer' }">Brewer</router-link></li>

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
    <link
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
      crossorigin="anonymous"
    />

    <router-view />
  </div>

  <!-- <div id="app">
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
      /> -->

      <!-- <div id="dropdown">
        <button id="logonav" class="dropbtn" @click="toggle"></button>
        <div v-if="active">Menu</div> -->

        <!-- <div class="dropdown-content">
      <a href="Home">Home</a>
      <a href="#">Link 2</a>
      <a href="#">Link 3</a>
    </div> -->
      <!-- </div>
      <router-link id="homenav" v-bind:to="{ name: 'home' }">Home |</router-link
      >&nbsp;|&nbsp;
      <div class="navbar">
        <router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link
        >

        <a id="about" href="#about">About</a> |
        <a id="contact" href="#contact">Contact</a>
        <input id="search" type="text" placeholder="Search.." />
        <i id="searchicon" class="fa fa-search icon"></i>
      </div>
    </div>
    <router-view />
  </div> -->
</template>



<style>
* {
  padding: 0;
  margin: 0;
}

/* li {
  float: right;
} */

ul {
  opacity: 75%;
  background-color: rgb(59, 64, 75);
  position: right;
  top: 11rem;
  width: 100%;
  border-top-left-radius: 30px;
  border-bottom-left-radius: 30px;
  box-shadow: inset 0px 0px 10px #000; 
}
div#app {
  font-family: Arial, Helvetica, sans-serif;
  background-image: url("/beer7.png");
  opacity: 92%;
   position: relative; 
  background-position: left top; 
   background-size: cover; 
 background-repeat: no-repeat; 
   background-attachment: fixed; 
  margin: -8px;
  margin-top: -20px;
}

.navbar {
  border-right: none; 
   display: flex;
   justify-content: flex-end; 
   background-color: transparent;
}

.nav-links {
  list-style-type: none;
}

a,
li {
  display: block;
  color: white;
  padding: 5px;
  text-decoration: none;
  transition-duration: 500ms;
  border-radius: 5px;
}

a:hover {
  color: goldenrod;
}

li a:hover {
  background-color: #111;
  box-shadow: inset 0px 0px 5px goldenrod;
}

#logo {
  max-width: 35%;
}

#nav {
  background-color: #F1F1F1;
  text-align: left;
  padding: 20px;
font-size: 3vw;
  box-shadow: 0 4px 5px 0 rgba(0,0,0,0.14), 0 1px 10px 0 rgba(0,0,0,0.12), 0 2px 4px -1px rgba(0,0,0,0.2);

}

#nav:hover{
  background-color:goldenrod;
    box-shadow: 0 4px 5px 0 rgba(0,0,0,0.14), 0 1px 10px 0 rgba(0,0,0,0.12), 0 2px 4px -1px rgba(0,0,0,0.2);

}  



</style>