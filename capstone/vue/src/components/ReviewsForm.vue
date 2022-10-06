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

    <div id="add-review" class="text-center">
      <img :src="'/Logo.png'" />
      <form class="form-register" @submit.prevent="createReview">
        <h1 class="h3 mb-3 font-weight-normal">Add Review</h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>

        <div>
          <label for="rating-number" class="sr-only">Rating</label>

         <select id="rating-number" name="rating-numbers" v-model="review.rating" @change="selectedRating($event)">
              <option disabled value="">Rating</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              
            </select>
        </div>

        <div>
          <label for="review" class="sr-only">Review</label>

          <textarea id="review" class="form-control" type="text"  placeholder="Write your review." v-model="review.description"></textarea>
         
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
        .addBeerReview(this.review)
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

#add-review{

}

* {
  padding: 0;
  margin: 0;
}

input, textarea {
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
  width: 20vw;
  
}

textarea::placeholder {
  color: black;
}

textarea{
  height: 20vh;
  width: 30vw;
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
  flex-direction: column;
}


body, html {
  height: 100vh;
  
}

h1 {
  text-shadow: 1px 1px black;

  font-size: 300%;
  color: darkgoldenrod;
}

#create-review {
  border: 2px solid rgba(255, 255, 255, 0.1);
  box-shadow: 0px 0px 20px rgba(8, 7, 16, 0.6);
  color: darkgoldenrod;
  font-size: 130%;
  background-color: black;
  cursor: pointer;
  margin-top: 2vh;
}
</style>