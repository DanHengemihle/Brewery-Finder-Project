<template>
  <body>
    <div id="login" class="text-center">
      <form class="form-signin" @submit.prevent="login">
        <h1 class="h3 mb-3 font-weight-bold">Welcome, Beer Lover!</h1>
        <br />
        <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
          Thank you for registering, please sign in!
        </div>
        <br />
        <div class="form-field">
          <label for="username" class="sr-only">Username</label>
          <!-- <i class="fa fa-user icon"></i> -->
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Enter Beer Lover Username!"
            v-model="user.username"
            required
            autofocus
          />
        </div>
        <br />
        <div class="form-field">
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
        <router-link class="register" :to="{ name: 'register' }"
          >Need an account?</router-link
        >
        <button class="submit" type="submit">Sign in</button>
      </form>
    </div>
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
            this.$router.push("/");
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
/* #text-center{

  display: flex;
flex-direction: row;
justify-content: space-around;
justify-content: space-evenly;
  box-shadow: 0 4px 5px 0 rgba(0,0,0,0.14), 0 1px 10px 0 rgba(0,0,0,0.12), 0 2px 4px -1px rgba(0,0,0,0.2);

} */

/* #login{

  display: flex;
  height: 300px;
  justify-content: center;
  align-items: center;
  flex-basis: 100%;
    box-shadow: 0 4px 5px 0 rgba(0,0,0,0.14), 0 1px 10px 0 rgba(0,0,0,0.12), 0 2px 4px -1px rgba(0,0,0,0.2);

}
    */

* {
  padding: 0;
  margin: 0;
}

#login {
  height: 90vh;
}

form.form-signin {
  height: 45vh;
  right: 0;
  margin: 5vh;
  max-width: 300px;
  padding: 60px;
  border-radius: 10px;
  padding-left: 30px;
  padding-right: 30px;
}

h1 {
  margin: -5px 0px -20px 0px;
  font-size: 2rem;
}

.form-signin {
  background-color: #f2f2f2;
  background-position: center;
  background-size: 100vh;
  backdrop-filter: blur(5px);
  box-shadow: inset 0px 0px 10px #000;
}

#username.form-control {
  font-size: 50;
  margin-right: 2rem;

  margin-top: 1rem;
}

#password.form-control {
  font-size: 50;
  margin-right: 2rem;
  margin-top: 1rem;
}

a.register {
  text-decoration: none;
  color: goldenrod;
}

.register:hover {
  color: silver;
  text-decoration: underline;
}

.submit {
  background-color: goldenrod;
  border: none;
  font-size: 15px;
  margin-left: 20px;
  width: 70px;
  padding: 3px;
  border-radius: 3px;
}

.submit:hover {
  background-color: silver;
  color: white;
}

.alert {
  margin-top: 1rem;
}

body {
  display: flex;
  background-image: url("https://images.unsplash.com/photo-1608270586620-248524c67de9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8YmVlcnxlbnwwfHwwfHw%3D&w=1000&q=80");
  background-size: cover;
  justify-content: center;
  box-shadow: 0 4px 5px 0 rgba(0, 0, 0, 0.14), 0 1px 10px 0 rgba(0, 0, 0, 0.12),
    0 2px 4px -1px rgba(0, 0, 0, 0.2);
}

placeholder {
  color: blue;
}
</style>
