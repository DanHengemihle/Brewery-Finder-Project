<template>
  <body>
    <div id="login" class="text-center">
      <img :src="'\Logo.png'" />
      <form class="form-signin" @submit.prevent="login">
        <h1>Cheers!</h1>
        <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
          Thank you for registering, please sign in.
        </div>

        <div>
          <label for="username" class="sr-only">Username</label>

          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
          />
        </div>

        <div>
          <label for="password" class="sr-only">Password</label>

          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />
        </div>
        <router-link id="create-account" :to="{ name: 'register' }"
          >Create Account</router-link
        >

        <button id="sign-in" type="submit">Sign in</button>
      </form>
    </div>
   
    <i id="usericon" class="fa fa-user icon"></i>
    <i id="lockicon" class="fa fa-lock icon"></i>
  </body>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
        role: "user",
      },
      invalidCredentials: false,
    };
  },

  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            console.log(response.data.user.authorities[0].name);
            if (response.data.user.authorities[0].name == "ROLE_BREWER") {
              this.$router.push({ name: "home" });
            } else if (
              response.data.user.authorities[0].name == "ROLE_BEERLOVER"){
              this.$router.push({ name: "beerlover" });
            } else {
              this.$router.push("/home");
            }
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>

#usericon {

  transform: translate(-16vw, 7.9vh);
  size: 100%;
  opacity: 0.8;
  padding: 10px;
  min-width: 40px;
}

#lockicon {
 

  transform: translate(-18vw, 13.5vh);
  opacity: 0.8;
  padding: 10px;
  min-width: 40px;
}

input::placeholder {
  color: black;
}

* {
  padding: 0;
  margin: 0;
}

input {
  display: block;
  height: 50px;
  background-color: rgba(255, 255, 255, 0.829);
  border: 2px solid rgba(0, 0, 0, 0.383);
  border-radius: 3px;
  padding: 0 10px;
  margin-top: 4px;
  font-size: 17px;
  font-weight: 500;
  text-align: center;
  color: black;
}

img {
  opacity: 0.85;
  width: 25vh;
}

body {
  display: flex;

  background-image: url("/beer7.png");

  justify-content: center;
  align-items: center;
  padding-left: 70px;
  background-position: center;
  background-size: cover;
  background-repeat: no-repeat;
}

body,
html {
  height: 100vh;
}

h1 {
  font-weight: bolder;
  margin-bottom: 7%;
  font-size: 300%;
  color: darkgoldenrod;
}

#sign-in {
  margin-top: 2%;
  width: 100%;
  height: 6vh;

  border: 2px solid rgba(255, 255, 255, 0.1);
  box-shadow: 0px 0px 20px rgba(8, 7, 16, 0.6);
  color: darkgoldenrod;
  font-size: 130%;
  font-weight: bold;
  background-color: black;
  cursor: pointer;
}

#login.text-center {
  width: 17vw;
}
</style>
