<template>
  
<div id="card">

<<<<<<< HEAD
<router-link v-bind:to="{name: 'brewery-details', params: {id: this.brewery.name} }">
=======

<brewery-details />
<beers />

<!-- <router-link v-bind:to="{name: 'brewery-details', params: {id: this.brewery.breweryId} }">
>>>>>>> main
<div id="card" data-aos="fade-down">
<a href="#" class="btn">{{this.brewery.name}}</a>
</div>
</router-link> -->
</div>
</template>

<script>
import BreweryDetails from "../components/BreweryDetails.vue"
import Beers from "../components/Beers.vue"

export default {
<<<<<<< HEAD
    props: ["breweries"],
=======
  components: { BreweryDetails, Beers },
    data(){
        return{
            activeBrewery: {
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
        }
    },

    created(){
        this.activeBrewery = this.$store.state.activeBrewery;
    }
>>>>>>> main

}
</script>

<style scoped>

.btn{
font-family: Arial, Helvetica, sans-serif;
font-size: .9rem;
display: inline-block;
background: #000;
color: #fff;
text-align: center;
padding: 5px 5px;
margin-top: 1rem;
margin-bottom: 1rem;
border-radius: 5px;
box-shadow: inset 0px 0px 10px #000;

}


.btn:hover {
    opacity: 0.8;
}

a:hover, a:visited, a:link, a:active {
    text-decoration: none;
}
/* 
#card{
    width: 300px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    grid-template-columns: 1fr;
    grid-gap: 0rem;
    background-color: #d3d3d3;
    margin-bottom: 2rem;
    border-radius: 5px;
    box-shadow: inset 0px 0px 10px #000;
} */



#name {

height: 20vh;
font-size: 10vh;
transform: translate(0, 50vh);
color: black;
}

</style>