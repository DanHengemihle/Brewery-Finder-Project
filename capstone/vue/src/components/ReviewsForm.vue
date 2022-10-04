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

    <div id="create-review" class="text-center">
      <img :src="'\Logo.png'" />
      <form class="form-register" @submit.prevent="createReview">
        <h1 class="h3 mb-3 font-weight-normal">Add Review</h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>

        <div>
          <label for="brewery-name" class="sr-only">Brewery Name</label>

         <select id="rating-number" name="rating-numbers" v-model="review.rating" @change="selectedRating($event)">
              <option disabled value="">Day</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              
            </select>


        <div>
          <label for="review" class="sr-only">Review</label>

          <input
            type="text"
            id="review"
            class="form-control"
            placeholder="Write your review."
            v-model="review.description"
          />
        </div>

        <button
          id="create-review"
          class="btn btn-lg btn-primary btn-block"
          type="submit"
        >
          Add Review
        </button>
      </form>
    </div>
  </body>
</template>

<script>
import applicationService from "../services/ApplicationService";

export default {
  props: {},
  name: "register",
  data() {
    return {
      review: {
        user_id: this.$store.state.user.id,
        beerId: "",
        beerName: "",
        breweryName: "",
        description: "",
        rating: "",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this review.",
    };
  },
  methods: {
    createReview() {
      applicationService
        .addReview(this.review)
        .then((response) => {
          if (response.status == 201) {
            this.$store.commit("SET_REVIEWS", response.data);
            this.reviews = response.data;
            this.$router.push({
              path: "/home",
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
      this.registrationErrorMsg =
        "There were problems registering this review.";
    },

    selectedRating(event) {
      this.review.rating = event.target.value;
    },
  },
};
</script>



<style scoped>
div#registerBrewery.text-center {
  position: absolute;
  overflow: hidden;
}

#remove {
  font-size: 1.5vh;
  padding: 0;
}

#hoursDisplay {
  font-weight: bold;
  font-size: 1.8vh;
  color: darkgoldenrod;
  margin: 1vh;
}

#hoursOfOpText {
  font-weight: bolder;
  font-size: 2vh;
  color: darkgoldenrod;
}

.switch {
  position: relative;
  display: inline-block;
  width: 25px;
  height: 15px;
  padding: 0px;
}

.switch input {
  opacity: 0;
  width: 0;
  height: 0;
}

.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgb(0, 0, 0);
  -webkit-transition: 0.4s;
  transition: 0.4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 10px;
  width: 10px;
  left: 4px;
  bottom: 3px;
  background-color: rgb(255, 247, 228);
  -webkit-transition: 0.4s;
  transition: 0.4s;
}

input:checked + .slider {
  background-color: rgb(235, 181, 46);
}

input:focus + .slider {
  box-shadow: 0 0 1px black;
}

input:checked + .slider:before {
  -webkit-transform: translateX(8px);
  -ms-transform: translateX(8px);
  transform: translateX(8px);
  color-adjust: black;
}

.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
}

.checkbox {
  transform: translate(4vw, -2.7vh);
}

.brewer {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  font-size: 2vh;
  font-weight: 750;
  max-height: 11vh;
  margin-bottom: -17%;
}

#space {
  height: 1000px;
}

#username {
  margin-top: -2%;
}

#usericon {
  transform: translate(-880%, -10%);
  opacity: 0.8;
  padding: 10px;
  min-width: 40px;
}

#keyicon {
  transform: translate(-985%, 145%);
  opacity: 0.8;
  padding: 10px;
  min-width: 40px;
}

input::placeholder {
  color: black;
}

#haveaccount {
  color: #000274;
  font-weight: 650;
  font-size: 1.8vh;
  text-shadow: 30px;
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

  background-image: url("/bar3.jpg");
  justify-content: center;
  align-items: center;
  padding-top: 50px;
  padding-left: 60px;
  background-position: center;
  background-size: cover;
  background-repeat: no-repeat;
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

#create-brewery {
  border: 2px solid rgba(255, 255, 255, 0.1);
  box-shadow: 0px 0px 20px rgba(8, 7, 16, 0.6);
  color: darkgoldenrod;
  font-size: 130%;
  background-color: black;
  cursor: pointer;
  margin-top: -4.5vh;
}
</style>
