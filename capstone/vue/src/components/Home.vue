<template>
 
 <div class="home"> 

  <div class="headings">

<h1 class="heading">Welcome to Bootlegger!</h1> 
<br>
<!-- <h2 class="subheading">Beer Lover's Paradise</h2>  -->
 </div>
 
 <div id="body"> 
<h3 class="breweries">Breweries</h3>
</div>
<br>
<input type="text" placeholder="Search..">
<br>
<br>
<br>
  

 <div class="loading" v-if="isLoading">
 <img id="beer" src="/public/centermug.jpg"/> 
   
  </div>
 <div class="breweries-list"> 
  
 <brewery-card class="card-space" v-for="brewery in breweries" v-bind:key="brewery.name" v-bind:brewery="brewery"/>
  </div> 

  
 </div>
</template>

<script>

// // import BreweryList from "./BreweryList.vue"


 export default {
  components: {
     },
};
</script>


<style>

* {
   padding: 0;
  margin: 0;
  box-sizing: border-box;
 }

.breweries input[type=text] {
  float: right;
  padding: 6px;
  border: none;
  margin-top: 8px;
  margin-right: 16px;
  font-size: 17px;
}

.headings h1 {
  font-size: 4rem;
     margin-top: -2rem;
  margin-bottom: 1rem;
   line-height: 1.2;
 }

.headings {
  display: flex;
  flex-direction: row;
  align-items: center;
 justify-content: center;
  text-align: center;
  height: 55vh;
  color: black;
  text-shadow: 2px 2px 15px black;
 }

.headings h2 {
   font-size: 1rem;
 font-style: italic;
   display: block;
 }

 h3 {
  color: black;
  text-shadow: 2px 2px 15px black;
  display: flex;
  flex-direction: column;
 align-items: center;
   font-size: 3rem;
   margin-top: 11rem;
   margin-bottom: 2rem;
 }


.brewery-list {
  padding-right: 25px;
   padding-left: 25px;
 display: flex;
  flex-wrap: wrap;
  grid-gap: 10px 200px;
  align-self: space-around;
  justify-content: space-around;
 }


</style>