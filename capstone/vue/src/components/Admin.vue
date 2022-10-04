<template>

<div id="admin">
    <div class="headings">
      <h1 class="heading">Welcome, Brewer!</h1>
<h2 class="subheading">Create New Brewery</h2>
  </div>
  <div id="body">


<div class="loading" v-if="isLoading">
  <img id="beer" src="/public/centermug.jpg"/> 
  </div>
  
  <div class="brewery-list">
  <brewery-card class="card-space" v-for="brewery in allBreweries" v-bind:key="brewery.breweryId" v-bind:brewery="brewery"/>
   </div>

</div>

</div>

</template>

<script>


export default {
  name: "admin"
  
};
</script>


<style>

*{
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}


.headings{
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  text-align: center;
  height: 55vh;
  color: black;
  text-shadow: 2px 2px 15px black;
}

.headings h1{
  font-size: 4rem;
  margin-top: -2rem;
  margin-bottom: 1rem;
  line-height: 1.2;
}

.headings h2{

  font-size: 1rem;
  font-style: italic;
}

h3{
  color: black;
  text-shadow: 2px 2px 15px black;
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 3rem;
  margin-top: 11rem;
  margin-bottom:2rem;
}

.brewery-list{
  padding-right: 25px;
  padding-left: 25px;
  display: flex;
  flex-wrap: wrap;
  grid-gap: 10px 200px;
  align-self: space-around;
  justify-content: space-around;
}

/* div.loading{
  text-align: center;
  float: center;
  z-index: 998;
} */
</style>