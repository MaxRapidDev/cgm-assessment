<template>
  <v-app>
    <v-app-bar
        app
        flat
    >
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>
        <router-link to="/">
          <v-img
              alt="logo"
              :height="60"
              :src="require('@/assets/logo.png')"
              contain
          />
        </router-link>

      </v-toolbar-title>


      <v-spacer></v-spacer>
    </v-app-bar>

    <v-navigation-drawer
        v-model="drawer"
        app
    >
      <patients-list />
    </v-navigation-drawer>

    <v-main class="grey lighten-3">
      <v-container>
        <router-view/>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import PatientsList from "@/components/PatientsList";
export default {
  components: {PatientsList},
  data: () => ({ drawer: null }),
}
</script>

<style lang="scss">

</style>
