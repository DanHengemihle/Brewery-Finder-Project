<template>
  <body>
  <div id="wholepage">
     <h1> Favorite Beers </h1>
     <br>
     <tr id="favorites" v-for="beer in favorites" :key="beer.id">

         
          <td ><img :src="beer.image" /></td>
          <td id="beername">{{ beer.beerName }}</td>
          <td id="description">{{ beer.beerDescription }}</td>
          <td id="abv">{{ beer.abv }}% abv</td>
     </tr>
  </div>
  </body>
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

<style scoped>
#wholepage{
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    margin-top: 100px;
     margin-top: 100px;
    background-color: goldenrod !important;
 transform: translate(0vw,-20vh);
 background-size: cover;
 background-repeat: no-repeat;
}

#favorites {
 color:  black !important;
 transform: translate(-5vw,20vh);
 background-color: goldenrod;
}

#beername {
  font-size: 30px;
  color: #000;
  font-weight: 700;
  font-style: italic;
  text-decoration: underline;
}
#description {
  font-size: 20px;
  color: black;
  font-weight: 700;
  text-align: left;
  padding-left: 5%;
  padding-right: 5%;
  font-style: italic;
  max-width: 57vw;
}
#abv {
  font-size: 25px;
  color: black;
  font-weight: 700;
  text-decoration: underline;
  text-align: left;
  transform: translate(-1vw);
  

}
div {
    color: white;
}
</style>