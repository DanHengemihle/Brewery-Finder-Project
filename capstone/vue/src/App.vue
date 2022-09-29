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
        <li><router-link v-bind:to="{ name: 'admin' }">Admin</router-link></li>

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
  
</template>


<style scoped>
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
  background-color: goldenrod;
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