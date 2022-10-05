<template>
  <body>
    <div class="home">
      <div class="headings">
        <h1 class="heading">Welcome to Bootlegger!</h1>
        <br />
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
        <!-- </thead> -->
        <tbody>
          <tr v-for="brewery in sortedBreweries" :key="brewery">
            <!-- <td class="id">{{brewery.id}}</td> -->
            <!-- <td> -->
            <td class="name">{{ brewery.name }}</td>
            <td class="ownedby">{{ brewery.phone }}</td>
            <td>{{ brewery.website_url }}</td>
            <td>
              <button v-on:click="viewBrewery(brewery.id)">Edit</button>&nbsp;
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
name: "breweries-list",
  methods: {
    viewBrewery(id) {
      this.$router.push(`/breweries/${id}`);
    },
    deleteBrewery() {
      applicationService
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
/* * {
  padding: 0px;
  margin: 0px;
  box-sizing: border-box;
}

table {
  padding: 30px;
  margin-top: 500px;
  background-color: goldenrod;
table{
  margin-top: 40px;
  background-color: initial;
  opacity: 90%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background-position: center;
}

table {
  padding-right: 50px;
  padding-left: 50px;
  display: flex;
  flex-wrap: wrap;
  grid-gap: 10px 200px;
  align-self: space-around;
  justify-content: space-around;
  background-color: goldenrod;
  opacity: 90%;
  border-radius: 50px;
   width: 100%;
  border-collapse: collapse;
  margin: 0;
  padding: 0;
}

.heading {
  font-size: 2rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 40vh;
  color: goldenrod;
  text-shadow: 2px 2px 15px black;
}
body,
html {
  display: flex;

  background-image: url("/beer7.png");

  justify-content: center;
  align-items: center;
  padding-left: 20px;
  background-position: center;
  background-size: cover;
  background-repeat: no-repeat;
}

body,
html {
  /* max-height: 300px; */
  /* height: 100vh;
}

.brewery-list {
  padding-right: 25px;
  padding-left: 25px;
  display: flex;
  flex-wrap: wrap;
  grid-gap: 10px 200px;
} -- */
table {
  width: 100%;
  border-collapse: collapse;
  margin: 0;
  padding: 0;
  padding-right: 20px;
  padding-left: 50px;
  display: flex;
  flex-wrap: wrap;
  grid-gap: 10px 200px;
  align-self: space-around;
  justify-content: space-around;
  background-color: goldenrod;
  opacity: 90%;
  border-radius: 50px;
   width: 100%;
 
  color: #f7fafc;
 
  padding: 40px;
  flex: 1;
  margin: 100px;
  text-align: center;
  cursor: pointer;
  width: 60%;
}

th {
  font-family: "Work Sans", sans-serif;
  font-weight: 500;
  text-align: left;
}

tr {
  margin: 20px;
  padding: 40px;
}
td {
  padding: 8px;
  font-family: "Work Sans", sans-serif;
}

td.name {
  font-weight: 400;
}
.docs-icon img {
  height: 32px;
}
.avatar {
  border-radius: 20px;
  width: 32px;
  vertical-align: middle;
  padding-right: 5px;
}
.ownedby {
  vertical-align: middle;
}

body,
html {
  /* display: flex; */

  background-image: url("/beer7.png");

  justify-content: center;
  align-items: center;
  padding-left: 20px;
  background-position: center;
  background-size: cover;
  background-repeat: no-repeat;
}

h1 {
  font-size: 50px;
  box-shadow: goldenrod;
}
</style>