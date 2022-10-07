<template>
      
   
    <div id="details">
<div class="heading">
      <h1 class="brewery-name">{{brewery.name}}</h1>

    <h1 class="brewery-name">{{brewery.name}}</h1>

<div class="address">
    <h2><span v-if="brewery.street" >{{brewery.street}}, </span>{{brewery.city}}</h2>
</div>

<div class="website">
    <a v-bind:href="brewery.websiteUrl" target="_blank"><h3> {{brewery.website_url}}</h3></a>
</div>

<div class="description">
    <a v-bind:href="brewery-description" target="_blank"><h2>{{brewery.description}}</h2></a>
</div>
</div>
<router-link id="updatebrewery" :to="{name: 'updatebrewery' }" v-if="$store.state.user.role == 'ROLE_BREWER'">Update Brewery</router-link>
              <button v-if="$store.state.user.role == 'ROLE_BREWER'" v-on:click="deleteBrewery(brewery.id)">Delete Brewery</button>
<router-link id="addbeer" :to="{name: 'beerform' }" v-if="$store.state.user.role == 'ROLE_BREWER'">Add Beer</router-link>

<div class="subheading">
    <h3>Beers from {{brewery.name}}</h3>
</div>

</div>

</template>


<script>


import applicationService from "../services/ApplicationService";
export default {
   
    name: "brewery-details",
    
    data() {
        return {
           brewery: {
  id: "",
  brewerId: this.$store.state.user.id,
        name: "",
        street: "",
        city: "",
        state: "",
        phone: "",
        websiteUrl: "",
        hoursOfOperation: "",
},
            showForm: false,

        }

    },

    methods: {

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

              this.$router.push({ name: "home" });
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
    },
   
    created() {
        this.brewery = this.$store.state.activeBrewery;
    }
}

</script>

<style scoped>

#addbeer{
    font-size: 5vh;
    display: flex;
    color: white;
}

#details {
  padding: 0;
  margin-bottom: -10vh;
  box-sizing: border-box;
  
}
.heading {
    display: grid;
    grid-template-columns: auto auto;
    margin-top: 100px;
    grid-column-gap: 1vw;
    background-color: #C0C0C0;
    margin: 15vh 20vw 0 20vw;
    border-radius: 15px;
    box-shadow: inset 0px 0px 10px #000;
}
.submitBtn {
    text-align: center;
    margin: 15px;
}
.subheading {
    color: 	#404040;
    font-size: 1.8rem;
    text-align: center;
    background-color: whitesmoke;
    background-position: center;
    margin: 8% 28% 5% 28%;
    border-radius: 15px;
    box-shadow: inset 0px 0px 10px #000;
}
@keyframes logo{
   0%{opacity: 0%; width: 0%;}
   20%{opacity: 20%; width: 20%;}
   40%{opacity: 40%; width: 40%;}
   60%{opacity: 60%; width: 60%;}
   80%{opacity: 80%; width: 80%;}
   100%{opacity: 100%; width: 100;}
}

.address{
    grid-column: 2/2;
    grid-row: 2/2;
    font-size: 12px;
    color: black;
    margin-top: -5vh;
    text-align: center;
}

.brewery-name {
    grid-column: 2/2;
    font-size: 3rem;
    grid-row: 1/1;
    text-align: center;
    margin-right: 20px;
    
}
.website {
    grid-column: 2/2;
    grid-row: 2/2;
    margin-top: -1vh;
}
/* .address {
    grid-column: 2/2;
    grid-row: 2/2;
    font-size: 12px;
    color: black;
    margin-top: 2vh;
} */
a:link {
    text-decoration: none;
    color: black;
    font-size: 12px;
}
a:hover {
    color: 	#696969;
}
.description {
    grid-column: 1/3;
    grid-row: 3/3;
    text-align: center;
    margin: 2vh 2vw 0 2vw;
}

/* #beer-list {
    padding-top: 15px;
    text-align: center;
} */
/* .card-space {
    border-radius: 15px;
    margin-bottom: 10vh;
    box-shadow: inset 0px 0px 10px #000;
}
.card-space:nth-child(odd) {
    background-color: 	#C0C0C0;
}
.card-space:nth-child(even) {
    background-color: 	#F5F5F5;
} */
/* .card-space:hover {
    background-color: rgb(139, 139, 139);

} */

#update-brewery{
    font-size: 20px;
}


</style>