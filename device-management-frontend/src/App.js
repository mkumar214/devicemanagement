import React from 'react';
import { Provider } from 'react-redux';
import { Switch } from 'react-router-dom';
import { BrowserRouter, Route } from 'react-router-dom';
import store from './redux/store';
// import './scss/style.scss'
import Login from './views/login/Login';
import Registration from './views/Registration/Registration';

function App() {
  return (
    <>
    <Provider store = {store()}>
    <BrowserRouter>
    
    <Switch>
    <Route exact path="/login" name = "Login Page" component={Login}/>
    <Route exact path="/" name = "Login Page" component={Login}/>

    <Route exact path="/register" name = "Registration Page" component={Registration}/>

    </Switch>
    </BrowserRouter>
    </Provider>
</>  );
}

export default App;
