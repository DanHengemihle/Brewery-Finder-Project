<template>
  <body>
    <div id="register" class="text-center">
      <img :src="'\Logo.png'" />
      <form class="form-register" @submit.prevent="register">
        <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
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
        <div>
          <input
            type="password"
            id="confirmPassword"
            class="form-control"
            placeholder="Confirm Password"
            v-model="user.confirmPassword"
            required
          />
        </div>
        <router-link id="haveaccount" :to="{ name: 'login' }">Have an account?</router-link>
        <button
          id="create-account"
          class="btn btn-lg btn-primary btn-block"
          type="submit"
        >
          Register
        </button>
      </form>
    </div>
    <div id="space">space</div>
    <i id="usericon" class="fa fa-user icon"></i>
    <i id="keyicon" class="fa fa-key icon"></i>
  </body>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
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
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
#space {
  height: 1000px;
}

#usericon {
  transform: translate(-880%, 130%);
  opacity: 0.8;
  padding: 10px;
  min-width: 40px;
}

#keyicon {
  transform: translate(-985%, 285%);
  opacity: 0.8;
  padding: 10px;
  min-width: 40px;
}

input::placeholder {
  color: black;
}

#haveaccount{

 color: #001979;
  font-weight: 650;
  font-size: 2.01vh;
}

* {
  padding: 0;
  margin: 0;
}


input {
  display: block;
  height: 50px;
  background-color: rgba(255, 255, 255, 0.205);
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

  background-image: url("/beer.jpeg");
  justify-content: center;
  align-items: center;
  padding-top: 50px;
  padding-left: 130px;
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
  
  margin-bottom: 7%;
  font-size: 300%;
  color: black;
 
}

#create-account {
  border: 2px solid rgba(255, 255, 255, 0.1);
  box-shadow: 0px 0px 20px rgba(8, 7, 16, 0.6);
  color: darkgoldenrod;
  font-size: 130%;
  background-color: black;
  cursor: pointer;
  
}
</style>
