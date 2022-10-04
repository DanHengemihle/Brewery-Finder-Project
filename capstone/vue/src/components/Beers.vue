<template>
  
<div class="brewery-list">


<h1>List of Breweries</h1>
<table>
    <thead>
<tr>
<th>&nbsp;</th>
<th>Name</th>
<th>Description</th>
<th>Abv</th>
<th>Type</th>
 </tr>
</thead>
<tbody>
<tr v-for="beer in sortedBeers" :key="beer">
    <td class="id"></td>
    <td>
        <td>{{beer.image}}</td>
        <td>{{beer.name}}</td>
        <td>{{beer.description}}</td>
        <td>{{beer.abv}}</td>

    <td>
        <button v-on:click="viewBeer(beer.name)">See More</button>&nbsp;
        <button v-on:click="favoriteBeer(beer.name)">Add to Favorites</button>
                <button v-on:click="deleteBeer(beer.id)">Delete</button>

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
            breweries: [],
            beers: [],

        }
    },
  name: "breweries-list",
  methods: {
    viewBrewery(id) {
      this.$router.push(`/breweries/${id}`);
    },
   deleteBeer() {
      if (confirm("Are you sure you want to delete this brewery and all associated information? This action cannot be undone.")) {
        applicationService
          .deleteBeer(this.brewery.id)
          .then(response => {
            if (response.status === 200) {
              alert("Brewery successfully deleted");

              this.$store.commit("DELETE_BEER", this.brewery.id);

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
    getBeers() {
      applicationService.getBeer().then(response => {
          if(response.status == 200) {
 this.$store.commit("SET_BEERS", response.data);
this.beers=response.data;
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
     getBeerByBreweryId() {
      applicationService.getBeersByBreweryId(this.$store.state.user.brewer_id).then(response => {
          if(response.status == 200) {
 this.$store.commit("SET_BEERS", response.data);
this.beers=response.data;
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
    this.getBeerByBreweryId();
  },
  computed: {
      sortedBeers(){
          return this.$store.state.beers;
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