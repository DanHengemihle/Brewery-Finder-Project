<template>
  <div>
      <h1>List of Beers</h1>
      <beers />
  </div>
</template>

<script>

import Beers from '../components/Beers.vue'
export default {
  components: { Beers },

}
</script>

<style>

h1{
display: block;
  color: blue;
}
</style>