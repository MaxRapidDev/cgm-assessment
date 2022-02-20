<template>
  <router-view v-if="patientid"/>
  <div v-else>No patient selected</div>
</template>

<script>
export default {
  computed: {
    patientid() {
      return this.$route.params.patientid;
    }
  },
}
</script>