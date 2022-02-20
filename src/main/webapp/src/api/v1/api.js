import axios from "axios";

export default {
    patients:{
        list: () => axios.get(`/api/v1/patients`),
        get: (patientid) =>axios.get(`/api/v1/patients/${patientid}`),
        getVisits: (patientid) =>axios.get(`/api/v1/patients/${patientid}/visits`),
    },
    visitreasons:{
        list: () => axios.get(`/api/v1/visitreasons`),
    },
    visits:{
        updateOrCreate(visit){
            return visit.id ? this.update(visit) : this.create(visit);
        },
        update: (visit) => axios.put('/api/v1/visits', visit),
        create: (visit) => axios.post('/api/v1/visits', visit),
    }
}