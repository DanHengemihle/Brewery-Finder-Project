<template>
  
<div class="breweries-list">

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
<tr v-for="brewery in breweries" :key="brewery.id">
    <td class="name">{{brewery.name}}</td>
    <td>
        <td>{{brewery.zipcode}}</td>
    <td>
        <button v-on:click="viewBrewery(brewery.name)">See More</button>&nbsp;
        <button v-on:click="favoriteBrewery(brewery.name)">Add to Favorites</button>
                <button v-on:click="deleteBrewery(brewery.id)">Delete</button>

    </td>
</tr>
    </tbody>

</table>  
</template>

<script>
import applicationService from "../services/ApplicationService";

export default {
  name: "breweries-list",
  methods: {
    viewBrewery(name) {
      this.$router.push(`/breweries/${name}`);
    },
    deleteBrewery(id) {
      applicationService
        .delete(id)
        .then((response) => {
          if (response.status === 200) {
            this.getDocuments();
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
    getBreweries() {
      applicationService.list().then((response) => {
        this.$store.commit("SET_BREWERY", response.data);
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
</style>