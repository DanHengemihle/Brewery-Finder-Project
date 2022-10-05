<template>
  <div class="beer-list">
    <h1>List of Beers</h1>
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
        <tr v-for="beer in sortedBeers" :key="beer.id">
          <td class="id"></td>
          <td></td>
          <td><img :src="beer.image" /></td>
          <td>{{ beer.beerName }}</td>
          <td>{{ beer.beerDescription }}</td>
          <td>{{ beer.abv }}</td>
          <td>
            <button v-on:click.prevent="favoriteBeer(beer.name)">
              Add to Favorites
            </button>
            <button v-on:click.prevent="deleteABeer(beer.beerId)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import applicationService from "../services/ApplicationService";

export default {
  data() {
    return {
      breweries: [],
      beers: [],
    };
  },
  name: "breweries-list",
  methods: {
    viewBrewery(id) {
      this.$router.push(`/breweries/${id}`);
    },
    deleteABeer(id) {
      if (
        confirm(
          "Are you sure you want to delete this brewery and all associated information? This action cannot be undone."
        )
      ) {
        applicationService
          .deleteBeer(this.brewery.id)
          .then((response) => {
            if (response.status === 200) {
<<<<<<< HEAD
            //   alert("Beer successfully deleted");
=======
              alert("Beer successfully deleted");
>>>>>>> main

              this.getBeers();
               this.$store.commit("DELETE_BEER", id);
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
      applicationService
        .getBeer()
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_BEERS", response.data);
            this.beers = response.data;
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
    getBeersByBreweryId() {
      applicationService
        .getBeerByBreweryId(this.$store.state.user.id)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_BEERS", response.data);
            this.beers = response.data;
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
    this.getBeers();
  },
  computed: {
    sortedBeers() {
      return this.$store.state.beers;
    },
  },
};
</script>

<style scoped>
#beer-list {
  display: inline-block;

}



table {
  background-color: initial;
  background-image: url("/lighterbg.jpg");
  background-position: center;
  background-size: cover;
  background-repeat: no-repeat;
}
</style>