<template>
  <v-row>
    <v-col>
      <v-menu
          v-model="pickermenuDate"
          :close-on-content-click="false"
          :nudge-right="40"
          transition="scale-transition"
          offset-y
          min-width="auto"
      >
        <template #activator="{ on, attrs }">
          <v-text-field
              v-model="date"
              label="Visit date"
              prepend-icon="mdi-calendar"
              readonly
              outlined
              dense
              v-bind="attrs"
              v-on="on"
              required
              :rules="rules.date"
          />
        </template>
        <v-date-picker
            v-model="date"
            @input="pickermenuDate = false"
        />
      </v-menu>
    </v-col>
    <v-col>
      <v-menu
          ref="menu"
          v-model="pickermenuTime"
          :close-on-content-click="false"
          :nudge-right="40"
          :return-value.sync="time"
          transition="scale-transition"
          offset-y
          max-width="290px"
          min-width="290px"
      >
        <template v-slot:activator="{ on, attrs }">
          <v-text-field
              v-model="time"
              label="Visit time"
              prepend-icon="mdi-clock-time-four-outline"
              readonly
              outlined
              dense
              v-bind="attrs"
              v-on="on"
          ></v-text-field>
        </template>
        <v-time-picker
            v-if="pickermenuTime"
            v-model="time"
            full-width
            @click:minute="$refs.menu.save(time)"
        ></v-time-picker>
      </v-menu>
    </v-col>
  </v-row>
</template>

<script>

export default {
  name: "DateTimeInput",
  props: {
    value: {
      type: String
    }
  },
  data: () => ({
    pickermenuDate: false,
    pickermenuTime: false,
    rules: {
      date: [v => !!v || 'Date is required'],
    }
  }),
  computed: {
    date: {
      get() {
        return this.value.substring(0, 10);
      },
      set(val) {
        const newValue = val + this.value.substring(10);
        this.$emit('input', newValue)
      }
    },
    time: {
      get() {
        return this.value.substring(11, 16)
      },
      set(val) {
        console.log(val);
      }
    }
  },
}
</script>

<style scoped>

</style>