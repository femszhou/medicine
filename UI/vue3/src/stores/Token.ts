import { ref, computed } from 'vue'
import {defineStore} from "pinia"

export const useTokenStore =defineStore("Token",()=>{
    const tokenJson=ref("")

    const token=computed(()=> tokenJson.value || window.localStorage.getItem("TokenInfo"))

    function saveToken(data:string){
        tokenJson.value=data
        window.localStorage.setItem("TokenInfo",data)
    }
    return {token,saveToken}
})