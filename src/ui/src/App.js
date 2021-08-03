// import './App.css';
import React, {useState} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import {CookiesProvider} from 'react-cookie';

import Header from './components/Header/Header';
import LoginForm from './components/LoginForm/LoginForm';
import RegistrationForm from './components/RegistrationForm/RegistrationForm';
import Home from './components/Home/Home';
import PrivateRoute from './utils/PrivateRoute';
import AlertComponent from './components/AlertComponent/AlertComponent';
import AddPost from './components/Post/AddPost';
import ShowPost from './components/Post/ShowPost';

function App() {
    const [title, updateTitle] = useState(null);
    const [errorMessage, updateErrorMessage] = useState(null);
    return (
        <CookiesProvider>
            <Router>
                <div className="App">
                    <Header title={title}/>
                    <div className="container d-flex align-items-center flex-column">
                        <Switch>
                            <Route path="/" exact={true}>
                                <RegistrationForm showError={updateErrorMessage} updateTitle={updateTitle}/>
                            </Route>
                            <Route path="/register">
                                <RegistrationForm showError={updateErrorMessage} updateTitle={updateTitle}/>
                            </Route>
                            <Route path="/login">
                                <LoginForm showError={updateErrorMessage} updateTitle={updateTitle}/>
                            </Route>
                            <Route component={ShowPost} path="/ShowPost"></Route>
                            <Route component={AddPost} path="/addPost"></Route>
                            <PrivateRoute path="/home">
                                <Home/>
                            </PrivateRoute>
                        </Switch>
                        <AlertComponent errorMessage={errorMessage} hideError={updateErrorMessage}/>
                    </div>
                </div>
            </Router>
        </CookiesProvider>
    );
}

export default App;
