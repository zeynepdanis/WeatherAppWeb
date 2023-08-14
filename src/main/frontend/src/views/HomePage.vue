<template>
  <div class="container-fluid"> <div class="a"></div>
    <div class="a"></div>
    <div class="a"></div>
    <div class="weather-box">
      <span>{{msg.toUpperCase()}}</span>

      <div class="a"></div>
      <div class="a"></div>


    </div>

    <div class="try-button">
      <button id="try-button" @click="goToWeatherPage">TRY</button>
    </div>



  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";

let msg = ref("");
const router = useRouter();

onMounted(async () => {
  const response = await fetch("/api/weather/home");
  msg.value = await response.text();
});

function goToWeatherPage() {
  router.push('/weather');
}
</script>
