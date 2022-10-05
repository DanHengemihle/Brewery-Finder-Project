<template>
  
<div>

<router-link v-bind:to="{name: 'brewery-details', params: {id: this.brewery.name} }">
<div id="card" data-aos="fade-down">
<a href="#" class="btn">{{this.brewery.name}}</a>
</div>
</router-link>
</div>
</template>

<script>
export default {
    props: ["breweries"],

}
</script>

<style>

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

</style>