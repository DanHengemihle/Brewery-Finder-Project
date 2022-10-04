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

    <div id="registerBrewery" class="text-center">
      <img :src="'\Logo.png'" />
      <form class="form-register" @submit.prevent="registerBrewery">
        <h1 class="h3 mb-3 font-weight-normal">Create Brewery</h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>

        <div>
          <label for="brewery-name" class="sr-only">Brewery Name</label>

          <input
            type="text"
            id="name"
            class="form-control"
            placeholder="Brewery Name"
            v-model="brewery.name"
            required
            autofocus
          />
        </div>

        <div>
          <label for="phone-number" class="sr-only">Phone Number</label>

          <input
            type="text"
            id="phone-number"
            class="form-control"
            placeholder="Phone Number"
            v-model="brewery.phone"
            required
          />
        </div>

        <div>
          <label for="website-url" class="sr-only">Website Url</label>

          <input
            type="text"
            id="website-url"
            class="form-control"
            placeholder="Website Url"
            v-model="brewery.websiteUrl"
            required
          />
        </div>
        <div>
          <label for="street" class="sr-only">Street</label>

          <input
            type="text"
            id="street"
            class="form-control"
            placeholder="Street Address"
            v-model="brewery.street"
            required
          />
        </div>
        <div>
          <label for="city" class="sr-only">City</label>

          <input
            type="text"
            id="city"
            class="form-control"
            placeholder="City"
            v-model="brewery.city"
            required
          />
        </div>
        <div>
          <label for="state" class="sr-only">State</label>

          <input
            type="text"
            id="state"
            class="form-control"
            placeholder="State"
            v-model="brewery.state"
            required
          />
        </div>



        <form @submit.prevent="hoursOfOperation">
          <div id="hours-of-operation">
            
            <p id="hoursOfOpText">Hours of Operation</p>

            <label for="Hours" class="sr-only">Hours</label>

            <select id="days" name="days" v-model="days" @change="selectedDay($event)">
              <option disabled value="">Day</option>
              <option value="Mon">Mon</option>
              <option value="Tue">Tue</option>
              <option value="Wed">Wed</option>
              <option value="Thu">Thu</option>
              <option value="Fri">Fri</option>
              <option value="Sat">Sat</option>
              <option value="Sun">Sun</option>
            </select>

            <select
              id="starting-hour"
              name="startingHour"
              v-model="startingHour"
              @change="selectedStartingHour($event)"
            >
              <option disabled value="">Starting Hour</option>
              <option value="12:00 AM">12:00 AM</option>
              <option value="01:00 AM">01:00 AM</option>
              <option value="02:00 AM">02:00 AM</option>
              <option value="03:00 AM">03:00 AM</option>
              <option value="04:00 AM">04:00 AM</option>
              <option value="05:00 AM">05:00 AM</option>
              <option value="06:00 AM">06:00 AM</option>
              <option value="07:00 AM">07:00 AM</option>
              <option value="08:00 AM">08:00 AM</option>
              <option value="09:00 AM">09:00 AM</option>
              <option value="10:00 AM">10:00 AM</option>
              <option value="11:00 AM">11:00 AM</option>
              <option value="12:00 PM">12:00 PM</option>
              <option value="01:00 PM">01:00 PM</option>
              <option value="02:00 PM">02:00 PM</option>
              <option value="03:00 PM">03:00 PM</option>
              <option value="04:00 PM">04:00 PM</option>
              <option value="05:00 PM">05:00 PM</option>
              <option value="06:00 PM">06:00 PM</option>
              <option value="07:00 PM">07:00 PM</option>
              <option value="08:00 PM">08:00 PM</option>
              <option value="09:00 PM">09:00 PM</option>
              <option value="10:00 PM">10:00 PM</option>
              <option value="11:00 PM">11:00 PM</option>
            </select>

            <select
              id="ending-hour"
              name="endingHour"
              v-model="endingHour"
              @change="selectedEndingHour($event)"
            >
              <option disabled value="">Ending Hour</option>
              <option value="12:00 AM">12:00 AM</option>
              <option value="01:00 AM">01:00 AM</option>
              <option value="02:00 AM">02:00 AM</option>
              <option value="03:00 AM">03:00 AM</option>
              <option value="04:00 AM">04:00 AM</option>
              <option value="05:00 AM">05:00 AM</option>
              <option value="06:00 AM">06:00 AM</option>
              <option value="07:00 AM">07:00 AM</option>
              <option value="08:00 AM">08:00 AM</option>
              <option value="09:00 AM">09:00 AM</option>
              <option value="10:00 AM">10:00 AM</option>
              <option value="11:00 AM">11:00 AM</option>
              <option value="12:00 PM">12:00 PM</option>
              <option value="01:00 PM">01:00 PM</option>
              <option value="02:00 PM">02:00 PM</option>
              <option value="03:00 PM">03:00 PM</option>
              <option value="04:00 PM">04:00 PM</option>
              <option value="05:00 PM">05:00 PM</option>
              <option value="06:00 PM">06:00 PM</option>
              <option value="07:00 PM">07:00 PM</option>
              <option value="08:00 PM">08:00 PM</option>
              <option value="09:00 PM">09:00 PM</option>
              <option value="10:00 PM">10:00 PM</option>
              <option value="11:00 PM">11:00 PM</option>
            </select>

            <button id="add-hours" type="submit">Add Hours</button>
          </div>
        </form>
        <div id="hoursDisplay" v-for="day in hours_of_operation" v-bind:key = "day">{{day}} <button id="remove" class="btn" @click="removeDay(day)">Remove</button></div>

        <br />
        <br />

        <button
          id="create-brewery"
          class="btn btn-lg btn-primary btn-block"
          type="submit"
        >
          Register Brewery
        </button>
      </form>
    </div>
    <div id="space">space</div>
  </body>
</template>

<script>
import applicationService from "../services/ApplicationService";

export default {
  name: "register",
  data() {
    return {
      brewery: {
        brewer_id: this.$store.state.user.id,
        name: "",
        street: "",
        city: "",
        state: "",
        phone: "",
        websiteUrl: "",
         hoursOfOperation: "",
         
        // hoursOfOp: [{day: []}, {starting: []}, {ending: []}],
        
      },
      hours_of_operation: [],
       days: "",
        startingHour: "",
        endingHour: "",

      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this brewery.",
    };
  },
  methods: {
    registerBrewery() {
      applicationService
        .addBrewery(this.brewery)
        .then((response) => {
          if (response.status == 201) {
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
      this.registrationErrorMsg = "There were problems registering this brewery.";
    },
    hoursOfOperation() {
      
      this.hours_of_operation.push(this.days + " " + this.startingHour + " - " + this.endingHour);
      this.brewery.hoursOfOperation = this.hours_of_operation.toString().split(",").join(", ");   
    },

    selectedDay(event){
      this.days = event.target.value;
    },

    selectedStartingHour(event){
      this.startingHour = event.target.value;
    },

    selectedEndingHour(event){
      this.endingHour = event.target.value;
    },

    removeDay(day){
      let currentDayToRemove = this.hours_of_operation.indexOf(day);
      this.hours_of_operation.splice(currentDayToRemove, 1);
    }


    //  emitChange() {
    //   this.$emit('change', this.selected);
    // },
  },
  
};
</script>



<style scoped>

div#registerBrewery.text-center{
  position: absolute;
  overflow: hidden;
}

#remove{
font-size: 1.5vh;
padding: 0;
}

#hoursDisplay{
  font-weight: bold;
  font-size: 1.8vh;
  color: darkgoldenrod;
  margin: 1vh;
}

#hoursOfOpText{
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

  background-image: url("/bar1.jpg");
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
