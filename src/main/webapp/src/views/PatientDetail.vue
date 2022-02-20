<template>
  <div>
    <v-row>
      <v-col>
        <v-card rounded="lg" :loading="loading">
         <v-container>
           <v-row>
             <v-col cols="auto">
                 <v-img :width="100" :height="100" contain :src="patient.imageurl" v-if="patient.imageurl"/>
             </v-col>
             <v-col>
               <h1>{{patient.name}} {{patient.surname}}</h1>
               <div>{{new Date(patient.dateOfBirth).toLocaleDateString()}}</div>
               <div>{{patient.socialSecurityNumber}}</div>
             </v-col>
           </v-row>
         </v-container>
        </v-card>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="3">
        <v-card
            min-height="calc( 70vh - 150px )"
            rounded="lg"
        >
          <v-data-table
              class="vistits-table"
              :headers="headers"
              :items="vistits"
              single-select
              :hide-default-footer="true"
              :items-per-page="Number.MAX_SAFE_INTEGER"
              v-model="selected"
              @click:row="clickRow"
          >
            <template #item.reason="{ item }">
              {{ item.reason.domainId }}
            </template>
            <template #item.date="{ item }">
              {{ new Date(item.date).toLocaleDateString()}} - {{new Date(item.date).toLocaleTimeString().substring(0,5)}}
            </template>
          </v-data-table>

          <v-btn
              color="pink"
              dark
              absolute
              bottom
              right
              fab
              v-if="visitid"
              @click="() => clickRow({id:null})"
          >
            <v-icon>mdi-plus</v-icon>
          </v-btn>
        </v-card>
      </v-col>

      <v-col>
          <visit-form
              :visit="selectedVisit"
              :visitreasons="visitreasons"
              @submit="submit"/>
      </v-col>
    </v-row>
  </div>

</template>

<script>
import VisitForm from "@/components/VisitForm";

export default {
  name: "PatientDetail",
  components: {VisitForm},
  data: () => ({
    selected: [],
    vistits: [],
    visitreasons: [],
    patient: null,
    loading: true,
    headers: [
      {text: 'Reason', value: 'reason'},
      {text: 'Date', value: 'date'},
    ],
  }),
  computed: {
    patientid() {
      return this.$route.params.patientid;
    },
    visitid() {
      const num = parseInt(this.$route.params.visitid);
      return isNaN(num) ? null : num;
    },
    selectedVisit() {
      return this.vistits.find(v => v.id === this.visitid);
    }
  },
  methods: {
    clickRow(item) {
      if( item.id === this.visitid) return;
      this.$router.push({
        name: this.$route.name,
        params: {patientid: this.patientid, visitid: item.id},
      });
    },
    async submit(form){
      const update = !!form.id;
      const newData = [...this.vistits];

      const {data} = await this.$api.visits.updateOrCreate({...form, patient: this.patient});
      if(update){
        const index=newData.findIndex(item => item.id === form.id);
        newData[index] = data;
      }else{
        newData.push(data);
        this.clickRow(data);
      }

      newData.sort(function(a,b){
        return new Date(b.date) - new Date(a.date);
      });

      this.vistits=newData;
    },
  },
  watch: {
    patientid: {
      async handler(patientid) {
        //TODO error handling
        this.loading = true;
        this.vistits = [];
        const [patientResponse, visitsResponse, visitreasonsResponse] = await Promise.all([
          this.$api.patients.get(patientid),
          this.$api.patients.getVisits(patientid),
          this.$api.visitreasons.list()
        ])
        this.patient = patientResponse.data;
        this.vistits = visitsResponse.data;
        this.visitreasons = visitreasonsResponse.data;
        this.loading = false;
      },
      immediate: true
    },
    selectedVisit: {
      async handler(selectedVisit) {
        this.selected=[selectedVisit];
      },
      immediate: true
    }
  }
}
</script>

<style scoped lang="scss">
.vistits-table ::v-deep tr {
  cursor: pointer;
}
</style>