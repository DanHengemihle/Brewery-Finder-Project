<template>
  <body>

<!-- <div id="details"> -->
  <!-- <div class="heading">
    <h1 class="brewery-name"> {{brewery.name}}</h1>
<div class="address">
  <h2><span v-if="brewery.state" >{{brewery.state}},</span>{{brewery.city}}</h2>
</div>
<div class="website">
  <a v-bind:href="brewery.websiteURL" target="_blank"><h3>{{brewery.websiteURL}}</h3></a>
</div>

<div class="show-form-button">
  <button href="#" v-on:click.prevent="showForm=true"
v-if="showForm === false && this.$store.state.brewer_id === this.brewery.brewer_id">
Show Form </button>
</div>
</div> -->

    <div id="createBeer" class="text-center">
      <img :src="'\Logo.png'" />
      <form class="form-register" @submit.prevent="createBeer">
        <h1 class="h3 mb-3 font-weight-normal">Add Beer</h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>

        <div>
          <label for="beer-name" class="sr-only">Beer Name</label>

          <input
            type="text"
            id="name"
            class="form-control"
            placeholder="Beer Name"
            v-model="beer.beerName"
            required
            autofocus
          />
        </div>

        <div>
          <label for="beer-description" class="sr-only">Description</label>

          <input
            type="text"
            id="description"
            class="form-control"
            placeholder="Description"
            v-model="beer.beerDescription"
            required
          />
        </div>

        <div>
          <label for="abv" class="sr-only">Abv</label>

          <input
            type="text"
            id="abv"
            class="form-control"
            placeholder="Abv"
            v-model="beer.abv"
            required
          />
        </div>
        <div>
          <label for="image" class="sr-only">Image</label>

          <input
            type="text"
            id="image"
            class="form-control"
            placeholder="Image Url"
            v-model="beer.image"
            required
          />
        </div>
        

        <button
          id="create-beer"
          class="btn btn-lg btn-primary btn-block"
          type="submit"
        >
          Add Beer
        </button>
      </form>
    </div>
  
  </body>
</template>

<script>
import applicationService from "../services/ApplicationService";

export default {
  name: "register",
  data() {
    return {
      beer: {
     
          breweryId: this.$store.state.activeBrewery.id,
          beerName: "",
          beerDescription: "",
          image: "",
          beerType: "1",
          abv: "",
          
      },

      registrationErrors: false,
      registrationErrorMsg: "There were problems adding this beer.",
    };
  },
  methods: {
    createBeer() {
      applicationService
        .addBeer(this.beer)
        .then((response) => {
          if (response.status == 201 || response.status == 200) {
            this.$router.push({
              path: "/brewery",
              query: { registration: "success" },
            });
          }
        })
        .catch((error) => {
          const response = error.response;
          this.registrationErrors = true;
          if (response.status === 400) {
            this.registrationErrorMsg = "Bad Request: Validation Errors";
          }
        });
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems adding this beer.";
    },
  }
  
};
</script>



<style scoped>


html{
  height: 100%;
  background-color: black;
min-width: 550px;
position: relative;

}



#registerBeer{
  display: block;
 max-height: 70vh;
 
}



.beer {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  font-size: 2vh;
  font-weight: 750;
  max-height: 11vh;
  margin-bottom: -17%;
  overflow: hidden;
}


input::placeholder {
  color: black;
}


* {
  padding: 0;
  margin: 0;
}

input {
  display: block;
  height: 50px;
  background-color: rgba(255, 255, 255, 0.787);
  border: 2px solid rgba(0, 0, 0, 0.383);
  border-radius: 3px;
  padding: 0 10px;
  margin-top: 4px;
  font-size: 17px;
  font-weight: 650;
  text-align: center;
  color: black;
}

img {
  
  width: 18vh;
}

body {
  display: flex;
  background-color: black;
  background-image: url("/bar3.jpg");
  justify-content: center;
  align-items: center;
  padding-top: 50px;
  padding-left: 60px;
  background-position: center;
  background-size: cover;
  background-repeat: no-repeat;
  overflow-y: auto;

}

body,
html {
  height: 100vh;
}

h1 {
  text-shadow: 1px 1px black;

  font-size: 300%;
  color: darkgoldenrod;
}

#create-beer {
  border: 2px solid rgba(255, 255, 255, 0.1);
  box-shadow: 0px 0px 20px rgba(8, 7, 16, 0.6);
  color: darkgoldenrod;
  font-size: 130%;
  background-color: black;
  cursor: pointer;
  margin-top: 1vh;
}
</style>
