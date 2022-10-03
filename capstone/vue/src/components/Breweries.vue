<template>
  
<div class="brewery-list">


<h1>List of Breweries</h1>
<table>
    <thead>
<tr>
<th>&nbsp;</th>
<th>Name</th>
<th>Street</th>
<th>City</th>
<th>State</th>
<th>Zipcode</th>
<th>Phone</th>
<th>Website URL</th>
<th>Hours of Operation</th>
<th>State</th>
 </tr>
</thead>
<tbody>
<tr v-for="brewery in sortedBreweries" :key="brewery">
    <td class="id">{{brewery.id}}</td>
    <td>
        <td>{{brewery.name}}</td>
    <td>
        <button v-on:click="viewBrewery(brewery.name)">See More</button>&nbsp;
        <button v-on:click="favoriteBrewery(brewery.name)">Add to Favorites</button>
                <button v-on:click="deleteBrewery(brewery.id)">Delete</button>

    </td>
</tr>
    </tbody>

</table>  
</div>
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

<style>

table,
th,
td {
}

</style>