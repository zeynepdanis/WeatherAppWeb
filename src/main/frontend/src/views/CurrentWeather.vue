<template>
  <div class="container-fluid"> <div class="a"></div>
    <div class="a"></div>
    <div class="a"></div>
    <div class="weather-box-2">

      <div id="city-name"> {{post.cityName}}</div>
      <div id="countryCode"> {{post.country}}</div>
      <div class="a"></div>
      <span id="description"> {{ post.description }}</span>
      <div class="a"></div>

      <div>

        <span v-if="msg=== 'Clear'">


          <img  src="../assets/forecast_gif/Clear.gif" alt="Sunny" style="
      width: 240px;
      margin-left: 20px;
      background-size: cover;"> </span>
        <span v-else-if="msg=== 'Clouds'">


          <img  src="../assets/forecast_gif/Clouds.gif" alt="Clouds" style="
      width: 240px;
      margin-left: 20px;
      background-size: cover;"> </span>
        <span v-else-if="msg=== 'Rain'">


          <img  src="../assets/forecast_gif/rainy.gif" alt="Rain" style="
      width: 240px;
      margin-left: 20px;
      background-size: cover;"> </span>
        <span v-else-if="msg=== 'Snow'">


          <img  src="../assets/forecast_gif/snow.gif" alt="Snow" style="
      width: 240px;
      margin-left: 20px;
      background-size: cover;"> </span>
        <span v-else-if="msg=== 'Thunderstorm'">


          <img  src="../assets/forecast_gif/storm.gif" alt="Storm" style="
      width: 240px;
      margin-left: 20px;
      background-size: cover;"> </span>
        <span v-else-if="msg=== 'Drizzle'">


          <img  src="../assets/forecast_gif/drizzle.gif" alt="Drizzle" style="
      width: 240px;
      margin-left: 20px;
      background-size: cover;"> </span>
        <span v-else>


          <img  src="../assets/forecast_gif/fog.gif"  style="
      width: 240px;
      margin-left: 20px;
      background-size: cover;"> </span>


      </div>



      <div> <span style="font-size: 100px">{{post.temperature}}</span><span>°C</span> </div>
      <div class="a"></div>
      <div ><span style="font-size: large">Feels Like : </span><span style="font-size: 50px ;">{{ post.feelsLike }}</span><span>°C</span></div>
      <div ><img src="../assets/forecast_gif/windSpeed.gif"  style="width:30px; height:30px;"><span style="font-size: 20px">wind : </span><span style="font-size:30px">{{ post.windSpeed }} km/h</span></div>

      <div><button @click="reloadPage">
        REFRESH
      </button></div>




    </div>


  </div>

</template>

<script>
import axios from 'axios';
import {ref} from "vue";

export default {

  data() {
    return {
      post:null,
      msg:null,

    }
  },

  methods: {
    reloadPage() {
      window.location.reload();
    }
  },

  created() {
    axios.get(`http://localhost:8080/api/weather/current`)
        .then(response => {
          this.post = response.data
          this.msg=response.data.description
        })
        .catch(e => {
          this.errors.push(e)
        })
  }

}


</script>