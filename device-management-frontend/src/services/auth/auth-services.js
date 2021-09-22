import axios from "axios";
import { BASE_URL, Login, REGISTRATION } from "../../constant/api-url";
/**
 * This class having the login,registation and logout services.
 */
class AuthService{

   async login(username,password){
     
        return axios.post(BASE_URL+Login,{username,password}).then((response)=>
        {
            if(response.data.accessToken){
                localStorage.setItem("user",JSON.stringify(response.data))
            }

            return response.data;
        });
    }

    async logout (){
        localStorage.removeItem(userId);
    }

    async register(username,password,email){
        return axios.post(BASE_URL+REGISTRATION,{username,email,password})
    }
}

export default AuthService;