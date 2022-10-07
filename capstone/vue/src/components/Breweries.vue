<template>
  <body>
    <div id="background">
    
      <div class="headings">
        <h1 class="heading">Welcome to Bootlegger!</h1>
      
      </div>

      <br />
      <br />
      <br />

      <div class="loading" v-if="isLoading">
        <img id="beer" src="/public/centermug.jpg" />
      </div>

      <!-- <brewery-card class="card-space" v-for="brewery in breweries" v-bind:key="brewery.name" v-bind:brewery="brewery"/> -->
      <!-- </div>  -->
    </div>

    <div class="brewery-list">
      <table>
        <!-- <thead>
          <tr>
            <th>&nbsp;</th> -->
        <!-- <th>Name</th>
            <th>City</th>
            <th>State</th>
            <th>Zipcode</th>
            <th>Phone</th>
            <th>Website URL</th>
            <th>Hours of Operation</th>
          </tr> -->
        <h1>Breweries</h1>
        <br>
        <br>
        <!-- </thead> -->
        <tbody>
          <tr v-for="brewery in sortedBreweries" :key="brewery.id">
            <!-- <td class="id">{{brewery.id}}</td> -->
            <!-- <td> -->
            <td class="name" @click="viewBrewery(brewery)">
              {{ brewery.name }}
            </td>
            <td class="ownedby">{{ brewery.phone }}</td>
            <td>
              <a :href="[brewery.websiteUrl]" target="_blank">
                {{ brewery.websiteUrl }}
              </a></td>
            <td>
              <a :href="[brewery.website_url]" target="_blank">
                {{ brewery.website_url }}
              </a>
            </td>
            <!-- <td>
              <button v-on:click="updateBrewery(brewery.id)">Edit</button>&nbsp;
              <button v-on:click="deleteBrewery(brewery.id)">Delete</button>
            </td> -->
          </tr>
        </tbody>
      </table>
    </div>
  </body>
</template>

<script>
import applicationService from "../services/ApplicationService";
// import BreweryCard from "../components/BreweryCard.vue";
export default {
  data() {
    return {
      activeBrewery: {
        id: "",
        brewerId: "",
        name: "",
        street: "",
        city: "",
        state: "",
        phone: "",
        websiteUrl: "",
        hoursOfOperation: "",
      },
      url: "",
    };
  },
  name: "breweries-list",
  methods: {
    viewBrewery(selectedBrewery) {
      applicationService.getBreweryById(selectedBrewery.id).then((response) => {
        if (response.status == 200) {
          this.$store.commit("SET_ACTIVE_BREWERY", selectedBrewery);
          this.$router.push({ name: "brewery" });
        }
      });
    },
    deleteBrewery() {
      applicationService;
      if (
        confirm(
          "Are you sure you want to delete this brewery and all associated information? This action cannot be undone."
        )
      ) {
        applicationService
          .deleteBrewery(this.brewery.id)
          .then((response) => {
            if (response.status === 200) {
              alert("Brewery successfully deleted");

              this.$store.commit("DELETE_BREWERY", this.brewery.id);

              this.$router.push({ name: "Home" });
            }
          })

          .catch((error) => {
            if (error.response) {
              this.errorMsg =
                "Error deleting brewery. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error deleting brewery. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error deleting brewery. Request could not be created.";
            }
          });
      }
    },
    getBreweries() {
      applicationService
        .getBreweries()
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_BREWERY", response.data);
            this.breweries = response.data;
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
    viewWebsite(url) {
      this.$router.replace(url);
    },
  },

    updateBrewery(id){
      applicationService.editBrewery(id)
      .then((response) => {
          if (response.status == 200) {
  this.$store.commit("SET_BREWERY", response.data);
            this.breweries = response.data;
          }
        })
        .catch((error) => {
          if (error.response.status === 204) {
            this.$router.push("/204");
          } else {
            console.error(error);
          }
        });
    },
  created() {
    this.getBreweries();
  },
  computed: {
    sortedBreweries() {
      return this.$store.state.breweries;
    },
  },
};
</script>

<style scoped>



table {
  width: 100%;
  margin: 0;
 font-size: 25px;
 max-width: 100%;
  padding-right: 40px;
  padding-left: 50px;
  display: flex;
  /* flex-wrap: wrap; */
  /* grid-gap: 10px 200px; */
  align-self: space-around;
  justify-content: space-around;
  /* background-color: initial; */
  opacity: 30%;
  border-radius: 70px;
  width: 50%;
  color: #f7fafc;
  padding: 20px;
  border-collapse: collapse;
  opacity: 90%;
 flex: 1;
 /* /* height: 400px; */
  margin: 80px;
  text-align: center; 
 border: 4px solid;
 /* border-width: 25px 10px; */
 margin-top: 30px;
animation-name: bounce;
animation-duration: 3s;
animation-iteration-count: 2;
backdrop-filter: blur(5px);
box-shadow: inset 0px 0px 20px #000;
}

/* th {
  font-family: "Work Sans", sans-serif;
  font-weight: 500;
  text-align: center;
} */

/* tr {
  margin: 20px;
  padding: 40px;
} */
td {
  padding: 20px;
  font-family: "Work Sans", sans-serif;
}

td.name {
  font-weight: 400;
  color: lightblue;
}

td.name:hover {
  cursor: pointer;
}


body,
html {
  /* display: flex; */
/* opacity: 80%; */
  background-image: url("/2beers.jpg");
/* position: absolute; */
/* display: flex; */
/* flex-wrap: wrap; */
/* flex-direction: column; */
  justify-content: center;
  align-items: center;
  padding-left: 20px;
  /* background-position: center; */
  background-size: cover;
  /* background-repeat: no-repeat; */
}


/* .brewery-list{
  text-
} */


h1 {
  font-size: 50px;
  box-shadow: goldenrod;
}







</style>