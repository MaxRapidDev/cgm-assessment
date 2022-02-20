<template>
  <v-list color="transparent">
    <v-list-item>
      <v-text-field
          dense
          flat
          hide-details
          rounded
          solo-inverted
          append-icon="mdi-account-search"
          v-model="query"
      />
    </v-list-item>
    <v-list-item
        v-for="patient in filtered"
        :key="patient.id"
        link
        :to="{name: 'PatientDetail', params: {patientid: patient.id}}"
    >
      <v-list-item-content>
        <v-list-item-title>
          {{ patient.surname }} {{ patient.name }}
        </v-list-item-title>
      </v-list-item-content>
    </v-list-item>
  </v-list>
</template>
<script>
export default {
  name: 'PatientsList',
  data: () => ({
    patients: [],
    loading: true,
    query: '',
  }),
  async mounted() {
    //TODO error handling
    this.patients = (await this.$api.patients.list()).data
    this.loading = false
  },
  computed:{
    filtered(){
      const search = this.query.toLowerCase();
      return search ? this.patients.filter( p => {
        return p.name.toLowerCase().includes(search)
            || p.surname.toLowerCase().includes(search)
            || p.socialSecurityNumber.toLowerCase().includes(search);
      }) : this.patients;
    }
  }
}
</script>