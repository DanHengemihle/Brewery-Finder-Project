<template>
    <body>
        <!-- <img class="background" src="../public/lighterbg.jpg" alt=""> -->
  <div class="about-page">
    <h1>What is a craft brewery?</h1>
      <h2>An American craft brewery is:</h2>
      <p>
        <b>Small</b>
      </p>
      <p>
        Annual production of 6 million barrels of beer or less (approximately 3
        percent of U.S. annual sales). Beer production is attributed to a brewer
        according to rules of alternating proprietorships.
      </p>
      <p><b>Independent</b></p>
      <p>
        Less than 25 percent of the craft brewery is owned or controlled (or
        equivalent economic interest) by a beverage alcohol industry member that
        is not itself a craft brewer.
      </p>
      <p><b>Brewer</b></p>
      <p>Has a TTB Brewer’s Notice and makes beer.</p>
      <h2>Look for the Seal</h2>
      <p>
        The Brewers Association, publishers of CraftBeer.com, launched a seal
        for independent craft brewers in summer 2017. The design is an upside
        down beer bottle, which symbolizes how craft beer has essentially turned
        the beer market on its head. You can see the
        <a
          href="https://www.craftbeer.com/breweries/independent-craft-brewer-seal"
          class="internal-link"
          >independent craft brewer seal here</a
        >
      </p>
      <p>
        <img
          loading="lazy"
          class="size-full wp-image-83786 alignleft"
          src="https://cdn.craftbeer.com/wp-content/uploads/independent-craft-brewer-seal-feature.png"
          alt="independent craft brewer seal"
          width="500"
          height="800"
        />
      </p>
      <p>
        The seal sends a “clear message to the beer drinker” that a beer is made
        by a small and independent brewer, explains Brewers Association Director
        Paul Gatza.
      </p>
      <p>
        Look for it on brewery websites, beer packaging, menus and more. That’s
        how you know you’re buying beer made by an independent craft brewer.
      </p>
  </div>
    </body>
</template>

<script>
export default {};
</script>

<style scoped>
.alignleft {
  width: 10%;
  height: 10%;
  float: left;
  clear: both;
}
body, html {

    background-image: url("/lighterbg.jpg");
    height: 100vh;
    width: 100vw;
    background-position: center;
    background-size: cover;
    background-repeat: no-repeat;
    
}
    
    body[style*="background-image: url"][style*="lighterbg.jpg"]

 {
        opacity: .1;
     }
img.background {

    opacity: 90%;
}
div.about-page {
    margin-top: 60px;
    max-width: 75vw;
  padding-top: 80px;
  background-position: center;
  margin-left: 50px;
  background-size: cover;
  background-repeat: no-repeat;
  color: black;
  font-size: 18px;
  font-weight: 700;
  letter-spacing: 2px;


}
h1 {
    text-decoration: underline;
}
b {
    text-decoration: underline;
}
  


</style>