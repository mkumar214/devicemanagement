import AuthService from "../../../services/auth/auth-services"
import { LOGIN_FAIL, LOGIN_SUCCESS } from "./types"

const login = (username,password) =>(dispatch)=>{

    return AuthService.login(username,password).then(
        (data) => {
            dispatch(
                {
                    type:LOGIN_SUCCESS,
                    payload: {user:data}
                }
            );

            return Promise.resolve();
        },
        (error) =>{
           console.log(error.response);
           dispatch({
               type:LOGIN_FAIL
           })

           Promise.resolve();
        }
    )
}


export default login;