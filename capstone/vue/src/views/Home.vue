<template>
  <body>
  <home />
  </body>
</template>

<script>

import Home from '@/components/Home'
export default {
  components: {
    Home
  }

}
</script>

<style scoped>
body{
  height: 100vh;
  background-image: url("/2beers.jpg");
  background-position: center;
  background-size: cover;
  background-repeat: no-repeat;
}

</style>