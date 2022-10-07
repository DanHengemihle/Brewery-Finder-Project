<template>
  <div id="wholepage">
     <h1> Favorite Beers </h1>
     <br>
     <tr v-for="beer in favorites" :key="beer.id">

          <div id="beerimage">
          <td ><img :src="beer.image" /></td></div>
          <td id="beername">{{ beer.beerName }}</td>
          <td id="description">{{ beer.beerDescription }}</td>
          <td id="abv">{{ beer.abv }}% abv</td>
     </tr>
  </div>
</template>

<script>
export default {
data(){
    return {
        favorites: this.$store.state.favorites
    }
}
}
</script>

<style>
#wholepage{
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    
}
</style>