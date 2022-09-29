<template>
<body>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <br />
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <br>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Create Beer Lover Username"
        v-model="user.username"
        required
        autofocus
      />
      <div class="form-field">
        <label for="password" class="sr-only">Password</label>

        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="New Password"
          v-model="user.password"
          required
        />
      </div>
      <br />
      <div class="form-field">
        <input
          type="password"
          id="confirmPassword"
          class="form-control"
          placeholder="Confirm New Password"
          v-model="user.confirmPassword"
          required
        />
      </div>
      <br>
      <br>
      <div class="brewer">
        <label class="brewer-label"> Are you a Brewer? </label>
        <br>
        <div class="checkbox">
          <input 
          type="checkbox"
          id="brewer-checkbox"
          class="checkbox"
          v-on:change="(user.role == 'user' ? user.role = 'brewer' : user.role= 'user')"
          />
        </div>
        <label class="yes"> Yes</label><br>
        </div>
      <router-link class="have-account" :to="{ name: 'login' }">Have an account?</router-link>
      <button class="create-account"  type="submit">
        Create Account
      </button>
    </form>
  </div>
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

<style>

*{
  padding: 0px;
  margin: 0;
  box-sizing: border-box;

}

#background{
  height: 87vh;
}

.password{
  margin-top: 1rem;
}

h1{
  margin: -5px 0px -20px -12px;
  font-size: 2rem;

}

.sr-only{
  margin-left: -.6rem;
}

/* form.form-register{
  position: absolute;
  right: 0;
  margin: 5vh;
  max-width: 300px;
  padding: 16px;
  background-color: #f2f2f2;
  border-radius: 5px;
  padding-left:30px;
 
} */

form.form-register{
  height: 60vh;
right: 0;
margin: 5vh;
max-width: 300px;
padding: 60px;
border-radius: 10px;
padding-left: 30px;
padding-right: 30px;
}

.form-register{
  background-color: #f2f2f2;
  background-position: center;
  background-size: 100vh;
  backdrop-filter: blur(5px);
  box-shadow: inset 0px 0px 10px #000;
}

.username-input-box, .password-input-box, .confirm-password-input-box {
  margin-top: .5rem;
  margin-left: -10px;
}

#username.form-control{

  font-size: 50;
  margin-right: 2rem;

  margin-top: 1rem;
 
}


#password.form-control{
  font-size: 50;
 margin-right: 2rem;
  margin-top: 1rem;
 
}

.have-account{
  text-decoration: none;
  color: #776262;
  text-decoration: underline;
}

.brewer{
  display: inline;
}

.checkbox{
  display: inline-block;
}

.have-account:hover{
  color: gold;
  text-decoration: underline;
}

.create-account{
  background-color: gold;
  border: none;
  font-size: 15px;
  padding: 7px;
  margin: 10px 0px 0px 10px;
  border-radius: 3px;
}

.create-account:hover{
  background-color: black;
  color: white;
}

#register {
  display: flex;
  justify-content: center;
  background-image: url("/halfpagemug.jpg");
  height: 100vh;
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  margin: 0;
  padding: 0;
}
</style>
