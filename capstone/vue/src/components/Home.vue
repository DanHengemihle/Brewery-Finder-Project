<template>
  <body>

<div class="home"> 

  <div class="headings">

<h1 class="heading">Welcome to Bootlegger!</h1> 
<br>

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
  
   
  </div>

  
 <!-- <brewery-card class="card-space" v-for="brewery in breweries" v-bind:key="brewery.name" v-bind:brewery="brewery"/> -->
  <!-- </div>  -->

  
 </div>

<div class="brewery-list">



<table>
    <thead>
<tr>
<th>&nbsp;</th>
<th>Name</th>
<th>City</th>
<th>State</th>
<th>Zipcode</th>
<th>Phone</th>
<th>Website URL</th>
<th>Hours of Operation</th>

 </tr>
</thead>
<tbody>
<tr v-for="brewery in sortedBreweries" :key="brewery">
    <!-- <td class="id">{{brewery.id}}</td> -->
    <td>
        <td>{{brewery.name}}</td>
        <td>{{brewery.phone}}</td>
          <td>{{brewery.website_url}}</td>
    <td>
        <button v-on:click="viewBrewery(brewery.name)">See More</button>&nbsp;
        <button v-on:click="favoriteBrewery(brewery.name)">Add to Favorites</button>
                <button v-on:click="deleteBrewery(brewery.id)">Delete</button>

    </td>
</tr>
    </tbody>

</table>  
</div>
</body>
</template>

<script>
import applicationService from "../services/ApplicationService";

export default {
    data(){
        return {
            breweries: []
        }
    },
  name: "breweries-list",
  methods: {
    viewBrewery(id) {
      this.$router.push(`/breweries/${id}`);
    },
   deleteBrewery() {
      if (confirm("Are you sure you want to delete this brewery and all associated information? This action cannot be undone.")) {
        applicationService
          .deleteBrewery(this.brewery.id)
          .then(response => {
            if (response.status === 200) {
              alert("Brewery successfully deleted");

              this.$store.commit("DELETE_BREWERY", this.brewery.id);

              this.$router.push({ name: 'Home' });
            }
          })
          
        .catch((error) => {
          if (error.response.status === 404) {
            this.$router.push("/404");
          } else {
            console.error(error);
          }
        
        });
      }
    },
    getBreweries() {
      applicationService.getBreweries().then(response => {
          if(response.status == 200) {
 this.$store.commit("SET_BREWERY", response.data);
this.breweries=response.data;
          }
       
      })
      .catch((error) => {
          if (error.response.status === 404) {
            this.$router.push("/404");
          } else {
            console.error(error);
          }
        
        });
    },
  },
  created() {
    this.getBreweries();
  },
  computed: {
      sortedBreweries(){
          return this.$store.state.breweries;
      }
  }
};
</script>

<style scoped>


*{
  padding: 0px;
  margin: 0px;
  box-sizing: border-box;
}

/* table{
  padding: 30px;
  margin-top: 500px;
  background-color: goldenrod;
  opacity: 90%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
background-position: center;
} */

table{
  padding-right: 25px;
  padding-left: 25px;
  display: flex;
  flex-wrap: wrap;
  grid-gap: 10px 200px;
  align-self: space-around;
  justify-content: space-around;
  /* background-color: goldenrod; */
}
.heading{
  font-size: 2rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 40vh;
  color: goldenrod;
  text-shadow: 2px 2px 15px black;
}
body, html {
  display: flex;


/* max-height: 300px; */
  justify-content: center;
  align-items: center;
  padding-left: 20px;
  background-position: center;
  background-size: cover;
  background-repeat: no-repeat;
  height: 100vh;
  background-image: url("/lighterbg.jpg");

} 

 body, html{
   /* max-height: 300px; */
  height: 100vh;
} 


</style>