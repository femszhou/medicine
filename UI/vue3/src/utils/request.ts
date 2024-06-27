import axios, { type AxiosRequestHeaders } from "axios"
import { useTokenStore } from "@/stores/Token"
const request=axios.create({
    baseURL:"/api"
})
request.interceptors.request.use((config)=>{
    if(!config.headers){
        config.headers={} as AxiosRequestHeaders
    }
    const store=useTokenStore()
    config.headers.token=store.token
    return config
})
export default request