/**
 * This is a helper function which is used to make a request with authentication token to the server.
 */
export default function  authHeader() {
    const user = JSON.parse(localStorage.getItem("user"));
    
    if(user && user.accesstoken){
        return {Authorization: 'Bearer ' + user.accessToken }
    }else{
        return {}
    }
}