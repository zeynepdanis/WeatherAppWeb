import {createRouter, createWebHashHistory, createWebHistory} from 'vue-router'
import HomePage from "../views/HomePage.vue";
import CurrentWeather from "../views/CurrentWeather.vue";

const routes=[
  {

    name:"HomePage",
    path:"/",
    component :HomePage,


  },

  {

    name:"CurrentWeather",
    path:"/weather",
    component :CurrentWeather


  }

];


export default createRouter({

  routes,
  history:createWebHashHistory()
});
