<template>
  
<div id= 'brewer-page'>
  <h1>New Brewery: Please Input Brewery Information</h1>
  <form>
    <table class='brewer-table' id='brewery-add'>
      <thead></thead>
      <tbody>
        <div class="form-element">
          <tr>
            <td><label for="name">Brewery Name:</label></td>
            <td><input id="name" type="text" v-model="newBrewery.name" required/></td>
            </tr>
            </div>

            <div class ="form-element">
              <tr>
                <td><label for="address">Brewery Address:</label></td>
                <td><input id="address" type="text" v-model="newBrewery.address" required/></td>
</tr>
            </div>
            <div class="form-element">
              <tr>
                <td><label for="city">City:</label></td>
                 <td><input id="city" type="text" v-model="newBrewery.city" required/></td>
              </tr>
            </div>
            <div class="form-element">
              <tr>
                <td><label for="zipcode">Zipcode:</label></td>
                <td><input id="zipcode" type="text" v-model="newBrewery.zipcode" required/></td>
              </tr>
              </div>
               <div class="form-element">
              <tr>
                <td><label for="description">Description:</label></td>
                <td><input id="description" type="text" v-model="newBrewery.description" required/></td>
              </tr>
               </div>
<div class="form-element">
              <tr>
                <td><label for="websiteurl">Website URL:</label></td>
                <td><input id="websiteurl" type="text" v-model="newBrewery.websiteurl" required/></td>
              </tr>
               </div>
<div class="form-element">
              <tr>
                <td><label for="hours">Hours of Operation:</label></td>
                <td><input id="hours" type="text" v-model="newBrewery.hours"/></td>
              </tr>
               </div>
            <div>
<button type="submit" class="submitBtn" onclick="window.location.reload();"
v-on:click.prevent="addNewBrewery()">Submit</button>
            </div></tbody>

    </table>
  </form>
<div>



<div>
  <table class="admin-table" id="brewery-table">
    <thead>
      <tr>
        <th>Brewery</th>
        <th>BreweryID</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="brewery in breweries" v-bind:key="brewery.id" v-bind:brewery="brewery">
        <td>{{brewery.name}}</td>
        <td>{{brewery.breweryID}}</td>
        <td><button type="button" class="deleteBtn" v-on:click="deleteBrewery(brewery)">Delete</button></td>
      </tr>
      <p />
    </tbody>
    </table>
</div>
</div>

</div>

</template>

<script>
import ApplicationService from '../services/ApplicationService'

export default {
name: "brewery",
props: [
  'brewery'
],
components:{


},

data(){
return{
users: [],
breweries: [],
newBrewery: {
name: "",
address: "",
city: "",
zipcode: "",
phoneNumber: "",
description: "",
websiteURL: "",
userID: 0,
hours: "",
lat: "",
long: "",
}
};

},

methods:{

addNewBrewery(){
ApplicationService.createNewBrewery(this.newBrewery).then(response =>{
let counter
response.data.forEach(element => {
  console.log(element)
  counter ++
});
return counter;
}
)

},

deleteBrewery(brewery){
  if(confirm('Are you sure you want to delete $(brewery.name}?')){
    ApplicationService.deleteBrewery(brewery.breweryId).then(response => {
      console.log(response)
      window.location.reload();
    })
  }
}
},
created(){
  ApplicationService.getAllUsers().then(response => {
    this.users = response.data;
  }),
  ApplicationService.getBreweries().then(response => {
    this.breweries = response.data;
  })
}
}


</script>




<style>
div #admin-page{

  margin-top: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
}
 
 td{

   padding: 10px;
   width: 150px;
border-bottom-style: solid;
border-bottom-width: 1px;
border-bottom-color: rgb(201,201,201);
 }


th{
  border-bottom-style: solid;
  border-bottom-width: 1px;
  border-bottom-color: rgb (201,201,201);
}

.submitBtn{
  text-align: center;
  margin: 15px;
}

.deleteBtn{
  background-color: rgb (197, 19, 19);
  color: white;
}


#user-table > tbody >tr >td{
  border-bottom-color: goldenrod;
}


</style>