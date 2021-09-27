
import classNames from 'classnames';
import style from './style/style';
import { Grid, TableBody, Typography, Tabs, Tab, Button, TextField, Fade, CircularProgress } from '@material-ui/core';
import logo from '../../logo.svg'
import { useState } from 'react';
import google from '../../assets/images/social-media/google.svg'
import { useStore } from 'react-redux';



const Login = props => {

    const classes = style();
    // This is used for the showing the tab on the screen.
    let [activeTabId, setActiveTabId] = useState(0);
    var [loginValue, setLoginValue] = useState('');
    const [passwordVal, setPasswordVal] = useState('');
    const [error, setError] = useState(null);

    //This is for hold the scren during login and registration
    var [isProcessing, setIsProcessing] = useState(false);

  const handleSubmit= () =>{
      console.log('click submit')
  }

    return (<div className="bg-light min-vh-100 d-flex flex-row align-items-center">
        <Grid container className={classes.container}>
            {/* Logo setting */}
            <div className={classes.logotypeContainer}>
                <img src={logo} alt="logo" className={classes.logotypeImage} />
                <Typography className={classes.logotypeText}>Khooju</Typography>
            </div>

            <div className={classes.formContainer}>
                <div className={classes.form}>
                    <Tabs value={activeTabId} onChange={(e, id) => setActiveTabId(id)} indicatorColor="primary" textColor="primary" centered>
                        <Tab label="Login" classes={{ root: classes.tab }} />
                        <Tab label="New User" classes={{ root: classes.tab }} />
                    </Tabs>
                    {/* When tab id is 0 then show the login page */}
                    {activeTabId === 0 && (
                        <>
                            <Typography variant="h1" className={classes.greeting}>
                                Welcome Back
                            </Typography>
                            <Button size="large" color="primary">
                                <img src={google} alt="google" className={classes.googleIcon} />
                                &nbsp;Sign in with Google

                            </Button>

                            <div className={classes.formDividerContainer}>
                                <div className={classes.formDivider}>
                                    <Typography className={classes.formDividerWord}>or</Typography>
                                    <div className={classes.formDivider} />
                                </div>
                            </div>
                            <Fade in={error}>
                                <Typography color="secondary" className={classes.errorMessage}>
                                    Something is wrong with your login or password :(
                                </Typography>
                            </Fade>

                            <TextField id="email"
                                InputProps={{
                                    classes: {
                                        underline: classes.textFieldUnderline,
                                        input: classes.textField,
                                    },
                                }}
                                value={loginValue}
                                onChange={e => setLoginValue(e.target.value)}
                                margin="normal"
                                placeholder="Email Adress"
                                type="email"
                                fullWidth

                            />

                            <TextField id="password"
                                InputProps={{
                                    classes: {
                                        underline: classes.textFieldUnderline,
                                        input: classes.TextField,
                                    }
                                }}
                                value={passwordVal}
                                onChange={e => setPasswordVal(e.target.value)}
                                margin="normal"
                                placeholder="Password"
                                type="password"
                                fullWidth
                            />

                            <div className={classes.formButtons}>
                                {isProcessing ? (<CircularProgress size={26} className={classes.loginLoader} />) : (<Button
                                    disabled={
                                        loginValue.length === 0 || passwordVal.length === 0
                                    }
                                    variant="contained"
                                    color="primary"
                                    size="large"
                                    onClick={handleSubmit}
                                >
                                    Login
                                </Button>)}
                               
                                <Button
                                    color="primary"
                                    size="large"
                                    className={classes.forgetButton}
                                >
                                    Forget Password
                                </Button>
                            </div>

                        </>


                    )}

                    {activeTabId === 1 && (
                        <>
                            <Typography variant="h1" className={classes.greeting}>
                                Become a Khooju
                            </Typography>
                            <Button size="large" color="primary">
                                <img src={google} alt="google" className={classes.googleIcon}>
                                    &nbsp;Sign up with Google
                                </img>
                            </Button>
                        </>

                    )}
                </div>
            </div>


        </Grid>
    </div>);
};

export default Login;