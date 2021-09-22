import { LOGIN_SUCCESS } from "../action/types";

const user = JSON.parse(localStorage.getItem("user"));

const initialState = user
  ? { isLoggedIn: true, user }
  : { isLoggedIn: false, user: null };

function auth(state=initialState,action){
    const {type,payload} = action;

    switch(type){
        case LOGIN_SUCCESS:
            return {...state,isLoggedIn:true,user:payload.user,}
    }
}

export default auth;