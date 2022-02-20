<template>
  <v-card
      min-height="calc( 70vh - 150px )"
      rounded="lg"
  >
    <v-container>
      <v-form
          ref="form"
          v-model="valid"
          lazy-validation
          @submit.prevent="submit"
      >
        <v-sheet :max-width="550">
          <date-time-input v-model="form.date"/>

          <v-select
              v-model="form.type"
              :items="types"
              label="Type of Visit"
              dense
              outlined
              required
              :rules="rules.type"
          />

          <v-select
              v-model="form.reason"
              :items="visitreasons"
              item-text="domainId"
              item-value="id"
              label="Reason"
              return-object
              dense
              outlined
              required
              :rules="rules.reason"
          />
        </v-sheet>


        Anamnesis
         <ckeditor :editor="editor" v-model="form.anamnesis" :config="editorConfig"/>


        <v-card-actions>
          <v-spacer/>
          <v-btn type="submit" :loading="submiting">Speichern</v-btn>
        </v-card-actions>
      </v-form>
    </v-container>
  </v-card>
</template>

<script>
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import DateTimeInput from "@/components/DateTimeInput";

export default {
  name: "VisitForm",
  components: {DateTimeInput},
  props: {
    submitFct:{
      type: Function,
    },
    visit: {
      type: Object,
    },
    visitreasons: {
      type: Array,
    },
  },
  data: () => ({
    submiting: false,
    valid: true,
    rules: {
      date: [v => !!v || 'Date is required'],
      reason: [v => !!v || 'Reason is required'],
      type: [v => !!v || 'Type of Visit is required'],
    },
    form: {},
    editor: ClassicEditor,
    editorConfig: {
      // The configuration of the editor.
    },
    types: [
      {value: 'OUTPATIENT', text: 'outpatient'},
      {value: 'DOMICILIARY', text: 'domiciliary'}
    ]
  }),
  methods: {
    async submit() {
      const valid = this.$refs.form.validate()
      if (valid) {
        this.submiting = true;
        await this.submitFct(this.form)

        this.$toast.success("Successfull saved", {
          position: "top-right",
          timeout: 5000,
          closeOnClick: true,
          pauseOnFocusLoss: true,
          pauseOnHover: true,
          draggable: true,
          draggablePercent: 0.6,
          showCloseButtonOnHover: false,
          hideProgressBar: true,
          closeButton: "button",
          icon: true,
          rtl: false
        });
        this.submiting = false;
      }
    }
  },
  watch: {
    visit: {
      handler(visit) {
        this.form = JSON.parse(JSON.stringify(visit || {
          //define here the defaults for a new patient
          date: new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000).toJSON()
        }));
        this.$refs.form && this.$refs.form.resetValidation();
      },
      immediate: true,
    }
  }
}
</script>

<style scoped>

</style>